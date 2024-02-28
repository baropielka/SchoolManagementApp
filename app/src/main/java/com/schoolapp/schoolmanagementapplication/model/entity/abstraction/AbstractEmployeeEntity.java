package com.schoolapp.schoolmanagementapplication.model.entity.abstraction;


import com.schoolapp.schoolmanagementapplication.type.JobType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@Data
public abstract class AbstractEmployeeEntity extends AbstractPersonEntity {
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
