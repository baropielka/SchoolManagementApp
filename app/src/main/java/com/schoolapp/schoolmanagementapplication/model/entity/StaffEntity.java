package com.schoolapp.schoolmanagementapplication.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
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
public class StaffEntity extends AbstractEmployeeEntity{

    @OneToOne
    private ContactDataEntity contactData;

    @OneToOne
    private AddressEntity address;

    @ManyToMany(
            mappedBy = "staffMembers"
    )
    private List<SchoolEntity> schools;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StaffEntity that)) return false;
        return Objects.equals(getContactData(), that.getContactData()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getSchools(), that.getSchools());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContactData(), getAddress(), getSchools());
    }
}
