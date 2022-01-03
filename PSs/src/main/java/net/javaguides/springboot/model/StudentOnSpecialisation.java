package net.javaguides.springboot.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table
public class StudentOnSpecialisation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    @ManyToOne
    @JoinColumn(name = "specialisation_id")
    private Specialisation specialisation;
    private int year;
    private int semester;
    // @OneToMany(fetch = FetchType.EAGER, mappedBy = "student", cascade = CascadeType.ALL)
    // public List<StudentClasses> studentClasses = new LinkedList<>();
    private double gradeAverage;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

//    public List<StudentClasses> getStudentClasses() {
//        return studentClasses;
//    }

//    public void setStudentClasses(List<StudentClasses> studentClasses) {
//        this.studentClasses = studentClasses;
//    }

    public double getGradeAverage() {
        return gradeAverage;
    }

    public void setGradeAverage(double gradeAverage) {
        this.gradeAverage = gradeAverage;
    }
}

