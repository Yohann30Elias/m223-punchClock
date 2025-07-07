package punchclock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import punchclock.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
