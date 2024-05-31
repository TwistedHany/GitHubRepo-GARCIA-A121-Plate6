import java.util.*;

public class PLATE6_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();

        // Create adjacency list
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        System.out.print("Enter the number of edges: ");
        int numEdges = scanner.nextInt();

        System.out.println("Enter the pairs of vertices associated with each edge:");
        for (int i = 0; i < numEdges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjacencyList.get(u).add(v);
            adjacencyList.get(v).add(u); // For undirected graph
        }

        // Calculate degree of each vertex
        int[] degree = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            degree[i] = adjacencyList.get(i).size();
        }

        // Output degrees of vertices
        System.out.println("Degrees of vertices:");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + i + ": " + degree[i]);
        }
    }
}
