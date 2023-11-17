package de.joachimsohn.application.infrastructure.cms.adapter;

import de.joachimsohn.application.domain.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public final class ProjectWebAdapter {

    private final ProjectService service;


}
