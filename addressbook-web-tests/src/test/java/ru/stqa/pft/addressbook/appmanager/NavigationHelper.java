package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void goToGroupPage() {
        click(By.linkText("groups"));
    }

    public void createNewContact() {
        click(By.linkText("add new"));
    }
    public void editContact() {
        click(By.xpath("/html/body/div[1]/div[4]/form[2]/table/tbody/tr[3]/td[8]/a/img"));
    }
}
