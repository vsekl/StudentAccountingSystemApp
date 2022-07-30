package ru.vsevakl.accounting.custom;

import java.io.Serializable;

public class MaxSequence {
    private Long grade;
    private Integer streak;

    public MaxSequence(Long grade, Integer streak) {
        this.grade = grade;
        this.streak = streak;
    }

    public Long getGrade() {
        return grade;
    }

    public Integer getStreak() {
        return streak;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }

    public void setStreak(Integer streak) {
        this.streak = streak;
    }
}
