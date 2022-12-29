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
		contactRepository.save(new Contact("Achraf", "Hakimi", df.parse("10/08/1998"), "achraf@gmail.com", 0645, "achraf.jpeg"));
		contactRepository.save(new Contact("Kawtar", "Lairaichi", df.parse("25/02/1998"), "kawtar@gmail.com", 0645, "kawtar.jpeg"));
		contactRepository.findAll().forEach(c -> {
			System.out.println(c.getFirstName());
		});
	}
}
