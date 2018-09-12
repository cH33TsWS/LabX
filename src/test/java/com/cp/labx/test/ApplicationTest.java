package com.cp.labx.test;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cp.labx.configuration.SpringBootRestApiApp;
import com.cp.labx.dao.PatientRepository;
import com.cp.labx.model.Doctor;
import com.cp.labx.model.Patient;
import com.cp.labx.service.DoctorServiceImpl;
import com.cp.labx.service.PatientServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = SpringBootRestApiApp.class)
@ActiveProfiles("test")
public class ApplicationTest {

	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailsService;
	
	@Autowired
	PatientServiceImpl patientService;
	
	@Autowired
	DoctorServiceImpl doctorService;
	
	@Test
	public void test() {
		BCryptPasswordEncoder bCryptPasswordEncoder =  new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("password"));
		
		UserDetails u = userDetailsService.loadUserByUsername("chandresh");
		System.out.println(u.getUsername() + " | " + u.getPassword());
		System.out.println(u.toString());
	}
	
	@Test
	public void patientTest() {
		List<Patient> patients;
		try {
			patients = patientService.getByFirstName("Bruce");
			if(patients != null && patients.size() >0) {
				System.out.println(patients.get(0).toString());
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void doctorTest() {
		/*List<Doctor> doctors;
		try {
			doctors = doctorService.getByFirstName("Ashish");
			if(doctors != null && doctors.size() > 0) {
				System.out.println(doctors.get(0).toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Doctor doctor = new Doctor();
		doctor.setGender("M");
		doctor.setFirstName("Ashish");
		doctor.setLastName("Desai");
		doctor.setSpecialization("BHMS");
		
		try {
			doctorService.saveDoctor(doctor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
