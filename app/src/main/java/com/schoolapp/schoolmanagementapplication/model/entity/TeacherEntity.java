package com.schoolapp.schoolmanagementapplication.model.entity;

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
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @OneToMany(
            mappedBy = "teacher"
    )
    private List<SubjectEntity> taughtSubjects;

    @OneToOne
    private ContactDataEntity contactData;

    @OneToOne
    private AddressEntity address;

    @OneToOne(
            mappedBy = "classTeacher"
    )
    private ClassEntity ledSchoolClass;

    @ManyToMany(
            mappedBy = "teachers"
    )
    private List<SchoolEntity> schools;
}
