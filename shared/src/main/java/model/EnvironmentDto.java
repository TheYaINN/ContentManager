package model;

import java.util.List;

public record EnvironmentDto(String name, int order, List<CmsKeyDto> keys) implements Comparable<EnvironmentDto> {

    @Override public int compareTo(final EnvironmentDto other) {
        return Integer.compare(order, other.order);
    }
}
