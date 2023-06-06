package com.stein.ausbilderportal.base;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
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
}
