package core

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.math.MathUtils.random
import de.alsclo.voronoi.graph.Edge
import de.alsclo.voronoi.graph.Point

class Area(
    val edges: List<Edge>,
    val center: Point
) {
    val color = Color(random(), random(), random(), random() + 0.5f)
}

