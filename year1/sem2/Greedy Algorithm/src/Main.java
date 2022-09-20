public class Main {

    public static void main(String[] args) {

        int fibNum = 5;
        int money = 14;
        int[] coins = new int[]{2,3,5,10};

        long start;
        long end;

        //Task 1.a
        start = System.nanoTime();
        Methods.fibRecursion(fibNum);
        end = System.nanoTime();
        System.out.println(end - start);

        //Task 1.b
        start = System.nanoTime();
        Methods.fibRecursion(fibNum);
        end = System.nanoTime();
        System.out.println(end - start);

        //Task 2
        //System.out.println(Methods.minCoins(money, coins));

        //Tasks DynamicProgramming
        System.out.println("Shortest Path : "+DynamicProgramming.shortestPathTo1(100));
        System.out.println("Shortest Path : "+DynamicProgramming.shortestPathToFirstStair(5));
    }
}
