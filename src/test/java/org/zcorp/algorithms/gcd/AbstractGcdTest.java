package org.zcorp.algorithms.gcd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

abstract class AbstractGcdTest {

    private Gcd gcd;

    protected AbstractGcdTest(Gcd gcd) {
        this.gcd = gcd;
    }

    @Test
    void gcd60and24() {
        assertEquals(12, gcd.gcd(60, 24));
    }

    @Test
    void gcd24and60() {
        assertEquals(12, gcd.gcd(24, 60));
    }

    @Test
    void gcd10and1() {
        assertEquals(1, gcd.gcd(10, 1));
    }

    @Test
    void gcd1and10() {
        assertEquals(1, gcd.gcd(1, 10));
    }

    @Test
    void gcd1and1() {
        assertEquals(1, gcd.gcd(1, 1));
    }

    @Test
    void gcd10and0() {
        assertEquals(10, gcd.gcd(10, 0));
    }

    @Test
    void gcd0and10() {
        assertEquals(10, gcd.gcd(0, 10));
    }

    @Test
    void gcd0and0() {
        assertEquals(Double.NaN, gcd.gcd(0, 0));
    }

    @Test
    void gcdLessThan0() {
        Exception exception = assertThrows(
                IllegalArgumentException.class,
                () -> gcd.gcd(-1, -10));
        assertEquals("Убедитесь, что m >= 0 и n >= 0!", exception.getMessage());
    }

}
