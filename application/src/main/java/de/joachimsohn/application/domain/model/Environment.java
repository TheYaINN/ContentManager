package de.joachimsohn.application.domain.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

import static java.lang.Integer.compare;

@Entity
@Table
public final class Environment implements Comparable<Environment> {

    @Id
    @NotNull
    private String name;

    private int order;

    @Nullable
    @Cascade({CascadeType.MERGE, CascadeType.SAVE_UPDATE})
    @OneToMany
    private List<CmsKey> keys;

    @Override
    public int compareTo(final Environment other) {
        return compare(order, other.order);
    }
}
