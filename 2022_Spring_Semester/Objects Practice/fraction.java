public class fraction {
    private int numerator;
    private int denominator;
    public fraction(int n, int d) {
        if(d==0) {
            throw new ArithmeticException();
        }
        numerator=n;
        denominator=d;
    }

    public int getNum() {
        return numerator;
    }

    public int getDenom() {
        return denominator;
    }

    public void setNum(int n) {
        numerator=n;
    }

    public void setDenom(int d) {
        if(d==0) {
            throw new ArithmeticException();
        }
        denominator=d;
    }

    public fraction add(fraction a) {
        numerator=numerator*a.getDenom()+a.getNum()*denominator;
        denominator*=a.getDenom();
        if(numerator/denominator==1) {
            numerator=1;
            denominator=1;
        }else {
            int numerTemp=numerator;
            int denomTemp=denominator;
            int remain;
            while (numerTemp%denomTemp != 0) {
                remain=numerTemp%denomTemp;
                numerTemp=denomTemp;
                denomTemp=remain;
            }
            numerator/=denomTemp;
            denominator/=denomTemp;
        }
        fraction sum=new fraction(numerator,denominator);
        return sum;
    }

    public boolean equals(fraction a) {
        if (numerator==a.getNum() && denominator==a.getDenom()) {
            return true;
        }else if(numerator*a.getDenom() == a.getNum()*denominator) {
            return true;
        }
        return false;
    }

    public String toString() {
        return numerator+"/"+denominator;
    }
}