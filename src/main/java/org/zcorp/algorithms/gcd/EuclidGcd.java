package org.zcorp.algorithms.gcd;

/**
 * Алгоритм Евклида для вычисления НОД (наибольшего общего делителя) двух целых чисел
 */
public class EuclidGcd implements Gcd {
    @Override
    public double gcd(int m, int n) {
        if (n < 0 || m < 0) {
            throw new IllegalArgumentException("Убедитесь, что m >= 0 и n >= 0!");
        }
        if (n == 0) {
            if (m == 0) {
                return Double.NaN;
            }
            return m;
        }
        return gcd(n, m % n);
    }
}
