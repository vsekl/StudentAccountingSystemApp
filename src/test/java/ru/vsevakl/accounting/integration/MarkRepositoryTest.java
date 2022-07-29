package ru.vsevakl.accounting.integration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.testcontainers.shaded.org.apache.commons.lang3.RandomUtils;
import ru.vsevakl.accounting.domain.Mark;
import ru.vsevakl.accounting.repository.MarkRepository;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

//public class MarkRepositoryTest {
//
//    private static final long MARK_ID = RandomUtils.nextLong();
//    private static final LocalDateTime MARK_LOCAL_DATE_TIME = LocalDateTime.now();
//    private static final Date MARK_DATE = Date.from(MARK_LOCAL_DATE_TIME.atZone(ZoneId.systemDefault()).toInstant());
//    private static final long MARK_DISCIPLINE_ID = RandomUtils.nextLong();
//    private static final long MARK_DESCRIPTION_ID = RandomUtils.nextLong();
//    private static final long MARK_STUDENT_ID = RandomUtils.nextLong();
//
//    @Autowired
//    MarkRepository markRepository;
//
//    @Test
//    public void findAllBetweenDates() {
//        // given
//        Mark mark1 = new Mark();
//        mark1.setId(MARK_ID);
//        mark1.setDate(MARK_DATE);
//        mark1.setDisciplineId(MARK_DISCIPLINE_ID);
//        mark1.setMarkDescriptionId(MARK_DESCRIPTION_ID);
//        mark1.setStudentId(MARK_STUDENT_ID);
//        markRepository.save(mark1);
//
//        // when
//        List<Mark> actual = markRepository.findAllBetweenDatesOrderByDate();
//
//        // then
//        Assertions.assertThat(mark1).usingRecursiveComparison().isEqualTo(actual);
//    }
//}
