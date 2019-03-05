package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcs.model.Contact;

import repository.ContactRepository;

@RestController
@RequestMapping({"/contacts"})
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepo;
	
	@GetMapping
	public List<Contact> findAll() {
		return contactRepo.findAll();
	}
}
