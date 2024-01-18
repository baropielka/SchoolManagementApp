package com.schoolapp.schoolmanagementapplication.model.entity;

import com.schoolapp.schoolmanagementapplication.model.entity.abstraction.AbstractEmployeeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
public class TeacherEntity extends AbstractEmployeeEntity {

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
