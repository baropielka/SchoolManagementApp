package com.schoolapp.schoolmanagementapplication.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@Entity
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @OneToOne
    private ContactData contactData;

    @OneToOne
    private Address address;

    @ManyToMany(
            mappedBy = "staffMembers"
    )
    private List<School> schools;
}
