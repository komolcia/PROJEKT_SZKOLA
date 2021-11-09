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
    private Long id;
    @Column(name = "name")
    private String name;
    @OneToMany
    @Column(name = "professors")
    private List<Professor> professors = new LinkedList<>();
    @OneToMany
    @Column(name = "groups")
    private List<Group> groups = new LinkedList<>();
    @Column(name = "typeofclasses")
    private TypeOfClasses typeOfClasses;
    @Column(name = "amountofhours")
    private AmountOfHours amountOfHours;
    @Column(name = "description")
    private String description;

    @Column(name = "maxamountofstudents")
    private int maxAmountOfStudents;
    @Column(name = "currentamountofstudents")
    private int currentAmountOfStudents;

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

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public TypeOfClasses getTypeOfClasses() {
        return typeOfClasses;
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
