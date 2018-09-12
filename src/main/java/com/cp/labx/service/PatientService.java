package com.cp.labx.service;

import java.util.List;

import com.cp.labx.model.Patient;

public interface PatientService {
	
	public List<Patient> getPatients() throws Exception;
	
	public Patient getPatient(Long id) throws Exception;
	
	public void savePatient(Patient patient) throws Exception;
	
	public List<Patient> getByFirstName(String firstName)throws Exception;
	
	public List<Patient> getByLastName(String lastName)throws Exception;

}
