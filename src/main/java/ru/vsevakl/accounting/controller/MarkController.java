package ru.vsevakl.accounting.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.*;
import ru.vsevakl.accounting.custom.MaxSequence;
import ru.vsevakl.accounting.domain.Mark;
import ru.vsevakl.accounting.repository.MarkRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarkController {
    MarkRepository markRepository;

    public MarkController(MarkRepository markRepository) {
        this.markRepository = markRepository;
    }

    @GetMapping()
    public List<Mark> getMarks() {
        return markRepository.findAll();
    }

    @PostMapping()
    @JsonIgnoreProperties("id")
    public void addMark(@RequestBody Mark mark) {
        markRepository.save(mark);
    }

    @GetMapping("/stats")
    public List<List<?>> markStatistics() {
        List<List<?>> stats = new ArrayList<>();
        stats.add(markRepository.avgGradeAtEveryDiscipline());
        stats.add(markRepository.minMaxGradeAtEveryDiscipline());
        stats.add(markRepository.countAllMarksByGrade());
        stats.add(findMaxSequence(markRepository.findAllBetweenDatesOrderByDate()));
        return stats;
    }

    private List<MaxSequence> findMaxSequence(List<Mark> marks) {
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
        List<MaxSequence> res = new ArrayList<>();
        res.add(new MaxSequence(maxGrade, Math.max(maxSequence, counter)));
        return res;
    }
}