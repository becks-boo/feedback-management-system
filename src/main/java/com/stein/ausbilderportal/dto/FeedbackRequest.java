package com.stein.ausbilderportal.dto;

import java.util.UUID;

public record FeedbackRequest(
        String title,
        String text,
        String poster,
        UUID apprenticeId,
        UUID categoryId,
        UUID userId
) {
}
