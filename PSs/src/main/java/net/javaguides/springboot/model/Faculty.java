package net.javaguides.springboot.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "faculty")
public class Faculty {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    //    @OneToMany(cascade = CascadeType.DETACH)
//    @JoinColumn(name = "faculty_id")
//    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Set<Professor> professors = new HashSet<Professor>(0);

    @Column(name = "address")
    private String address;

    @OneToOne
    private Professor dean;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(Set<Professor> professors) {
        this.professors = professors;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Professor getDean() {
        return dean;
    }

    public void setDean(Professor dean) {
        this.dean = dean;
    }

    public void addProfessor(Professor professor) {
        this.professors.add(professor);
    }

    public void removeProfessor(Professor professor) {
        this.professors.remove(professor);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Faculty faculty = (Faculty) o;
        return id != null && Objects.equals(id, faculty.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
