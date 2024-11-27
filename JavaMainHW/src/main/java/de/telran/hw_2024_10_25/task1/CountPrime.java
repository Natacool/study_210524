package de.telran.hw_2024_10_25.task1;

import java.util.concurrent.Callable;

public class CountPrime implements Callable<Long>{
        private int start;
        private int end;

        public CountPrime(int start, int end) {
                this.start = start;
                this.end = end;
        }

        public long countPrimes(){
                Long amount = 0L;
                for (int i = start; i <= end; i++) {
                        if (isPrime(i)){
                                amount++;
                                /*
                                System.out.println("calc: "
                                        + Thread.currentThread().getName()
                                        + ", amount of primes: "
                                        + amount
                                );
                                */
                        }
/*
                        if (Thread.interrupted()) {

                                System.out.println("Interrupted: "
                                        + Thread.currentThread().getName()
                                        + ", amount of primes: "
                                        + amount
                                );
                                return ;
                        }
*/
                }
                return amount;

        }

        private boolean isPrime(int num) {
                if (num == 1) {
                        return true;
                }

                boolean res = true;
                for (int i = 2; i < num; i++) {
                        if (num % i == 0) {
                                res = false;
                                break;
                        }
                }
                return res;
        }

        @Override
        public Long call() throws Exception {
                Long res = countPrimes();
                return res;
        }
}
