package ru.vsevakl.accounting.test1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.vsevakl.accounting.StudentAccountingSystemApplication;
import ru.vsevakl.accounting.domain.Mark;
import ru.vsevakl.accounting.domain.Student;
import ru.vsevakl.accounting.repository.MarkRepository;
import ru.vsevakl.accounting.repository.StudentRepository;

import java.util.List;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StudentAccountingSystemApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// TODO: 30.07.2022 rename
public class MarksRepositoryTest extends ContainersEnvironment {

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void abc() {
        List<Mark> list = markRepository.findAllBetweenDatesOrderByDate();
        Assertions.assertThat(list).usingRecursiveComparison().isEqualTo(List.of());
    }

    @Test
    public void studentsTest() {
        List<Student> students = studentRepository.findAllByGroup(1L);
        Assertions.assertThat(students).usingRecursiveComparison().isEqualTo(List.of());
    }
}
