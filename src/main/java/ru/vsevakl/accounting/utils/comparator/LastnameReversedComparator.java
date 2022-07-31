package ru.vsevakl.accounting.utils.comparator;

import ru.vsevakl.accounting.domain.Student;

import java.util.Comparator;

public class LastnameReversedComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.getLastname().compareTo(o1.getLastname());
    }
}
