package com.schoolapp.schoolmanagementapplication.controller.impl;

import com.schoolapp.schoolmanagementapplication.controller.SchoolController;
import com.schoolapp.schoolmanagementapplication.model.entity.AddressEntity;
import com.schoolapp.schoolmanagementapplication.model.entity.SchoolEntity;
import com.schoolapp.schoolmanagementapplication.model.entity.TeacherEntity;
import com.schoolapp.schoolmanagementapplication.type.SchoolType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolControllerImpl implements SchoolController {

    @GetMapping("/schools")
    public ResponseEntity<SchoolEntity> getSchoolDetails(){

        AddressEntity address = AddressEntity.AddressEntityBuilder.anAddressEntity()
                .withStreetName("streetName")
                .build();

        TeacherEntity headTeacher = TeacherEntity.TeacherEntityBuilder.aTeacherEntity()
                .withFirstName("firstName")
                .withLastName("lastName")
                .build();
        SchoolEntity school = SchoolEntity.SchoolEntityBuilder.aSchoolEntity()
                .withName("name")
                .withEmail("email")
                .withPhoneNumber("email")
                .withSchoolType(SchoolType.HIGH_SCHOOL)
                .withAddress(address)
                .withHeadTeacher(headTeacher)
                .build();

        return ResponseEntity.ok(school);
    }

}
