package de.telran.hw_2024_09_04.task1;

public class MainCalculator {
    public static void main(String[] args) {

        Integer i1 = 3;
        Integer i2 = 7;
        Calculator<Integer> calcInt = new CalcInt();
        System.out.println("-----------------------------------");
        System.out.println("calcLong: i1 = " + i1 + ", i2 = " + i2);
        System.out.println("add(i1,i2) = " + calcInt.add(i1,i2));
        System.out.println("sub(i1,i2) = " + calcInt.sub(i1,i2));
        System.out.println("mul(i1,i2) = " + calcInt.mul(i1,i2));
        System.out.println("div(i1,i2) = " + calcInt.div(i1,i2));

        Double d1 = 3.6;
        Double d2 = 1.2;
        Calculator<Double> calcDouble = new CalcDouble();
        System.out.println("-----------------------------------");
        System.out.println("calcLong: d1 = " + d1 + ", d2 = " + d2);
        System.out.println("add(d1,d2) = " + calcDouble.add(d1,d2));
        System.out.println("sub(d1,d2) = " + calcDouble.sub(d1,d2));
        System.out.println("mul(d1,d2) = " + calcDouble.mul(d1,d2));
        System.out.println("div(d1,d2) = " + calcDouble.div(d1,d2));

        Long l1 = 201L;
        Long l2 = 3L;
        Calculator<Long> calcLong = new CalcLong();
        System.out.println("-----------------------------------");
        System.out.println("CalcLong: l1 = " + l1 + ", l2 = " + l2);
        System.out.println("add(l1,l2) = " + calcLong.add(l1,l2));
        System.out.println("sub(l1,l2) = " + calcLong.sub(l1,l2));
        System.out.println("mul(l1,l2) = " + calcLong.mul(l1,l2));
        System.out.println("div(l1,l2) = " + calcLong.div(l1,l2));

        Float f1 = 1.5F;
        Float f2 = 0.5F;
        Calculator<Float> calcFloat = new CalcFloat();
        System.out.println("-----------------------------------");
        System.out.println("calcFloat: f1 = " + f1 + ", f2 = " + f2);
        System.out.println("add(f1,f2) = " + calcFloat.add(f1,f2));
        System.out.println("sub(f1,f2) = " + calcFloat.sub(f1,f2));
        System.out.println("mul(f1,f2) = " + calcFloat.mul(f1,f2));
        System.out.println("div(f1,f2) = " + calcFloat.div(f1,f2));

        System.out.println("-----------------------------------");
        System.out.println("Int divide by 0");
        System.out.println("div(5,0)" + calcInt.div(5,0));
    }
}
