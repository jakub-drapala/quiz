package com.drapala.quiz.entity.enums;

public enum Category {
    HISTORY("history"), GEOGRAPHY("geography"), BIOLOGY("biology");

    private final String description;

    Category(final String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}





