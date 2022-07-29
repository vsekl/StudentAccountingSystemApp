package ru.vsevakl.accounting.domain;

import javax.persistence.*;

@Entity
@Table(name = "Groups")
public class Group {
    @Id
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}