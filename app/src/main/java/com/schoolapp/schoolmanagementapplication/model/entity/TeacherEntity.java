package com.schoolapp.schoolmanagementapplication.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class TeacherEntity extends AbstractEmployeeEntity{

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeacherEntity that)) return false;
        return Objects.equals(getTaughtSubjects(), that.getTaughtSubjects()) && Objects.equals(getContactData(), that.getContactData()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getLedSchoolClass(), that.getLedSchoolClass()) && Objects.equals(getSchools(), that.getSchools());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTaughtSubjects(), getContactData(), getAddress(), getLedSchoolClass(), getSchools());
    }
}
