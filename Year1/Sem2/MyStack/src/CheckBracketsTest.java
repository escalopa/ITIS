import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class CheckBracketsTest {

    String string;

    @Test
    public void checkBracketsWithoutStack(){

        string="(gh(()))";
        Assert.assertTrue(CheckBrackets.bracketsWithStack(string));
    }

    @Test
    public void checkBracketsWithStack00(){

        string="()[[]{}]";
        Assert.assertTrue(CheckBrackets.bracketsWithStack(string));


    }
    @Test
    public void checkBracketsWithStack01(){

        string="()[[{]}]";
        Assert.assertFalse(CheckBrackets.bracketsWithStack(string));


    }

}