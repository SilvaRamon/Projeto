package com.rcs.SpringRest.controller;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcs.SpringRest.model.Contact;
import com.rcs.SpringRest.repository.ContactRepository;

@RestController
@RequestMapping({"/contacts"})
public class ContactController {
	
	private final ContactRepository contactRepository;
	
	public ContactController(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	@GetMapping
	public List<Contact> findAll() {
		return contactRepository.findAll();
	}
	
//	@GetMapping
//	public String hello() {
//		return "relou";
//	}
}
