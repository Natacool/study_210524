package de.telran.hw_2024_09_04.task1;

public class CalcLong implements Calculator<Long> {
    @Override
    public Long add (Long d1, Long d2){
        return d1+d2;
    }

    public Long sub (Long d1, Long d2){
        return  d1-d2;
    }

    public Long mul (Long d1, Long d2){
        return d1*d2;
    }

    public Long div (Long d1, Long d2){
        if (d2 != 0)
            return d1/d2;
        else
            throw new ArithmeticException("Divide by 0 is NOT allowed!");
    }
}
