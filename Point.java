public class Point {  // a Point is a position in the maze
    public int r, c;
    public boolean visited;   // for DFS
    public Point parent;      // for DFS

    // Constructor
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public boolean equals(Object obj) {
    	if (obj == null) return false;
    	if (!Point.class.isAssignableFrom(obj.getClass())) return false;

    	final Point p = (Point) obj;
    	return (this.r == p.r && this.c == p.c);
    }

    public String toString() {
    	return String.format("Point: (%d, %d)", r, c);
    }
}