package com.stein.ausbilderportal.feedback;

import com.stein.ausbilderportal.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, UUID> {
    List<Feedback> findByApprenticeId(UUID apprenticeId);
    @Query("SELECT f.category FROM Feedback f WHERE f.apprentice.id = :apprenticeId")
    List<Category> findCategoryByApprenticeId(UUID apprenticeId);

    List<Feedback> findByApprenticeIdAndCategoryId(UUID apprenticeId, UUID categoryId);
}
