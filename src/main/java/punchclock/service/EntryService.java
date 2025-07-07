package punchclock.service;

import java.util.List;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import punchclock.domain.Entry;
import punchclock.repository.EntryRepository;

@Service
public class EntryService {

	private final EntryRepository entryRepository;

	public EntryService(EntryRepository entryRepository) {
		this.entryRepository = entryRepository;
	}

	public List<Entry> findAllEntries() {
		return entryRepository.findAll();
	}

	public Entry createEntry(Entry entry) {
		return entryRepository.save(entry);
	}

	public void deleteEntry(Long id) {
		if (!entryRepository.existsById(id)) {
			throw new EntityNotFoundException("Entry not found with id: " + id);
		}
		entryRepository.deleteById(id);
	}

	public Entry updateEntry(Long id, Entry updatedEntry) {
		return entryRepository.findById(id)
				.map(existing -> {
					existing.setCheckIn(updatedEntry.getCheckIn());
					existing.setCheckOut(updatedEntry.getCheckOut());
					existing.setComment(updatedEntry.getComment());
					return entryRepository.save(existing);
				})
				.orElseThrow(() -> new EntityNotFoundException("Entry not found with id: " + id));
	}
}
