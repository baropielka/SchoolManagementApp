package com.schoolapp.schoolmanagementapplication.repository;

import com.schoolapp.schoolmanagementapplication.model.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
}
