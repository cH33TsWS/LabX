package com.cp.labx.service;

import java.util.List;

import com.cp.labx.model.Doctor;

public interface DoctorService {
	
	public List<Doctor> getDoctors() throws Exception;
	
	public Doctor getDoctor(Long id) throws Exception;
	
	public List<Doctor> getByFirstName(String firstName) throws Exception;
	
	public List<Doctor> getByLastName(String lastName) throws Exception;
	
	public void saveDoctor(Doctor doctor) throws Exception;

}
