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



@RestController
public class LoginController {

	@Autowired
	private LoginService service;

    @Autowired
    private LoginResponse response;
    
    
    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> userLogin(@RequestBody UserCredentials UserCredentials) {
        LoginResponse user = service.getUser(UserCredentials);
      return new ResponseEntity<LoginResponse>(user, HttpStatus.OK);
	}
//     
//    @RequestMapping(value="/registration", method = RequestMethod.POST)
//    public ResponseEntity<Response> registration(@RequestBody RegistrationDTO registrationDTO)
//    {
//    	Address address=new Address();
//    	address.setCity(registrationDTO.getCity());
//    	
//    	
//    	
//    	
//    	UserCredentials userCredentials = new UserCredentials(); 
//    	userCredentials.set
//    }
//    
}
