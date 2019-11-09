package ru.stqa.pft.addressbook.test.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.TestBase;

public class ContactCreation extends TestBase {
    @Test
    public void testContactCreation() throws Exception {
        int before = app.getContactHelper().getContactCount();
        //new group creation, it would avoid situation when no one groups doesn't exit.
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().createGroup(new GroupData("temp_group", null, null));
        //main test, contact creation
        app.getContactHelper().createNewContact();
        app.getContactHelper().fillContactForm(new ContactData("ContName", "ContMiddle",
                "ContLast", "CompanyOfContact", "111232, tuda-to, syuda-to",
                "+74895238845", "cont@adg.com", "temp_group"), true);
        app.getContactHelper().submitContactCreation();
        //temp group deletion
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().selectGroup(0);
        app.getGroupHelper().deleteSelectedGroup();
        app.getNavigationHelper().gotoHomePage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after, before+1);
    }
}
