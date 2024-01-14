package com.schoolapp.schoolmanagementapplication.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class ParentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private Long version;

    @OneToOne
    private ContactDataEntity contactData;

    @OneToOne
    private AddressEntity address;

    @ManyToMany(
            mappedBy = "parents"
    )
    List<StudentEntity> children;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParentEntity that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getVersion(), that.getVersion()) && Objects.equals(getContactData(), that.getContactData()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getChildren(), that.getChildren());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVersion(), getContactData(), getAddress(), getChildren());
    }
}
