package ru.vsevakl.accounting.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    public Date getDate() {
        return date;
    }
}
