import javax.print.attribute.standard.NumberUp;

public class Int2Bainary {
    public static int Number2Integer(int Number)
    {
        {
            if (Number == 0)
                return 0;
            else
                return (Number % 2 + 10 * Number2Integer(Number / 2));
        }
    }
    public static void main(String[] args) {
        int Number=501;
        System.out.print("Число "+Number+" представлено в двоичной форме следующим образом "+Number2Integer(Number));
        
    }
}
