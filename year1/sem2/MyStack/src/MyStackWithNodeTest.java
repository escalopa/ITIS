import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

class MyStackWithNodeTest {

    MyStackWithNode<Integer> myStackWithNode = new MyStackWithNode<>();

    @BeforeEach
    public void SetUp() {

        for (int i = 0; i < 10; i++) {
            myStackWithNode.push(i);
        }
    }

    @Test
    void isEmpty() {

        Assert.assertFalse(myStackWithNode.isEmpty());
    }

    @Test
    void peek() {
        Assert.assertEquals(9, myStackWithNode.peek());
    }

    @Test
    void pop() {
        Assert.assertEquals(9, myStackWithNode.pop());
        Assert.assertEquals(8, myStackWithNode.pop());
    }

    @Test
    void search() {
        Assert.assertEquals(10, myStackWithNode.search(0));
    }

}