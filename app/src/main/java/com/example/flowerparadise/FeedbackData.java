package com.example.flowerparadise;

public class FeedbackData {
    String name;
    String feedback;

    public FeedbackData(String name, String feedback) {
        this.name = name;
        this.feedback = feedback;
    }

    public String getName() {
        return name;
    }

    public String getFeedback() {
        return feedback;
    }
}
