package model;

import java.time.LocalDateTime;

public record CmsKeyDto(String key, String value, LocalDateTime ValidFrom, CmsKeyDto child, CmsKeyDto parent) {
}
