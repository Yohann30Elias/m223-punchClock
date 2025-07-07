package punchclock.controller;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import punchclock.domain.Entry;
import punchclock.dto.EntryDTO;
import punchclock.service.EntryService;

@RestController
@RequestMapping("/entries")
public class EntryController {

    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<EntryDTO> getAllEntries() {
        return entryService.findAllEntries()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntryDTO createEntry(@Valid @RequestBody EntryDTO dto) {
        Entry entry = toEntity(dto);
        Entry saved = entryService.createEntry(entry);
        return toDto(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntryDTO> updateEntry(@PathVariable Long id, @RequestBody EntryDTO dto) {
        try {
            Entry updated = entryService.updateEntry(id, toEntity(dto));
            return ResponseEntity.ok(toDto(updated));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntry(@PathVariable Long id) {
        try {
            entryService.deleteEntry(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    private EntryDTO toDto(Entry entry) {
        return new EntryDTO(entry.getId(), entry.getCheckIn(), entry.getCheckOut());
    }

    private Entry toEntity(EntryDTO dto) {
        return new Entry(dto.getId(), dto.getCheckIn(), dto.getCheckOut());
    }
}
