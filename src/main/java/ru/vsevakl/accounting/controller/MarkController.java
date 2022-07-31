package ru.vsevakl.accounting.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.*;
import ru.vsevakl.accounting.domain.Mark;
import ru.vsevakl.accounting.dto.Stats;
import ru.vsevakl.accounting.service.MarkService;
import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarkController {
    private final MarkService markService;

    public MarkController(MarkService markService) {
        this.markService = markService;
    }

    @GetMapping()
    public List<Mark> getMarks() {
        return markService.getMarks();
    }

    @PostMapping("/add")
    @JsonIgnoreProperties("id")
    public void addMark(@RequestBody Mark mark) {
        markService.addMark(mark);
    }

    @PostMapping("/stats")
    public Stats markStatistics() {
        return markService.markStatistics();
    }
}