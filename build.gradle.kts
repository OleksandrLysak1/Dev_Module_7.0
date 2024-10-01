plugins {
    id("java")
    kotlin("jvm") version "1.9.10"
    id("application")
}


group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))
    implementation("com.h2database:h2:2.2.220")
    implementation("org.flywaydb:flyway-core:9.15.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain {
        (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(17))
    }
}


//kotlin {
//    jvmToolchain(21)
//}


application {
    mainClass.set("org.example.Main")
}
