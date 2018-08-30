package ru.stqa.java_training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().gotoAddNewContactPage();
    app.getContactHelper().createContact(new ContactData("Liza", "Vasileva", "Brain",
            "+79650909700", "liza@test.com", "test1"), true);
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }
}
