package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repository.ContactRepository;

@RestController
@RequestMapping({"/contacts"})
public class ContactController {
	
	private ContactRepository contactRepo;
	
	public ContactController(ContactRepository contactRepo) {
		this.contactRepo = contactRepo;
	}

	@GetMapping
//	public List<Contact> findAll() {
//		return contactRepo.findAll();
//	}
	
	public String hello() {
		return "relou";
	}
}
