package de.joachimsohn.application.cms;

import de.joachimsohn.application.cms.adapter.ProjectWebAdapter;
import model.ProjectDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("projects/")
public final class ProjectController {

    private ProjectWebAdapter adapter;

    @GetMapping
    public ResponseEntity<ProjectDto> loadAll() {
        return ResponseEntity.ok(ProjectDto.builder().name("test").build());
    }

}
