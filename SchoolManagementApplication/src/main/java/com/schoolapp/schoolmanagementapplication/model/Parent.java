package com.schoolapp.schoolmanagementapplication.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @OneToOne
    private ContactData contactData;

    @OneToOne
    private Address address;

    @ManyToMany(
            mappedBy = "parents"
    )
    List<Student> children;
}
