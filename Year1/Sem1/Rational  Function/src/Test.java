public class Test extends RationalFraction {

    public static void main(String[] args) {

        RationalFraction fraction1=new RationalFraction(9,4);
        RationalFraction fraction2=new RationalFraction(3,6);
        RationalFraction fraction3=new RationalFraction(8,7);
        RationalFraction fraction4=new RationalFraction(6,4);


        2/3 + 9/5
        System.out.println(fraction1.numberPart());
        fraction1.reduce();
        System.out.println(fraction1);

        System.out.println(fraction1.RationalFraction_Addition(fraction2));
        System.out.println(fraction1 +" "+fraction2);

        System.out.println(fraction1.RationalFraction_Division(fraction2));

        System.out.println(fraction1.RationalFraction_Multiplication(fraction2));

        System.out.println(fraction1.RationalFraction_Subtraction(fraction2));

        System.out.println(fraction1.equals(fraction3));

        fraction2.addition(fraction3);
        System.out.println(fraction2);

        fraction1.subtraction(fraction4);
        System.out.println(fraction1);

        fraction4.Multiplication(fraction3);
        System.out.println(fraction4);

        fraction3.Division(fraction2);
        System.out.println(fraction3);

        fraction1.setRationalFraction(6,7);
        System.out.println(fraction1);

        System.out.println(fraction3.value_in_double());
        System.out.println(fraction3);
    }
}
