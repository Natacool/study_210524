package de.telran.hw_2024_09_04.task1;

public class CalcDouble implements Calculator<Double> {
    @Override
    public Double add (Double d1, Double d2){
        return d1+d2;
    }

    public Double sub (Double d1, Double d2){
        return  d1-d2;
    }

    public Double mul (Double d1, Double d2){
        return d1*d2;
    }

    public Double div (Double d1, Double d2){
        if (d2 != 0)
            return d1/d2;
        else
            throw new ArithmeticException("Divide by 0 is NOT allowed!");
    }
}
