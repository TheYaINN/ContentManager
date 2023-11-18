package de.joachimsohn.application.domain.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class CmsKey {

    @Id
    @NotNull
    private String key;

    @NotNull
    private String value;

    @Nullable
    private LocalDateTime ValidFrom;

    @Nullable
    @OneToOne
    private CmsKey child;

    private int children;

    @Nullable
    @OneToOne
    private CmsKey parent;

    /**
     * the child always has to be in the future to be a valid recursion, that will only be replaced
     *
     * @param child
     * @throws NotAssignableError
     */
    public void setChild(final CmsKey child) throws NotAssignableError {
        if (parent == null) {
            this.child = child;
            propagateUp();
        } else {
            if (parent.ValidFrom != null && parent.ValidFrom.isBefore(child.ValidFrom)) {
                this.child = child;
                propagateUp();
            } else {
                throw new NotAssignableError();
            }
        }
    }

    private void propagateUp() {
        var current = this;
        while (current.parent != null) {
            current.children++;
            current = parent;
        }
    }

    public static class NotAssignableError extends Throwable {

    }
}
