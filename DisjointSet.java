public class DisjointSet {
    public static final int ROOT = -1;
    private int[] up; // keeps track of "up" pointers in up-tree
    private int[] rank; // keeps track of rank of sets
    private int numSets;

    public DisjointSet(int n) {
        up = new int[n];
        rank = new int[n];
        numSets = n;

        for (int i = 1; i <= n; i++) {
            up[i-1] = ROOT;
            rank[i-1] = 0;
        }
    }

    // Finds and returns the root of the set containing i
    public int find(int i) {
        int r = i;

        // Find root
        while (up[r] != ROOT) {
            r = up[r];
        }

        // Do path compression
        if (r != i) {
            int y = up[i];

            while (y != r) {
                up[i] = r;
                i = y;
                y = up[y];
            }
        }

        return r;
    }

    // Perform union by rank
    // Precondition: i and j must be roots of two separate sets
    public void union(int i, int j) {
        if (rank[i] <= rank[j]) {
            up[i] = j;
            if (rank[i] == rank[j]) {
                rank[j]++;
            }
        } else { // equal ranks
            up[j] = i;
        }

        numSets--;
    }

    public int getNumSets() {
        return numSets;
    }
}