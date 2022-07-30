package ru.vsevakl.accounting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vsevakl.accounting.domain.Discipline;
import ru.vsevakl.accounting.service.DisciplineService;
import java.util.List;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {
    private final DisciplineService disciplineService;

    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping()
    public List<Discipline> getDisciplines() {return disciplineService.getDisciplines();}
}