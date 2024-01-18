package com.schoolapp.schoolmanagementapplication.model.entity;

import com.schoolapp.schoolmanagementapplication.model.entity.abstraction.AbstractEntity;
import com.schoolapp.schoolmanagementapplication.type.SchoolType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
public class SchoolEntity extends AbstractEntity {

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
}
