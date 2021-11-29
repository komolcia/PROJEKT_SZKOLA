package net.javaguides.springboot.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.javaguides.springboot.model.domain.Degree;

import javax.persistence.*;

@Entity
@Table(name = "specialisation")
@AllArgsConstructor
@NoArgsConstructor
public class Specialisation {
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
}
