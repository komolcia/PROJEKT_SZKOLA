package net.javaguides.springboot.model;

import net.javaguides.springboot.model.domain.Degree;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Student {
    @NotNull

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @NotNull
    @Size(min = 2, max = 10, message = "name should be longer than (equal to) 2 letters and shorter than (equal to) 10")

    private String firstName;
    @NotNull
    @Size(min = 2, max = 20)
    private String lastName;
    @NotNull
    @Size(min = 8, max = 20)
    private String email;
    @NotNull

    private Degree degree;
    @OneToOne(targetEntity = net.javaguides.springboot.model.Adress.class)

    @Autowired
    private Adress adress;

    public Student(String firstname, String lastName, String email, Degree degree,Adress adress) {
        this.adress=adress;
        this.email = email;
        this.degree = degree;
        this.firstName = firstname;
        this.lastName = lastName;

    }

    public Student(long id, String firstname, String lastName, String email, Degree degree,Adress adress) {
        this.adress=adress;
        this.id = id;
        this.degree = degree;

        this.email = email;
        this.firstName = firstname;
        this.lastName = lastName;

    }

    public Student() {
    }


    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setId(long id) {
        this.id = id;
    }


}

