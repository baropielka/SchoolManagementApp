package com.schoolapp.schoolmanagementapplication.model.entity;

import com.schoolapp.schoolmanagementapplication.model.entity.abstraction.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class ParentEntity extends AbstractEntity {

    @OneToOne
    private AddressEntity address;

    @ManyToMany(
            mappedBy = "parents"
    )
    List<StudentEntity> children;


    public static final class ParentEntityBuilder {
        private AddressEntity address;
        private List<StudentEntity> children;
        private Long id;
        private Long version;

        private ParentEntityBuilder() {
        }

        public static ParentEntityBuilder aParentEntity() {
            return new ParentEntityBuilder();
        }

        public ParentEntityBuilder withAddress(AddressEntity address) {
            this.address = address;
            return this;
        }

        public ParentEntityBuilder withChildren(List<StudentEntity> children) {
            this.children = children;
            return this;
        }

        public ParentEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public ParentEntityBuilder withVersion(Long version) {
            this.version = version;
            return this;
        }

        public ParentEntity build() {
            ParentEntity parentEntity = new ParentEntity();
            parentEntity.setAddress(address);
            parentEntity.setChildren(children);
            parentEntity.setId(id);
            parentEntity.setVersion(version);
            return parentEntity;
        }
    }
}
