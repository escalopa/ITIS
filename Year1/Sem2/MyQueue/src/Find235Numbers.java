import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Find235Numbers {

    public static void main(String[] args) {
        for (int num:find235WithoutQueue(25)) {
            System.out.print(num+" ,");
        }
    }

    public static List<Integer> find235WithoutQueue(int max) {

        List<Integer> list = new LinkedList<>();

        for (int i = 0; i <= max; i++) {
            if (is235NumberWithoutQueue(i))
                list.add(i);
        }
        return list;
    }

    public static List<Integer> find235WithQueue(int max) {

        List<Integer> list = new LinkedList<>();

        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();
        Queue<Integer> q5 = new LinkedList<>();


        return list;
    }

    private static boolean is235NumberWithoutQueue(int num) {

        if (num == 1) return false;

        num = divide2TheMax(num, 2);
        num = divide2TheMax(num, 3);
        num = divide2TheMax(num, 5);


        return num == 1;
    }

    private static int divide2TheMax(int num, int valueByDivision) {

        while (num % valueByDivision == 0 & num > 1) {
            num = num / valueByDivision;
        }
        return num;
    }

    private static boolean is235NumberWithQueue(int num) {

        return false;
    }

}
