package de.telran.hw_2024_09_04.task1;

public class CalcInt implements Calculator<Integer>{
    @Override
    public Integer add (Integer d1, Integer d2){
        return d1+d2;
    }

    public Integer sub (Integer d1, Integer d2){
        return  d1-d2;
    }

    public Integer mul (Integer d1, Integer d2){
        return d1*d2;
    }

    public Integer div (Integer d1, Integer d2){

        if (d2 != 0)
            return d1/d2;
        else
            System.out.println("Divide by 0 is NOT allowed!");
            throw new ArithmeticException("Divide by 0");
    }
}
