package org.sid;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class GestionContactsApplication implements CommandLineRunner {

	@Autowired
	private ContactRepository contactRepository;


	public static void main(String[] args) {
		SpringApplication.run(GestionContactsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		contactRepository.save(new Contact("Hassani", "Mohamed", df.parse("12/10/1998"), "hassani@gmail.com", 0645, "hassan.jpeg"));
		contactRepository.findAll().forEach(c -> {
			System.out.println(c.getFirstName());
		});
	}
}
