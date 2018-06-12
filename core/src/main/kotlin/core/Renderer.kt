package core

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import ktx.log.logger
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch
import com.badlogic.gdx.graphics.g2d.PolygonSprite


class Renderer {
    companion object {
        val log = logger<World>()
    }

    private lateinit var spriteBatch: SpriteBatch
    private lateinit var shape: ShapeRenderer
    private lateinit var world: World

    private lateinit var poly: PolygonSprite
    private lateinit var polyBatch: PolygonSpriteBatch
    private lateinit var textureSolid: Texture

    fun create() {
        spriteBatch = Game.context.inject()
        shape = Game.context.inject()
        polyBatch = Game.context.inject()
        world = Game.context.inject()
    }

    fun render() {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        shape.setAutoShapeType(true)
        drawPoints(shape)
    }

    fun drawPoints(shape: ShapeRenderer) {

        for (a in world.areas) {
            shape.begin(ShapeRenderer.ShapeType.Filled)
            shape.color = a.color
            shape.polygon(a.poly.vertices)
            shape.end()
        }

        shape.color = Color.WHITE
        for (p in world.points) {
            shape.begin(ShapeRenderer.ShapeType.Filled)
            shape.circle(p.x.toFloat(), p.y.toFloat(), 5f)
            shape.end()
        }


    }


}