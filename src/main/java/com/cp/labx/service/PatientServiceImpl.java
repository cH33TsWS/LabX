package com.cp.labx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.labx.dao.PatientRepository;
import com.cp.labx.model.Patient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;
	
	
	@Override
	public List<Patient> getPatients() throws Exception {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

	@Override
	public Patient getPatient(Long id) throws Exception {
		// TODO Auto-generated method stub
		return patientRepository.getOne(id);
	}

	@Override
	public void savePatient(Patient patient) throws Exception {
		// TODO Auto-generated method stub
		patientRepository.save(patient);
	}

	@Override
	public List<Patient> getByFirstName(String firstName) throws Exception {
		// TODO Auto-generated method stub
		return patientRepository.findByFirstName(firstName);
	}

	@Override
	public List<Patient> getByLastName(String lastName) throws Exception {
		// TODO Auto-generated method stub
		return patientRepository.findByLastName(lastName);
	}
	
	@Override
	public boolean isExists(Patient patient) throws Exception {
		return getPatient(patient.getId())!=null;
		
	}

}
