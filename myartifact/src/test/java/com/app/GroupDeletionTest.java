package com.app;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {


    @Test
    public void GroupDeletionTest() {
        goToGroupPage();
        selectGroup();
        deleteSelectedGrups();
        returnToGroupPage();
    }


}
