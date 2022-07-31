package ru.vsevakl.accounting.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "disciplines")
public class Discipline {
    @Id
    private Long id;
    private String name;
}
