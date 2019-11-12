package ru.stqa.pft.addressbook.test.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.TestBase;

import java.util.List;

public class ContactModificationTests extends TestBase {
    //! Test will be failed any time, due it has a bug with Update button.
    @Test
    public void groupModification() {
        if (! app.getContactHelper().isThereAContact()){
            //new group creation, it would avoid situation when no one groups doesn't exit.
            app.getNavigationHelper().goToGroupPage();
            app.getGroupHelper().createGroup(new GroupData("temp_group", null, null));
            //new contact creation
            app.getContactHelper().createContact(new ContactData("Temp", null,
                    "Temp2", null, null,
                    null, "temp@adg.com", "temp_group"), true);
        }
        //int before = app.getContactHelper().getContactCount();
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(new ContactData("ContNameEdit", "ContMiddleEdit",
                "ContLastEdit", "CompanyOfContactEdit", "111232, tuda-to, syuda-toEdit",
                "+74895238845", "contEdit@adg.com", "temp_group"), false);
        app.getContactHelper().submitContactUpdate(); //page has a bug. its delete the updated contact.
        //temp group deletion
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup(0);
        app.getGroupHelper().deleteSelectedGroup();
        app.getNavigationHelper().gotoHomePage();
        //int after = app.getContactHelper().getContactCount();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
        Assert.assertEquals(before, after);
    }
}
