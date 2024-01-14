package com.schoolapp.schoolmanagementapplication.model.entity;

import com.schoolapp.schoolmanagementapplication.type.JobType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class EmploymentDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @Column
    private LocalDateTime startDate;

    @Column
    private LocalDateTime endDate;

    @Column
    private BigDecimal salary;

    @Column
    private BigDecimal fullTimePart;

    @Column
    @Enumerated(EnumType.STRING)
    private JobType jobType;

    @Column
    private int vacationDays;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmploymentDataEntity that)) return false;
        return getVacationDays() == that.getVacationDays() && Objects.equals(getId(), that.getId()) && Objects.equals(getVersion(), that.getVersion()) && Objects.equals(getStartDate(), that.getStartDate()) && Objects.equals(getEndDate(), that.getEndDate()) && Objects.equals(getSalary(), that.getSalary()) && Objects.equals(getFullTimePart(), that.getFullTimePart()) && getJobType() == that.getJobType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVersion(), getStartDate(), getEndDate(), getSalary(), getFullTimePart(), getJobType(), getVacationDays());
    }
}
