package ru.vsevakl.accounting.domain;

import javax.persistence.*;

@Entity
@Table(name = "marks_description")
public class MarkDescription {
    @Id
    private  Long id;
    private Long mark;
    private String description;

    public Long getId() {
        return id;
    }

    public Long getMark() {
        return mark;
    }

    public String getDescription() {
        return description;
    }
}