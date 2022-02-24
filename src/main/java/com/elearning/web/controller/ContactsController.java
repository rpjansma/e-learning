package com.elearning.web.controller;

import com.elearning.entity.Contacts;
import com.elearning.service.ContactsService;
import com.elearning.service.impl.ContactsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactsController {

    private final ContactsService contactsService;
    private String ERROR_MESSAGE = "Sorry, we got the error: ";


    public ContactsController(ContactsServiceImpl contactsService) {
        this.contactsService = contactsService;
    }

    @GetMapping("/")
    public ResponseEntity getAllContacts() {
        try {
            return new ResponseEntity(contactsService.getAllContacts(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    public ResponseEntity saveContacts(@RequestBody Contacts contacts) {
        try {
            return new ResponseEntity(contactsService.saveContacts(contactsService.saveContacts(contacts)), HttpStatus.CREATED);

        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/")
    public ResponseEntity updateContacts(@RequestBody Contacts contacts) {
        try {
            return new ResponseEntity(contactsService.updateContacts(contacts), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.NOT_IMPLEMENTED);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteContacts(@PathVariable Long id) {
        try {
            return new ResponseEntity(contactsService.deleteContacts(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(ERROR_MESSAGE + e.getMessage() + " caused by: " + e.getCause(), HttpStatus.NOT_IMPLEMENTED);
        }
    }

}
