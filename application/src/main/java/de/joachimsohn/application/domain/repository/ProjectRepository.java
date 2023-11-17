package de.joachimsohn.application.domain.repository;


import de.joachimsohn.application.domain.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, String> {

}
