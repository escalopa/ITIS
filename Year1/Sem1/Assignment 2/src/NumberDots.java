public class NumberDots {

    //Хелали Ахмед
    public static void main(String[] args) {

        int Given_number=100;
        int Line=1;
        for (int i=0;i<Given_number;i++,Line++)
        {
            for (int j=0;j<Given_number-Line;j++)   /*в этом цикле мы печатаем точки, которые находятся перед цифровыми */
            {
                System.out.print(".");
            }
            System.out.print(Line);
            for (int j=1;j<Line;j++)                /*в этом цикле мы печатаем точки, которые находятся после цифровой */
            {
                System.out.print(".");
            }
            System.out.println();
        }



    }

}
