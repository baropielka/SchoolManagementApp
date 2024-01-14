package com.schoolapp.schoolmanagementapplication.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class ClassEntity {

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getVersion(), that.getVersion()) && Objects.equals(getClassNumber(), that.getClassNumber()) && Objects.equals(getClassLetter(), that.getClassLetter()) && Objects.equals(getClassTeacher(), that.getClassTeacher()) && Objects.equals(getSchool(), that.getSchool()) && Objects.equals(getStudents(), that.getStudents()) && Objects.equals(getSubjects(), that.getSubjects());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVersion(), getClassNumber(), getClassLetter(), getClassTeacher(), getSchool(), getStudents(), getSubjects());
    }
}
