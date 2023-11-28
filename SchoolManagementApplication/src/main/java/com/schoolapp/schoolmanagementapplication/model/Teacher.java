package com.schoolapp.schoolmanagementapplication.model;

import jakarta.persistence.*;
import lombok.*;

import javax.security.auth.Subject;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @Column
    @Enumerated(EnumType.STRING)
    private List<Subject> taughtSubjects;

    @OneToOne
    private ContactData contactData;

    @OneToOne
    private Address address;

    @OneToOne(
            mappedBy = "classTeacher"
    )
    private SchoolClass ledSchoolClass;

    @ManyToMany(
            mappedBy = "teachers"
    )
    private List<School> schools;
}
