import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyQueueTest {

    MyQueue<Integer> myQueue = new MyQueue<>();

    @BeforeEach
    void setUp() {

        for (int i = 0; i < 20; i++) {
            myQueue.add(i);
        }
    }

    @Test
    void size() {
        Assertions.assertEquals(20, myQueue.size());
    }

    @Test
    void isEmpty() {
        Assertions.assertEquals(false, myQueue.isEmpty());
    }

    @Test
    void contains() {
        Assertions.assertEquals(true, myQueue.contains(6));
    }

    @Test
    void remove() {
        Assertions.assertTrue(myQueue.remove(15));
        Assertions.assertFalse(myQueue.remove(20));
    }

    @Test
    void clear() {
        myQueue.clear();

        Assertions.assertNull(myQueue.poll());
        Assertions.assertTrue(myQueue.isEmpty());
    }

    @Test
    void poll() {
        Assertions.assertEquals(0, myQueue.poll());
        Assertions.assertEquals(1, myQueue.poll());
    }

    @Test
    void peek() {

        Assertions.assertEquals(0, myQueue.peek());
    }
}