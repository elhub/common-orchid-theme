group = "no.elhub.common"
description = "Elhub Theme for Orchid Docs"

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.github.javaeden.orchid:OrchidCore:0.21.1")
    testImplementation("io.github.javaeden.orchid:OrchidTest:0.21.1")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.2")
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform { }
}
