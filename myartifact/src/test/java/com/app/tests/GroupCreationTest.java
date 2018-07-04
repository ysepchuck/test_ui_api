package com.app.tests;

import com.app.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTest extends TestBase {


    @Test
    public void testGroupCreation() {
        app.getNavigationHelper().goToGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        GroupData group = new GroupData("test2", null, null);
        app.getGroupHelper().greateGroup(group);
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() +1);


        int max = 0;
        for (GroupData g : after){
            if (g.getId() > max) {
                max = g.getId();
            }
        }
        
        int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
        group.setId(max1);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(after), new HashSet<Object>(before));

    }

}
