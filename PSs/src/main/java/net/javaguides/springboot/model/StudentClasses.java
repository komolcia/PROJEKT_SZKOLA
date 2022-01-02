package net.javaguides.springboot.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.javaguides.springboot.model.domain.AmountOfHours;
import net.javaguides.springboot.model.domain.Degree;
import net.javaguides.springboot.model.domain.GradeEnum;
import net.javaguides.springboot.model.domain.TypeOfClasses;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
@Table
public class StudentClasses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;

    @NotNull

    private GradeEnum gradeEnum;
    @NotNull

    private AmountOfHours amountOfHours;

    @NotNull

    private TypeOfClasses typeOfClasses;
    @OneToOne(targetEntity = net.javaguides.springboot.model.Class.class)

    @Autowired
    private Class classes;
    @OneToOne(targetEntity = net.javaguides.springboot.model.Student.class)

    @Autowired
    private Student student;
    @OneToOne(targetEntity = net.javaguides.springboot.model.Professor.class)

    @Autowired
    private Professor professor;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Class getClasses() {
        return classes;
    }

    public void setClasses(Class classes) {
        this.classes = classes;
    }

    public TypeOfClasses getTypeOfClasses() {
        return typeOfClasses;
    }

    public GradeEnum getGradeEnum() {
        return gradeEnum;
    }


    public Professor getProfessor() {
        return professor;
    }

    public void setGradeEnum(GradeEnum gradeEnum) {
        this.gradeEnum = gradeEnum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setTypeOfClasses(TypeOfClasses typeOfClasses) {
        this.typeOfClasses = typeOfClasses;
    }

    public AmountOfHours getAmountOfHours() {
        return amountOfHours;
    }

    public void setAmountOfHours(AmountOfHours amountOfHours) {
        this.amountOfHours = amountOfHours;
    }

}
