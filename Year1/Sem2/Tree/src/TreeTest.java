import org.junit.jupiter.api.Assertions;

class TreeTest {

    TreeTraversal t ;

    @org.junit.jupiter.api.Test
    void BFS_queue() {
        t = new TreeTraversal(100);
        Assertions.assertEquals(42,t.BFS_queue(t.root));
    }

    @org.junit.jupiter.api.Test
    void DFS_stack() {
        t = new TreeTraversal(200);
        Assertions.assertEquals(83,t.DFS_recursion(t.root));
    }

    @org.junit.jupiter.api.Test
    void DFS_recursion() {
        t = new TreeTraversal(40);
        Assertions.assertEquals(19,t.DFS_stack(t.root));
    }
}