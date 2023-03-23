package com.stein.ausbilderportal.apprentice;

import com.stein.ausbilderportal.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "apprentice")
public class Apprentice extends BaseEntity {

    private String firstName;

    private String email;
}
