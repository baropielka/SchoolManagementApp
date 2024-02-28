package com.schoolapp.schoolmanagementapplication.model.entity;

import com.schoolapp.schoolmanagementapplication.model.entity.abstraction.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
public class AddressEntity extends AbstractEntity {

    @Column
    private String country;

    @Column
    private String city;

    @Column
    private String streetName;

    @Column
    private String streetNumber;

    @Column
    private String zipCode;


    public static final class AddressEntityBuilder {
        private String country;
        private String city;
        private String streetName;
        private String streetNumber;
        private String zipCode;
        private Long id;
        private Long version;

        private AddressEntityBuilder() {
        }

        public static AddressEntityBuilder anAddressEntity() {
            return new AddressEntityBuilder();
        }

        public AddressEntityBuilder withCountry(String country) {
            this.country = country;
            return this;
        }

        public AddressEntityBuilder withCity(String city) {
            this.city = city;
            return this;
        }

        public AddressEntityBuilder withStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public AddressEntityBuilder withStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public AddressEntityBuilder withZipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public AddressEntityBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public AddressEntityBuilder withVersion(Long version) {
            this.version = version;
            return this;
        }

        public AddressEntity build() {
            AddressEntity addressEntity = new AddressEntity();
            addressEntity.setCountry(country);
            addressEntity.setCity(city);
            addressEntity.setStreetName(streetName);
            addressEntity.setStreetNumber(streetNumber);
            addressEntity.setZipCode(zipCode);
            addressEntity.setId(id);
            addressEntity.setVersion(version);
            return addressEntity;
        }
    }
}
