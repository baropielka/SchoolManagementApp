package com.schoolapp.schoolmanagementapplication.model.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Mark {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    private int value;

    private int weight;

    @ManyToOne
    private Student student;

    //TODO dodać nauczyciela wystrawiającego i przedmiot dotyczacy oceny
}
