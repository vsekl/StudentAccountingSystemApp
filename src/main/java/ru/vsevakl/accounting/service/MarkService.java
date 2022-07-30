package ru.vsevakl.accounting.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsevakl.accounting.domain.Mark;
import ru.vsevakl.accounting.dto.*;
import ru.vsevakl.accounting.repository.MarkRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class MarkService {
    private final MarkRepository markRepository;

    public List<Mark> getMarks() {
        return markRepository.findAll();
    }

    public void addMark(Mark mark) {
        markRepository.save(mark);
    }

    public Stats markStatistics() {
        List<DisciplineAvg> avgGradeAtEveryDiscipline = markRepository.avgGradeAtEveryDiscipline();
        List<DisciplineMinMax> minMaxGradeAtEveryDiscipline = markRepository.minMaxGradeAtEveryDiscipline();
        List<GradeNumber> gradeNumber = markRepository.countAllMarksByGrade();
        MaxSequence maxSequence = findMaxSequence(markRepository.findAllBetweenDatesOrderByDate());
        return new Stats(avgGradeAtEveryDiscipline, minMaxGradeAtEveryDiscipline, gradeNumber, maxSequence);
    }

    private MaxSequence findMaxSequence(List<Mark> marks) {
        long maxGrade=0;
        int maxSequence=0;
        int counter=0;

        if (marks == null)
            return null;
        for(Mark mark : marks) {
            if(mark.getMarkDescriptionId() > maxGrade) {
                maxGrade = mark.getMarkDescriptionId();
                maxSequence = 1;
                counter = 1;
            }
            else if (mark.getMarkDescriptionId() == maxGrade)
                counter++;
            else {
                maxSequence = Math.max(maxSequence, counter);
                counter = 0;
            }
        }
        return new MaxSequence(maxGrade+1, Math.max(maxSequence, counter));
    }
}
