package pl.oskarpolak.models.dao;

import pl.oskarpolak.models.ContactModel;

import java.util.List;

public interface ContactDao {
    void addContact(ContactModel model);
    void removeContact(String number);
    List<ContactModel> getAllContacts();
}
