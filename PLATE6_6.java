import java.util.*;

public class PLATE6_6 {

    // Method to create adjacency matrix
    public static int[][] createAdjacencyMatrix(List<int[]> edges, int numVertices) {
        // Initialize adjacency matrix
        int[][] adjMatrix = new int[numVertices][numVertices];

        // Populate adjacency matrix with edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjMatrix[u][v]++;
        }

        return adjMatrix;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of vertices
        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        // Input number of edges
        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        // List to store edges
        List<int[]> edges = new ArrayList<>();

        // Input edges
        System.out.println("Enter the edges: ");
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            edges.add(new int[]{u, v});
        }

        // Create adjacency matrix
        int[][] adjMatrix = createAdjacencyMatrix(edges, numVertices);

        // Display adjacency matrix
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
