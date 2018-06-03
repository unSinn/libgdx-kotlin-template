package core.fortune.voronoi;

// represents the beach line
// can either be a site that is the center of a parabola
// or can be a vertex that bisects two sites
public class Parabola {
	
	static int IS_FOCUS = 0;
	static int IS_VERTEX = 1;
	
	int type;
	Point point; // if is focus
	Edge edge; // if is vertex
	Event event; // a parabola with a focus can disappear in a circle event
	
	Parabola parent;
	Parabola child_left;
	Parabola child_right;
	
	Parabola() {
		type = IS_VERTEX;
	}
	
	Parabola(Point p) {
		point = p;
		type = IS_FOCUS;
	}

	void setLeftChild(Parabola p) {
		child_left = p;
		p.parent = this;
	}

	void setRightChild(Parabola p) {
		child_right = p;
		p.parent = this;
	}

	public String toString() {
		if (type == IS_FOCUS) {
			return "Focus at " + point;
		}
		else{
			return "Vertex/Edge beginning at " + edge.start;
		}
	}
	
	// returns the closest left site (focus of parabola) 
	public static Parabola getLeft(Parabola p) {
		return getLeftChild(getLeftParent(p));
	}
	
	// returns closest right site (focus of parabola)
	public static Parabola getRight(Parabola p) {
		return getRightChild(getRightParent(p));
	}
	
	// returns the closest parent on the left
	static Parabola getLeftParent(Parabola p) {
		Parabola parent = p.parent;
		if (parent == null) return null;
		Parabola last = p;
		while (parent.child_left == last) {
			if(parent.parent == null) return null;
			last = parent;
			parent = parent.parent;
		}
		return parent;
	}
	
	// returns the closest parent on the right
	static Parabola getRightParent(Parabola p) {
		Parabola parent = p.parent;
		if (parent == null) return null;
		Parabola last = p;
		while (parent.child_right == last) {
			if(parent.parent == null) return null;
			last = parent;
			parent = parent.parent;
		}
		return parent;
	}
	
	// returns closest site (focus of another parabola) to the left
	static Parabola getLeftChild(Parabola p) {
		if (p == null) return null;
		Parabola child = p.child_left;
		while(child.type == IS_VERTEX) child = child.child_right;
		return child;
	}
	
	// returns closest site (focus of another parabola) to the right
	static Parabola getRightChild(Parabola p) {
		if (p == null) return null;
		Parabola child = p.child_right;
		while(child.type == IS_VERTEX) child = child.child_left;
		return child;	
	}
	
	

}
