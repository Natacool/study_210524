package de.telran.hw_2024_08_28.task1;
//int[] num = new int[5];
public class MathUtil {
    static double avg(int num1, int num2) {
        return (double)(num1 + num2) / 2;
    }
    static double avg(double num1, double num2) {
        return (num1 + num2) / 2;
    }
    static double avg(int num1, double num2) {
        return (double)(num1 + num2) / 2;
    }
    static double avg(double num1, int num2) {
        return (double)(num1 + num2) / 2;
    }
    static double avg(int[] nums) {
        double retAvg = 0;
        for (int i=0; i < nums.length;i++)
        {
            retAvg += nums[i];
        }
        return retAvg/nums.length;
    }
    static double avg(double[] nums) {
        double retAvg = 0;
        for (int i=0; i < nums.length;i++)
        {
            retAvg += nums[i];
        }
        return retAvg/nums.length;
    }


    static int max(int num1, int num2) {
        int max = 0;
        if (num1 > num2) max = num1;
        else max = num2;
        return max;
    }
    static double max(double num1, double num2) {
        double max = 0;
        if (num1 > num2) max = num1;
        else max = num2;
        return max;
    }
    static double max(int num1, double num2) {
        double max = 0;
        if (num1 > num2) max = num1;
        else max = num2;
        return max;
    }
    static double max(double num1, int num2) {
        double max = 0;
        if (num1 > num2) max = num1;
        else max = num2;
        return max;
    }
    static int max(int[] nums) {
        int max = nums[0];
        for (int i=1; i< nums.length; i++){
            if (nums[i] > max) max = nums[i];
        }
        return max;
    }
    static double max(double[] nums) {
        double max = nums[0];
        for (int i=1; i< nums.length; i++){
            if (nums[i] > max) max = nums[i];
        }
        return max;
    }


    static int min(int num1, int num2) {
        int min = 0;
        if (num1 < num2) min = num1;
        else min = num2;
        return min;
    }
    static double min(double num1, double num2) {
        double min = 0;
        if (num1 < num2) min = num1;
        else min = num2;
        return min;
    }
    static double min(int num1, double num2) {
        double min = 0;
        if (num1 < num2) min = num1;
        else min = num2;
        return min;
    }
    static double min(double num1, int num2) {
        double min = 0;
        if (num1 < num2) min = num1;
        else min = num2;
        return min;
    }
    static int min(int[] nums) {
        int min = nums[0];
        for (int i=1; i< nums.length; i++){
            if (nums[i] < min) min = nums[i];
        }
        return min;
    }
    static double min(double[] nums) {
        double min = nums[0];
        for (int i=1; i< nums.length; i++){
            if (nums[i] < min) min = nums[i];
        }
        return min;
    }

}
