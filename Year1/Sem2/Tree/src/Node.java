public class Node<T> {
    T value;
    Node<T> left, right;

    Node() {
    }

    Node(T value) {
        this.value = value;
    }
}
