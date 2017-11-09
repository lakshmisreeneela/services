package com.omniwyse.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.omniwyse.Application;
import com.omniwyse.db.DBFactory;
import com.omniwyse.models.Address;
import com.omniwyse.models.UserCredentials;
import com.omniwyse.models.UserRoles;
import com.omniwyse.utils.LoginResponse;
import com.omniwyse.utils.RegistrationDTO;
import com.omniwyse.utils.Response;

@Service
public class LoginService {

	@Autowired
	private DBFactory database;

	private Database db;

	 private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);
	
	public LoginResponse getUser(UserCredentials userCredentials) {
		LoginResponse response = new LoginResponse();
		db = database.getServiceDb();
		try {

			List<UserCredentials> user = db
					.where("emailid=? and password=?", userCredentials.getEmailid(), userCredentials.getPassword())
					.results(UserCredentials.class);
			response = new LoginResponse();
			if (!user.isEmpty()) {
				UserCredentials userdetails = user.get(0);
				String role = db.where("id=?", userdetails.getRoleid()).results(UserRoles.class).get(0).getRole();
				response.setUserrole(role);
				response.setUsername(userdetails.getEmailid());
				response.setUserId(userdetails.getId());
			}
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public void registration(RegistrationDTO registrationDTO) {
	Address address=new Address();
	address.setDoornumber(registrationDTO.getDoornumber());
	address.setStreet(registrationDTO.getStreet());
	address.setCity(registrationDTO.getCity());
	address.setState(registrationDTO.getState());
	address.setPin(registrationDTO.getPin());
	db = database.getServiceDb();
	db.insert(address);
	UserCredentials userCredentials=new UserCredentials();
	userCredentials.setAddressid(address.getId());
	userCredentials.setEmailid(registrationDTO.getEmailid());
	userCredentials.setContactnumber(registrationDTO.getContactnumber());
	userCredentials.s
	userCredentials
	}
}
