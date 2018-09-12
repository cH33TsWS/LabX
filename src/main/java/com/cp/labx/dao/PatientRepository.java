package com.cp.labx.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cp.labx.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	List<Patient> findByFirstName(String firstName);
	List<Patient> findByLastName(String lastName);
}
