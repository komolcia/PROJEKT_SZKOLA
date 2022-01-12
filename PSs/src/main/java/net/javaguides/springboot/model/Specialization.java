package net.javaguides.springboot.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.javaguides.springboot.model.domain.Degree;

import javax.persistence.*;

@Entity
@Table(name = "specialization")
@AllArgsConstructor
@NoArgsConstructor
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String requirements;
    @Column
    private int maxAmountOfStudent;
    @Column
    private int currentAmountOfStudents;
    @ManyToOne
    private Faculty faculty;
    @Column
    private Degree requiredDegree;

    public int getCurrentAmountOfStudents() {
        return currentAmountOfStudents;
    }

    public int getMaxAmountOfStudent() {
        return maxAmountOfStudent;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setCurrentAmountOfStudents(int currentAmountOfStudents) {
        this.currentAmountOfStudents = currentAmountOfStudents;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setMaxAmountOfStudent(int maxAmountOfStudent) {
        this.maxAmountOfStudent = maxAmountOfStudent;
    }


    public void setRequiredDegree(Degree requiredDegree) {
        this.requiredDegree = requiredDegree;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }


    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public Degree getRequiredDegree() {
        return requiredDegree;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

}
