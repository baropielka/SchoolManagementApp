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
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @Column
    private Character classNumber;

    @Column
    private Character classLetter;

    @OneToOne
    private Teacher classTeacher;

    @ManyToOne
    private School school;

    @OneToMany(
            mappedBy = "schoolClass"
    )
    private List<Student> students;

    @ManyToMany
    @JoinTable(
            name = "class_to_subject",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;
}
