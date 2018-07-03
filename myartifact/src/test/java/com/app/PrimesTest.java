package com.app;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimesTest {

    @Test
    public void testPrimes () {

        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
    }

    @Test
    public void testNoPrimes () {

        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE -2));
    }
}
