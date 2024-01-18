package com.schoolapp.schoolmanagementapplication.model.entity.abstraction;

import jakarta.persistence.*;

@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;
}
