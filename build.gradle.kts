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

    // Use this task to run the game if IntelliJ run application configuration doesn't work.
    tasks.register<JavaExec>("run") {
        main = "desktop.Main"
        classpath = sourceSets.main.get().runtimeClasspath
        standardInput = System.`in`
        isIgnoreExitValue = true
    }

    dependencies {
        implementation(project(":core"))
        implementation("com.badlogicgames.gdx:gdx-backend-lwjgl:$gdxVersion")
        implementation("com.badlogicgames.gdx:gdx-platform:$gdxVersion:natives-desktop")
        implementation("com.badlogicgames.gdx:gdx-freetype-platform:$gdxVersion:natives-desktop")
        implementation("com.badlogicgames.gdx:gdx-tools:$gdxVersion")
        implementation("com.badlogicgames.gdx:gdx-controllers-desktop:$gdxVersion")
        implementation("com.badlogicgames.gdx:gdx-controllers-platform:$gdxVersion:natives-desktop")
        implementation(kotlin("stdlib"))
    }
}

project(":core") {
    apply(plugin = "kotlin")

    val gdxVersion = this.extra["gdxVersion"]

    dependencies {
        val ktxVersion = "1.9.13-b1"

        implementation(kotlin("stdlib"))
        implementation("de.alsclo:voronoi-java:1.0")
        implementation("com.badlogicgames.gdx:gdx:$gdxVersion")
        implementation("com.badlogicgames.gdx:gdx-freetype:$gdxVersion")
        implementation("com.badlogicgames.gdx:gdx-controllers:$gdxVersion")
        api(group = "io.github.libktx", name = "ktx-app", version = ktxVersion)
        implementation(group = "io.github.libktx", name = "ktx-inject", version = ktxVersion)
        implementation(group = "io.github.libktx", name = "ktx-log", version = ktxVersion)
        implementation(group = "io.github.libktx", name = "ktx-assets", version = ktxVersion)
        implementation(group = "io.github.libktx", name = "ktx-freetype", version = ktxVersion)
        implementation(group = "io.github.libktx", name = "ktx-graphics", version = ktxVersion)
    }
}