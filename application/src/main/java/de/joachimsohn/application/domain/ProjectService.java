package de.joachimsohn.application.domain;

import de.joachimsohn.cmsapp.domain.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public final class ProjectService {

    private ProjectRepository repository;
}
