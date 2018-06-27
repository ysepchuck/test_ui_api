package com.app;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase{


    @Test
    public void testGroupCreation() {

        goToGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupData("test2", "test3", "test4"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
