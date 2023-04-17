package com.stein.ausbilderportal.apprentice;

import com.stein.ausbilderportal.base.BaseEntity;
import com.stein.ausbilderportal.feedback.Feedback;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "apprentice")
public class Apprentice extends BaseEntity {
    private String firstName;
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apprentice", fetch = FetchType.LAZY)
    private Set<Feedback> feedbackSet;

    public Apprentice(String firstname, String email) {
        this.firstName = firstname;
        this.email = email;
    }
}
