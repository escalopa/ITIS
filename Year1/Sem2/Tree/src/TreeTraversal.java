import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversal {

    Node<Integer> root;
    static int evenNumber;

    public TreeTraversal(){

    }
    public TreeTraversal(int n) {
        root = new Node<Integer>();
        makeBalancedTreeOn(root, n);
    }

    public void printTree() {
        printNode(root, 0);
    }

    private void printNode(Node<Integer> n, int space) {

        if (n.left != null) {
            printNode(n.left, space + 1);
        }

        for (int i = 1; i <= space; i++) {
            System.out.print("  ");
        }
        System.out.println(n.value);

        if (n.right != null) {
            printNode(n.right, space + 1);
        }
    }

    private void makeBalancedTreeOn(Node<Integer> root, int n) {
        root.value = n;
        if (n > 1) {
            int nl = n / 2;
            root.left = new Node<Integer>();
            makeBalancedTreeOn(root.left, nl);
            int nr = n - nl - 1;
            if (nr == 0) {
                root.right = null;
            } else {
                root.right = new Node<Integer>();
                makeBalancedTreeOn(root.right, nr);
            }
        }


    }

    public int  BFS_queue(Node<Integer> root){

        evenNumber = 0;
        if (root == null) return -1;
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node<Integer> temp = queue.poll();
            if(temp.left!=null)queue.offer(temp.left);
            if(temp.right!=null)queue.offer(temp.right);
            if (temp.value%2  ==0) evenNumber++;
        }
        return evenNumber;
    }

    public int DFS_stack(Node<Integer> root){

        Stack<Node<Integer>> stack = new Stack<>();
        evenNumber = 0;
        stack.push(root);
        while (!stack.isEmpty()){
            Node<Integer> temp = stack.pop();
            if(temp.right!=null) stack.push(temp.right);
            if(temp.left!=null) stack.push(temp.left);
            if (temp.value%2==0) evenNumber++;
        }
        return evenNumber;
    }

    public int DFS_recursion(Node<Integer> root){
        if (root==null) return 0;
        return DFS_recursion(root.left) + DFS_recursion(root.right) + (root.value%2==0 ? 1 :0);

    }

}
