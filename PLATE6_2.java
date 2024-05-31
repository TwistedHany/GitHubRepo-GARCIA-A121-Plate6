import java.util.*;

public class PLATE6_2 {

    static void countEdges(int[][] adjacencyMatrix) {
        int n = adjacencyMatrix.length;
        Map<String, Integer> edgeCount = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    String edge = "(" + i + ", " + j + ")";
                    edgeCount.put(edge, edgeCount.getOrDefault(edge, 0) + 1);
                }
            }
        }

        System.out.println("Edges and their counts:");
        for (Map.Entry<String, Integer> entry : edgeCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int n = scanner.nextInt();
        int[][] adjacencyMatrix = new int[n][n];
        System.out.println("Enter the adjacency matrix (0 for no edge, 1 for edge exists):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }
        countEdges(adjacencyMatrix);
    }
}