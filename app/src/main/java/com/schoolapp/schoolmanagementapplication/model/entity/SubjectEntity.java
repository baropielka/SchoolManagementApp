package com.schoolapp.schoolmanagementapplication.model.entity;

import com.schoolapp.schoolmanagementapplication.type.SubjectLevel;
import com.schoolapp.schoolmanagementapplication.type.SubjectName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

import static com.schoolapp.schoolmanagementapplication.type.SubjectLevel.BASIC;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class SubjectEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubjectEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getVersion(), that.getVersion()) && getSubjectName() == that.getSubjectName() && getSubjectLevel() == that.getSubjectLevel() && Objects.equals(getClasses(), that.getClasses()) && Objects.equals(getTeacher(), that.getTeacher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVersion(), getSubjectName(), getSubjectLevel(), getClasses(), getTeacher());
    }
}
