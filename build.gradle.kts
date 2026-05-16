import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("net.fabricmc.fabric-loom")
    id("org.jetbrains.kotlin.jvm")
    `maven-publish`
}

val minecraft_version: String by project
val loader_version: String by project
val fabric_version: String by project
val fabric_kotlin_version: String by project
val kotlin_version: String by project
val archives_base_name: String by project

val releaseModDependencies by configurations.creating {
    isCanBeConsumed = false
    isCanBeResolved = true
    isTransitive = false
}

version = project.property("mod_version").toString()
group = project.property("maven_group").toString()

base {
    archivesName.set(archives_base_name)
}

repositories {
    // Loom agrega los repositorios de Fabric, Mojang y Maven Central necesarios.
    // Agrega aqui repositorios extra solo cuando dependas de otros mods.
    mavenCentral()
}

dependencies {
    minecraft("com.mojang:minecraft:$minecraft_version")

    implementation("net.fabricmc:fabric-loader:$loader_version")
    implementation("net.fabricmc.fabric-api:fabric-api:$fabric_version")
    implementation("net.fabricmc:fabric-language-kotlin:$fabric_kotlin_version")

    releaseModDependencies("net.fabricmc.fabric-api:fabric-api:$fabric_version")
    releaseModDependencies("net.fabricmc:fabric-language-kotlin:$fabric_kotlin_version")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
}

tasks.processResources {
    val props = mapOf(
        "version" to project.version,
        "minecraft_version" to minecraft_version,
        "loader_version" to loader_version,
        "fabric_version" to fabric_version,
        "fabric_kotlin_version" to fabric_kotlin_version,
    )

    inputs.properties(props)

    filesMatching("fabric.mod.json") {
        expand(props)
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }

    withSourcesJar()
    sourceCompatibility = JavaVersion.VERSION_25
    targetCompatibility = JavaVersion.VERSION_25
}

kotlin {
    jvmToolchain(25)
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(25)
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_25)
        freeCompilerArgs.add("-Xjdk-release=25")
    }
}

tasks.named<Jar>("jar") {
    archiveFileName.set("RiserJuices.jar")
}

tasks.register<Copy>("prepareMinecraftMods") {
    group = "distribution"
    description = "Copia el mod y sus dependencias externas necesarias a build/minecraft-mods."

    dependsOn(tasks.named("jar"))

    doFirst {
        delete(layout.buildDirectory.dir("minecraft-mods"))
    }

    into(layout.buildDirectory.dir("minecraft-mods"))

    from(tasks.named<Jar>("jar").flatMap { it.archiveFile })

    from(releaseModDependencies)
}

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
        }
    }

    repositories {
        // Configura aqui un repositorio si luego quieres publicar el mod como artefacto Maven.
    }
}
