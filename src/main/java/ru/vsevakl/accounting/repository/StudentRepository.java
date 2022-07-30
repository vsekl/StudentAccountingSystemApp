package ru.vsevakl.accounting.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vsevakl.accounting.domain.Student;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.firstname=?1")
    List<Student> findAllByFirstname(String val, Sort sort);

    @Query("SELECT s FROM Student s WHERE s.lastname=?1")
    List<Student> findAllByLastname(String val, Sort sort);

    @Query("SELECT s FROM Student s WHERE s.age=?1")
    List<Student> findAllByAge(String val, Sort sort);

    @Query("SELECT s FROM Student s WHERE s.groupId=?1")
    List<Student> findAllByGroup(Long id);
}
