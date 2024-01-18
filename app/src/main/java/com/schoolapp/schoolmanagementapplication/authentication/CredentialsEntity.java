package com.schoolapp.schoolmanagementapplication.authentication;

import com.schoolapp.schoolmanagementapplication.model.entity.ParentEntity;
import com.schoolapp.schoolmanagementapplication.model.entity.StaffEntity;
import com.schoolapp.schoolmanagementapplication.model.entity.StudentEntity;
import com.schoolapp.schoolmanagementapplication.model.entity.TeacherEntity;
import com.schoolapp.schoolmanagementapplication.model.entity.abstraction.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode(callSuper = true)
@Entity
public class CredentialsEntity extends AbstractEntity {

    @Column
    private String login;

    @Column
    private String password;

    @OneToOne
    private ParentEntity parent;

    @OneToOne
    private TeacherEntity teacher;

    @OneToOne
    private StudentEntity student;

    @OneToOne
    private StaffEntity staff;

}
