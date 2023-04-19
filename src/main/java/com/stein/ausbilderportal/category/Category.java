package com.stein.ausbilderportal.category;

import com.stein.ausbilderportal.base.BaseEntity;
import com.stein.ausbilderportal.feedback.Feedback;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Category extends BaseEntity {
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category", fetch = FetchType.LAZY)
    private List<Feedback> feedbackSet;

    public Category(String name) {
        this.name = name;
    }
}
