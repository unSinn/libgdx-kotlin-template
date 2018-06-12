package core

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import ktx.app.KtxApplicationAdapter

class MainGame : KtxApplicationAdapter {

    private lateinit var renderer: Renderer

    override fun create() {
        renderer = Game.context.inject()
        renderer.create()
    }

    override fun render() {
        renderer.render()
    }


    override fun dispose() {
        Game.context.dispose()
    }
}
