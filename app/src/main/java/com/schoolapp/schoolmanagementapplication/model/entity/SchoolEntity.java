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


    public static final class SchoolEntityBuilder {
        private String name;
        private String email;
        private String phoneNumber;
        private SchoolType schoolType;
        private AddressEntity address;
        private TeacherEntity headTeacher;
        private List<ClassEntity> schoolClasses;
        private List<TeacherEntity> teachers;
        private List<StaffEntity> staffMembers;
        private Long id;
        private Long version;

        private SchoolEntityBuilder() {
        }

        public static SchoolEntityBuilder aSchoolEntity() {
            return new SchoolEntityBuilder();
        }

        public SchoolEntityBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public SchoolEntityBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public SchoolEntityBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public SchoolEntityBuilder withSchoolType(SchoolType schoolType) {
            this.schoolType = schoolType;
            return this;
        }

        public SchoolEntityBuilder withAddress(AddressEntity address) {
            this.address = address;
            return this;
        }

        public SchoolEntityBuilder withHeadTeacher(TeacherEntity headTeacher) {
            this.headTeacher = headTeacher;
            return this;
        }

        public SchoolEntityBuilder withSchoolClasses(List<ClassEntity> schoolClasses) {
            this.schoolClasses = schoolClasses;
            return this;
        }

        public SchoolEntityBuilder withTeachers(List<TeacherEntity> teachers) {
            this.teachers = teachers;
            return this;
        }

        public SchoolEntityBuilder withStaffMembers(List<StaffEntity> staffMembers) {
            this.staffMembers = staffMembers;
            return this;
        }

        public SchoolEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public SchoolEntityBuilder withVersion(Long version) {
            this.version = version;
            return this;
        }

        public SchoolEntity build() {
            SchoolEntity schoolEntity = new SchoolEntity();
            schoolEntity.setName(name);
            schoolEntity.setEmail(email);
            schoolEntity.setPhoneNumber(phoneNumber);
            schoolEntity.setSchoolType(schoolType);
            schoolEntity.setAddress(address);
            schoolEntity.setHeadTeacher(headTeacher);
            schoolEntity.setSchoolClasses(schoolClasses);
            schoolEntity.setTeachers(teachers);
            schoolEntity.setStaffMembers(staffMembers);
            schoolEntity.setId(id);
            schoolEntity.setVersion(version);
            return schoolEntity;
        }
    }
}
