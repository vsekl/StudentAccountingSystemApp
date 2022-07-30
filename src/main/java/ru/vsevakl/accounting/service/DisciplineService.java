package ru.vsevakl.accounting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsevakl.accounting.domain.Discipline;
import ru.vsevakl.accounting.repository.DisciplineRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class DisciplineService {
    private final DisciplineRepository disciplineRepository;

    public List<Discipline> getDisciplines(){
        return disciplineRepository.findAll();
    }
}
