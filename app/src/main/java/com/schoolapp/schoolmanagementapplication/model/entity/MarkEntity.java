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


    public static final class MarkEntityBuilder {
        private int value;
        private int weight;
        private StudentEntity student;
        private TeacherEntity teacher;
        private SubjectEntity subject;
        private Long id;
        private Long version;

        private MarkEntityBuilder() {
        }

        public static MarkEntityBuilder aMarkEntity() {
            return new MarkEntityBuilder();
        }

        public MarkEntityBuilder withValue(int value) {
            this.value = value;
            return this;
        }

        public MarkEntityBuilder withWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public MarkEntityBuilder withStudent(StudentEntity student) {
            this.student = student;
            return this;
        }

        public MarkEntityBuilder withTeacher(TeacherEntity teacher) {
            this.teacher = teacher;
            return this;
        }

        public MarkEntityBuilder withSubject(SubjectEntity subject) {
            this.subject = subject;
            return this;
        }

        public MarkEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public MarkEntityBuilder withVersion(Long version) {
            this.version = version;
            return this;
        }

        public MarkEntity build() {
            MarkEntity markEntity = new MarkEntity();
            markEntity.setValue(value);
            markEntity.setWeight(weight);
            markEntity.setStudent(student);
            markEntity.setTeacher(teacher);
            markEntity.setSubject(subject);
            markEntity.setId(id);
            markEntity.setVersion(version);
            return markEntity;
        }
    }
}
