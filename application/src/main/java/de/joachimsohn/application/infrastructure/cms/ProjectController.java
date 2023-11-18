package de.joachimsohn.application.infrastructure.cms;

import de.joachimsohn.application.infrastructure.cms.adapter.ProjectWebAdapter;
import model.CmsKeyDto;
import model.EnvironmentDto;
import model.ProjectDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.TreeSet;

@RestController
@RequestMapping("projects/")
public final class ProjectController {

    private ProjectWebAdapter adapter;

    @GetMapping
    public ResponseEntity<List<ProjectDto>> loadAll() {
        var res = ResponseEntity.ok(List.of(ProjectDto.builder().name("test").environments(new TreeSet<>() {{
            add(EnvironmentDto.builder().name("Env 1").order(0).keys(List.of(CmsKeyDto.builder()
                    .key("just keying").value("my Value").children(110).build())).build());
            add(EnvironmentDto.builder().name("Env 2").order(1).keys(List.of()).build());
            add(EnvironmentDto.builder().name("Env 3").order(2).keys(List.of()).build());
            add(EnvironmentDto.builder().name("Env 4").order(3).keys(List.of()).build());
            add(EnvironmentDto.builder().name("Env 5").order(4).keys(List.of()).build());
            add(EnvironmentDto.builder().name("Env 6").order(5).keys(List.of()).build());
            add(EnvironmentDto.builder().name("Env 7").order(6).keys(List.of()).build());
        }}).build(), ProjectDto.builder().name("final").environments(new TreeSet<>()).build()));
        return res;
    }

}
