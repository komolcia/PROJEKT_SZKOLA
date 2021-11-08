package net.javaguides.springboot.model;

import javax.persistence.*;

@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Professor professor;
    @Column(name = "number")
    private int number;
    @ManyToOne
    private Term term;
    @Column(name = "place")
    private String place;
}
