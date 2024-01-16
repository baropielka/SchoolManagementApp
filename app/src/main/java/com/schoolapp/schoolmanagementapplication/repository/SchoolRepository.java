package com.schoolapp.schoolmanagementapplication.repository;

import com.schoolapp.schoolmanagementapplication.model.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolEntity, Long> {
}
