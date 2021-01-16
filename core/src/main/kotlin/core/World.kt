package core

import de.alsclo.voronoi.Voronoi
import de.alsclo.voronoi.graph.Edge
import de.alsclo.voronoi.graph.Point
import ktx.log.logger
import java.util.*
import java.util.stream.Collectors.toList


class World {

    companion object {
        val log = logger<World>()
    }

    var r = Game.context.inject<Random>()
    private fun random() = r.nextDouble() * size

    private val size = 1000

    var list = List(size) { Point(random(), random()) }
    var diagram: Voronoi = Voronoi(list).relax().relax()

    val areas = mutableListOf<Area>()
    val edges: List<Edge> = diagram.graph.edgeStream().collect(toList())
        .toList()
        .mapNotNull { it }
        .filter { it.a != null && it.b != null }

    val points: List<Point> = diagram.graph.sitePoints.mapNotNull { it }

    init {
        val edgesForPoint: Map<Point, List<Edge>> = points.associateBy({ it }, { p ->
            edges.filter { e ->
                e.site1 == p || e.site2 == p
            }
        })
        edgesForPoint.forEach { (p, _) ->
            val floats = arrayListOf<Float>()
            val edges = mutableListOf<Edge>()
            edges.addAll(edges)

            val start = edges[0].a.location
            val end = edges[0].b.location

            floats.add(end.x.toFloat())
            floats.add(end.y.toFloat())
            floats.add(edges[0].a.location.x.toFloat())
            floats.add(edges[0].a.location.y.toFloat())


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
                areas.add(Area(edges, p))
            }
        }
    }


}