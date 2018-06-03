@file:JvmName("Main")

package desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import core.MainGame

fun main(arg: Array<String>) {
    val config = LwjglApplicationConfiguration()
    config.height = 1080
    config.width = 1920
    config.resizable = false
    LwjglApplication(MainGame(), config)
}
