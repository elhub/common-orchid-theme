package no.elhub.common.orchid.theme

import com.eden.orchid.impl.generators.HomepageGenerator
import com.eden.orchid.strikt.pageWasRendered
import com.eden.orchid.testhelpers.OrchidIntegrationTest
import com.eden.orchid.testhelpers.withGenerator
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.contains

class ElhubThemeTest : OrchidIntegrationTest(withGenerator<HomepageGenerator>(), ElhubModule()) {

    @Test
    fun test01() {
        configObject(
            "site",
            """
            |{
            |   "theme": "Elhub"
            |}
            """.trimMargin()
        )
        resource(
            "homepage.md",
            """
            |# Hello!
            |This is only
            |a test.
            |
            |homepage-check
            """.trimMargin()
        )

        expectThat(execute())
            .pageWasRendered("/index.html") {
                get { content }.contains("homepage-check")
            }
    }
}
