package de.telran.hw_2024_08_27.task2;

import java.util.Scanner;

public class MainComplexity {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
/* *******************************************
task #1

START
READ number n
IF n == 1 THEN return
FOR i = 1, i <= n, i + 1
    FOR j = 1; j <= n, j + 1
        print "*"
        BREAK
END
*/
        int i=0;
        int j=0;

        int n = in.nextInt();
        if (n == 1){
            System.out.println("complexity: 1");
        }
        else {
            for (i=1; i <= n; i++)
                for (j=1; j <= n; j++)
                    System.out.print("* ");
            System.out.println("Complexity: n^2" );
        }



/* *******************************************
task #2

START
READ number n
numbers i = 0, j = 0, a = 0
FOR i = n/2, i <= n; i + 1
    FOR j = 2, j <= n, j * 2
        a = a + n / 2
END
*/
        i=0;
        j=0;
        int a=0;

        n = in.nextInt();
        for (i=n/2; i <= n; i++) { // n/2 + 1
            for (j = 2; j <= n; j = j * 2) { //(n-2) /2
                a = a + n / 2; //3
            }
        }
        System.out.println("a " + a);
        System.out.println("Complexity: n^2");


/* *******************************************
task #3

START
READ number n
number a = 0
FOR i = 0, i < n, i + 1
    FOR j = n, j > i, j - 1
        a = a + i + j
END
*/

        i=0;
        j=0;
        a=0;

        n = in.nextInt();
        for (i=0; i < n; i++) { // n
            System.out.println("i " + i);
            for (j = n; j > i; j--) { // log n
                System.out.println("j " + j);
                a = a + i + j; // 3
            }
        }
        System.out.println("a " + a);
        System.out.println("Complexity: n * log (n)");



/* *******************************************
task #4

START
READ number n
numbers a = 0, i = n
WHILE i > 0
    a = a + i
    i = i / 2
END
*/
        i=0;
        j=0;
        a=0;

        n = in.nextInt();
        i=n;
        while (i > 0)
        {
            a = a + i;
            i = i / 2;
            System.out.println("i " + i);
        }

        System.out.println("a " + a);
        System.out.println("Complexity: log(n)");


    }
}
