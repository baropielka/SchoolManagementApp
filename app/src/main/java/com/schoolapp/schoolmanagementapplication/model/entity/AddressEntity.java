package com.schoolapp.schoolmanagementapplication.model.entity;

import com.schoolapp.schoolmanagementapplication.model.entity.abstraction.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
public class AddressEntity extends AbstractEntity {

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String streetName;

    @Column
    private String streetNumber;

    @Column
    private String zipCode;
}
