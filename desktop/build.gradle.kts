import org.gradle.api.tasks.JavaExec
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    application
    kotlin("jvm")
}

apply {
    plugin("com.github.johnrengelman.shadow")
}

application {
    mainClassName = "desktop.Main"
}

val gdxVersion: String by extra
val kotlinVersion: String by project

dependencies {
    compile(project(":core"))
    compile("com.badlogicgames.gdx:gdx-backend-lwjgl:$gdxVersion")
    compile("com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-desktop")
    compile(kotlin("stdlib"))
}

