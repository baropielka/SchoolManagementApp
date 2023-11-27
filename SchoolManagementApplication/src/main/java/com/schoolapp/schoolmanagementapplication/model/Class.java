package com.schoolapp.schoolmanagementapplication.model;

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
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private int classNumber;
    @OneToOne
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "id")
    private Teacher classTeacher;
    @ManyToOne
    private School school;
    @OneToMany(
            mappedBy = "class"
    )
    private List<Student> students;
}
