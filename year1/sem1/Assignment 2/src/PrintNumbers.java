public class PrintNumbers {

    //Хелали Ахмед
    public static void main(String[] args) {
        int integer1=0, integer2=1;
        for (int i = integer1+1; i <integer2 ; i++) /* мы проходим через цикл for и печатаем цифры*/
        {                                           /* которые находятся между числами*/
            for (int j = 0; j <i ; j++) {           /*В этом цикле for мы печатаем число за количество раз равное его значению*/
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}