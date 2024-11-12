plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.7.21"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.2")
    implementation("com.codeborne:selenide:6.12.3")
    implementation("org.apache.logging.log4j:log4j-core:2.18.0")
    implementation("org.apache.logging.log4j:log4j-api:2.17.1")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.9.0")
    implementation("com.codeborne:selenide-proxy:6.9.0")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.13.0")
    testImplementation("org.seleniumhq.selenium:selenium-devtools-v102:4.2.2")
    implementation("io.github.bonigarcia:webdrivermanager:5.7.0")
}

sourceSets {
    main {
        java.srcDirs("src/main/java")
        resources.srcDirs("src/main/resources")
    }
    test {
        java.srcDirs("src/test/java")
        resources.srcDirs("src/test/resources")
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.processTestResources {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}
tasks.processResources {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}

kotlin {
    jvmToolchain(11)
}