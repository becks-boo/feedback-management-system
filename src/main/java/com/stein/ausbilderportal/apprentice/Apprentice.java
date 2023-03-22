package com.stein.ausbilderportal.apprentice;

import com.stein.ausbilderportal.general.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "apprentice")
/*@SQLDelete(sql = "UPDATE apprentice SET state = 'deleted', deleted_at = current_date WHERE id=?")
@Where(clause = "state IN ('created', 'updated')")*/
public class Apprentice extends BaseEntity {
    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "email", nullable = false)
    private String email;
}
