package punchclock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import punchclock.domain.Entry;
import punchclock.domain.EntryCategory;
import punchclock.repository.EntryRepository;


@SpringBootApplication
public class PunchclockApplication {
	private static final Logger log = LoggerFactory.getLogger(PunchclockApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(PunchclockApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(EntryRepository repository) {
		return (args) -> {
			// save a couple of customers
			Entry e1 = new Entry(LocalDateTime.now(), LocalDateTime.now());
			Entry e2 = new Entry(LocalDateTime.now(), LocalDateTime.now());
			Entry e3 = new Entry(LocalDateTime.now(), LocalDateTime.now());
			Entry e4 = new Entry(LocalDateTime.now(), LocalDateTime.now(), EntryCategory.FIX);
			Entry e5 = new Entry(LocalDateTime.now(), LocalDateTime.now(), EntryCategory.FIX);
			repository.save(e1);
			repository.save(e2);
			repository.save(e3);
			repository.save(e4);
			repository.save(e5);
						
			// fetch all customers
			log.info("Entries found with findAll():");
			log.info("-------------------------------");
			for (Entry entry : repository.findAll()) {
				log.info(entry.toString());
			}
			log.info("");

//			// fetch an individual customer by ID
//			repository.findById(1).ifPresent(customer -> {
//				log.info("Customer found with findById(1L):");
//				log.info("--------------------------------");
//				log.info(customer.toString());
//				log.info("");
//			});
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			repository.findByLastname("Bauer").forEach(bauer -> {
//				log.info(bauer.toString());
//			});
//			// for (Customer bauer : repository.findByLastName("Bauer")) {
//			// log.info(bauer.toString());
//			// }
//			log.info("customers");

			

		};
	}
}
