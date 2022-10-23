package olympics_2021;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class ProblemF {

    public static void main(String[] args) {


    }

    class Graph {

        // No. of vertices
        private int V;

        // Adjacency List Representation
        private LinkedList<LinkedList<Node>> adj;
        // Constructor
        Graph(int v) {
            V = v;
            adj = new LinkedList<>();
            for (int i = 0; i < v; ++i)
                adj[i] = new LinkedList();
        }

        void addEdge(Node v, Node w) {
            adj[v].add(w);
            adj[w].add(v);
        }


        Boolean isCyclicUtil(int v,Boolean visited[], int parent) {
            visited[v] = true;
            Integer i;
            Iterator<Integer> it =
                    adj[v].iterator();
            while (it.hasNext()) {
                i = it.next();
                if (!visited[i]) {
                    if (isCyclicUtil(i, visited, v))
                        return true;
                }
                else if (i != parent)
                    return true;
            }
            return false;
        }

        Boolean isCyclic() {

            Boolean visited[] = new Boolean[V];
            for (int i = 0; i < V; i++)
                visited[i] = false;
            for (int u = 0; u < V; u++) {
                if (!visited[u])
                    if (isCyclicUtil(u, visited, -1))
                        return true;
            }

            return false;
        }

        private class Node {
            private int x;
            private int y;

            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }

            public int getX() {
                return x;
            }

            public void setX(int x) {
                this.x = x;
            }

            public int getY() {
                return y;
            }

            public void setY(int y) {
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Node node = (Node) o;
                return x == node.x && y == node.y;
            }
        }
    }
}
