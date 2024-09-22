package de.telran.hw_2024_08_28.task1;

import java.util.Arrays;

public class MainMathUtil {
    public static void main(String[] args) {
        int i1 = 3;
        int i2 = 4;
        double d1 = 2.2;
        double d2 = 7.2;
        int[] inums = {2,4,1,3};
        double[] dnums = {3.3,4.4,1.1,2.2};

        System.out.println("avg(" + i1 + ", " + i2 + ") = " + MathUtil.avg(i1, i2));
        System.out.println("avg(" + i2 + ", " + i1 + ") = " + MathUtil.avg(i2, i1));
        System.out.println("avg(" + d1 + ", " + d2 + ") = " + MathUtil.avg(d1, d2));
        System.out.println("avg(" + i1 + ", " + d1 + ") = " + MathUtil.avg(i1, d1));
        System.out.println("avg(" + d2 + ", " + i2 + ") = " + MathUtil.avg(d2, i2));
        System.out.println("avg(" + Arrays.toString(inums) + ") = " + MathUtil.avg(inums));
        System.out.println("avg(" + Arrays.toString(dnums) + ") = " + MathUtil.avg(dnums));
        System.out.println("----------------------------------------------------");

        System.out.println("max(" + i1 + ", " + i2 + ") = " + MathUtil.max(i1, i2));
        System.out.println("max(" + i2 + ", " + i1 + ") = " + MathUtil.max(i2, i1));
        System.out.println("max(" + d1 + ", " + d2 + ") = " + MathUtil.max(d1, d2));
        System.out.println("max(" + i1 + ", " + d1 + ") = " + MathUtil.max(i1, d1));
        System.out.println("max(" + d2 + ", " + i2 + ") = " + MathUtil.max(d2, i2));
        System.out.println("max(" + Arrays.toString(inums) + ") = " + MathUtil.max(inums));
        System.out.println("max(" + Arrays.toString(dnums) + ") = " + MathUtil.max(dnums));
        System.out.println("----------------------------------------------------");

        System.out.println("min(" + i1 + ", " + i2 + ") = " + MathUtil.min(i1, i2));
        System.out.println("min(" + i2 + ", " + i1 + ") = " + MathUtil.min(i2, i1));
        System.out.println("min(" + d1 + ", " + d2 + ") = " + MathUtil.min(d1, d2));
        System.out.println("min(" + i1 + ", " + d1 + ") = " + MathUtil.min(i1, d1));
        System.out.println("min(" + d2 + ", " + i2 + ") = " + MathUtil.min(d2, i2));
        System.out.println("min(" + Arrays.toString(inums) + ") = " + MathUtil.min(inums));
        System.out.println("min(" + Arrays.toString(dnums) + ") = " + MathUtil.min(dnums));
        System.out.println("----------------------------------------------------");
    }
}
