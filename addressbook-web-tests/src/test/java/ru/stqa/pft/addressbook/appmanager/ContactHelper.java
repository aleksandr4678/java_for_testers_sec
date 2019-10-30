package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.test.contacts.ContactData;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver driver) {
        super(driver);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void submitContactCreation() {
        click(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes:'])[1]/following::input[1]"));
    }

    public void submitContactUpdate() {
        click(By.xpath("/html/body/div[1]/div[4]/form[1]/input[22]"));
    }
    public void createNewContact() {
        click(By.linkText("add new"));
    }
    public void editContact() {
        click(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[2]/td[8]/a/img"));
    }

    public void selectContact() {
        click(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[1]/input"));
    }

    public void deleteContact() {
        click(By.xpath("/html/body/div[1]/div[4]/form[2]/div[2]/input"));
    }

    public void confirmContactDeleteAlert() {
        driver.switchTo().alert().accept();
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("middlename"), contactData.getMiddleName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("company"), contactData.getCompanyName());
        type(By.name("address"), contactData.getAddress());
        type(By.name("work"), contactData.getWorkTel());
        type(By.name("email"), contactData.getEmail());
    }
}
