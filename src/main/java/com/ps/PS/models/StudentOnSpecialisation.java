package com.ps.PS.models;

import java.util.LinkedList;
import java.util.List;

public class StudentOnSpecialisation {
    private String index;
    private Specialisation specialisation;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Specialisation getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(Specialisation specialisation) {
        this.specialisation = specialisation;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public List<ClassesOfStudent> getClassesOfStudent() {
        return classesOfStudent;
    }

    public void setClassesOfStudent(List<ClassesOfStudent> classesOfStudent) {
        this.classesOfStudent = classesOfStudent;
    }

    public double getGradeAverage() {
        return gradeAverage;
    }

    public void setGradeAverage(double gradeAverage) {
        this.gradeAverage = gradeAverage;
    }

    private int year;
    private int semester;
    private List<ClassesOfStudent> classesOfStudent = new LinkedList<>();
    private double gradeAverage;
}
