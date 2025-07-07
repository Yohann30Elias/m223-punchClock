package punchclock;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import punchclock.domain.Category;
import punchclock.domain.Entry;
import punchclock.domain.Tag;
import punchclock.repository.CategoryRepository;
import punchclock.repository.EntryRepository;
import punchclock.repository.TagRepository;

@SpringBootApplication
public class PunchclockApplication {
	private static final Logger log = LoggerFactory.getLogger(PunchclockApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PunchclockApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(
			EntryRepository entryRepository,
			CategoryRepository categoryRepository,
			TagRepository tagRepository) {
		return (args) -> {
			// Categories
			Category catWork = new Category("Arbeit");
			Category catBreak = new Category("Pause");
			categoryRepository.saveAll(List.of(catWork, catBreak));

			// Tags
			Tag tagUrgent = new Tag("Dringend");
			Tag tagOptional = new Tag("Optional");
			tagRepository.saveAll(List.of(tagUrgent, tagOptional));

			// Entries
			Entry e1 = new Entry(LocalDateTime.now().minusHours(3), LocalDateTime.now());
			e1.setCategory(catWork);
			e1.setTags(List.of(tagUrgent));

			Entry e2 = new Entry(LocalDateTime.now().minusHours(2), LocalDateTime.now());
			e2.setCategory(catBreak);
			e2.setTags(List.of(tagOptional));

			Entry e3 = new Entry(LocalDateTime.now().minusHours(1), LocalDateTime.now());
			e3.setCategory(catWork);
			e3.setTags(List.of(tagUrgent, tagOptional));

			entryRepository.saveAll(List.of(e1, e2, e3));

			log.info("Testdaten geladen:");
			entryRepository.findAll().forEach(entry -> log.info(entry.toString()));
		};
	}
}
