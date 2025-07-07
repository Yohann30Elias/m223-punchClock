package punchclock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import punchclock.domain.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
