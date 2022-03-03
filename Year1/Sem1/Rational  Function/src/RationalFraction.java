public class RationalFraction {

    protected int numerator;
    protected int denominator;

    RationalFraction(){

    }

    RationalFraction(int numerator,int denominator){
        this.numerator=numerator;
        this.denominator=denominator;

    }

    public void setRationalFraction(int numerator ,int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    private int getNumerator() {
        return numerator;
    }

    private int getDenominator() {
        return denominator;
    }

    private void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    private void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    /////Addition
    public RationalFraction RationalFraction_Addition (RationalFraction fraction){
        RationalFraction clone=new RationalFraction();
        clone.setNumerator(this.numerator*fraction.getDenominator()+denominator*fraction.getNumerator());
        clone.setDenominator(this.denominator*fraction.getDenominator());
        clone.reduce();
        return  clone;
    }
    public void addition (RationalFraction fraction){
        this.numerator=numerator*fraction.getDenominator()+denominator*fraction.getNumerator();
        this.denominator=denominator*fraction.getDenominator();
        this.reduce();
    }

    /////Subtraction
    public RationalFraction RationalFraction_Subtraction (RationalFraction fraction){
        RationalFraction clone=new RationalFraction();
        clone.setNumerator(this.numerator*fraction.getDenominator()-denominator*fraction.getNumerator());
        clone.setDenominator(this.denominator*fraction.getDenominator());
        clone.reduce();
        return  clone;
    }
    public void subtraction (RationalFraction fraction){
        this.numerator=numerator*fraction.getDenominator()-denominator*fraction.getNumerator();
        this.denominator=denominator*fraction.getDenominator();
        this.reduce();
    }

    /////Multiplication
    public RationalFraction RationalFraction_Multiplication (RationalFraction fraction){
        RationalFraction clone=new RationalFraction();
        clone.setNumerator(this.numerator*fraction.getNumerator());
        clone.setDenominator(this.denominator*fraction.getDenominator());
        clone.reduce();
        return  clone;
    }
    public void Multiplication (RationalFraction fraction){
        this.numerator=numerator*fraction.getNumerator();
        this.denominator=denominator* fraction.getDenominator();
        this.reduce();
    }

    /////Division
    public RationalFraction RationalFraction_Division (RationalFraction fraction){
        RationalFraction clone=new RationalFraction();
        clone.setNumerator(this.numerator*fraction.getDenominator());
        clone.setDenominator(this.denominator*fraction.getNumerator());
        clone.reduce();
        return  clone;
    }
    public void Division (RationalFraction fraction){
        this.numerator=numerator*fraction.getDenominator();
        this.denominator=denominator* fraction.getNumerator();
        this.reduce();
    }

    /////Properties
    public double value_in_double(){

        double dob;
        dob = (double) this.getNumerator() / this.getDenominator();
        return (dob);
    }

    void reduce(){
        int count=0;
        for (int i = 2; i <Math.abs(denominator) ; i++) {
            if (numerator%i==0 && denominator%i==0){
                this.numerator=numerator/i;
                this.denominator=denominator/i;
                count++;
            }
        }
        if (count!=0)this.reduce();
    }

    public boolean equals(RationalFraction fraction){
            this.reduce();
            fraction.reduce();
        return this.getNumerator()==fraction.getNumerator() && this.getDenominator()==fraction.getDenominator();
    }

    public int numberPart(){
        return this.numerator/this.denominator ;
    }



    @Override
    public String toString() {
        return "RationalFraction{ " +
                 + numerator +
                "/"+
                 denominator +
                " }";
    }
}
