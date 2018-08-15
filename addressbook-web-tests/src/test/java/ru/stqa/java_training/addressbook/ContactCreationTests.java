package ru.stqa.java_training.addressbook;

import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    gotoAddNewContactPage();
    fillContactForm(new ContactData("Liza", "Vasileva", "Brain", "+79650909700", "liza@test.com"));
    submitContactCreation();
    gotoHomePage(); //для проверки, что контакт действительно был создан
  }

}
