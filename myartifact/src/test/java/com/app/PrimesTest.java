package com.app;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PrimesTest {

    @Test(enabled = false)
    public void testPrimes () {

        Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
    }

    @Test(enabled = false)
    public void testNoPrimes () {

        Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE -2));
    }
}
