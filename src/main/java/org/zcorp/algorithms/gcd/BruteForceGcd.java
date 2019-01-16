package org.zcorp.algorithms.gcd;

/**
 * Последовательный перебор для вычисления НОД (наибольшего общего делителя) двух целых чисел
 */
public class BruteForceGcd implements Gcd {
    @Override
    public double gcd(int m, int n) {
        if (n < 0 || m < 0) {
            throw new IllegalArgumentException("Убедитесь, что m >= 0 и n >= 0!");
        }

        if (m == 0 && n == 0) {
            return Double.NaN;
        } else if (m == 0) {
            return n;
        } else if (n == 0) {
            return m;
        }

        int i = Math.min(m, n);
        for (; i > 1; i--) {
            if (m % i == 0 && n % i == 0) {
                break;
            }
        }

        return i;
    }
}
