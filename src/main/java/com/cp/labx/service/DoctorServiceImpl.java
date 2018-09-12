package com.cp.labx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cp.labx.dao.DoctorRepository;
import com.cp.labx.model.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	@Autowired
	DoctorRepository doctorRepository;

	@Override
	public List<Doctor> getDoctors() throws Exception {
		// TODO Auto-generated method stub
		return doctorRepository.findAll();
	}

	@Override
	public Doctor getDoctor(Long id) throws Exception {
		// TODO Auto-generated method stub
		return doctorRepository.getOne(id);
	}

	@Override
	public List<Doctor> getByFirstName(String firstName) throws Exception {
		// TODO Auto-generated method stub
		return doctorRepository.findByFirstName(firstName);
	}

	@Override
	public List<Doctor> getByLastName(String lastName) throws Exception {
		// TODO Auto-generated method stub
		return doctorRepository.findByLastName(lastName);
	}

	@Override
	public void saveDoctor(Doctor doctor) throws Exception {
		// TODO Auto-generated method stub
		doctorRepository.save(doctor);
	}

}
