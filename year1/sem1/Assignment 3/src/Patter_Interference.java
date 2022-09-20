public class Patter_Interference {

    //Хелали Ахмед
    public static void main(String[] args) {

        int Pattern_interrupter = 0;
        int[] array = {78, 77, 763, 75, 74, 80, 73, 72, 71, 70}; /*Случайный массив*/
        for (int i = 1; i < array.length; i++)  /*Мы проверяем, влияет ли значение числа на паттерн или нет*/
        {
            if (array[i] > array[i - 1]) {
                Pattern_interrupter = array[i];
                break;
            }
        }
        System.out.println(); /*мы формируем новую линию*/
        System.out.println("Это число прервавшее паттерн равно "+Pattern_interrupter); /*мы печатаем значение*/
        System.out.println(); /*мы формируем новую линию*/

    }

}
