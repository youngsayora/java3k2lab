package com.company;

import java.util.Comparator;

public class StudentComparatorAge implements Comparator<Student> {
    public int compare(Student a, Student b){

        return a.getAge() - b.getAge();

    }

}