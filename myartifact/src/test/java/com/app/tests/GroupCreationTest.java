package com.app.tests;

import com.app.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {


    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        app.getGroupHelper().greateGroup(new GroupData("test2", "test3", "test4"));
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before +1);

    }

}
