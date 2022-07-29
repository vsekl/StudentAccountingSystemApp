package ru.vsevakl.accounting.domain;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;

    private Long age;
    @Column(name = "group_id")
    private Long groupId;

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Long getAge() {
        return age;
    }

    public Long getGroupId() {
        return groupId;
    }
}
