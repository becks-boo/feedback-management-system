package com.stein.ausbilderportal.feedback;

import com.stein.ausbilderportal.apprentice.Apprentice;
import com.stein.ausbilderportal.base.BaseEntity;
import com.stein.ausbilderportal.category.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "feedback")
public class Feedback extends BaseEntity {
    private String title;
    private String text;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Apprentice apprentice;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Category category;
}
