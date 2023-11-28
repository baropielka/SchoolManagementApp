package com.schoolapp.schoolmanagementapplication.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @OneToOne
    private ContactData contactData;

    @OneToOne
    private Address address;

    @ManyToMany
    @JoinTable(
            name = "child_to_parent",
            joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id")
    )
    private List<Parent> parents;

    @OneToMany(
            mappedBy = "student"
    )
    private List<Mark> marks;
}
