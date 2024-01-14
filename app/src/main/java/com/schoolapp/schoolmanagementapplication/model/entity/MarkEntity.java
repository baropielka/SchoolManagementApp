package com.schoolapp.schoolmanagementapplication.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class MarkEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    private int value;

    private int weight;

    @ManyToOne
    private StudentEntity student;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private SubjectEntity subject;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MarkEntity that)) return false;
        return getValue() == that.getValue() && getWeight() == that.getWeight() && Objects.equals(getId(), that.getId()) && Objects.equals(getVersion(), that.getVersion()) && Objects.equals(getStudent(), that.getStudent()) && Objects.equals(getTeacher(), that.getTeacher()) && Objects.equals(getSubject(), that.getSubject());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVersion(), getValue(), getWeight(), getStudent(), getTeacher(), getSubject());
    }
}
