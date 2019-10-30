package ru.stqa.pft.addressbook.test.contacts;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;

public class ContactCreation extends TestBase {
    @Test
    public void testContactCreation() throws Exception {
        app.getContactHelper().createNewContact();
        app.getContactHelper().fillContactForm(new ContactData("ContName", "ContMiddle", "ContLast", "CompanyOfContact", "111232, tuda-to, syuda-to", "+74895238845", "cont@adg.com"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();
    }
}
