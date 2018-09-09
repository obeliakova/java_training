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
      app.contact().create(new ContactData("Liza", "Vasileva", "Brain",
              "+79650909700", "liza@test.com", "test1"), true);
    }
  }

  @Test
  public void testContactModification() {
    List<ContactData> before = app.contact().list();
    ContactData contact = new ContactData(before.get(before.size()-1).getId(),"Anton", "Mishin", "ALE",
            "+79005060900", "anton@ale.com", null);
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
