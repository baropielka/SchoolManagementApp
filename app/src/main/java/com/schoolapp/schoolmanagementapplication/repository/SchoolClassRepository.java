package com.schoolapp.schoolmanagementapplication.repository;

import com.schoolapp.schoolmanagementapplication.model.entity.ClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolClassRepository extends JpaRepository<ClassEntity, Long> {
}
