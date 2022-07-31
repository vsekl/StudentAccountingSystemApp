package ru.vsevakl.accounting.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Stats {
    private List<DisciplineAvg> disciplineAvg;
    private List<DisciplineMinMax> disciplineMinMax;
    private List<GradeNumber> gradeNumber;
    private MaxSequence maxSequence;
}
