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

    @Version
    private Long version;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @Column
    @Enumerated(EnumType.STRING)
    private SchoolType schoolType;

    @OneToOne
    private Address address;

    @OneToOne
    private Teacher headTeacher;

    @OneToMany(
            mappedBy = "school"
    )
    private List<SchoolClass> schoolClasses;

    @ManyToMany
    @JoinTable(
            name = "school_to_teacher",
            joinColumns = @JoinColumn(name = "school_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<Teacher> teachers;

    @ManyToMany
    @JoinTable(
            name = "school_to_staff",
            joinColumns = @JoinColumn(name = "school_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_id")
    )
    private List<Staff> staffMembers;
}
