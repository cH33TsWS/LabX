package com.cp.labx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cp.labx.model.CommonResponse;
import com.cp.labx.model.ErrorResponse;
import com.cp.labx.model.Patient;
import com.cp.labx.service.PatientServiceImpl;

@RestController
public class PatientController {
	
	 public static final Logger log = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	PatientServiceImpl patientService;

	@RequestMapping(value = "/api/patient/", method = RequestMethod.POST)
	public ResponseEntity<?> createPatient(@RequestBody Patient patient) {
		
		ResponseEntity<?> response = null;
		CommonResponse successResponse = new CommonResponse();
		
		ErrorResponse error = new ErrorResponse();
		try {
			if (null != patient.getId() && patientService.isExists(patient)) {
				log.error("A Patient with name " + patient.getFirstName() +" "+ patient.getLastName() + " already exist");
				error.setErrorCode(HttpStatus.CONFLICT.value());
				error.setMessage("A User with name " + patient.getFirstName() +" "+ patient.getLastName() + " already exist");
				response = new ResponseEntity<ErrorResponse>(error, HttpStatus.CONFLICT);
				return response;
			}

			try {
				patientService.savePatient(patient);
				successResponse.setResponseCode(HttpStatus.CREATED.value());
				successResponse.setMessage("Patient created successfully.");
				response = new ResponseEntity<CommonResponse>(successResponse, HttpStatus.CREATED);
				return response;
			} catch (Exception e) {
				// TODO: handle exception
				log.error("Error : ", e);
				error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
				error.setMessage("Error while creating patient, Please contact admistrator");
				response = new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
				return response;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("Error : ", e);
			error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			error.setMessage("Error while creating patient, Please contact admistrator");
			response = new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
			return response;
		}
		

	}

}
