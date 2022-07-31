package ru.vsevakl.accounting.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.vsevakl.accounting.StudentAccountingSystemApplication;
import ru.vsevakl.accounting.controller.DisciplineController;
import ru.vsevakl.accounting.domain.Discipline;
import java.util.ArrayList;
import java.util.List;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StudentAccountingSystemApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DisciplineTest extends ContainersEnvironment {
    @Autowired
    private DisciplineController disciplineController;

    @Test
    public void getDisciplinesTest() {
        List<Discipline> disciplines = new ArrayList<>();

        disciplines.add(new Discipline(1L, "Mathematical analysis"));
        disciplines.add(new Discipline(2L, "Discrete mathematics"));
        disciplines.add(new Discipline(3L, "Probability theory"));
        disciplines.add(new Discipline(4L, "Philosophy"));
        disciplines.add(new Discipline(5L,"Physical culture" ));
        disciplines.add(new Discipline(6L,"Physics" ));
        disciplines.add(new Discipline(7L, "Computer networks"));
        disciplines.add(new Discipline(8L, "Linear algebra"));

        List<Discipline> actual = disciplineController.getDisciplines();
        Assertions.assertThat(disciplines).usingRecursiveComparison().isEqualTo(actual);
    }
}
