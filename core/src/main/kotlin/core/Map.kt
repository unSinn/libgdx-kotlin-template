package core

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import core.fortune.voronoi.Voronoi

class Map {

    val SIZE = 1000
    val v: Voronoi = Voronoi.gen(SIZE)

    fun drawPoints(shape: ShapeRenderer) {
        // draw results


        shape.color = Color.WHITE

        for (p in v.sites) {
            shape.begin(ShapeRenderer.ShapeType.Filled)
            shape.circle(p.x.toFloat() * SIZE, p.y.toFloat() * SIZE, 5f)
            shape.end()
        }

        for (e in v.edges) {
            shape.begin(ShapeRenderer.ShapeType.Line)
            shape.line(e.start.x.toFloat() * SIZE, e.start.y.toFloat() * SIZE, e.end.x.toFloat() * SIZE, e.end.y.toFloat() * SIZE)
            shape.end()
        }

    }

}