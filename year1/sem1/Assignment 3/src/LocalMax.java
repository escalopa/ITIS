public class LocalMax {

    //Хелали Ахмед
    public static void main (String[] arg)
    {
        int local_max=0;
        int index=0;
        int[] array ={56,34,78,112,90,46,78,23,98,23,100,453,76,5,43};  /*Случайный массив*/
        for (int i = 1; i <array.length - 1; i++) {
            if(array[i]>array[i-1] && array[i]>array[i+1])   /* мы проверяем, является ли это число локальным максимумом или нет */
            {
                local_max=array[i];
                index=i;
            }
        }
        System.out.println(); /*мы формируем новую линию*/
        System.out.print("Последний локальный максимум в массиве равен "+local_max+" и его место в мвссиви ("+index+")"); /*выводим значение числа */
        System.out.println(); /*мы формируем новую линию*/

    }
}
