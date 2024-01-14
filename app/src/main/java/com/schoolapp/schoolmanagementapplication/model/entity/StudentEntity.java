package com.schoolapp.schoolmanagementapplication.model.entity;

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
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @OneToOne
    private ContactDataEntity contactData;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getVersion(), that.getVersion()) && Objects.equals(getContactData(), that.getContactData()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getParents(), that.getParents()) && Objects.equals(getMarks(), that.getMarks()) && Objects.equals(getSchoolClass(), that.getSchoolClass());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVersion(), getContactData(), getAddress(), getParents(), getMarks(), getSchoolClass());
    }
}
