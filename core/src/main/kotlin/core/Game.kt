package core

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import ktx.inject.*
import java.util.Random


object Game {

    val context = Context()

    init {
        context.register {
            bind { Random() }
            bind { SpriteBatch() }
            bind { ShapeRenderer() }
            bindSingleton { Map() }
        }

    }

}