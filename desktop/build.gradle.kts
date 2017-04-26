import org.gradle.api.tasks.JavaExec

buildscript {
    repositories {
        gradleScriptKotlin()
    }
    dependencies {
        classpath(kotlinModule("gradle-plugin"))
        classpath("com.github.jengelman.gradle.plugins:shadow:1.2.4")
    }
}

plugins {
    application
}

apply {
    plugin("kotlin")
    plugin("com.github.johnrengelman.shadow")
}

application {
    mainClassName = "desktop.Main"
}

(getTasksByName("run", false).firstOrNull() as? JavaExec)?.isIgnoreExitValue = true

val gdxVersion: String by extra

dependencies {
    compile(project(":core"))
    compile(kotlinModule("stdlib"))
    compile("com.badlogicgames.gdx:gdx-backend-lwjgl:$gdxVersion")
    compile("com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-desktop")
}
