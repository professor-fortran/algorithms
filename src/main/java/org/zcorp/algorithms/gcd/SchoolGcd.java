package org.zcorp.algorithms.gcd;

import org.zcorp.algorithms.primes.EratosthenesSieve;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * "Школьный" метод вычисления НОД (наибольшего общего делителя) двух целых чисел
 */
public class SchoolGcd implements Gcd {

    @Override
    public double gcd(int m, int n) {
        if (n < 0 || m < 0) {
            throw new IllegalArgumentException("Убедитесь, что m >= 0 и n >= 0!");
        }

        if (m == 0 && n == 0) {
            return Double.NaN;
        } else if (m == 0 || n == 0) {
            return Math.max(m, n);
        } else if (m == 1 || n == 1) {
            return 1;
        }

        return new Auxiliary(m, n).gcd();
    }

    public static class Auxiliary {
        private final int m;
        private final int n;
        private final List<Integer> primes;

        public Auxiliary(int m, int n) {
            this.m = m;
            this.n = n;
            this.primes = new EratosthenesSieve().sieve(Math.max(m, n));
        }

        private Map<Integer, Integer> getPrimeFactors(int x) {
            Map<Integer, Integer> primeFactors = new HashMap<>();
            for (int p : primes) {
                if (x <= 1) {
                    break;
                }
                while (x % p == 0) {
                    primeFactors.merge(p, 1, (oldValue, value) -> oldValue + value);
                    x /= p;
                }
            }
            return primeFactors;
        }

        private static Map<Integer, Integer> getCommonPrimeFactors(Map<Integer, Integer> mPrimeFactors, Map<Integer, Integer> nPrimeFactors) {
            Map<Integer, Integer> commonPrimeFactors = new HashMap<>();
            for (Map.Entry<Integer, Integer> mPrimeFactorEntry : mPrimeFactors.entrySet()) {
                int mPrimeFactorCount = mPrimeFactorEntry.getValue();
                Integer nPrimeFactorCount = nPrimeFactors.get(mPrimeFactorEntry.getKey());
                if (nPrimeFactorCount != null) {
                    commonPrimeFactors.put(mPrimeFactorEntry.getKey(), Math.min(mPrimeFactorCount, nPrimeFactorCount));
                }
            }
            return commonPrimeFactors;
        }

        public double gcd() {
            Map<Integer, Integer> mPrimeFactors = getPrimeFactors(m);
            Map<Integer, Integer> nPrimeFactors = getPrimeFactors(n);

            Map<Integer, Integer> commonPrimeFactors = getCommonPrimeFactors(mPrimeFactors, nPrimeFactors);

            return commonPrimeFactors.entrySet().stream()
                    .map(e -> Math.pow(e.getKey(), e.getValue()))
                    .reduce(1.0, (a, b) -> a * b);
        }
    }

}