package org.zcorp.algorithms.primes;

import java.util.List;

@FunctionalInterface
public interface Sieve {
    List<Integer> sieve(int n);
}
