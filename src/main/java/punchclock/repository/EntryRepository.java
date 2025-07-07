package punchclock.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import punchclock.domain.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {
}
