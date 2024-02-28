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


    public static final class ClassEntityBuilder {
        private Character classNumber;
        private Character classLetter;
        private TeacherEntity classTeacher;
        private SchoolEntity school;
        private List<StudentEntity> students;
        private List<SubjectEntity> subjects;
        private Long id;
        private Long version;

        private ClassEntityBuilder() {
        }

        public static ClassEntityBuilder aClassEntity() {
            return new ClassEntityBuilder();
        }

        public ClassEntityBuilder withClassNumber(Character classNumber) {
            this.classNumber = classNumber;
            return this;
        }

        public ClassEntityBuilder withClassLetter(Character classLetter) {
            this.classLetter = classLetter;
            return this;
        }

        public ClassEntityBuilder withClassTeacher(TeacherEntity classTeacher) {
            this.classTeacher = classTeacher;
            return this;
        }

        public ClassEntityBuilder withSchool(SchoolEntity school) {
            this.school = school;
            return this;
        }

        public ClassEntityBuilder withStudents(List<StudentEntity> students) {
            this.students = students;
            return this;
        }

        public ClassEntityBuilder withSubjects(List<SubjectEntity> subjects) {
            this.subjects = subjects;
            return this;
        }

        public ClassEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ClassEntityBuilder withVersion(Long version) {
            this.version = version;
            return this;
        }

        public ClassEntity build() {
            ClassEntity classEntity = new ClassEntity();
            classEntity.setClassNumber(classNumber);
            classEntity.setClassLetter(classLetter);
            classEntity.setClassTeacher(classTeacher);
            classEntity.setSchool(school);
            classEntity.setStudents(students);
            classEntity.setSubjects(subjects);
            classEntity.setId(id);
            classEntity.setVersion(version);
            return classEntity;
        }
    }
}
