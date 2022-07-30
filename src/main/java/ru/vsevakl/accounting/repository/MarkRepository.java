package ru.vsevakl.accounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vsevakl.accounting.dto.DisciplineAvg;
import ru.vsevakl.accounting.dto.DisciplineMinMax;
import ru.vsevakl.accounting.dto.GradeNumber;
import ru.vsevakl.accounting.domain.Mark;
import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {
    @Query(value = "SELECT disciplines.name AS name, AVG(marks_description.mark) AS average FROM disciplines LEFT JOIN ( SELECT * FROM marks  WHERE date BETWEEN '01.09.2021' AND '30.06.2022') subquery ON subquery.discipline_id=disciplines.id LEFT JOIN marks_description ON marks_description.id=subquery.mark_id GROUP BY disciplines.id", nativeQuery = true)
    List<DisciplineAvg> avgGradeAtEveryDiscipline();

    @Query(value = "SELECT disciplines.name AS name, MIN(marks_description.mark) AS min, MAX(marks_description.mark) AS max FROM disciplines LEFT JOIN (SELECT * FROM marks WHERE date BETWEEN '01.09.2021' AND '30.06.2022') subquery ON subquery.discipline_id=disciplines.id LEFT JOIN marks_description ON marks_description.id=subquery.mark_id GROUP BY disciplines.id", nativeQuery = true)
    List<DisciplineMinMax> minMaxGradeAtEveryDiscipline();

    @Query(value = "SELECT marks_description.mark as mark, COUNT(subquery.id) AS number FROM marks_description LEFT JOIN (SELECT * FROM marks WHERE date BETWEEN '01.09.2021' AND '30.06.2022') subquery ON subquery.mark_id = marks_description.id GROUP BY marks_description.mark ORDER BY marks_description.mark", nativeQuery = true)
    List<GradeNumber> countAllMarksByGrade();

    @Query(value = "SELECT * FROM marks WHERE date BETWEEN '01.09.2021' AND '30.06.2022' ORDER BY date", nativeQuery = true)
    List<Mark> findAllBetweenDatesOrderByDate();
}