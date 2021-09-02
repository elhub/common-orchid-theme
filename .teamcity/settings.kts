import jetbrains.buildServer.configs.kotlin.v2019_2.DslContext
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.SshAgent
import jetbrains.buildServer.configs.kotlin.v2019_2.project
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.VcsTrigger
import jetbrains.buildServer.configs.kotlin.v2019_2.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2019_2.version
import no.elhub.common.build.configuration.Assemble
import no.elhub.common.build.configuration.AutoRelease
import no.elhub.common.build.configuration.CodeReview
import no.elhub.common.build.configuration.ProjectType
import no.elhub.common.build.configuration.SonarScan
import no.elhub.common.build.configuration.UnitTest
import no.elhub.common.build.configuration.constants.GlobalTokens

version = "2021.1"

project {

    val projectId = "no.elhub.common:common-orchid-theme"
    val artifactoryRepository = "elhub-mvn-release-local"

    params {
        param("teamcity.ui.settings.readOnly", "true")
    }

    val unitTest = UnitTest(
        UnitTest.Config(
            vcsRoot = DslContext.settingsRoot,
            type = ProjectType.GRADLE
        )
    )

    val sonarScan = SonarScan(
        SonarScan.Config(
            vcsRoot = DslContext.settingsRoot,
            type = ProjectType.GRADLE,
            sonarId = projectId
        )
    ) {
        dependencies {
            snapshot(unitTest) { }
        }
    }

    val assemble = Assemble(
        Assemble.Config(
            vcsRoot = DslContext.settingsRoot,
            type = ProjectType.GRADLE
        )
    ) {
        dependencies {
            snapshot(sonarScan) { }
        }
    }

    val githubAuth = SshAgent {
        teamcitySshKey = "teamcity_github_rsa"
        param("secure:passphrase", GlobalTokens.githubSshPassphrase)
    }

    val autoRelease = AutoRelease(
        AutoRelease.Config(
            vcsRoot = DslContext.settingsRoot,
            type = ProjectType.GRADLE,
            sshAgent = githubAuth,
            repository = artifactoryRepository
        )
    ) {
        dependencies {
            snapshot(assemble) { }
        }
    }

    val publishDocs = PublishDocs(
        PublishDocs.Config(
            vcsRoot = DslContext.settingsRoot,
            type = projectType,
            dest = "common/common-orchid-theme
        )
    ) {
        triggers {
            vcs {
                branchFilter = "+:<default>"
                quietPeriodMode = VcsTrigger.QuietPeriodMode.USE_DEFAULT
            }
        }

        dependencies {
            snapshot(autoRelease) { }
        }
    }

    listOf(unitTest, sonarScan, assemble, autoRelease, publishDocs).forEach { buildType(it) }

    buildType(
        CodeReview(
            CodeReview.Config(
                vcsRoot = DslContext.settingsRoot,
                type = ProjectType.GRADLE,
                sonarId = projectId
            )
        )
    )
}
