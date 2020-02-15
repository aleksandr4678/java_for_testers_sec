package ru.stqa.pft.addressbook.test.groups;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.TestBase;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().groupPage();
        List<GroupData> before = app.group().list();
        GroupData group = new GroupData("test1-1", null, null);
        app.group().create(group);
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), before.size() + 1);
        //**1
        /*
        int max = 0;
        for (GroupData g : after) {
            if (g.getId() > max) {
                max = g.getId();
            }
        }*/
        //same as **1
        //anonymous class (it is staying here as example
        /*Comparator<? super GroupData> byId = new Comparator<GroupData>() {
            @Override
            public int compare(GroupData o1, GroupData o2) {  //anonymous class
                return Integer.compare(o1.getId(), o2.getId());
            }
        };
        int max2 = after.stream().max(byId).get().getId(); //same as max
        */
        //lambda function, same as **1
        //Comparator<? super GroupData> byId = (Comparator<GroupData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        int max = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
        group.setId(max);
        before.add(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
