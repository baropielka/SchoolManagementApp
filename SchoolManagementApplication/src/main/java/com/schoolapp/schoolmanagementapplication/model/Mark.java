package com.schoolapp.schoolmanagementapplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Mark {

    @Version
    private Long version;

    private int value;

    private int weight;

    @ManyToOne
    private Student student;
}
