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
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("!!!temp_group"));
        app.goTo().homePage();
        if (!app.contact().isThereAContact()) {
            //new contact creation
            ContactData contact = new ContactData().withFirstName("ContNameNew1").withMiddleName("ContMiddleNew1").
                    withLastName("ContLastNew1").withCompanyName("CompanyOfContactNew").withAddress("111232, tuda-to, syuda-toNew").
                    withWorkTel("+74895238845").withEmail("contNew@adg.com").withGroup("!!!temp_group");
            app.contact().createContact(contact, true);
        }
        //main test, contact deletion
        app.goTo().homePage();
        List<ContactData> before = app.contact().getContactList();
        app.contact().selectContact(0);
        app.contact().delete();
        app.contact().confirmContactDeleteAlert();
        //temp group deletion
        app.goTo().groupPage();
        app.group().selectGroup(0);
        app.group().deleteSelectedGroup();
        app.goTo().homePage();
        List<ContactData> after = app.contact().getContactList();
        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }
}