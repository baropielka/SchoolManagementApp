package com.schoolapp.schoolmanagementapplication.model.entity;

import com.schoolapp.schoolmanagementapplication.model.entity.abstraction.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class StudentEntity extends AbstractEntity {

    @OneToOne
    private ContactDataEntity contactData;

    @OneToOne
    private AddressEntity address;

    @ManyToMany
    @JoinTable(
            name = "child_to_parent",
            joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id")
    )
    private List<ParentEntity> parents;

    @OneToMany(
            mappedBy = "student"
    )
    private List<MarkEntity> marks;

    @ManyToOne
    private ClassEntity schoolClass;
}
