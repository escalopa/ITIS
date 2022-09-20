public class Reminder {

    //Хелали Ахмед
    public static void main(String[] args) {

        boolean digit_type=false ;
        int    number=26478626;
        while(number%2==0 && number>0) /*здесь мы проверим если числа четные и нечетные*/
        {
            number=number/10;          /*Здесь мы делим на 10 так что мы можем проверить следующую */
                                       /*цифру в числе является ли она четной или нечетной*/

        }
        if(number%2!=0)                /*здесь мы проверим если числа четные и нечетные*/
        {
            digit_type=true;
        }
        System.out.println(digit_type);



    }
}
