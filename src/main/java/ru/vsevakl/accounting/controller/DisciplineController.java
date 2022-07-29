package ru.vsevakl.accounting.controller;

import org.springframework.web.bind.annotation.*;
import ru.vsevakl.accounting.domain.Discipline;
import ru.vsevakl.accounting.repository.DisciplineRepository;
import java.util.List;

@RestController
@RequestMapping("/disciplines")
public class DisciplineController {
    private final DisciplineRepository disciplineRepository;

    public DisciplineController(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    @GetMapping()
    public List<Discipline> getDisciplines() {
        return disciplineRepository.findAll();
    }
}