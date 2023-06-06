package com.stein.ausbilderportal.feedback;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackData {
    private String title;
    private String text;
    private UUID apprenticeId;
    private UUID categoryId;
    private UUID userId;
}
