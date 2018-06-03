package core.fortune.voronoi;

// a point in 2D, sorted by y-coordinate
public class Point implements Comparable <Point>{
	
	public double x;
	public double y;
	
	public Point (double x0, double y0) {
		x = x0;
		y = y0;
	}
	
	public int compareTo (Point other) {
		if (this.y == other.y) {
			return Double.compare(this.x, other.x);
		}
		else if (this.y > other.y) {
			return 1;
		}
		else {
			return -1;
		}
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}
