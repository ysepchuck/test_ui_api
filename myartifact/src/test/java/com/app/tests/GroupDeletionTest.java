package com.app.tests;

import com.app.model.GroupData;
import com.app.model.Groups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if ( app.group().all().size() == 0) {
            app.group().greate(new GroupData().withName("test1"));
        }
    }

    @Test
    public void GroupDeletionTest() {
        Groups before = app.group().all();
        GroupData deleteGroup = before.iterator().next();
        app.group().delete(deleteGroup);
        Groups after = app.group().all();
        assertThat(app.group().count(), equalTo(before.size() -1));
//        before.remove(deleteGroup);
        assertThat(after, equalTo(before.without(deleteGroup)));
//        assertThat(after, equalTo(before));
    }



}
