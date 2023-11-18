package de.joachimsohn.application.domain.model;

import jakarta.persistence.*;

import java.util.SortedSet;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@Table
public final class Project {

    @Id
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = {MERGE, PERSIST}, targetEntity = Environment.class)
    private SortedSet<Environment> environments;


}
