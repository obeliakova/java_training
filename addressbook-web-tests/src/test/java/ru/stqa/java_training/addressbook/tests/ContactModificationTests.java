package ru.stqa.java_training.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.java_training.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition(){
    app.goTo().homePage();
    if (app.contact().list().size() == 0) {
      app.goTo().addNewContactPage();
      app.contact().create(new ContactData().withFirstname("Liza").withLastname("Vasileva")
                      .withCompany("Brain").withMobile("+79650909700").withEmail("liza@test.com").withGroup("test1"),
                      true);
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withId(before.get(before.size()-1).getId()).withFirstname("Vasya")
            .withLastname("Petrov").withGroup("ALE").withMobile("+79005060900").withEmail("anton@ale.com");
    int index = before.size() - 1;
    app.contact().modify(contact, index);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }

}
