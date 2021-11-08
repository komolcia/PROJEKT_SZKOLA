package net.javaguides.springboot.model;

import net.javaguides.springboot.model.domain.GradeEnum;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "grade")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "grade")
    private GradeEnum grade;
    @Column(name = "date")
    private Date date;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GradeEnum getGrade() {
        return grade;
    }

    public void setGrade(GradeEnum grade) {
        this.grade = grade;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

