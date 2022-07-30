package ru.vsevakl.accounting.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.*;
import ru.vsevakl.accounting.domain.Student;
import ru.vsevakl.accounting.request.StudentRequest;
import ru.vsevakl.accounting.service.StudentService;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //ЭТО НЕ ПОСТ МЕТОД, НО КАК СДЕЛАТЬ ДВА ПОСТ МЕТОДА?
    @GetMapping()
    public List<Student> getStudents(@RequestBody StudentRequest request) {
        return studentService.getStudents(request);
    }
    @GetMapping("/wtf")
    public StudentRequest retReq(){
        return new StudentRequest();
    }

    @PostMapping()
    @JsonIgnoreProperties("id")
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);
    }
}