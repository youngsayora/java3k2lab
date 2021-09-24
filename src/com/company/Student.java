package com.company;
import java.lang.Comparable;

public class Student implements Comparable<Student>{
    String lastName;
    double averageMark;
    private Double averageMark1 = averageMark;
    int age;
    double getAverageMark(){return averageMark;}
    String getName(){return lastName;}
    int getAge(){return age;}

    public int compareTo(Student p){
        if((averageMark - p.getAverageMark())>0)
            return 1;
        else if((averageMark - p.getAverageMark())<0)
            return -1;
        else
            return 0;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student man = (Student) o;
        return averageMark == man.averageMark;
    }
    @Override
    public int hashCode() {
        return averageMark1.hashCode();
    }
}
