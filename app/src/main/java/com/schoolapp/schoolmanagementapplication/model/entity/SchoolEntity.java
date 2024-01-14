package com.schoolapp.schoolmanagementapplication.model.entity;

import com.schoolapp.schoolmanagementapplication.type.SchoolType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;
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
public class SchoolEntity {
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
    private AddressEntity address;

    @OneToOne
    private TeacherEntity headTeacher;

    @OneToMany(
            mappedBy = "school"
    )
    private List<ClassEntity> schoolClasses;

    @ManyToMany
    @JoinTable(
            name = "school_to_teacher",
            joinColumns = @JoinColumn(name = "school_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<TeacherEntity> teachers;

    @ManyToMany
    @JoinTable(
            name = "school_to_staff",
            joinColumns = @JoinColumn(name = "school_id"),
            inverseJoinColumns = @JoinColumn(name = "staff_id")
    )
    private List<StaffEntity> staffMembers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SchoolEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getVersion(), that.getVersion()) && Objects.equals(getName(), that.getName()) && Objects.equals(getEmail(), that.getEmail()) && Objects.equals(getPhoneNumber(), that.getPhoneNumber()) && getSchoolType() == that.getSchoolType() && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getHeadTeacher(), that.getHeadTeacher()) && Objects.equals(getSchoolClasses(), that.getSchoolClasses()) && Objects.equals(getTeachers(), that.getTeachers()) && Objects.equals(getStaffMembers(), that.getStaffMembers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVersion(), getName(), getEmail(), getPhoneNumber(), getSchoolType(), getAddress(), getHeadTeacher(), getSchoolClasses(), getTeachers(), getStaffMembers());
    }
}
