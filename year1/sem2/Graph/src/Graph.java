import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    private final int vertices;
    private List<List<Integer>> adjList;

    Graph(int verticesNumber) {
        vertices = verticesNumber;
        adjList = new LinkedList<>();
    }

    Graph(int[][] matrix) {
        vertices = matrix.length;
        adjList = new LinkedList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new LinkedList<>());
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                if (matrix[i][j]==0) continue;
                if (!adjList.get(i).contains(j))
                    addEdge(i,j);
            }
        }
    }

    public void addEdge(int v1, int v2) {
        adjList.get(v1).add(v2);
        adjList.get(v2).add(v1);
    }

    public void removeEdge(int v1, int v2) {
        adjList.get(v1).remove(v2);
        adjList.get(v2).remove(v1);
    }

    public void BFS(int v) {

        boolean[] visited = new boolean[vertices];
        Arrays.fill(visited, false);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node);
            for (int ver : adjList.get(node)) {
                if (!visited[ver]) {
                    queue.offer(ver);
                    visited[ver] = true;
                }
            }
        }
    }

    public void DFS(int v) {
        boolean[] visited = new boolean[vertices];
        Arrays.fill(visited, false);
        DFS_Recursion(v, visited);
    }

    private void DFS_Recursion(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println(v);
        for (int ver : adjList.get(v)) {
            if (visited[ver]) continue;
            DFS_Recursion(ver, visited);
        }
    }

}
