package com.schoolapp.schoolmanagementapplication.model.entity;

import com.schoolapp.schoolmanagementapplication.model.entity.abstraction.AbstractEntity;
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
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class StudentEntity extends AbstractEntity {

    @OneToOne
    private AddressEntity address;

    @ManyToMany
    @JoinTable(
            name = "child_to_parent",
            joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id")
    )
    private List<ParentEntity> parents;

    @OneToMany(
            mappedBy = "student"
    )
    private List<MarkEntity> marks;

    @ManyToOne
    private ClassEntity schoolClass;


    public static final class StudentEntityBuilder {
        private AddressEntity address;
        private List<ParentEntity> parents;
        private List<MarkEntity> marks;
        private ClassEntity schoolClass;
        private Long id;
        private Long version;

        private StudentEntityBuilder() {
        }

        public static StudentEntityBuilder aStudentEntity() {
            return new StudentEntityBuilder();
        }

        public StudentEntityBuilder withAddress(AddressEntity address) {
            this.address = address;
            return this;
        }

        public StudentEntityBuilder withParents(List<ParentEntity> parents) {
            this.parents = parents;
            return this;
        }

        public StudentEntityBuilder withMarks(List<MarkEntity> marks) {
            this.marks = marks;
            return this;
        }

        public StudentEntityBuilder withSchoolClass(ClassEntity schoolClass) {
            this.schoolClass = schoolClass;
            return this;
        }

        public StudentEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public StudentEntityBuilder withVersion(Long version) {
            this.version = version;
            return this;
        }

        public StudentEntity build() {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setAddress(address);
            studentEntity.setParents(parents);
            studentEntity.setMarks(marks);
            studentEntity.setSchoolClass(schoolClass);
            studentEntity.setId(id);
            studentEntity.setVersion(version);
            return studentEntity;
        }
    }
}
