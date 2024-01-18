package com.schoolapp.schoolmanagementapplication.model.entity;

import com.schoolapp.schoolmanagementapplication.model.entity.abstraction.AbstractEntity;
import com.schoolapp.schoolmanagementapplication.type.SubjectLevel;
import com.schoolapp.schoolmanagementapplication.type.SubjectName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.List;

import static com.schoolapp.schoolmanagementapplication.type.SubjectLevel.BASIC;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
public class SubjectEntity extends AbstractEntity {
    @Column
    @Enumerated(EnumType.STRING)
    private SubjectName subjectName;

    @Column
    @Enumerated(EnumType.STRING)
    private SubjectLevel subjectLevel = BASIC;

    @ManyToMany(
            mappedBy = "subjects"
    )
    private List<ClassEntity> classes;

    @ManyToOne
    private TeacherEntity teacher;
}
