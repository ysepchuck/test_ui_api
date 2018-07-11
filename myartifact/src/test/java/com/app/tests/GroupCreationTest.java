package com.app.tests;

import com.app.model.GroupData;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupCreationTest extends TestBase {

    Logger logger = LoggerFactory.getLogger(ContactCreationTest.class);

    @DataProvider
    public Iterator<Object[]> validGroupsFromXml() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))) {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xStream = new XStream();
            xStream.processAnnotations(GroupData.class);
            List<GroupData> grops = (List<GroupData>) xStream.fromXML(xml);
            return grops.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }
        @DataProvider
        public Iterator<Object[]> validGroupsFromJson() throws IOException {
            try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))) {
                String json = "";
                String line = reader.readLine();
                while (line != null) {
                    json += line;
                    line = reader.readLine();
                }
                Gson gson = new Gson();
                List<GroupData> groups = gson.fromJson(json, new TypeToken<List<GroupData>>() {
                }.getType()); //List<GroupData>.class
                return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();

//        String[] split = line.split(";");
//        list.add(new Object[] {new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
//        line = reader.readLine();
//        list.add(new Object[] {new GroupData().withName("test1").withHeader("header1").withFooter("footer1")});
//        list.add(new Object[] {new GroupData().withName("test2").withHeader("header2").withFooter("footer2")});
//        list.add(new Object[] {new GroupData().withName("test3").withHeader("header3").withFooter("footer3")});
//        return list.iterator();
            }
        }


    @Test(dataProvider = "validGroupsFromJson")
    public void testGroupCreation (GroupData group) {
        logger.info("start test testGroupCreation");
        String[] names = new String[]  {"test1", "test2", "test3"};
            app.goTo().groupPage();
            Set<GroupData> before = app.group().all();
            app.group().greate(group);
            Set<GroupData> after = app.group().all();
            Assert.assertEquals(after.size(), before.size() +1);
            app.group().count();
            group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
            before.add(group);
            Assert.assertEquals(after,before);
        logger.info("stop test testGroupCreation");

        }


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
//        Comparator<? super GroupData> byID = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
//        before.sort(byID);
//        after.sort(byID);



//    @Test
//    public void testBadGroupCreation() {
//        app.goTo().groupPage();
//        Set<GroupData> before = app.group().all();
//        GroupData group = new GroupData().withName("test2'");
//        app.group().greate(group);
//        Set<GroupData> after = app.group().all();
//        Assert.assertEquals(after.size(), before.size());
////        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
//        before.add(group);
//        Assert.assertEquals(before,after);
//    }
}
