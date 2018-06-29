package com.app.tests;

import com.app.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification () {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("test2", "test3", "test4"));
        app.getGroupHelper().submitCroupModification();
        app.getGroupHelper().returnToGroupPage();

    }
}
