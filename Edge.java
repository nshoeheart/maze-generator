// Edges represent a link/boundary between two Points
public class Edge {  
    Point pointA;
    Point pointB;

    // Constructor
    public Edge(Point a, Point b) {
        this.pointA = a;
        this.pointB = b;
    }

    // Override the equals method that is used when searching for an Edge with ArrayList.contains() method
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!Edge.class.isAssignableFrom(obj.getClass())) return false;

        final Edge e = (Edge) obj;
        return ((this.pointA.equals(e.pointA) && this.pointB.equals(e.pointB)) || (this.pointA.equals(e.pointB) && this.pointB.equals(e.pointA)));
    }
}