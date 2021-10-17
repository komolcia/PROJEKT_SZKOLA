package com.ps.PS.models;

import java.util.LinkedList;
import java.util.List;

public class Classes {
    private String name;
    private List<Professor> professors = new LinkedList<>();
    private List<Group> groups = new LinkedList<>();
    private TypeOfClasses typeOfClasses;
    private AmountOfHours amountOfHours;
    private String description;
    private Faculty faculty;
    private int maxAmountOfStudents;
    private int currentAmountOfStudents;
    private Degree requiredDegree;
}

