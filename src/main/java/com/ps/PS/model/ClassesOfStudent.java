package com.ps.PS.model;

import java.util.LinkedList;
import java.util.List;

public class ClassesOfStudent {
    private int id;
    private Classes classForStudent;
    private Group group;
    private List<Grade> grades = new LinkedList<>();
    private Grade finalGrade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Classes getClassForStudent() {
        return classForStudent;
    }

    public void setClassForStudent(Classes classForStudent) {
        this.classForStudent = classForStudent;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public Grade getFinalGrade() {
        return finalGrade;
    }

    public void setFinalGrade(Grade finalGrade) {
        this.finalGrade = finalGrade;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    private boolean isCompleted;
}
