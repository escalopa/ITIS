import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;


class MyLinkedListTest {

    MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 30; i++) {
            myLinkedList.add(i);
        }
    }

    @Test
    void size() {
        Assertions.assertEquals(30, myLinkedList.size());
    }

    @Test
    void isEmpty() {
        Assertions.assertEquals(false, myLinkedList.isEmpty());
    }

    @Test
    void containsTrue() {
        Assertions.assertEquals(true, myLinkedList.contains(20));

    }

    @Test
    void containsFalse() {
        Assertions.assertEquals(false, myLinkedList.contains(30));

    }

    @Test
    void removeTrue() {
        Assertions.assertEquals(20, myLinkedList.remove(20));
    }

    @Test
    void removeFalse() {
        Assertions.assertEquals(null, myLinkedList.remove(40));

    }

    @Test
    void addWithIndex() {
        myLinkedList.add(10, 40);

        Assertions.assertAll(
                "heading",
                () -> Assertions.assertEquals(9, myLinkedList.indexOf(9)),
                () -> Assertions.assertEquals(10, myLinkedList.indexOf(40)),
                () -> Assertions.assertEquals(11, myLinkedList.indexOf(10)),
                () -> Assertions.assertEquals(12, myLinkedList.indexOf(11))
        );
    }


    @Test
    void addAll() {
        List<Integer> list = new LinkedList<>();
        for (int i = 30; i < 40; i++) {
            list.add(i);
        }
        myLinkedList.addAll(list);
    }

    @Test
    void clear() {
        myLinkedList.clear();
        Assertions.assertEquals(null, myLinkedList.remove(0));


    }

    @Test
    void get() {
        Assertions.assertEquals(21, myLinkedList.get(21));
    }

    @Test
    void set() {
        myLinkedList.set(0, 30);
        Assertions.assertEquals(30, myLinkedList.get(0));

    }

    @Test
    void indexOf() {
        Assertions.assertEquals(9, myLinkedList.indexOf(9));
    }

    @Test
    void indexOf0() {
        Assertions.assertEquals(-1, myLinkedList.indexOf(30));
    }

    @Test
    void subList() {
        List<Integer> list = new LinkedList<>();
        for (int i = 20; i < 30; i++) {
            list.add(i);
        }
        Assertions.assertEquals(true, list.equals(myLinkedList.subList(20, 29)));
    }
}