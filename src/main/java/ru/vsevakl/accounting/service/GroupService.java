package ru.vsevakl.accounting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsevakl.accounting.domain.Group;
import ru.vsevakl.accounting.domain.Student;
import ru.vsevakl.accounting.repository.GroupRepository;
import ru.vsevakl.accounting.repository.StudentRepository;
import java.util.List;

@Service
@AllArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final StudentRepository studentRepository;

    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    public  List<Student> getStudentsByGroup(Long id) {
        return  studentRepository.findAllByGroup(id);
    }
}
