import java.util.*;

public class MyQueue<T> implements Queue<T> {

    private class Node {

        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }
    }

    private int capacity = 0;
    private Node head;
    private Node tail;

    @Override
    public int size() {
        return capacity;
    }

    public boolean isEmpty() {

        return capacity == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node node = head;
        while (node != null) {
            if (node.data.equals(o))
                return true;
            node = node.next;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        //T[] array = new T[capacity];
        //Array.newInstance(array,capacity);
        Node node=head;
        for (int i = 0; i <capacity ; i++) {
           // array[i]=node.data;
            node=node.next;
        }
        return null;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        Node node = new Node(t);
        if (tail != null)
            tail.next = node;

        tail = node;

        if (head == null)
            head = node;

        capacity++;
        return true;
    }

    @Override
    public boolean offer(T t) {
        return false;
    }

    @Override
    public T remove() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        Node node = head;
        while (node.next != null) {
            if (node.data.equals(o)) {
                poll();
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        capacity = 0;
    }


    @Override
    public T poll() {
        if (head==null) return null;
        T data = head.data;
        head = head.next;
        if (head == null)
            tail = null;
        capacity--;
        return data;
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public T peek() {
        return head.data;
    }


}
