# common-orchid-theme

[<img src="https://img.shields.io/badge/repo-github-blue" alt=""/>](https://github.com/elhub/common-orchid-theme)
[<img src="https://img.shields.io/badge/issues-jira-orange" alt=""/>](https://jira.elhub.cloud/issues/?jql=project%20%3D%20%22Team%20Dev%22%20AND%20component%20%3D%20common-orchid-theme%20AND%20status%20!%3D%20Done)
[<img src="https://teamcity.elhub.cloud/app/rest/builds/buildType:(id:Common_CommonOrchidTheme_AutoRelease)/statusIcon" alt=""/>](https://teamcity.elhub.cloud/project/Common_CommonOrchidTheme?mode=builds#all-projects)
[<img src="https://sonar.elhub.cloud/api/project_badges/measure?project=no.elhub.common%3Acomon-orchid-theme&metric=alert_status" alt=""/>](https://sonar.elhub.cloud/dashboard?id=no.elhub.common%3Acomon-orchid-theme)
[<img src="https://sonar.elhub.cloud/api/project_badges/measure?project=no.elhub.common%3Acomon-orchid-theme&metric=ncloc" alt=""/>](https://sonar.elhub.cloud/dashboard?id=no.elhub.common%3Acomon-orchid-theme)
[<img src="https://sonar.elhub.cloud/api/project_badges/measure?project=no.elhub.common%3Acomon-orchid-theme&metric=bugs" alt=""/>](https://sonar.elhub.cloud/dashboard?id=no.elhub.common%3Acomon-orchid-theme)
[<img src="https://sonar.elhub.cloud/api/project_badges/measure?project=no.elhub.common%3Acomon-orchid-theme&metric=vulnerabilities" alt=""/>](https://sonar.elhub.cloud/dashboard?id=no.elhub.common%3Acomon-orchid-theme)
[<img src="https://sonar.elhub.cloud/api/project_badges/measure?project=no.elhub.common%3Acommon-orchid-theme&metric=coverage" alt=""/>](https://sonar.elhub.cloud/dashboard?id=no.elhub.common%3Acommon-orchid-theme)

## Table of Contents

* [About](#about)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [Testing](#testing)
* [Roadmap](#roadmap)
* [Contributing](#contributing)
* [Owners](#owners)
* [License](#license)


## About

This project is Elhub's standard theme for our Orchid-based documentation. It is based off the standard Orchid BSDoc theme.

## Getting Started

### Prerequisites

See the [quick start guide at orchid.run](https://orchid.run/wiki/user-manual/getting-started/quickstart). This is a
Gradle/Kotlin project.

This project requires [elhub-gradle](https://github.com/elhub/common-elhub-gradle).

If you do not have access to Elhub's internal repository, simply download the above project, assemble the custom gradle
distribution and edit the distributionUrl in _this projects_ gradle-wrapper.properties to point to your local file. 

### Installation

To build the custom distribution:

```sh
./gradlew assemble
```

To publish:
```sh
./gradlew publish
```

## Usage

The theme can be used in one of two ways: either add the theme in your build.gradle.kts or set it in your orchid.kts
script. If you're using elhub-gradle, common-elhub-gradle is predefined as the theme.

### Gradle

Add the Orchid Implementation 

```kotlin
orchidImplementation("io.github.javaeden.orchid:OrchidAll:$orchidVersion")
orchidImplementation("no.elhub.common:common-orchid-theme:1.0-SNAPSHOT")
```

And set the theme to Elhub.

### Kotlin Script

The following kscript file works for this project (assuming correct repository and theme dependency):

```kotlin
// orchid.kts
@file:MavenRepository("elhub-mvn", "https://jfrog.elhub.cloud/artifactory/elhub-mvn")
@file:DependsOn("io.github.javaeden.orchid:OrchidAll:0.21.1")
@file:DependsOn("no.elhub.common:common-orchid-theme:1.0-SNAPSHOT")

import com.eden.orchid.Orchid
import com.eden.orchid.StandardModule

val flags = HashMap<String, Any>()
flags["version"] = "0.21.1"
flags["theme"]  = "Elhub"
flags["src"]  = "./docs"
flags["dest"] = "./build/docs/orchid"
flags["runTask"] = "build"

val modules = listOf(StandardModule.builder()
  .args(args) // pass in the array of command-line args and let Orchid parse them out
  .flags(flags) // pass a map with any additional args
  .build()
)
Orchid.getInstance().start(modules)
```

## Testing

Gradle unit tests:

```sh
./gradlew test
```

## Contributing

Contributing, issues and feature requests are welcome. See the 
[Contributing](https://github.com/elhub/common-orchid-theme/blob/main/CONTRIBUTING.md) file.

## Owners

This project is developed by [Elhub](https://wwww.elhub.no). For the specific development group responsible for this
code, see the [Codeowners](https://github.com/elhub/common-orchid-theme/blob/main/CODEOWNERS) file.

## License

This project is [MIT](https://github.com/elhub/common-orchid-theme/blob/main/LICENSE.md) licensed.
