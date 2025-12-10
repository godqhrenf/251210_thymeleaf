package kr.java.thymeleaf.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "MENTOR")
@Getter @Setter @NoArgsConstructor
@ToString
public class Mentor extends BaseEntity {
    private String name;
    private String speciality;
    @Column(unique = true)
    private String email;

    public Mentor(String name, String speciality, String email) {
        this.name = name;
        this.speciality = speciality;
        this.email = email;
    }

    @OneToMany(mappedBy = "mentor", fetch = FetchType.LAZY)
    private List<Mentee> mentees = new ArrayList<>();
}
