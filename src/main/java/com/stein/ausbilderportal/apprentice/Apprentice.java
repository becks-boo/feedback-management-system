package com.stein.ausbilderportal.apprentice;

import com.stein.ausbilderportal.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "apprentice")
public class Apprentice extends BaseEntity {

    private String firstName;

    private String email;
}
