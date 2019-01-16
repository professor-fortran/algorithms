package org.zcorp.algorithms.gcd;

/**
 * Алгоритм Евклида для вычисления НОД (наибольшего общего делителя) двух целых чисел.
 * Вариант с циклом
 */
public class EuclidLoopGcd implements Gcd {
    @Override
    public double gcd(int m, int n) {
        if (n < 0 || m < 0) {
            throw new IllegalArgumentException("Убедитесь, что m >= 0 и n >= 0!");
        }

        while (n != 0) {
            int tmp = m % n;
            m = n;
            n = tmp;
        }
        if (m == 0) {
            return Double.NaN;
        }
        return m;
    }
}
