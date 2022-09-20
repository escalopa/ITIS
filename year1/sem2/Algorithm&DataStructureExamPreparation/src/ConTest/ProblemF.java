package ConTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProblemF {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        String string = reader.readLine();
        reader.close();
        if (size == 1) {
            if (string.equals("0")) {
                System.out.println("-1");
                return;
            } else
                System.out.println(string);
                return;
        }
        System.out.println(findMinPalindrome(string));
    }

    private static String findMinPalindrome(String string) {
        int[] array = new int[10];
        int mid = -1;

        //Fill Array
        Arrays.fill(array, 0);
        for (char c : string.toCharArray()) {
            int n = Integer.parseInt(String.valueOf(c));
            array[n]++;
        }

        //Find odd numbers & if they exceed 2 return -1 else save the location of the odd number(if existx)
        for (int i = 0, odd = 0; i < 10; i++) {
            if (array[i] % 2 != 0) {
                odd++;
                mid = i;
            }
            if (odd == 2)
                return "-1";
        }

        //Create a string in which we will create our palindrome
        StringBuilder stringBuilder = new StringBuilder();

        //Add number in the front to prevent zero leading number
        if (array[0] != 0) {
            for (int i = 1; i < 10; i++) {
                //if to prevent getting 0 or 1 as input in append function
                if (array[i] >= 2) {
                    array[i] -= 2;
                    stringBuilder.append(i);
                    break;
                }
            }
        }

        //Add all numbers including the odd number we found(mid) , if there is any
        for (int i = 0; i < 10; i++) {
            if (i == mid) {
                if (array[mid] != 1)
                    stringBuilder.append(String.valueOf(i).repeat((array[i] - 1) / 2));
            } else
                stringBuilder.append(String.valueOf(i).repeat(array[i] / 2));
        }
        if (stringBuilder.charAt(0) == '0') return "-1";
        return String.valueOf(stringBuilder) + ((mid == -1) ? "" : String.valueOf(mid).repeat(1)) + stringBuilder.reverse();
    }
}
