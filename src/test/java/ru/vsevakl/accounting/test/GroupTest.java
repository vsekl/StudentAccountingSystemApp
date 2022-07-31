package ru.vsevakl.accounting.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.vsevakl.accounting.StudentAccountingSystemApplication;
import ru.vsevakl.accounting.controller.GroupController;
import ru.vsevakl.accounting.domain.Group;
import ru.vsevakl.accounting.domain.Student;

import java.util.ArrayList;
import java.util.List;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StudentAccountingSystemApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GroupTest extends ContainersEnvironment {
    @Autowired
    private GroupController groupController;

    @Test
    public void getGroupsTest() {
        List<Group> groups = new ArrayList<>();

        groups.add(new Group(1L,"A-01-22"));
        groups.add(new Group(2L,"A-02-22"));
        groups.add(new Group(3L,"A-03-22"));
        groups.add(new Group(4L,"B-01-22"));
        groups.add(new Group(5L,"B-02-22"));
        groups.add(new Group(6L,"C-01-22"));
        groups.add(new Group(7L,"C-02-22"));
        groups.add(new Group(8L,"D-01-22"));

        Assertions.assertThat(groups).usingRecursiveComparison().isEqualTo(groupController.getGroups());
    }

    @Test
    public void getStudentsByGroupTest() {
        List<Student> students = new ArrayList<>();
        Long groupId = 2L;

        students.add(new Student(6L, "Tatyana", "Tatyanova", 19L, 2L));
        students.add(new Student(7L, "Ekaterina", "Ekaterinina", 21L, 2L));

        Assertions.assertThat(students).usingRecursiveComparison().isEqualTo(groupController.getStudentsByGroup(groupId));
    }
}
