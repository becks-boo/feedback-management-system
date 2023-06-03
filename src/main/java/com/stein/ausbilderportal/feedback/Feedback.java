package com.stein.ausbilderportal.feedback;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.stein.ausbilderportal.apprentice.Apprentice;
import com.stein.ausbilderportal.base.BaseEntity;
import com.stein.ausbilderportal.category.Category;
import com.stein.ausbilderportal.user.User;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Feedback extends BaseEntity {
    private String title;
    private String text;
//    private String poster;
//    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "apprentice_id")
    private Apprentice apprentice;
//    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
//    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Feedback{" +
                "title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", apprentice=" + apprentice +
                ", category=" + category +
                ", user=" + user +
                '}';
    }
}
