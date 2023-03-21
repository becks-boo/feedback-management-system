package com.stein.ausbilderportal.general.base;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
public class EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    protected LocalDateTime createdAt;

    @Column(name = "updated_at")
    protected LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    protected LocalDateTime deletedAt;

    @Column(name = "state", nullable = false)
    @Enumerated(EnumType.STRING)
    protected EntityState entityState;

    @PrePersist
    public void onPrePersist() {
        this.createdAt = LocalDateTime.now();
        this.entityState = EntityState.CREATED;
    }

    @PreUpdate
    public void onPreUpdate() {
        if (entityState.equals(EntityState.DELETED)) {
            return;
        }

        this.updatedAt = LocalDateTime.now();
        this.entityState = EntityState.UPDATED;
    }

    @PostRemove
    public void onPostRemove() {
        this.deletedAt = LocalDateTime.now();
        this.entityState = EntityState.DELETED;
    }
}
