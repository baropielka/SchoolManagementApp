package com.schoolapp.schoolmanagementapplication.model.entity;

import com.schoolapp.schoolmanagementapplication.model.entity.abstraction.AbstractEntity;
import com.schoolapp.schoolmanagementapplication.type.JobType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
public class EmploymentDataEntity extends AbstractEntity {

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
}
