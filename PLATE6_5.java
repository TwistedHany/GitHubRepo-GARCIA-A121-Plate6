import java.util.*;

class PLATE6_5 {
    private int V;
    private LinkedList<Integer> adj[];

    PLATE6_5(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v,int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    boolean isBipartite() {
        int color[] = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!isBipartiteUtil(i, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean isBipartiteUtil(int src, int color[]) {
        color[src] = 0; // Change from color[src] = 1; to color[src] = 0;

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Integer v : adj[u]) {
                if (color[v] == -1) {
                    color[v] = 1 - color[u];
                    queue.add(v);
                } else if (color[v] == color[u]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        PLATE6_5 g = new PLATE6_5(V);

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        System.out.println("Enter the pairs of edges:");
        for (int i = 0; i < E; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            g.addEdge(v, w);
        }

        scanner.close();

        if (g.isBipartite())
            System.out.println("Graph is bipartite");
        else
            System.out.println("Graph is not bipartite");
    }
}
