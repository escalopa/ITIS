import javax.security.auth.login.CredentialException;
import java.util.*;


public class MyLinkedList<T> implements List<T> {

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.add(0);
        myLinkedList.add(1);
        myLinkedList.add(2);
        System.out.println(myLinkedList.remove(3));
        System.out.println(myLinkedList.get(0));
        System.out.println(myLinkedList.get(1));

    }

    private class Elem<T> {

        public T data;
        Elem<T> next;

        Elem(T data) {
            this.data = data;
        }
    }

    private int capacity = 0;
    private Elem<T> head;
    private Elem<T> tail;

    @Override
    public int size() {
        return capacity;
        /*
        int count =0 ;
        while (head.next != null){
            count++;
        }
        return count;
        */
    }

    @Override
    public boolean isEmpty() {
        return capacity == 0;
    }

    @Override
    public boolean contains(Object o) {
        Elem<T> node;
        node = head;
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
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        Elem<T> node = new Elem<T>(t);
        if (head == null) {
            head = node;
            head.next = node;

        }
        if (tail != null)
            tail.next = node;
        tail = node;
        capacity++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Elem<T> node;
        node = head;
        while (node.next != null) {
            if (node.next.data.equals(o)) {
                node.next = node.next.next;
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<T> iterator = (Iterator<T>) c.iterator();
        while (iterator.hasNext()) {
            if (!contains(iterator.next())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            add(t);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index > capacity - 1 | index < 0) {
            return false;
        }
        int count = 0;
        Elem<T> node = head;
        while (node != null) {
            if (count == index)
                break;
            count++;
            node = node.next;
        }
        if (count != index) return false;
        for (T t : c) {
            add(t);
        }
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
    public T get(int index) {
        Elem<T> node = head;
        for (int i = 0; i < capacity; i++) {
            if (i == index) {
                return node.data;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public T set(int index, T element) {
        Elem<T> node = head;
        for (int i = 0; i < capacity; i++) {
            if (i == index) {
                node.data = element;
                return node.data;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public void add(int index, T element) {
        Elem<T> newNode = new Elem<>(element);
        Elem<T> node = head;
        int count = 0;
        if (index == 0) {
            newNode.next = head;
            newNode = head;
        }
        while (count < capacity & node.next != null) {
            if ((count + 1) == index) {
                newNode.next = node.next;
                node.next = newNode;
                break;
            }
            count++;
            node = node.next;
        }
    }

    @Override
    public T remove(int index) {
        Elem<T> node = head;
        if (isEmpty())
            return null;
        if (index == 0) {
            node = node.next;
            head=node;
        }
        int i = 1;
        while (node.next != null) {
            if (i == index) {
                T temp = node.next.data;
                node.next = node.next.next;
                System.out.println(temp);
                return temp;
            }
            i++;
            node = node.next;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        Elem<T> node = head;
        int count = 0;
        while (node != null) {
            if (node.data.equals(o))
                return count;
            count++;
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Elem<T> node = head;
        int count = 0;
        int value = -1;
        while (node != null) {
            if (node.data.equals(o))
                value = count;
            count++;
            node = node.next;
        }
        return value;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        List<T> list = new LinkedList<>();
        Elem<T> node = head;
        int count = 0;
        while (count < fromIndex & node != null) {
            node = node.next;
            count++;
        }
        while (count <= toIndex & node != null & count >= fromIndex) {
            list.add(node.data);
            node = node.next;
            count++;
        }
        return list;
    }
}
