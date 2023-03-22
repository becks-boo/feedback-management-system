package com.stein.ausbilderportal.general.base;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "state", nullable = false)
    @Enumerated(EnumType.STRING)
    private StateEnum stateEnum;

    @PrePersist
    public void onPrePersist() {
        this.createdAt = LocalDateTime.now();
        this.stateEnum = StateEnum.CREATED;
    }

    @PreUpdate
    public void onPreUpdate() {
        if (stateEnum.equals(StateEnum.DELETED)) {
            return;
        }

        this.updatedAt = LocalDateTime.now();
        this.stateEnum = StateEnum.UPDATED;
    }

    @PostRemove
    public void onPostRemove() {
        this.deletedAt = LocalDateTime.now();
        this.stateEnum = StateEnum.DELETED;
    }
}
