package com.schoolapp.schoolmanagementapplication.authentication;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialsRepository extends JpaRepository<CredentialsEntity, Long> {
}
