package core

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import ktx.app.KtxApplicationAdapter

class MainGame : KtxApplicationAdapter {

    private lateinit var batch: SpriteBatch
    private lateinit var shape: ShapeRenderer
    private lateinit var img: Texture
    private lateinit var map: Map

    override fun create() {
        batch = Game.context.inject()
        shape = Game.context.inject()
        map = Game.context.inject()
        img = Texture("badlogic.jpg")
    }

    override fun render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        shape.setAutoShapeType(true)
        map.drawPoints(shape)

        batch.begin()
        batch.end()
    }


    override fun dispose() {
        Game.context.dispose()
        img.dispose()
    }
}
