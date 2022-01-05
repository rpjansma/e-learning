package com.elearning.adminservice.controller;

import com.elearning.adminservice.entity.Contacts;
import com.elearning.adminservice.entity.User;
import com.elearning.adminservice.service.impl.ContactsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactsController {

    private final ContactsServiceImpl contactsService;

    public ContactsController(ContactsServiceImpl contactsService) {
        this.contactsService = contactsService;
    }

    @GetMapping("/")
    public ResponseEntity getAllContacts() {
        return new ResponseEntity(contactsService.getAllContacts(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity saveContacts(@RequestBody Contacts contacts) {
        try {
            return new ResponseEntity(contactsService.saveContacts(contactsService.saveContacts(contacts)), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity("Checkout the data inputed, please. Seems like we have a error, Houston.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/")
    public ResponseEntity updateContacts(@RequestBody Contacts contacts) {
        try {
            return new ResponseEntity(contactsService.updateContacts(contacts), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity("Looks like this id not exists, check it out please.", HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteContacts(@PathVariable Long id) {
        try {
            return new ResponseEntity(contactsService.deleteContacts(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Looks like this id not exists, check it out please.", HttpStatus.NOT_IMPLEMENTED);
        }
    }

}
