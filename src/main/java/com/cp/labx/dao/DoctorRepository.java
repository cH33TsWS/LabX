package com.cp.labx.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cp.labx.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long>{
	
	List<Doctor> findByFirstName(String firstName);
	List<Doctor> findByLastName(String lastName);
}
