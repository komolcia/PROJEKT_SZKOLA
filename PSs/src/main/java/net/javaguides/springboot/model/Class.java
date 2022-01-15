package net.javaguides.springboot.model;

import net.javaguides.springboot.model.domain.AmountOfHours;
import net.javaguides.springboot.model.domain.TypeOfClasses;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
    @ManyToOne
    public Specialization specialization;
    @ManyToMany
    public Set<Term> terms = new HashSet<Term>(0);

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

    public Class() {
    }

    public Class(long id, String name, String description, int maxAmountOfStudents, int currentAmountOfStudents) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.currentAmountOfStudents = currentAmountOfStudents;
        this.maxAmountOfStudents = maxAmountOfStudents;
    }

    public Class(String name, String description, Student student, int maxAmountOfStudents, int currentAmountOfStudents, Specialization specialization, Set<Term> terms) {
        this.name = name;
        this.description = description;
        this.student = student;
        this.maxAmountOfStudents = maxAmountOfStudents;
        this.currentAmountOfStudents = currentAmountOfStudents;
        this.specialization = specialization;
        this.terms = terms;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Set<Term> getTerms() {
        return terms;
    }

    public void setTerms(Set<Term> terms) {
        this.terms = terms;
    }

    public Class(Long id, String name, String description, Student student, int maxAmountOfStudents, int currentAmountOfStudents, Specialization specialization, Set<Term> terms) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.student = student;
        this.maxAmountOfStudents = maxAmountOfStudents;
        this.currentAmountOfStudents = currentAmountOfStudents;
        this.specialization = specialization;
        this.terms = terms;
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
