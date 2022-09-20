import java.util.Scanner;

import javax.swing.*;
import java.util.Scanner;
public class Shop {

    //Хелали Ахмед
    public static void main (String[] args) {

        char check='Y';
        int time_shop;
        while(check=='Y' || check=='y')  // Цикл, созданный для того, чтобы пользователь мог попробовать код более одного раза //
        {
            System.out.println("пожалуйста, введите время в формате 24 часа");

            Scanner scanner= new Scanner(System.in);
            time_shop = scanner.nextInt();              // Сохранить ввод пользователя //


            // Функция, которая проверяет время //
            if(8<=time_shop && time_shop<12 || 13<=time_shop && time_shop<=17)
            {
                System.out.println("Да магазин работает ,мы ждем вас");
            }
            else if (0<=time_shop && time_shop<=24)
            {
                System.out.println("Извините но магазин не работает");
            }
            else
            {
                System.out.println("Вы ввели неправильный формат, пожалуйста, " +
                                   " введите время между 0 и 24 (часовой формат)");
            }
            System.out.println("Хотите еще раз проверить?\n" + "Введите Y для да , N не");
            Scanner sc= new Scanner(System.in);
            check =sc.next().charAt(0);
            if(check=='N' || check=='n'){
                System.out.println("Увидимся");
            }
        }
    }
}
