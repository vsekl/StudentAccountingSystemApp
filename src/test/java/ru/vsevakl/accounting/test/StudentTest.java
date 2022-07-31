package ru.vsevakl.accounting.test;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.vsevakl.accounting.StudentAccountingSystemApplication;
import ru.vsevakl.accounting.controller.StudentController;
import ru.vsevakl.accounting.domain.Student;
import ru.vsevakl.accounting.request.StudentRequest;

import java.util.ArrayList;
import java.util.List;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = StudentAccountingSystemApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentTest extends ContainersEnvironment {
    @Autowired
    StudentController studentController;

    @Test
    public void addStudentTest() {
        Student student = new Student(10L, "Olga", "Tarasova", 20L, 2L);
        List<Student> expected = studentController.getStudents(null);

        expected.add(student);
        studentController.addStudent(student);

        Assertions.assertThat(expected).usingRecursiveComparison().isEqualTo(studentController.getStudents(null));
    }

    @Test
    public void getStudentsEmptyRequestBodyTest() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L,"Vasiliy", "Vasiliev", 20L, 3L));
        students.add(new Student(2L, "Andrey", "Andreev", 18L, 5L));
        students.add(new Student(3L, "Ivan", "Ivanov", 17L, 1L));
        students.add(new Student(4L, "Sergey", "Sergeev", 22L, 8L));
        students.add(new Student(5L, "Antoliy", "Rezin", 20L, 7L));
        students.add(new Student(6L, "Tatyana", "Tatyanova", 19L, 2L));
        students.add(new Student(7L, "Ekaterina", "Ekaterinina", 21L, 2L));
        students.add(new Student(8L, "Ivan", "Popov", 18L, 3L));
        students.add(new Student(9L, "Ivan", "Vasiliev", 17L, 1L));

        StudentRequest studentRequest = new StudentRequest(null,null,null,null);
        Assertions.assertThat(students).usingRecursiveComparison().isEqualTo(studentController.getStudents(studentRequest));
    }

    @Test
    public void getStudentsFirstnameOnlyTest() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(3L, "Ivan", "Ivanov", 17L, 1L));
        students.add(new Student(8L, "Ivan", "Popov", 18L, 3L));
        students.add(new Student(9L, "Ivan", "Vasiliev", 17L, 1L));
        StudentRequest studentRequest = new StudentRequest("Ivan",null,null,null);
        Assertions.assertThat(students).usingRecursiveComparison().isEqualTo(studentController.getStudents(studentRequest));
    }

    @Test
    public void getStudentsLastnameOnlyTest() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1L,"Vasiliy", "Vasiliev", 20L, 3L));
        students.add(new Student(9L, "Ivan", "Vasiliev", 17L, 1L));
        StudentRequest studentRequest = new StudentRequest(null,"Vasiliev",null,null);
        Assertions.assertThat(students).usingRecursiveComparison().isEqualTo(studentController.getStudents(studentRequest));
    }

    @Test
    public void getStudentsAgeOnlyTest() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(2L, "Andrey", "Andreev", 18L, 5L));
        students.add(new Student(8L, "Ivan", "Popov", 18L, 3L));
        StudentRequest studentRequest = new StudentRequest(null,null,18L,null);
        Assertions.assertThat(students).usingRecursiveComparison().isEqualTo(studentController.getStudents(studentRequest));
    }

    @Test
    public void getStudentsSortedAscByFirstnameTest() {
        List<Student> students = new ArrayList<>();
        StudentRequest.SortRequest sortRequest = new StudentRequest.SortRequest(StudentRequest.Sort.ASC, StudentRequest.SortParam.firstname);

        students.add(new Student(2L, "Andrey", "Andreev", 18L, 5L));
        students.add(new Student(5L, "Antoliy", "Rezin", 20L, 7L));
        students.add(new Student(7L, "Ekaterina", "Ekaterinina", 21L, 2L));
        students.add(new Student(3L, "Ivan", "Ivanov", 17L, 1L));
        students.add(new Student(8L, "Ivan", "Popov", 18L, 3L));
        students.add(new Student(9L, "Ivan", "Vasiliev", 17L, 1L));
        students.add(new Student(4L, "Sergey", "Sergeev", 22L, 8L));
        students.add(new Student(6L, "Tatyana", "Tatyanova", 19L, 2L));
        students.add(new Student(1L,"Vasiliy", "Vasiliev", 20L, 3L));

        StudentRequest studentRequest = new StudentRequest(null,null,null,sortRequest);
        Assertions.assertThat(students).usingRecursiveComparison().isEqualTo(studentController.getStudents(studentRequest));
    }

    @Test
    public void getStudentsSortedDescByAgeTest() {
        List<Student> students = new ArrayList<>();
        StudentRequest.SortRequest sortRequest = new StudentRequest.SortRequest(StudentRequest.Sort.DESC, StudentRequest.SortParam.age);

        students.add(new Student(4L, "Sergey", "Sergeev", 22L, 8L));
        students.add(new Student(7L, "Ekaterina", "Ekaterinina", 21L, 2L));
        students.add(new Student(1L,"Vasiliy", "Vasiliev", 20L, 3L));
        students.add(new Student(5L, "Antoliy", "Rezin", 20L, 7L));
        students.add(new Student(6L, "Tatyana", "Tatyanova", 19L, 2L));
        students.add(new Student(2L, "Andrey", "Andreev", 18L, 5L));
        students.add(new Student(8L, "Ivan", "Popov", 18L, 3L));
        students.add(new Student(3L, "Ivan", "Ivanov", 17L, 1L));
        students.add(new Student(9L, "Ivan", "Vasiliev", 17L, 1L));

        StudentRequest studentRequest = new StudentRequest(null,null,null, sortRequest);
        Assertions.assertThat(students).usingRecursiveComparison().isEqualTo(studentController.getStudents(studentRequest));
    }
    @Test
    public void getStudentsByAllParamsTest() {
        List<Student> students = new ArrayList<>();
        StudentRequest.SortRequest sortRequest = new StudentRequest.SortRequest(StudentRequest.Sort.ASC, StudentRequest.SortParam.firstname);

        students.add(new Student(3L, "Ivan", "Ivanov", 17L, 1L));

        StudentRequest studentRequest = new StudentRequest("Ivan","Ivanov",17L,sortRequest);
        Assertions.assertThat(students).usingRecursiveComparison().isEqualTo(studentController.getStudents(studentRequest));
    }
}