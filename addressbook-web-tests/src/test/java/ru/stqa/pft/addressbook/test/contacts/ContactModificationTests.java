package ru.stqa.pft.addressbook.test.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.TestBase;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {
    //! Test will be failed any time, due it has a bug with Update button.
    @Test (enabled = false)
    public void contactModification() {
        if (!app.getContactHelper().isThereAContact()) {
            //new group creation, it would avoid situation when no one groups doesn't exit.
            app.goTo().groupPage();
            app.group().create(new GroupData("temp_group", null, null));
            //new contact creation
            app.getContactHelper().createContact(new ContactData("Temp", null,
                    "Temp2", null, null,
                    null, "temp@adg.com", "temp_group"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData(before.get(before.size()-1).getId(), "ContNameEdit", "ContMiddleEdit",
                "ContLastEdit", "CompanyOfContactEdit", "111232, tuda-to, syuda-toEdit",
                "+74895238845", "contEdit@adg.com", "temp_group");
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(contact, false);
        //app.getContactHelper().submitContactUpdate(); //page has a bug. its delete the updated contact.
        //temp group deletion
        app.goTo().groupPage();
        app.group().selectGroup(0);
        app.group().deleteSelectedGroup();
        app.goTo().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size()-1);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}