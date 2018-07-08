package com.app.tests;

import com.app.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();

        if ( app.group().list().size() == 0) {
            app.group().greate(new GroupData().withName("test1"));
        }
    }

    @Test
    public void GroupDeletionTest() {
        List<GroupData> before = app.group().list();
        int index = before.size() -1;
        app.group().delete(index);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Assert.assertEquals(before, after);
    }



}
