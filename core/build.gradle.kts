import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    application
    kotlin("jvm")
}

val gdxVersion: String by extra
val ktxVersion: String by extra

dependencies {
    compile("com.badlogicgames.gdx:gdx:$gdxVersion")
    compile("io.github.libktx:ktx-actors:$ktxVersion")
    compile("io.github.libktx:ktx-app:$ktxVersion")
    compile("io.github.libktx:ktx-assets:$ktxVersion")
    compile("io.github.libktx:ktx-async:$ktxVersion")
    compile("io.github.libktx:ktx-collections:$ktxVersion")
    compile("io.github.libktx:ktx-i18n:$ktxVersion")
    compile("io.github.libktx:ktx-inject:$ktxVersion")
    compile("io.github.libktx:ktx-log:$ktxVersion")
    compile("io.github.libktx:ktx-math:$ktxVersion")
    compile("io.github.libktx:ktx-scene2d:$ktxVersion")
    compile("io.github.libktx:ktx-style:$ktxVersion")
    compile(kotlin("stdlib"))
}

