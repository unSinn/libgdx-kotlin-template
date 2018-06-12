package core

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.math.MathUtils.random
import com.badlogic.gdx.math.Polygon
import de.alsclo.voronoi.graph.Edge
import de.alsclo.voronoi.graph.Point

class Area(val points: List<Point>,
           val edges: List<Edge>,
           val poly: Polygon) {

    val color = Color(random(), random(), random(), random() + 0.5f)


}

