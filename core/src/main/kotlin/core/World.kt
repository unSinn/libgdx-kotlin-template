package core

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Polygon
import de.alsclo.voronoi.Voronoi
import de.alsclo.voronoi.graph.Edge
import de.alsclo.voronoi.graph.Point
import de.alsclo.voronoi.graph.Vertex
import ktx.log.logger
import java.util.*
import java.util.stream.Collectors.toList
import kotlin.collections.ArrayList


class World {

    companion object {
        val log = logger<World>()
    }

    var r = Game.context.inject<Random>()
    fun random() = r.nextDouble() * SIZE

    val SIZE = 1000

    var list = List(SIZE) { Point(random(), random()) }
    var diagram = Voronoi(list).relax().relax()

    val areas = mutableListOf<Area>()
    val edges: List<Edge>

    val points: List<Point>

    init {
        edges = diagram.graph.edgeStream().collect(toList())
                .toList()
                .mapNotNull { it }
                .filter { it.a != null && it.b != null }
        points = diagram.graph.sitePoints.mapNotNull { it }

        val edgesForPoint: Map<Point, List<Edge>>

        edgesForPoint = points.associateBy({ it }, { p ->
            edges.filter { e ->
                e.site1 == p || e.site2 == p
            }
        })

        edgesForPoint.forEach { p, e ->
            val floats = arrayListOf<Float>()
            val edges = mutableListOf<Edge>()
            edges.addAll(e)

            val start = e[0].a.location
            val end = e[0].b.location

            floats.add(end.x.toFloat())
            floats.add(end.y.toFloat())
            floats.add(e[0].a.location.x.toFloat())
            floats.add(e[0].a.location.y.toFloat())


            edges.removeAt(0)

            var current = start

            var i = 0
            while (current != end && i < 100) {
                edges.find { it.a.location == current }
                        ?.let {
                            floats.add(it.b.location.x.toFloat())
                            floats.add(it.b.location.y.toFloat())
                            current = it.b.location
                            edges.remove(it)
                        }
                edges.find { it.b.location == current }
                        ?.let {
                            floats.add(it.a.location.x.toFloat())
                            floats.add(it.a.location.y.toFloat())
                            current = it.a.location
                            edges.remove(it)
                        }
                i++
            }

            if (floats.size > 6) {
                areas.add(Area(points, e, Polygon(floats.toFloatArray())))
            }
        }
    }


}