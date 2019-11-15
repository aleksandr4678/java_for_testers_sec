package ru.stqa.pft.addressbook.test.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.TestBase;

import java.util.List;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactDeletion() throws Exception {
        //new group creation, it would avoid situation when no one groups doesn't exit.
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().createGroup(new GroupData("!!!temp_group", null, null));
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            //new contact creation
            app.getContactHelper().createContact(new ContactData("Temp", null,
                    "Temp2", null, null,
                    null, "temp@adg.com", "!!!temp_group"), true);
        }
        //main test, contact deletion
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact(0);
        app.getContactHelper().deleteContact();
        app.getContactHelper().confirmContactDeleteAlert();
        //temp group deletion
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup(0);
        app.getGroupHelper().deleteSelectedGroup();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}