package com.app.tests;

import com.app.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification () {
        app.getNavigationHelper().goToGroupPage();

        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().greateGroup(new GroupData("test2", null, null));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() -1);
        app.getGroupHelper().initGroupModification();
        GroupData group = new GroupData("test2", "test3", "test4");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitCroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() );

        before.remove(before.size() -1);
        before.add(group);
        Comparator<? super GroupData> byID = (g1,g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byID);
        after.sort(byID);
        Assert.assertEquals(before, after);

    }

}
