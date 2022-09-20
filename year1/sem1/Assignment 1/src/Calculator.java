import javax.swing.*;
import java.util.Scanner;
public class Calculator {

    //Хелали Ахмед
    public static void main(String[] args) {

        double number1;
        double number2;
        String operation;
        char check = 'Y';

        while (check == 'Y' || check == 'y') {
            System.out.println("введите первый номер");
            Scanner sc = new Scanner(System.in);
            number1 = sc.nextFloat();
            System.out.println("введите второй номер ");
            number2 = sc.nextFloat();
            System.out.println("введите какую операцию вы будете выполнять(+,-,*,/,^)");
            Scanner scanner= new Scanner(System.in);
            operation = scanner.nextLine();
            switch (operation) {
                case "+" -> System.out.println(number1 + "+" + number2 + "=" + (number1 + number2));
                case "-" -> System.out.println(number1 + "-" + number2 + "=" + (number1 - number2));
                case "/" -> System.out.println(number1 + "/" + number2 + "=" + (number1 / number2));
                case "*" -> System.out.println(number1 + "*" + number2 + "=" + (number1 * number2));
                case "^" -> System.out.println(number1 + "^" + number2 + "=" + (number1 * number2));
                default -> System.out.println("вы ввели неправильный формат пожалуйста попробуйте еще раз");
            }
            System.out.println("Хотите еще раз Вычислить ?\n" + "Введите Y для да , N не");
            check = sc.next().charAt(0);
            if (check == 'N' || check == 'n') {
                System.out.println("Увидимся :D");
            }
        }
    }
}




