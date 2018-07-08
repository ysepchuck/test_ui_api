package com.app.tests;

import com.app.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if ( app.group().list().size() == 0) {
            app.group().greate(new GroupData().withName("test1"));
        }
    }


    @Test
    public void testGroupModification () {
        List<GroupData> before = app.group().list();
        int index = before.size() -1;
        GroupData group = new GroupData()
                .withId(before.get(index).getId()).withName("test2").withHeader("test3").withFooter("test4");
        app.group().modify(index, group);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() );

        before.remove(index);
        before.add(group);
        Comparator<? super GroupData> byID = (g1,g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byID);
        after.sort(byID);
        Assert.assertEquals(before, after);

    }



}
