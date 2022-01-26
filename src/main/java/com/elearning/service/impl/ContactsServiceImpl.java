package com.elearning.service.impl;

import com.elearning.entity.Contacts;
import com.elearning.repository.ContactsRepository;
import com.elearning.service.ContactsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService {

    private final ContactsRepository repository;

    public ContactsServiceImpl(ContactsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Contacts saveContacts(Contacts contacts) {
        return repository.save(contacts);
    }

    @Override
    public Contacts updateContacts(Contacts contacts) {

        return  repository.save(contacts);
    }

    //    Customer customerToUpdate = customerRepository.getOne(id);
//     customerToUpdate.setName(customerDto.getName);
//customerRepository.save(customerToUpdate);
    @Override
    public boolean deleteContacts(Long id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public List<Contacts> getAllContacts() {
        return repository.findAll();
    }
}
