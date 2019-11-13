package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {
    public List<ContactData> contacts = new ArrayList<>();

    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
    } ///html/body/div/div[4]/form/input[21]

    public void submitContactUpdate() {
        click(By.xpath("/html/body/div[1]/div[4]/form[1]/input[22]"));
    }

    public void createNewContact() {
        click(By.linkText("add new"));
    }

    public void editContact() {
        click(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[8]/a/img"));
    }

    public void selectContact(int index) {
        driver.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteContact() {
        click(By.xpath("/html/body/div[1]/div[4]/form[2]/div[2]/input"));
    }

    public void confirmContactDeleteAlert() {
        driver.switchTo().alert().accept();
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("company"), contactData.getCompanyName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("work"), contactData.getWorkTel());
        type(By.name("email"), contactData.getEmail());
        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createContact(ContactData contact, boolean creation) {
        createNewContact();
        fillContactForm(contact, creation);
        submitContactCreation();
        returnToHomePage();
    }

    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = driver.findElements(By.id("maintable"));
        for (WebElement element : elements) {
            String id = element.findElement(By.tagName("input")).getAttribute("value");
            String firstName = element.getText();
            String middleName = element.getText();
            String lastName = element.getText();
            String companyName = element.getText();
            String address = element.getText();
            String workTel = element.getText();
            String email = element.getText();
            String group = element.getText();
            ContactData contact = new ContactData(id, firstName, middleName, lastName, companyName, address, workTel,
                    email, group);
            contacts.add(contact);
        }
        return contacts;
    }
}