@file:JvmName("Main")
package desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import core.MainGame

fun main(arg: Array<String>) {
    val config = LwjglApplicationConfiguration()
    LwjglApplication(MainGame(), config)
}
