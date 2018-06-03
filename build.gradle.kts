
buildscript {

    repositories {
        jcenter()
    }
    dependencies {
        classpath("com.github.jengelman.gradle.plugins:shadow:2.0.4")
    }
}

allprojects {

    repositories {
        jcenter()
    }

    var gdxVersion: String by extra
    var ktxVersion: String by extra

    gdxVersion = "1.9.8"
    ktxVersion = "1.9.8-b3"

    group = "com.example.gdxgame"
    version = "1.0"

    apply(plugin = "kotlin")
}


plugins {
    base
    kotlin("jvm") version "1.2.41"
}

dependencies {
    // Make the root project archives configuration depend on every subproject
    subprojects.forEach {
        archives(it)
    }
}
