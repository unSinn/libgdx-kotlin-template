package core.fortune.voronoi;

// an event is either a site or circle event for the sweep line to process
public class Event implements Comparable <Event>{
	
	// a site event is when the point is a site
	static int SITE_EVENT = 0;
	
	// a circle event is when the point is a vertex of the voronoi diagram/parabolas
	static int CIRCLE_EVENT = 1;
	
	Point p;
	int type;
	Parabola arc; // only if circle event
	
	Event(Point p, int type) {
		this.p = p;
		this.type = type;
		arc = null;
	}
	
	public int compareTo(Event other) {
		return this.p.compareTo(other.p);
	}

}
