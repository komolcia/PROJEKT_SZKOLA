package net.javaguides.springboot.model;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "faculty")
public class Faculty {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany
    private List<Professor> professors = new LinkedList<>();

    @Column(name = "address")
    private String address;

    @OneToOne
    private Professor dean;
}
