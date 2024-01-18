package com.schoolapp.schoolmanagementapplication.model.entity;

import com.schoolapp.schoolmanagementapplication.model.entity.abstraction.AbstractEmployeeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
public class StaffEntity extends AbstractEmployeeEntity {

    @OneToOne
    private ContactDataEntity contactData;

    @OneToOne
    private AddressEntity address;

    @ManyToMany(
            mappedBy = "staffMembers"
    )
    private List<SchoolEntity> schools;
}
