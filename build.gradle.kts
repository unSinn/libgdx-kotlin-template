buildscript {
    repositories {
        gradleScriptKotlin()
    }
    dependencies {
        classpath(kotlinModule("gradle-plugin"))
    }
}

allprojects {

    group = "me.danbeneventano.anothergame"

    version = "1.0"

    repositories {
        gradleScriptKotlin()
        jcenter()
    }

    var gdxVersion: String by extra
    gdxVersion = "1.9.6"

    var ktxVersion: String by extra
    ktxVersion = "1.9.6-b2"
}

plugins {
    base
}

dependencies {
    // Make the root project archives configuration depend on every subproject
    subprojects.forEach {
        archives(it)
    }
}
