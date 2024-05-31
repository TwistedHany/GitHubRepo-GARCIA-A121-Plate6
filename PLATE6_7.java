import java.util.*;

public class PLATE6_7 {

    // Method to create incidence matrix
    public static int[][] createIncidenceMatrix(List<int[]> edges, int numVertices, int numEdges) {
        // Initialize incidence matrix
        int[][] incidenceMatrix = new int[numVertices][numEdges];

        // Populate incidence matrix with edges
        for (int i = 0; i < numEdges; i++) {
            int[] edge = edges.get(i);
            int u = edge[0];
            int v = edge[1];
            int count = edge[2]; // number of times the edge appears

            // Since the graph is undirected, mark both u and v for each edge count
            incidenceMatrix[u][i] = count;
            incidenceMatrix[v][i] = count;
        }

        return incidenceMatrix;
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
            int count = scanner.nextInt();
            edges.add(new int[]{u, v, count});
        }

        // Create incidence matrix
        int[][] incidenceMatrix = createIncidenceMatrix(edges, numVertices, numEdges);

        // Display incidence matrix
        System.out.println("Incidence Matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numEdges; j++) {
                System.out.print(incidenceMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
