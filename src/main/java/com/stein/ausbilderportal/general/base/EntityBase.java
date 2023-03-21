package com.stein.ausbilderportal.general.base;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public class EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(unique = true, nullable = false)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    protected LocalDateTime createdAt;

    @Column(name = "updated_at")
    protected LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    protected LocalDateTime deletedAt;

    @Column(name = "state", nullable = false)
    protected LocalDateTime state;

    /*@PrePersist
    public void onPrePersist() {
        this.createdAt = LocalDateTime.now();
        this.state = EntityState.CREATED.toString();
    }*/
}
