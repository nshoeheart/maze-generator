public class Edge { 
    // an Edge is a link between two Points: 
    Point pointA;
    Point pointB;

    // Constructor
    public Edge(Point a, Point b) {
        this.pointA = a;
        this.pointB = b;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!Edge.class.isAssignableFrom(obj.getClass())) return false;

        final Edge e = (Edge) obj;
        return ((this.pointA.equals(e.pointA) && this.pointB.equals(e.pointB)) || (this.pointA.equals(e.pointB) && this.pointB.equals(e.pointA)));
    }

    public String toString() {
        return String.format("Edge: {(%d, %d), (%d, %d)}", pointA.r, pointA.c, pointB.r, pointB.c);
    }
}