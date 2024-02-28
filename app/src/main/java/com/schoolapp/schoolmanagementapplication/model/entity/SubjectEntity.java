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


    public static final class SubjectEntityBuilder {
        private SubjectName subjectName;
        private SubjectLevel subjectLevel;
        private List<ClassEntity> classes;
        private TeacherEntity teacher;
        private Long id;
        private Long version;

        private SubjectEntityBuilder() {
        }

        public static SubjectEntityBuilder aSubjectEntity() {
            return new SubjectEntityBuilder();
        }

        public SubjectEntityBuilder withSubjectName(SubjectName subjectName) {
            this.subjectName = subjectName;
            return this;
        }

        public SubjectEntityBuilder withSubjectLevel(SubjectLevel subjectLevel) {
            this.subjectLevel = subjectLevel;
            return this;
        }

        public SubjectEntityBuilder withClasses(List<ClassEntity> classes) {
            this.classes = classes;
            return this;
        }

        public SubjectEntityBuilder withTeacher(TeacherEntity teacher) {
            this.teacher = teacher;
            return this;
        }

        public SubjectEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public SubjectEntityBuilder withVersion(Long version) {
            this.version = version;
            return this;
        }

        public SubjectEntity build() {
            SubjectEntity subjectEntity = new SubjectEntity();
            subjectEntity.setSubjectName(subjectName);
            subjectEntity.setSubjectLevel(subjectLevel);
            subjectEntity.setClasses(classes);
            subjectEntity.setTeacher(teacher);
            subjectEntity.setId(id);
            subjectEntity.setVersion(version);
            return subjectEntity;
        }
    }
}
