package com.stein.ausbilderportal.apprentice;

import com.stein.ausbilderportal.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "apprentice")
public class Apprentice extends BaseEntity {
    private String firstName;
    private String email;
}
