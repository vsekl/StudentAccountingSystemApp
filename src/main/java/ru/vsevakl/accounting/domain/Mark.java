package ru.vsevakl.accounting.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "marks")
public class Mark {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @Column(name = "discipline_id")
    private Long disciplineId;
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "mark_id")
    private Long markDescriptionId;

    public Long getId() {
        return id;
    }

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date getDate() {
        return date;
    }

    public Long getDisciplineId() {
        return disciplineId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Long getMarkDescriptionId() {
        return markDescriptionId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDisciplineId(Long disciplineId) {
        this.disciplineId = disciplineId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setMarkDescriptionId(Long markDescriptionId) {
        this.markDescriptionId = markDescriptionId;
    }
}
