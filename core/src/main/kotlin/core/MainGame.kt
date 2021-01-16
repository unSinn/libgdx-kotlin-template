package core

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
