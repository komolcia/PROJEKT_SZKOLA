package com.ps.PS.model;

import java.util.LinkedList;
import java.util.List;

public class Faculty {
    private String name;
    private List<Professor> professors = new LinkedList<>();
    private String address;
    private Professor dean;
}
