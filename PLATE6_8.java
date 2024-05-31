import java.util.*;

public class PLATE6_8 {

    // Function to check if two graphs are isomorphic
    public static boolean areIsomorphic(int[][] graph1, int[][] graph2) {
        int n1 = graph1.length;
        int n2 = graph2.length;

        // Graphs must have the same number of vertices
        if (n1 != n2) return false;

        // Graphs must have the same number of edges
        if (!sameNumberOfEdges(graph1, graph2)) return false;

        // Use a permutation array to try all possible mappings
        int[] perm = new int[n1];
        for (int i = 0; i < n1; i++) {
            perm[i] = i;
        }

        return isIsomorphic(graph1, graph2, perm, 0);
    }

    // Function to check if graphs have the same number of edges
    private static boolean sameNumberOfEdges(int[][] graph1, int[][] graph2) {
        int edges1 = 0, edges2 = 0;
        for (int i = 0; i < graph1.length; i++) {
            for (int j = 0; j < graph1[i].length; j++) {
                edges1 += graph1[i][j];
                edges2 += graph2[i][j];
            }
        }
        return edges1 == edges2;
    }

    // Backtracking function to check for isomorphism
    private static boolean isIsomorphic(int[][] graph1, int[][] graph2, int[] perm, int index) {
        if (index == perm.length) {
            return checkIsomorphism(graph1, graph2, perm);
        }

        for (int i = index; i < perm.length; i++) {
            swap(perm, i, index);
            if (isIsomorphic(graph1, graph2, perm, index + 1)) {
                return true;
            }
            swap(perm, i, index);
        }
        return false;
    }

    // Swap function to generate permutations
    private static void swap(int[] perm, int i, int j) {
        int temp = perm[i];
        perm[i] = perm[j];
        perm[j] = temp;
    }

    // Function to check if a permutation results in an isomorphic mapping
    private static boolean checkIsomorphism(int[][] graph1, int[][] graph2, int[] perm) {
        int n = graph1.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph1[i][j] != graph2[perm[i]][perm[j]]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices for the graphs:");
        int vertices = scanner.nextInt();

        int[][] graph1 = new int[vertices][vertices];
        int[][] graph2 = new int[vertices][vertices];

        System.out.println("Enter the edges for the first graph:");
        inputGraph(scanner, graph1);

        System.out.println("Enter the edges for the second graph:");
        inputGraph(scanner, graph2);

        if (areIsomorphic(graph1, graph2)) {
            System.out.println("Graphs are isomorphic");
        } else {
            System.out.println("Graphs are not isomorphic");
        }

        scanner.close();
    }

    private static void inputGraph(Scanner scanner, int[][] graph) {
        System.out.println("Enter the number of edges: ");
        int edges = scanner.nextInt();
        System.out.println("Enter edges: ");

        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph[u][v] = 1;
            graph[v][u] = 1; // assuming undirected graph
        }
    }
}
