package org.sid.web;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContactRestService {

    @Autowired
    private ContactRepository contactRepository;

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public List<Contact> getContacts(){
        return contactRepository.findAll();
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
    public Optional<Contact> getContact(@PathVariable Long id){
        return contactRepository.findById(id);
    }

    @RequestMapping(value = "/searchContacts", method = RequestMethod.GET)
    public Page<Contact> search(
            @RequestParam(name = "kw", defaultValue = "") String kw,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size){
        return contactRepository.search("%" + kw + "%", PageRequest.of(page, size));
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.POST)
    public Contact save(@RequestBody Contact c){
        return contactRepository.save(c);
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE)
    public boolean remove(@PathVariable Long id){
        contactRepository.deleteById(id);
        return true;
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.PUT)
    public Contact update(@PathVariable Long id, @RequestBody Contact c){
        c.setId(id);
        return contactRepository.save(c);
    }

}
