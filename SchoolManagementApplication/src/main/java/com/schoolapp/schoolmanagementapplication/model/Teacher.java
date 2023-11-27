package com.schoolapp.schoolmanagementapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@Entity
public class Teacher extends Employee{

    @OneToOne(
            mappedBy = "address"
    )
    private Class ledClass;
}
