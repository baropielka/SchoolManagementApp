package com.schoolapp.schoolmanagementapplication.repository;

import com.schoolapp.schoolmanagementapplication.model.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity, Long> {
}
