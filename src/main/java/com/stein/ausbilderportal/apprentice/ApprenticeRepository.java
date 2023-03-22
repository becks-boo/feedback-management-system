package com.stein.ausbilderportal.apprentice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ApprenticeRepository extends JpaRepository<Apprentice, UUID> {
}
