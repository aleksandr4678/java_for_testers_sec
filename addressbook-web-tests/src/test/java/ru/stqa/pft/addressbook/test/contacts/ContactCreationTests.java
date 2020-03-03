package ru.stqa.pft.addressbook.test.contacts;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.TestBase;

import java.io.File;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase {
    @Test
    public void testContactCreation() throws Exception {
        List<ContactData> before = app.contact().getContactList();
        //new group creation, it would avoid situation when no one groups doesn't exit.
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("!temp_group"));
        //main test, contact creation
        File photo = new File("src/test/resources/img.png");
        ContactData contact = new ContactData().withFirstName("ContNameNew1").withMiddleName("ContMiddleNew1").
                withLastName("ContLastNew1").withCompanyName("CompanyOfContactNew").withAddress("111232, tuda-to, syuda-toNew").
                withWorkTel("+74895238845").withEmail("contNew@adg.com").withGroup("!temp_group").withPhoto(photo);
        app.contact().createContact(contact, true);
        //temp group deletion
        app.goTo().groupPage();
        app.group().selectGroup(0);
        app.group().deleteSelectedGroup();
        app.goTo().homePage();
        List<ContactData> after = app.contact().getContactList();
        Assert.assertEquals(after.size(), before.size() + 1);

        int max = 0;
        for (ContactData c : after) {
            if (c.getId() > max) {
                max = c.getId();
            }
        }
        contact.withId(max);
        contact.withMiddleName(null);
        contact.withCompanyName(null);
        contact.withGroup(null);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
