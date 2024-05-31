import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        for (Integer n : adj[v]) {
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    boolean isConnected() {
        boolean visited[] = new boolean[V];
        int i;
        for (i = 0; i < V; ++i)
            visited[i] = false;

        for (i = 0; i < V; ++i)
            if (adj[i].size() != 0)
                break;

        if (i == V)
            return true;

        DFSUtil(i, visited);

        for (i = 0; i < V; ++i)
            if (!visited[i] && adj[i].size() > 0)
                return false;

        return true;
    }

    int countConnectedComponents() {
        boolean visited[] = new boolean[V];
        int count = 0;
        for (int v = 0; v < V; ++v) {
            if (!visited[v]) {
                DFSUtil(v, visited);
                count++;
            }
        }
        return count;
    }
}

public class PLATE6_1 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int Vertice = scanner.nextInt();
        Graph graph = new Graph(Vertice);
        System.out.print("Enter the number of edges: ");
        int Edges = scanner.nextInt();
        System.out.println("Enter edges in the format 'source destination':");
        for (int i = 0; i < Edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }
        if (graph.isConnected()) {
            System.out.println("The graph is connected.");
        } else {
            System.out.println("The graph is not connected.");
            int components = graph.countConnectedComponents();
            System.out.println("Number of connected components: " + components);
        }
    }
}
