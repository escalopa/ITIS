import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ExpressionTree {

    Node<String> root;
    List<String> postFixList = new LinkedList<>();
    List<String> preFixList = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();

    ExpressionTree() {

    }

    ExpressionTree(String str) {
        root = new Node<>(str);
    }

    private List<String> postFixRecord() {
        postFixDFS(root);
        return postFixList;
    }

    private void postFixDFS(Node<String> root) {
        if (root.left != null )
            postFixDFS(root.left);
        if (root.right != null)
            postFixDFS(root.right);
        postFixList.add(root.value);
    }

    private Node whichIsOperation(Node root) {
        if (root.right != null) {
            if (isOperation((String) root.right.value) || root.left == null) {
                return root.right;
            }
        }
        return root.left;
    }

    public List<String> preFixRecord() {
        postFixDFS(root);
        return preFixList;
    }

    private void preFixDFS(Node<String> root) {
        preFixList.add(root.value);
        if (root.left != null)
            postFixDFS(root.left);
        if (root.right != null)
            postFixDFS(root.right);
    }

    public int evaluate() {
        postFixDFS(root);
        for (String str : postFixList) {
            if (!isOperation(str)) {
                stack.push(Integer.parseInt(str));
            } else {
                preformOperation(str);
            }
        }
        return stack.pop();
    }

    private boolean isOperation(String str) {
        return (str.equals("-") | str.equals("+") | str.equals("*") | str.equals("/") | str.equals("^"));
    }

    private void preformOperation(String operation) {

        int sum = stack.pop();
        switch (operation) {
            case "-" -> sum -= stack.pop();
            case "+" -> sum += stack.pop();
            case "*" -> sum *= stack.pop();
            case "/" -> sum /= stack.pop();
            case "^" -> sum ^= stack.pop();
        }
        stack.push(sum);
    }
}
