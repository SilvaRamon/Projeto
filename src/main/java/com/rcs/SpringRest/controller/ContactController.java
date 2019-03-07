package com.rcs.SpringRest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rcs.SpringRest.model.Contact;
import com.rcs.SpringRest.repository.ContactRepository;

@RestController
@RequestMapping({"/contacts"})
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@GetMapping
	public List<Contact> findAll() {
		return contactRepository.findAll();
	}
	
	@PostMapping
	@ResponseStatus(code=HttpStatus.CREATED)
	public Contact add(@RequestBody Contact contact) {
		return contactRepository.save(contact);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Contact> findById(@PathVariable long id) {
		return contactRepository.findById(id)
				.map(result -> ResponseEntity.ok().body(result))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") long id) {
		return contactRepository.findById(id)
				.map(result -> {contactRepository.deleteById(id);
	            return ResponseEntity.ok().build();
			}).orElse(ResponseEntity.notFound().build());
	  }
}
