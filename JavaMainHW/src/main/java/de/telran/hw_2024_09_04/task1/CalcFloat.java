package de.telran.hw_2024_09_04.task1;

public class CalcFloat implements Calculator<Float> {
    @Override
    public Float add (Float d1, Float d2){
        return d1+d2;
    }

    public Float sub (Float d1, Float d2){
        return  d1-d2;
    }

    public Float mul (Float d1, Float d2){
        return d1*d2;
    }

    public Float div (Float d1, Float d2){
        if (d2 != 0)
            return d1/d2;
        else
            throw new ArithmeticException("Divide by 0 is NOT allowed!");
    }
}
