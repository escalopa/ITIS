import java.util.Comparator;
import java.util.Stack;

public class ExpTreeMain {

    public static void main(String[] args) {

        ExpressionTree expressionTree = new ExpressionTree("*");
        expressionTree.root.left = new Node<>("5");
        expressionTree.root.right = new Node<>("+");
        expressionTree.root.right.left = new Node<>("5");
        expressionTree.root.right.right = new Node<>("5");

        System.out.println(expressionTree.evaluate());

        System.out.println(expressionTree.postFixList.toString());
    }

}
