package com.schoolapp.schoolmanagementapplication.model.entity;

import com.schoolapp.schoolmanagementapplication.model.entity.abstraction.AbstractEmployeeEntity;
import com.schoolapp.schoolmanagementapplication.type.JobType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
public class StaffEntity extends AbstractEmployeeEntity {

    @OneToOne
    private AddressEntity address;

    @ManyToMany(
            mappedBy = "staffMembers"
    )
    private List<SchoolEntity> schools;


    public static final class StaffEntityBuilder {
        private AddressEntity address;
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

        private StaffEntityBuilder() {
        }

        public static StaffEntityBuilder aStaffEntity() {
            return new StaffEntityBuilder();
        }

        public StaffEntityBuilder withAddress(AddressEntity address) {
            this.address = address;
            return this;
        }

        public StaffEntityBuilder withSchools(List<SchoolEntity> schools) {
            this.schools = schools;
            return this;
        }

        public StaffEntityBuilder withStartDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public StaffEntityBuilder withEndDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public StaffEntityBuilder withSalary(BigDecimal salary) {
            this.salary = salary;
            return this;
        }

        public StaffEntityBuilder withFullTimePart(BigDecimal fullTimePart) {
            this.fullTimePart = fullTimePart;
            return this;
        }

        public StaffEntityBuilder withJobType(JobType jobType) {
            this.jobType = jobType;
            return this;
        }

        public StaffEntityBuilder withVacationDays(int vacationDays) {
            this.vacationDays = vacationDays;
            return this;
        }

        public StaffEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public StaffEntityBuilder withVersion(Long version) {
            this.version = version;
            return this;
        }

        public StaffEntityBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StaffEntityBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StaffEntityBuilder withBirthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public StaffEntityBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public StaffEntityBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public StaffEntity build() {
            StaffEntity staffEntity = new StaffEntity();
            staffEntity.setAddress(address);
            staffEntity.setSchools(schools);
            staffEntity.setStartDate(startDate);
            staffEntity.setEndDate(endDate);
            staffEntity.setSalary(salary);
            staffEntity.setFullTimePart(fullTimePart);
            staffEntity.setJobType(jobType);
            staffEntity.setVacationDays(vacationDays);
            staffEntity.setId(id);
            staffEntity.setVersion(version);
            staffEntity.setFirstName(firstName);
            staffEntity.setLastName(lastName);
            staffEntity.setBirthDate(birthDate);
            staffEntity.setEmail(email);
            staffEntity.setPhoneNumber(phoneNumber);
            return staffEntity;
        }
    }
}
