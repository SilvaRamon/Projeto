package com.rcs.SpringRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcs.SpringRest.model.Contact;
import com.rcs.SpringRest.repository.ContactRepository;

@RestController
@RequestMapping({"/contacts"})
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@GetMapping("/all")
	public List<Contact> findAll() {
		return contactRepository.findAll();
	}
	
	@PostMapping("/add")
	public Contact add(@RequestBody Contact contact) {
		return contactRepository.save(contact);
	}
}
