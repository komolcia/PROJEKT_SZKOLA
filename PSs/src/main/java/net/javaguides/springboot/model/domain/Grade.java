package net.javaguides.springboot.model.domain;

import java.util.Date;

public class Grade {
    private static final double[] grades = {2, 2.5, 3, 3.5, 4, 4.5, 5};
    private double grade;
    private Date date;

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
