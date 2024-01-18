package com.schoolapp.schoolmanagementapplication.model.entity;

import com.schoolapp.schoolmanagementapplication.model.entity.abstraction.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
public class MarkEntity extends AbstractEntity {

    @Column
    private int value;

    @Column
    private int weight;

    @ManyToOne
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;

}
