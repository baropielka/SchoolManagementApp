package com.schoolapp.schoolmanagementapplication.model.entity;

import com.schoolapp.schoolmanagementapplication.model.entity.abstraction.AbstractEntity;
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
public class ParentEntity extends AbstractEntity {

    @OneToOne
    private ContactDataEntity contactData;

    @OneToOne
    private AddressEntity address;

    @ManyToMany(
            mappedBy = "parents"
    )
    List<StudentEntity> children;
}
