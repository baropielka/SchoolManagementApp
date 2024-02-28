package com.schoolapp.schoolmanagementapplication.model.entity;

import com.schoolapp.schoolmanagementapplication.model.entity.abstraction.AbstractEmployeeEntity;
import com.schoolapp.schoolmanagementapplication.type.JobType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class TeacherEntity extends AbstractEmployeeEntity {

    @OneToMany(
            mappedBy = "teacher"
    )
    private List<SubjectEntity> taughtSubjects;

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


    public static final class TeacherEntityBuilder {
        private List<SubjectEntity> taughtSubjects;
        private AddressEntity address;
        private ClassEntity ledSchoolClass;
        private List<SchoolEntity> schools;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private BigDecimal salary;
        private BigDecimal fullTimePart;
        private JobType jobType;
        private int vacationDays;
        private Long id;
        private Long version;
        private String firstName;
        private String lastName;
        private LocalDate birthDate;
        private String email;
        private String phoneNumber;

        private TeacherEntityBuilder() {
        }

        public static TeacherEntityBuilder aTeacherEntity() {
            return new TeacherEntityBuilder();
        }

        public TeacherEntityBuilder withTaughtSubjects(List<SubjectEntity> taughtSubjects) {
            this.taughtSubjects = taughtSubjects;
            return this;
        }

        public TeacherEntityBuilder withAddress(AddressEntity address) {
            this.address = address;
            return this;
        }

        public TeacherEntityBuilder withLedSchoolClass(ClassEntity ledSchoolClass) {
            this.ledSchoolClass = ledSchoolClass;
            return this;
        }

        public TeacherEntityBuilder withSchools(List<SchoolEntity> schools) {
            this.schools = schools;
            return this;
        }

        public TeacherEntityBuilder withStartDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public TeacherEntityBuilder withEndDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public TeacherEntityBuilder withSalary(BigDecimal salary) {
            this.salary = salary;
            return this;
        }

        public TeacherEntityBuilder withFullTimePart(BigDecimal fullTimePart) {
            this.fullTimePart = fullTimePart;
            return this;
        }

        public TeacherEntityBuilder withJobType(JobType jobType) {
            this.jobType = jobType;
            return this;
        }

        public TeacherEntityBuilder withVacationDays(int vacationDays) {
            this.vacationDays = vacationDays;
            return this;
        }

        public TeacherEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public TeacherEntityBuilder withVersion(Long version) {
            this.version = version;
            return this;
        }

        public TeacherEntityBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public TeacherEntityBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public TeacherEntityBuilder withBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public TeacherEntityBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public TeacherEntityBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public TeacherEntity build() {
            TeacherEntity teacherEntity = new TeacherEntity();
            teacherEntity.setTaughtSubjects(taughtSubjects);
            teacherEntity.setAddress(address);
            teacherEntity.setLedSchoolClass(ledSchoolClass);
            teacherEntity.setSchools(schools);
            teacherEntity.setStartDate(startDate);
            teacherEntity.setEndDate(endDate);
            teacherEntity.setSalary(salary);
            teacherEntity.setFullTimePart(fullTimePart);
            teacherEntity.setJobType(jobType);
            teacherEntity.setVacationDays(vacationDays);
            teacherEntity.setId(id);
            teacherEntity.setVersion(version);
            teacherEntity.setFirstName(firstName);
            teacherEntity.setLastName(lastName);
            teacherEntity.setBirthDate(birthDate);
            teacherEntity.setEmail(email);
            teacherEntity.setPhoneNumber(phoneNumber);
            return teacherEntity;
        }
    }
}
