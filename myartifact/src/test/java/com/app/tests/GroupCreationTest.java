package com.app.tests;

import com.app.model.GroupData;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {


    @Test
    public void testGroupCreation() {
        int before = app.getGroupHelper().getGroupCoun();
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("hello", "test3", "test4"));
        int after = app.getGroupHelper().getGroupCoun();
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToGroupPage();


    }

}
