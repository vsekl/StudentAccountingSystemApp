package ru.vsevakl.accounting.test;

import lombok.AllArgsConstructor;
import lombok.val;
import org.assertj.core.api.Assertions;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.vsevakl.accounting.StudentAccountingSystemApplication;
import ru.vsevakl.accounting.controller.MarkController;
import ru.vsevakl.accounting.dto.*;
import ru.vsevakl.accounting.repository.MarkRepository;

import java.util.ArrayList;
import java.util.List;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StudentAccountingSystemApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MarkTest extends ContainersEnvironment {
    @Autowired
    MarkController markController;

    @Test
    public void markTest() {
        Stats expected;
        List<DisciplineAvg> disciplineAvgs = new ArrayList<>();
        List<DisciplineMinMax> disciplineMinMaxes = new ArrayList<>();
        List<GradeNumber> gradeNumbers = new ArrayList<>();
        MaxSequence maxSequence;

        disciplineAvgs.add(new DisciplineAvgClass("Mathematical analysis", 3.3333333333333335));
        disciplineAvgs.add(new DisciplineAvgClass("Discrete mathematics", 3.0));
        disciplineAvgs.add(new DisciplineAvgClass("Probability theory", 3.3333333333333335));
        disciplineAvgs.add(new DisciplineAvgClass("Philosophy",4.5 ));
        disciplineAvgs.add(new DisciplineAvgClass("Physical culture", 3.0));
        disciplineAvgs.add(new DisciplineAvgClass("Physics", 3.6666666666666665));
        disciplineAvgs.add(new DisciplineAvgClass("Computer networks", 2.0));
        disciplineAvgs.add(new DisciplineAvgClass("Linear algebra", 4.5));

        disciplineMinMaxes.add(new DisciplineMinMaxClass("Mathematical analysis",2L,5L));
        disciplineMinMaxes.add(new DisciplineMinMaxClass("Discrete mathematics", 3L, 3L));
        disciplineMinMaxes.add(new DisciplineMinMaxClass("Probability theory", 3L, 4L));
        disciplineMinMaxes.add(new DisciplineMinMaxClass("Philosophy", 4L,5L));
        disciplineMinMaxes.add(new DisciplineMinMaxClass("Physical culture",2L,4L));
        disciplineMinMaxes.add(new DisciplineMinMaxClass("Physics",2L,5L));
        disciplineMinMaxes.add(new DisciplineMinMaxClass("Computer networks",2L,2L));
        disciplineMinMaxes.add(new DisciplineMinMaxClass("Linear algebra",4L,5L));

        gradeNumbers.add(new GradeNumberClass(2L, 4L));
        gradeNumbers.add(new GradeNumberClass(3L, 5L));
        gradeNumbers.add(new GradeNumberClass(4L, 5L));
        gradeNumbers.add(new GradeNumberClass(5L, 4L));

        maxSequence = new MaxSequence(5L,3);

        expected = new Stats(disciplineAvgs, disciplineMinMaxes, gradeNumbers, maxSequence);
        Stats actual = markController.markStatistics();

        Assertions.assertThat(expected).usingRecursiveComparison().isEqualTo(Hibernate.getClass(actual));

    }

    @AllArgsConstructor
    private class DisciplineAvgClass implements DisciplineAvg {
        private String name;
        private Double average;

        @Override
        public String getName() {
            return name;
        }

        @Override
        public Double getAverage() {
            return average;
        }
    }

    @AllArgsConstructor
    private class DisciplineMinMaxClass implements DisciplineMinMax {
        private String name;
        private Long min;
        private Long max;

        @Override
        public String getName() {
            return name;
        }

        @Override
        public Long getMin() {
            return min;
        }

        @Override
        public Long getMax() {
            return max;
        }
    }

    @AllArgsConstructor
    private class GradeNumberClass implements GradeNumber {
        private Long mark;
        private Long number;

        @Override
        public Long getMark() {
            return mark;
        }

        @Override
        public Long getNumber() {
            return number;
        }
    }

//    private GradeNumber generateGradeNumber(Long mark, Long number) {
//        return new GradeNumber() {
//            @Override
//            public Long getMark() {
//                return mark;
//            }
//
//            @Override
//            public Long getNumber() {
//                return number;
//            }
//        };
//    }
}
