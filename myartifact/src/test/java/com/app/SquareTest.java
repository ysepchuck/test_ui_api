package com.app;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SquareTest {
    @Test(enabled = false)
    public void testArea () {
        Square s =new Square (5);
        Assert.assertEquals( s.area(), 25.0);

    }
}
