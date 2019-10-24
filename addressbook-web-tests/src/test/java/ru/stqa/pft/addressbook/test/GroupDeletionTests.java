package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;

public class GroupDeletionTests extends TestBase {

    @Test
    public void testGroupDeletion() throws Exception {
        app.goToGroupPage();
        app.selectGroup();
        app.deleteSelectedGroup();
        app.returnToGroupPage();
    }

}
