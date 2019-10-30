package ru.stqa.pft.addressbook.test.contacts;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.TestBase;

public class ContactDeletionTests extends TestBase {
    @Test
    public void testContactCreation() throws Exception {
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        app.getContactHelper().confirmContactDeleteAlert();
    }
}