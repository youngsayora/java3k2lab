package com.company;
import java.util.Comparator;

public class StudentComparatorMark implements Comparator<Student>{
    public int compare(Student a, Student b){

        if((a.getAverageMark() - b.getAverageMark())>0)
            return 1;
        else if((a.getAverageMark() - b.getAverageMark())<0)
            return -1;
        else
            return 0;
    }
}
