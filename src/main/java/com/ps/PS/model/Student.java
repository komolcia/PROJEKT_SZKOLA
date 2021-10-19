package com.ps.PS.model;

import java.util.LinkedList;
import java.util.List;

public class Student {
    private int id;
    private String index;
    private String fullName;
    private String phoneNumber;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<StudentOnSpecialisation> getSpecialisations() {
        return specialisations;
    }

    public void setSpecialisations(List<StudentOnSpecialisation> specialisations) {
        this.specialisations = specialisations;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    private String address;
    private List<StudentOnSpecialisation> specialisations = new LinkedList<>();
    private Degree degree;



}

