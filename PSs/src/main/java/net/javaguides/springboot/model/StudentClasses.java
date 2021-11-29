package net.javaguides.springboot.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class StudentClasses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Class classForStudent;
    @ManyToOne
    private Group group;
//  @OneToOne
//  private List<Grade> grades;
    @OneToOne
    private Grade finalGrade;
    @Column
    private boolean isCompleted;
}
