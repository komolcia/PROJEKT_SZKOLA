package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "year")
    private int year;
    @Column(name = "semester")
    private int semester;
    @ManyToOne
    private Professor professor;
    @Column(name = "number")
    private int number;
    @ManyToOne
    private Term term;
    @Column(name = "place")
    private String place;
}
