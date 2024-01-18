package com.schoolapp.schoolmanagementapplication.model.entity;

import com.schoolapp.schoolmanagementapplication.model.entity.abstraction.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class ClassEntity extends AbstractEntity {

    @Column
    private Character classNumber;

    @Column
    private Character classLetter;

    @OneToOne
    private TeacherEntity classTeacher;

    @ManyToOne
    private SchoolEntity school;

    @OneToMany(
            mappedBy = "schoolClass"
    )
    private List<StudentEntity> students;

    @ManyToMany
    @JoinTable(
            name = "class_to_subject",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<SubjectEntity> subjects;
}
