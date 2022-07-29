package ru.vsevakl.accounting.repository;

import io.micrometer.core.instrument.config.validate.Validated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vsevakl.accounting.domain.Mark;
import ru.vsevakl.accounting.domain.dto.DisciplineToAvgMark;

import java.sql.ResultSet;
import java.util.List;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {
    @Query(value = "SELECT * FROM marks WHERE date BETWEEN '01.09.2021' AND '30.06.2022'", nativeQuery = true)
    List<Mark> findAllBetweenDates();

    @Query(value = "SELECT marks_description.mark, COUNT(subquery.id) AS counter FROM marks_description LEFT JOIN (SELECT * FROM marks WHERE date BETWEEN '01.09.2021' AND '30.06.2022') subquery ON subquery.mark_id = marks_description.id GROUP BY marks_description.mark ORDER BY marks_description.mark", nativeQuery = true)
    List<String[]> countAllMarksByGrade();

    @Query(value = """
                SELECT disciplines.name, AVG(marks_description.mark) AS average 
                FROM disciplines 
                LEFT JOIN (
                    SELECT * FROM marks 
                    WHERE date BETWEEN '01.09.2021' AND '30.06.2022'
                ) subquery ON subquery.discipline_id=disciplines.id 
                LEFT JOIN marks_description ON marks_description.id=subquery.mark_id 
                GROUP BY disciplines.id
            """, nativeQuery = true)
//    List<String[]> avgGradeAtEveryDiscipline();
    List<DisciplineToAvgMark> avgGradeAtEveryDiscipline();

    @Query(value = "SELECT disciplines.name, MIN(marks_description.mark) AS min, MAX(marks_description.mark) AS max FROM disciplines LEFT JOIN (SELECT * FROM marks WHERE date BETWEEN '01.09.2021' AND '30.06.2022') subquery ON subquery.discipline_id=disciplines.id LEFT JOIN marks_description ON marks_description.id=subquery.mark_id GROUP BY disciplines.id", nativeQuery = true)
    List<String[]> minMaxGradeAtEveryDiscipline();

    @Query(value = "SELECT * FROM marks WHERE date BETWEEN '01.09.2021' AND '30.06.2022' ORDER BY date", nativeQuery = true)
    List<Mark> findAllBetweenDatesOrderByDate();

    @Query(value = "SELECT MAX(mark_id) FROM marks WHERE date BETWEEN '01.09.2021' AND '30.06.2022'", nativeQuery = true)
    Long findMaxGrade();
}