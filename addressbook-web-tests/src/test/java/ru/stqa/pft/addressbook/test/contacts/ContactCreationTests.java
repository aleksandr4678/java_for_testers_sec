package ru.stqa.pft.addressbook.test.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.TestBase;

import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {
    @Test
    public void testContactCreation() throws Exception {
        List<ContactData> before = app.getContactHelper().getContactList();
        //new group creation, it would avoid situation when no one groups doesn't exit.
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().createGroup(new GroupData("temp_group", null, null));
        //main test, contact creation
        ContactData contact = new ContactData("ContNameNew", "ContMiddleNew",
                "ContLastNew", "CompanyOfContactNew", "111232, tuda-to, syuda-toNew",
                "+74895238845", "contNew@adg.com", "temp_group");
        app.getContactHelper().createContact(contact, true);
        //temp group deletion
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup(0);
        app.getGroupHelper().deleteSelectedGroup();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        System.out.println("before" + before);
        System.out.println("after" + after);
        //Assert.assertEquals(after.size(), before.size() + 1);

        int max = 0;
        for (ContactData c : after) {
            if (c.getId() > max) {
                max = c.getId();
            }
        }
        contact.setId(max);
        before.add(contact);
        //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
