package ru.stqa.pft.addressbook.test.contacts;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.TestBase;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactCreation() throws Exception {
        if (! app.getContactHelper().isThereAContact()){
            //new group creation, it would avoid situation when no one groups doesn't exit.
            app.getNavigationHelper().goToGroupPage();
            app.getGroupHelper().createGroup(new GroupData("temp_group", null, null));
            //new contact creation
            app.getContactHelper().createContact(new ContactData("Temp", null,
                    "Temp2", null, null,
                    null, "temp@adg.com", "temp_group"), true);
        }
        //main test, contact deletion
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().confirmContactDeleteAlert();
        //temp group deletion
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroup();
        app.getNavigationHelper().gotoHomePage();
    }
}