package com.cp.labx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cp.labx.model.CommonResponse;
import com.cp.labx.model.Doctor;
import com.cp.labx.model.ErrorResponse;
import com.cp.labx.service.DoctorServiceImpl;

@RestController
public class DoctorController {

	public static final Logger log = LoggerFactory.getLogger(DoctorController.class);

	@Autowired
	private DoctorServiceImpl doctorService;

	@RequestMapping(value = "/api/doctor/", method = RequestMethod.POST)
	public ResponseEntity<?> createDoctor(@RequestBody Doctor doctor) {
		
		ResponseEntity<?> response;
		CommonResponse successResponse = new CommonResponse();
		ErrorResponse error = new ErrorResponse();
		
		try {
			
			if( !StringUtils.isEmpty(doctor.getFirstName()) 
					&& !StringUtils.isEmpty(doctor.getLastName()) 
					&& !StringUtils.isEmpty(doctor.getSpecialization())
					&& doctorService.isExists(doctor)) {
				log.error("A doctor with name " + doctor.getFirstName() +" "+ doctor.getLastName() + " already exist");
				error.setErrorCode(HttpStatus.CONFLICT.value());
				error.setMessage("A doctor with name " + doctor.getFirstName() +" "+ doctor.getLastName() + " already exist");
				response = new ResponseEntity<ErrorResponse>(error, HttpStatus.CONFLICT);
			}
			
			try {
				doctorService.saveDoctor(doctor);
				successResponse.setResponseCode(HttpStatus.CREATED.value());
				successResponse.setMessage("Doctor created successfully.");
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
