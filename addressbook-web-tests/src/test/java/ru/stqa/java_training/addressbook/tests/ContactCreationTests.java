package ru.stqa.java_training.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation() {
    app.gotoAddNewContactPage();
    app.fillContactForm(new ContactData("Liza", "Vasileva", "Brain", "+79650909700", "liza@test.com"));
    app.submitContactCreation();
    app.gotoHomePage(); //для проверки, что контакт действительно был создан
  }

}