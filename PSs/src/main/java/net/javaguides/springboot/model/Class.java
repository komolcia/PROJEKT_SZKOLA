package net.javaguides.springboot.model;

import net.javaguides.springboot.model.domain.AmountOfHours;
import net.javaguides.springboot.model.domain.TypeOfClasses;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    public Long id;
    @Column(name = "name")
    public String name;

    @Column(name = "description")
    public String description;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id", referencedColumnName = "id")

    public Student student;

    @Column(name = "maxamountofstudents")
    public int maxAmountOfStudents;
    @Column(name = "currentamountofstudents")
    public int currentAmountOfStudents;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    public Class(){}
    public Class(long id,String name,String description,int maxAmountOfStudents,int currentAmountOfStudents){
        this.id=id;
        this.name=name;
        this.description=description;
        this.currentAmountOfStudents=  currentAmountOfStudents;
        this.maxAmountOfStudents=maxAmountOfStudents;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public int getMaxAmountOfStudents() {
        return maxAmountOfStudents;
    }

    public void setMaxAmountOfStudents(int maxAmountOfStudents) {
        this.maxAmountOfStudents = maxAmountOfStudents;
    }

    public int getCurrentAmountOfStudents() {
        return currentAmountOfStudents;
    }

    public void setCurrentAmountOfStudents(int currentAmountOfStudents) {
        this.currentAmountOfStudents = currentAmountOfStudents;
    }
}
