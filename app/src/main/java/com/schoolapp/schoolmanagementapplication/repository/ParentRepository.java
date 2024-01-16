package com.schoolapp.schoolmanagementapplication.repository;

import com.schoolapp.schoolmanagementapplication.model.entity.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentRepository extends JpaRepository<ParentEntity, Long> {
}
