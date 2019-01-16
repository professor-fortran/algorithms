package org.zcorp.algorithms.primes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class AbstractSieveTest {

    private Sieve sieve;

    protected AbstractSieveTest(Sieve sieve) {
        this.sieve = sieve;
    }

    @Test
    void sieveLessThan2() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> sieve.sieve(1));
        assertEquals("Число должно быть >= 2!", exception.getMessage());
    }

    @Test
    void sieveEquals2() {
        assertEquals(Collections.singletonList(2), sieve.sieve(2));
    }

    @Test
    void sieveEquals4() {
        assertEquals(Arrays.asList(2, 3), sieve.sieve(4));
    }

    @Test
    void sieveEquals25() {
        assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23), sieve.sieve(25));
    }

}