@file:JvmName("Main")

package desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import core.MainGame

fun main() {
    val config = LwjglApplicationConfiguration()
    config.height = 1080
    config.width = 1920
    config.resizable = false
    config.stencil = 8
    config.samples = 4
    LwjglApplication(MainGame(), config)
}
