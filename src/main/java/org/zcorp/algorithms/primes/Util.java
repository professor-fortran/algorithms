package org.zcorp.algorithms.primes;

public class Util {
    private Util() {
    }

    public static void sift(String[] args, Sieve sieve) {
        if (args.length != 1) {
            System.err.println("Укажите один параметр: максимальное натуральное число >= 2, до которого нужно искать простые числа!");
            return;
        }
        int n;
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.err.println("Укажите натуральное число >= 2!");
            return;
        }

        System.out.println("Простые числа до " + n + " включительно:");
        System.out.println(sieve.sieve(n));
    }
}
