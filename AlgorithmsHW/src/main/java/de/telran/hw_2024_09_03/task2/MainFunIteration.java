package de.telran.hw_2024_09_03.task2;

public class MainFunIteration {
// given from task - recursive
    private static int funRecursion(int x, int y) {
        if (x == 0) {
            return y;
        } else {
            int res = funRecursion(x - 1, x + y);
            System.out.println("res = " + res + "; x = " + x + "; y = " + y);
            return res;
        }
    }

    public static void main(String[] args) {
        int x = 3;
        int y = 5;
        System.out.println("funRecursion(" + x + "," + y + ") = " +
                funRecursion(x,y));

        System.out.println("funIteration(" + x + "," + y + ") = " +
                funIteration(x,y));
    }

// need create an iterative function
    private static int funIteration(int x, int y) {
        int res = y;
        for (int i=x; i > 0; i--){
            res = res + i;
            System.out.println("res = " + res + "; i = " + i);
        }
        return res;
    }

}
