package ru.stqa.pft.addressbook.test.contacts;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;
import ru.stqa.pft.addressbook.test.groups.GroupData;

public class ContactModificationTests extends TestBase {
    @Test
    public void groupModification() {
        app.getNavigationHelper().editContact();
        app.getContactHelper().fillContactForm(new ContactData("ContNameEdit", "ContMiddleEdit", "ContLastEdit", "CompanyOfContactEdit", "111232, tuda-to, syuda-toEdit", "+74895238845", "contEdit@adg.com"));
        app.getContactHelper().submitContactUpdate(); //page has a bug. its delete the updated contact.
        app.getContactHelper().returnToHomePage();
    }
}
