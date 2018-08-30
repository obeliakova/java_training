package ru.stqa.java_training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoAddNewContactPage();
      app.getContactHelper().createContact(new ContactData("Anton", "Mishin", "Brain",
              "+79650909700", "anton@brain.com", "test1"), true);
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().editContact(before - 1);
    app.getContactHelper().fillContactForm(new ContactData("Anton", "Mishin", "ALE",
            "+79005060900", "anton@ale.com", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);
  }
}
