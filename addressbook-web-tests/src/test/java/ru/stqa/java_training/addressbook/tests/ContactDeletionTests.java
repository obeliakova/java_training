package ru.stqa.java_training.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.ContactData;
import ru.stqa.java_training.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition(){
    app.goTo().homePage();
    if (app.contact().all().size() == 0) {
      app.goTo().addNewContactPage();
      app.contact().create(new ContactData().withFirstname("Liza").withLastname("Vasileva")
              .withCompany("Brain").withMobile("+79650909700").withEmail("liza@test.com").withGroup("test1"),
              true);
    }
  }

  @Test
  public void testContactDeletion(){
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.without(deletedContact)));
  }

}
