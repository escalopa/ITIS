public class MyStackWithNode<T> {

    private class Node {

        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node top;

    public boolean isEmpty() {
        return top == null;
    }

    public  Object peek() {
        if (top != null)
            return top.data;
        else return null;
    }

    public Object pop() {
        if (top != null) {

            Object object = top.data;
            top = top.next;
            return object;
        }
        return null;
    }

    public T push(T object) {
        Node node = new Node(object);
        if (top != null)
            node.next = top;
        top = node;
        return top.data;
    }

    public int search(T object) {

        int index = 1;
        Node node = top;
        while (node != null) {
            if (object.equals(node.data))
                return index;

            index++;
            node = node.next;
        }
        return -1;
    }

}