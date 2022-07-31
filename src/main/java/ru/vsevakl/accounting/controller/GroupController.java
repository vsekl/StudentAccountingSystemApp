package ru.vsevakl.accounting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.vsevakl.accounting.domain.Group;
import ru.vsevakl.accounting.domain.Student;
import ru.vsevakl.accounting.service.GroupService;
import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping()
    public List<Group> getGroups() {
        return groupService.getGroups();
    }

    @GetMapping("/{id}")
    public  List<Student> getStudentsByGroup(@PathVariable("id") Long id) {
        return  groupService.getStudentsByGroup(id);
    }
}
