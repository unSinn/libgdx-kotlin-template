# libgdx-kotlin-template

This is a template for LibGDX using Kotlin,  and [gradle-script-kotlin](https://github.com/gradle/gradle-script-kotlin).
It also has [KTX](https://github.com/libktx/ktx) dependencies. It currently only has the core and desktop modules. 

I created this because the official LibGDX project generator is still using an old version of gradle and old tasks, 
I didn't like the project structure it made, it didn't automatically add Kotlin support, and it was using the Groovy Gradle DSL, and I prefer the new Kotlin Gradle DSL.

To use it, simply download the repo and start coding. You can import the project into IntelliJ using the settings.gradle file. To run the desktop game, simply run the gradle task :desktop:run.
