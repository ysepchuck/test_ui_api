package com.app.tests;

import com.app.model.GroupData;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {


    @Test
    public void GroupDeletionTest() {
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().greateGroup(new GroupData("hello", "test3", "test4"));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGrups();
        app.getGroupHelper().returnToGroupPage();
    }


}
