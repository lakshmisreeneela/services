package com.omniwyse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.omniwyse.models.UserCredentials;
import com.omniwyse.services.LoginService;
import com.omniwyse.utils.LoginResponse;
import com.omniwyse.utils.RegistrationDTO;
import com.omniwyse.utils.Response;



@RestController
public class LoginController {

	@Autowired
	private LoginService service;

	@Autowired
	private Response response;
   
    
	@SuppressWarnings("null")
	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public ResponseEntity<LoginResponse> userLogin(@RequestBody UserCredentials UserCredentials) {
		LoginResponse response = service.getUser(UserCredentials);
		if (response != null && response.getUserId() != null) {
			response.setStatus(200);
			response.setDescription("login success");
			return new ResponseEntity<LoginResponse>(response, HttpStatus.OK);
		} else if (response != null) {
			response.setStatus(400);
			response.setDescription("invalid username or password");
			return new ResponseEntity<LoginResponse>(response, HttpStatus.BAD_REQUEST);
		} else {
			response.setStatus(400);
			response.setDescription("database doesn't exist");
			return new ResponseEntity<LoginResponse>(response, HttpStatus.OK);
		}
	}
   
    
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ResponseEntity<Response> registration(@RequestBody RegistrationDTO registrationDTO) {
		int rowEffected = service.registration(registrationDTO);
		if (rowEffected > 0) {
			response.setStatus(200);
			response.setMessage("Registration successfull");
			response.setDescription("Registration successfull");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else if (rowEffected == -1) {
			response.setStatus(400);
			response.setMessage("mailid already in use");
			response.setDescription("mailid already in use");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		} else if (rowEffected == -5) {
			response.setStatus(400);
			response.setMessage("contactnumber in use");
			response.setDescription("contactnumber in use");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}

		response.setStatus(200);
		response.setMessage("Registration successfull");
		response.setDescription("Registration successfull");
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

}
