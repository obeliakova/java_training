package ru.stqa.java_training.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.java_training.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("company"), contactData.getCompany());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());

    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    acceptAlert();
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void editContact(int index) {
    wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']")).get(index)
      .findElement(By.xpath("./td[8]/a/img")).click();
  }

  public void create(ContactData contactData, boolean creation) {
    fillContactForm(contactData, creation);
    submitContactCreation();
    returnToHomePage();
  }

  public void modify(ContactData contact, int index) {
    editContact(index);
    fillContactForm(contact, false);
    submitContactModification();
    returnToHomePage();
  }

  public void delete(int index) {
    selectContact(index);
    deleteSelectedContacts();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> rowsInTable = wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[@name='entry']"));
    for (WebElement rowInTable : rowsInTable) {

      int id = Integer.parseInt(rowInTable.findElement(By.xpath("./td[1]/input")).getAttribute("value"));
      String lastName = rowInTable.findElement(By.xpath("./td[2]")).getText();
      String firstName = rowInTable.findElement(By.xpath("./td[3]")).getText();
      String email = rowInTable.findElement(By.xpath("./td[5]/a")).getText();
      String mobile = rowInTable.findElement(By.xpath("./td[6]")).getText();
      contacts.add(new ContactData()
              .withId(id).withFirstname(firstName).withLastname(lastName).withMobile(mobile).withEmail(email));
    }
    return contacts;
  }
}
