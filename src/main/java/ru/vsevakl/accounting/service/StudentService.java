package ru.vsevakl.accounting.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsevakl.accounting.domain.Student;
import ru.vsevakl.accounting.repository.StudentRepository;
import ru.vsevakl.accounting.request.StudentRequest;
import ru.vsevakl.accounting.utils.comparator.*;
import java.util.List;
import java.util.stream.Collectors;
import static ru.vsevakl.accounting.request.StudentRequest.Sort.ASC;
import static ru.vsevakl.accounting.request.StudentRequest.Sort.DESC;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getStudents(StudentRequest studentRequest) {
        List<Student> students = studentRepository.findAll();
        if (studentRequest == null)
            return students;
        students = filterStudentsByFirstname(students, studentRequest.getFirstname());
        students = filterStudentsByLastname(students, studentRequest.getLastname());
        students = filterStudentsByAge(students, studentRequest.getAge());
        if(studentRequest.getSortRequest() == null)
            return students;
        sortStudents(students, studentRequest.getSortRequest().getSort(), studentRequest.getSortRequest().getSortParam());
        return students;
        }

    private List<Student> filterStudentsByFirstname(List<Student> students, String firstname) {
        if(firstname != null)
            return students.stream()
                    .filter(student -> student.getFirstname().equals(firstname))
                    .collect(Collectors.toList());
        return students;
    }

    private List<Student> filterStudentsByLastname(List<Student> students, String lastname) {
        if(lastname != null)
            return students.stream()
                    .filter(student -> student.getLastname().equals(lastname))
                    .collect(Collectors.toList());
        return students;
    }

    private List<Student> filterStudentsByAge(List<Student> students, Long age) {
        if(age != null)
            return students.stream()
                    .filter(student -> student.getAge().equals(age))
                    .collect(Collectors.toList());
        return students;
    }
    private void sortStudents(List<Student> students, StudentRequest.Sort sort, StudentRequest.SortParam sortParam) {
        if(sort == ASC)
            switch (sortParam) {
                case firstname -> students.sort(new FirstnameComparator());
                case lastname -> students.sort(new LastnameComparator());
                case age -> students.sort(new AgeComparator());
            }
        else if(sort == DESC)
            switch (sortParam) {
                case firstname -> students.sort(new FirstnameReversedComparator());
                case lastname -> students.sort(new LastnameReversedComparator());
                case age -> students.sort(new AgeReversedComparator());
            }
    }
}
