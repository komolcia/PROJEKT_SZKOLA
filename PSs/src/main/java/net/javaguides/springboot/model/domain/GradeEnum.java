package net.javaguides.springboot.model.domain;

public enum GradeEnum {
    VERY_GOOD(5), GOOD_AND_HALF(4.5), GOOD(4), PASSING_AND_HALF(3.5), PASSING(3), NOT_PASSING(2);

    GradeEnum(double grade) {
        this.grade = grade;
    }

    public final double grade;
}