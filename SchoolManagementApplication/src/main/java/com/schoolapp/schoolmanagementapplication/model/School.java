package com.schoolapp.schoolmanagementapplication.model;

import com.schoolapp.schoolmanagementapplication.type.SchoolType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@Entity
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private SchoolType schoolType;
    @Column
    private Address address;
    @Column
    private Teacher headTeacher;

    @OneToMany(
            mappedBy = "school"
    )
    private List<Class> classes;
    private List<Teacher> teachers;
    private List<Staff> staffMembers;


}
