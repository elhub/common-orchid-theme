// orchid.kts
@file:MavenRepository("elhub-mvn", "https://jfrog.elhub.cloud/artifactory/elhub-mvn")
@file:DependsOn("io.github.javaeden.orchid:OrchidAll:0.21.1")
@file:DependsOn("no.elhub.common:common-orchid-theme:0.2.0")

import com.eden.orchid.Orchid
import com.eden.orchid.StandardModule

val flags = HashMap<String, Any>()
flags["version"] = "0.21.1"
flags["src"]  = "./docs"
flags["dest"] = "./build/docs/orchid"
flags["runTask"] = "build"

val modules = listOf(StandardModule.builder()
    .args(args) // pass in the array of command-line args and let Orchid parse them out
    .flags(flags) // pass a map with any additional args
    .build()

)
Orchid.getInstance().start(modules)
