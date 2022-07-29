package ru.vsevakl.accounting.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import ru.vsevakl.accounting.domain.Mark;
import ru.vsevakl.accounting.domain.dto.DisciplineToAvgMark;
import ru.vsevakl.accounting.repository.MarkRepository;

import java.sql.ResultSet;
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
//    public List<List<String[]>> markStatistics() {
    public List<DisciplineToAvgMark> markStatistics() {
        List<DisciplineToAvgMark> stats = markRepository.avgGradeAtEveryDiscipline();

//        List<List<String[]>> stats = new ArrayList<>();
//        stats.add(markRepository.avgGradeAtEveryDiscipline());
//        stats.add(markRepository.minMaxGradeAtEveryDiscipline());
//        stats.add(markRepository.countAllMarksByGrade());
//        stats.add(findMaxSequence(markRepository.findAllBetweenDatesOrderByDate(),markRepository.findMaxGrade()));
        return stats;
    }

    private List<String[]> findMaxSequence(List<Mark> marks, Long maxGradeId) {
        int max=0;
        int counter=0;
        List<String[]> list = new ArrayList<>();
        String[] res = new String[1];

        if (maxGradeId == null)
            return null;
        for(Mark mark : marks) {
            if (mark.getId().equals(maxGradeId))
                counter++;
            else {
                max = Math.max(max, counter);
                counter = 0;
            }
        }
        res[0] = Integer.toString(max);
        list.add(res);
        return list;
    }
}
