public class Triforce {

    //Хелали Ахмед
    public static void main(String[] args) {

        int Lines=150;
        int points=1;
        for (int rows=0;rows<Lines;rows++)   /*В этом цикле мы рисуем первый треугольник*/
        {
            for(int i=1;i<Lines*2-rows;i++)  /*Выведите пробелы в два раза больше, чтобы нарисовать другой треугольник вниз по нему */
            {
                System.out.print(" ");
            }
            for (int j=0;j<points;j++)      /*Печать звезд рисует треугольник*/
            {
                System.out.print("*");
            }
            points+=2;       /*Значение (points) увеличивается на 2, потому что каждый раз добавляются 2 точки (1 слева, другая справа*/
            System.out.println();
        }
        points=1;           /*мы сбрасываем значение (points), поэтому снова начинаем рисовать с первой строки*/
        for (int rows=0;rows<Lines;rows++)      /*мы просто снова рисуем здесь тот же треугольник, что и первый*/
        {
            for(int i=1;i<Lines-rows;i++)
            {
                System.out.print(" ");
            }
            for (int j=0;j<points;j++)
            {
                System.out.print("*");
            }
            for(int i=1;i<Lines*2-rows*2;i++) /*здесь количество пробелов удваивается, чтобы сформировать форму triforce */
            {
                System.out.print(" ");
            }
            for (int j=0;j<points;j++)
            {
                System.out.print("*");
            }
            points+=2;
            System.out.println();
        }


    }
}
