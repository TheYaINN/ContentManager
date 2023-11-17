package de.joachimsohn.application.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.SortedSet;

@Entity
@Table
public final class Project {

    @Id
    private String name;

    @OneToMany
    private SortedSet<Environment> environments;


}
