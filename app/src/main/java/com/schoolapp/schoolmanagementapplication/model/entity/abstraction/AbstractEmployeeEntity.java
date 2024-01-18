package com.schoolapp.schoolmanagementapplication.model.entity.abstraction;

import com.schoolapp.schoolmanagementapplication.model.entity.EmploymentDataEntity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;

@MappedSuperclass
public abstract class AbstractEmployeeEntity extends AbstractEntity{
    @OneToOne
    private EmploymentDataEntity employmentData;
}
