package model;

import lombok.Builder;

import java.util.SortedSet;

@Builder
public record ProjectDto(String name, SortedSet<EnvironmentDto> environments) {
}
