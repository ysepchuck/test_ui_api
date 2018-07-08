package com.app.tests;

import com.app.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTest extends TestBase {


    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        List<GroupData> before = app.group().list();
        GroupData group = new GroupData().withName("test2");
        app.group().greate(group);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() +1);


//        int max = 0;
//        for (GroupData g : after){
//            if (g.getId() > max) {
//                max = g.getId();
//            }
//        }


//        group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
//        before.add(group);
//        Comparator<? super GroupData> byID = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
//        before.sort(byID);
//        after.sort(byID);

//        group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(group);
        Comparator<? super GroupData> byID = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byID);
        after.sort(byID);
        Assert.assertEquals(after,before);

    }

}
