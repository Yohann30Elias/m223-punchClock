package punchclock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import punchclock.domain.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
