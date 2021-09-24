package com.company;
import java.lang.Comparable;

public class Student implements Comparable<Student>{
    String lastName;
    double averageMark;
    int age;
    double getAverageMark(){return averageMark;}

    public int compareTo(Student p){
        if((averageMark - p.getAverageMark())>0)
            return 1;
        else if((averageMark - p.getAverageMark())<0)
            return -1;
        else
            return 0;
    }
}
