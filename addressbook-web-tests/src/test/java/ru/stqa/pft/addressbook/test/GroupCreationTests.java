package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goToGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("test1-1", "test2-1", "test3-1"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

}
