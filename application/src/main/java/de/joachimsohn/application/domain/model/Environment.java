package de.joachimsohn.application.domain.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static java.lang.Integer.compare;

@Entity
@Table
public final class Environment implements Comparable<Environment> {

    @Id
    @NotNull
    private String name;

    private int order;

    @OneToMany(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST}, targetEntity = CmsKey.class)
    private List<CmsKey> keys;

    @Override
    public int compareTo(final Environment other) {
        return compare(order, other.order);
    }
}
