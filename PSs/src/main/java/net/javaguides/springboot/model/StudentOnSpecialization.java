package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table
public class StudentOnSpecialization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private long id;
    @ManyToOne
    @JoinColumn(name = "specialization_id")
    private Specialization specialization;
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

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
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

