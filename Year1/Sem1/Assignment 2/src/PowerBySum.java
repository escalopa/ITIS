public class PowerBySum {

    //Хелали Ахмед
    public static void main(String[] args) {

        int Given_number=8;                     /* Число, которое мы хотим найти, это  степень*/
        int Counter=1, Result=1;

            for (int i=0;i<Given_number-1;i++)
            {
                Counter+=2;                     /*Сначала мы считаем каждое число по одному, а затем добавляем их к*/
                Result+=Counter;                /*переменной(Result) */
            }
        System.out.println(Result);             /*Здесь мы выводим значение квадрата числа*/
    }
}

/* 1 3 5 7 9 11 13 15*/