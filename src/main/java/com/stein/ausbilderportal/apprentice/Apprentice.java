package com.stein.ausbilderportal.apprentice;

import com.stein.ausbilderportal.base.BaseEntity;
import com.stein.ausbilderportal.feedback.Feedback;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Apprentice extends BaseEntity {
    private String firstName;
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "apprentice", fetch = FetchType.LAZY)
    private List<Feedback> feedbackList;

    public Apprentice(String firstname, String email) {
        this.firstName = firstname;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Apprentice{" +
                "firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
