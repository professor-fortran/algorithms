package org.zcorp.algorithms.primes;

import java.util.LinkedList;
import java.util.List;

/**
 * Алгоритм "Решето Фортрана"
 */
public class FortranSieve {
    public static void main(String[] args) {
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
        System.out.println(sieve(n));
    }

    /**
     * Реализация решета Фортрана
     *
     * @param n положительное целое число >= 2
     * @return список простых чисел, меньших или равных n
     */
    private static List<Integer> sieve(int n) {
        if (n < 2) {
            throw new IllegalArgumentException("Число должно быть >= 2!");
        }

        // Если сделать ArrayList, то работать будет, но менее эффективно, т.к.
        // мы будем по мере просеивания чисел удалять из списка все не простые
        List<Integer> a = new LinkedList<>();
        // Все числа, которые будем просеивать через решето, для выявления простых
        for (int p = 2; p <= n; p++) {
            a.add(p);
        }

        // Удаляем из списка все не простые числа
        a.removeIf(p -> {
            // Проверяем, делится ли p на какое-нибудь из предыдущих
            // по списку чисел, которые к тому моменту уже все простые
            for (Integer prev : a) {
                if (prev < p) {
                    if (p % prev == 0) {
                        // Если да, то удаляем p как не простое
                        return true;
                    }
                } else {
                    break;
                }
            }
            return false;
        });

        return a;
    }
}
