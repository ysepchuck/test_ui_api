package com.app.tests;

import com.app.model.GroupData;
import com.app.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if ( app.group().all().size() == 0) {
            app.group().greate(new GroupData().withName("test1"));
        }
    }


    @Test
    public void testGroupModification () {
        Groups before = app.group().all();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withId(modifiedGroup.getId()).withName("test2").withHeader("test3").withFooter("test4");
        app.group().modify(group);
        Groups after = app.group().all();
        assertEquals(after.size(), before.size() );
        assertThat(after, equalTo(before.without(modifiedGroup).withAddet(group)));
//        before.remove(modifiedGroup);
//        before.add(group);
//        Assert.assertEquals(before, after);
    }



}
