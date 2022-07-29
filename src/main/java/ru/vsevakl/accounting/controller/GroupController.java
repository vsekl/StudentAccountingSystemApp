package ru.vsevakl.accounting.controller;

import org.springframework.web.bind.annotation.*;
import ru.vsevakl.accounting.domain.Group;
import ru.vsevakl.accounting.domain.Student;
import ru.vsevakl.accounting.repository.GroupRepository;
import ru.vsevakl.accounting.repository.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    public GroupController(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping()
    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    @GetMapping("/{id}")
    public  List<Student> getStudentsByGroup(@PathVariable("id") Long id) {
        return  studentRepository.findAllByGroup(id);
    }
}
