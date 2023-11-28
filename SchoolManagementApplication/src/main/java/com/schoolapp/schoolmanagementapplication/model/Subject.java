package com.schoolapp.schoolmanagementapplication.model;

import com.schoolapp.schoolmanagementapplication.type.SubjectLevel;
import com.schoolapp.schoolmanagementapplication.type.SubjectName;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

import static com.schoolapp.schoolmanagementapplication.type.SubjectLevel.BASIC;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @Column
    @Enumerated(EnumType.STRING)
    private SubjectName subjectName;

    @Column
    @Enumerated
    private SubjectLevel subjectLevel = BASIC;

    @ManyToMany(
            mappedBy = "subjects"
    )
    private List<SchoolClass> classes;
}
