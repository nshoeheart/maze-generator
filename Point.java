// a Point is a position in the maze
public class Point {  
    public int r; // row number
    public int c; // column number

    // Constructor
    public Point(int r, int c) {
        this.r = r;
        this.c = c;
    }

    // Override the equals method that is used to compare Points
    public boolean equals(Object obj) {
    	if (obj == null) return false;
    	if (!Point.class.isAssignableFrom(obj.getClass())) return false;

    	final Point p = (Point) obj;
    	return (this.r == p.r && this.c == p.c);
    }
}