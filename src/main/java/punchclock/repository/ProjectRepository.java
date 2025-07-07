package punchclock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import punchclock.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
