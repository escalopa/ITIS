import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static class Edge {
        int ver1;
        int ver2;

        Edge(int v1, int v2) {
            this.ver1 = v1;
            this.ver2 = v2;
        }

        public int getVer1() {
            return ver1;
        }

        public int getVer2() {
            return ver2;
        }
    }

    public static void main(String[] args) {

        int vertices = 10;
        List<Edge> edgeList = new LinkedList<>();
        edgeList.add(new Edge(5,6));
        edgeList.add(new Edge(2,3));
        edgeList.add(new Edge(5,4));
        edgeList.add(new Edge(5,1));
        edgeList.add(new Edge(5,0));
        edgeList.add(new Edge(8,0));
        edgeList.add(new Edge(0,9));
        edgeList.add(new Edge(2,4));
        edgeList.add(new Edge(6,9));
        edgeList.add(new Edge(7,9));
        edgeList.add(new Edge(0,6));
        edgeList.add(new Edge(0,3));
        edgeList.add(new Edge(7,8));
        edgeList.add(new Edge(1,6));
        edgeList.add(new Edge(3,2));
        edgeList.add(new Edge(9,8));

        int[][] matrix = list2Matrix(edgeList,vertices);
        Graph graph = new Graph(matrix);
        System.out.println("DFS");
        graph.DFS(0);
        System.out.println("BFS");
        graph.BFS(0);


    }

    public static int[][] list2Matrix (List<Edge> list, int number_vertices){
        int[][] matrix = new int[number_vertices][number_vertices];
        for (int[] array:matrix) {
            Arrays.fill(array,0);
        }
        for (Edge edge: list) {
            int v1= edge.getVer1();
            int v2= edge.getVer2();
            matrix[v1][v2]++;
            matrix[v2][v1]++;
        }
        return matrix;
    }
}
