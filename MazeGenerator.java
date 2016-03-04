import java.util.*;

public class MazeGenerator {
    public static int size;	// Number of points on one side of maze
    public static int n;  // Total number of points in maze
    public static ArrayList<Point> points;
    public static ArrayList<Edge> edges;
    public static ArrayList<Edge> usedEdges;
    
    public static void main(String[] args) {
    	// Read in the size of a maze
	    Scanner scan = new Scanner(System.in);
	    try {	     
	        System.out.print("Enter the side length for the maze: ");
	        size = scan.nextInt();
	    }
	    catch(Exception ex){
	        ex.printStackTrace();
	    }
	    scan.close();
	     
	    // Create board and graph.
	    n = size*size;  // number of points
	    points = new ArrayList<Point>();

	    for (int r = 1; r <= size; r++) {
	    	for (int c = 1; c <= size; c++) {
	    		points.add(new Point(r, c));
	    	}
	    }

	    edges = new ArrayList<Edge>();

	    for (int i = 1; i <= n; i++) {
            // Add edge to the right of point i if it isn't the last in the column
	    	if (!(i % size == 0)) {
	    		edges.add(new Edge(points.get(i - 1), points.get(i)));
	    	}

            // Add edge below point i if it isn't in the bottom row
	    	if (!(i + size > n)) {
	    		edges.add(new Edge(points.get(i - 1), points.get(i + size - 1)));
	    	}
	    }

        DisjointSet djs = new DisjointSet(n);
        Random randomGenerator = new Random();
        int rand, u, v;
        Edge edge;
        usedEdges = new ArrayList<Edge>();

        while (djs.getNumSets() > 1) {
            rand = randomGenerator.nextInt(edges.size());
            edge = edges.get(rand);

            u = djs.find(points.indexOf(edge.pointA));
            v = djs.find(points.indexOf(edge.pointB));

            if (u != v) {
                djs.union(u, v);
                edges.remove(rand);
            } else {
                edges.remove(rand);
                usedEdges.add(edge);
            }
        }

        printBoard();
    }

    public static void printBoard() {
    	// Print top edges
    	System.out.print("    -");
    	for (int c = 1; c <= size; c++) {
    		System.out.print("----");
    	}
    	System.out.println();

    	// Iterate through all points (1, 1) through (size, size)
        for (int r = 1; r <= size; r++) {
        	// Print leftmost edge
        	if (r == 1) {
        		System.out.print("Start");
        	} else {
        		System.out.print("    |");
        	}

        	// Print right edge of each cell if the edge exists, or it is the last cell in the column
        	for (int c = 1; c <= size; c++) {
        		if (c == size) {
        			if (r == size) {
        				System.out.print("    End");
        			} else {
        				System.out.print("   |");
        			}
        		} else {
        			Edge rightEdge = new Edge(new Point(r, c), new Point(r, c + 1));
        			if (edges.contains(rightEdge) || usedEdges.contains(rightEdge)) {
        				System.out.print("   |");
        			} else {
        				System.out.print("    ");
        			}
        		}
        	}
        	System.out.println();

        	// Print bottom edges if the edge exists, or the cell is in the bottom row
        	System.out.print("    -");
        	for (int c = 1; c <= size; c++) {
        		if (r == size) {
        			System.out.print("----");
        		} else {
        			Edge bottomEdge = new Edge(new Point(r, c), new Point(r + 1, c));
        			if (edges.contains(bottomEdge) || usedEdges.contains(bottomEdge)) {
        				System.out.print("----");
        			} else {
        				System.out.print("   -");
        			}
        		}
        	}
        	System.out.println();
        }
    }
}

