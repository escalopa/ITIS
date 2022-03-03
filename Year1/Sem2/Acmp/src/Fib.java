import java.math.BigInteger;
import java.util.Scanner;

public class Fib {

    public static void main(String[] args) {

        Scanner scanner  = new Scanner(System.in);
        findFib(scanner.nextInt());
        scanner.close();
    }

    public static void findFib(int k){
        BigInteger[] arr = new BigInteger[k+1];
        arr[0] = new BigInteger("1");
        arr[1] = new BigInteger("1");
        for (int i = 2; i <= k ; i++) {
            arr[i] = arr[i-1].add(arr[i-2]);
        }
        System.out.println(arr[k]);
    }
}
