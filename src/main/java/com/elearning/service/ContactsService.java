package com.elearning.service;

import com.elearning.entity.Contacts;

import java.util.List;

public interface ContactsService {

    Contacts saveContacts(Contacts contacts);

    Contacts updateContacts(Contacts contacts);

    boolean deleteContacts(Long id);

    List<Contacts> getAllContacts();
}
