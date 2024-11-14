package de.telran.hw_2024_10_16.task1;

public class FindPrime extends Thread{
    private int start;
    private int end;

    public FindPrime(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        long amount = 0;
        try {
            for (int i = start; i <= end; i++) {


//                try {
                    Thread.sleep(10);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                if (isPrime(i)){
                    System.out.println("\t\t\t" + i + " is PRIME");
                    amount++;
                }
                //else{
                //    System.out.println("\t\t\t\t" + i + " is not prime");
                //}
                System.out.println(Thread.currentThread().getName()
                        + " -> amount = "
                        + amount);

                if (Thread.interrupted()) {

                    System.out.println("Interrupted: "
                            + Thread.currentThread().getName()
                            + ", amount of primes: "
                            + amount
                    );
                    return;
                }

            }
        } catch (InterruptedException e) {
            System.out.println("Exception -- interrupted : "
                    + Thread.currentThread().getName()
                    + ", amount of primes: "
                    + amount
                    );
            //throw new RuntimeException(e);
            return;
        }
    }

    private boolean isPrime(int num) {
        boolean res = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                res = false;
                break;
            }
        }
        return res;
    }
}
