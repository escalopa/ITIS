import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Find235NumbersTest {


    @Test
    public void find235WithoutQueueTrail0(){
        //{2,3,4,5,6,8,9,10,12,15,16,18,20,24,25}
        Assertions.assertEquals(15,Find235Numbers.find235WithoutQueue(25).size());
    }

    @Test
    public void find235WithoutQueueTrail1(){

    }
    @Test
    public void find235WithoutQueueTrail2(){

    }

}
