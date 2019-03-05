package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rcs.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
