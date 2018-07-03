package com.app;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EuqationTest {

    @Test
    public void test1() {
//        Euqation e = new Euqation(1, 1,1);
        Euqation e = new Euqation(1,1,1);
        Assert.assertEquals(e.rootNumber(), 0);
        System.out.println("D = 0");
    }
    @Test
    public void test2() {
//        Euqation e = new Euqation(1, 1,1);
        Euqation e = new Euqation(1,2,1);
        Assert.assertEquals(e.rootNumber(), 1);
        System.out.println("D = 1");

    }@Test
    public void test3() {
//        Euqation e = new Euqation(1, 1,1);
        Euqation e = new Euqation(1,5,6);
        Assert.assertEquals(e.rootNumber(), 2);
        System.out.println("D = 2");

    }


}
