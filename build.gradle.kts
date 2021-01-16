plugins {
    idea
    kotlin("jvm") version "1.4.21"
}

allprojects {
    version = "1.0"

    val appName by extra { "Gorcassonne" }
    val gdxVersion by extra { "1.9.13" }

    repositories {
        mavenLocal()
        mavenCentral()
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
        maven { url = uri("https://oss.sonatype.org/content/repositories/releases/") }
    }
}



project(":desktop") {
    apply(plugin = "kotlin")

    val gdxVersion = this.extra["gdxVersion"]

    dependencies {
        compile(project(":core"))
        compile("com.badlogicgames.gdx:gdx-backend-lwjgl:$gdxVersion")
        compile("com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-desktop")
        compile("com.badlogicgames.gdx:gdx-freetype-platform:$gdxVersion:natives-desktop")
        compile("com.badlogicgames.gdx:gdx-tools:$gdxVersion")
        compile("com.badlogicgames.gdx:gdx-controllers-desktop:$gdxVersion")
        compile("com.badlogicgames.gdx:gdx-controllers-platform:$gdxVersion:natives-desktop")
        compile(kotlin("stdlib"))
    }
}

project(":core") {
    apply(plugin = "kotlin")

    val gdxVersion = this.extra["gdxVersion"]

    dependencies {
        val ktxVersion = "1.9.13-b1"

        compile("de.alsclo:voronoi-java:1.0")
        compile("com.badlogicgames.gdx:gdx:$gdxVersion")
        compile("com.badlogicgames.gdx:gdx-freetype:$gdxVersion")
        compile("com.badlogicgames.gdx:gdx-controllers:$gdxVersion")
        compile(kotlin("stdlib"))
        compile(group = "io.github.libktx", name = "ktx-app", version = ktxVersion)
        compile(group = "io.github.libktx", name = "ktx-inject", version = ktxVersion)
        compile(group = "io.github.libktx", name = "ktx-log", version = ktxVersion)
        compile(group = "io.github.libktx", name = "ktx-assets", version = ktxVersion)
        compile(group = "io.github.libktx", name = "ktx-freetype", version = ktxVersion)
        compile(group = "io.github.libktx", name = "ktx-graphics", version = ktxVersion)
    }
}