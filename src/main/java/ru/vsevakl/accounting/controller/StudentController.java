package ru.vsevakl.accounting.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.vsevakl.accounting.domain.Student;
import ru.vsevakl.accounting.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping()
    public List<Student> getStudents(@RequestParam(required = false) String search,
                                     @RequestParam(required = false) String val,
                                     @RequestParam(required = false) String sort) {

        Sort mySort = switch (sort) {
            case null -> Sort.unsorted();
            case "firstname" -> Sort.by("firstname").ascending();
            case "lastname" -> Sort.by("lastname").ascending();
            case "age" -> Sort.by("age").ascending();
            default -> throw new IllegalStateException("Unexpected search value: " + sort);
        };
        return switch (search) {
            case null -> studentRepository.findAll(mySort);
            case "firstname" -> studentRepository.findAllByFirstname(val, mySort);
            case "lastname" -> studentRepository.findAllByLastname(val, mySort);
            case "age" -> studentRepository.findAllByAge(val, mySort);
            default -> throw new IllegalStateException("Unexpected sort value: " + search);
        };
    }

    @PostMapping()
    @JsonIgnoreProperties("id")
    public void addStudent(@RequestBody Student student) {
        studentRepository.save(student);
    }
}