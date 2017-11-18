package com.omniwyse.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.dieselpoint.norm.Transaction;
import com.omniwyse.db.DBFactory;
import com.omniwyse.models.Address;
import com.omniwyse.models.UserCredentials;
import com.omniwyse.models.UserRoles;
import com.omniwyse.utils.LoginResponse;
import com.omniwyse.utils.RegistrationDTO;

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
				response.setUserId(userdetails.getUserid());
			}
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public int registration(RegistrationDTO registrationDTO) {
		try {

			db = database.getServiceDb();
			Transaction transaction = db.startTransaction();

			List<UserCredentials> user = db.where("emailid=?", registrationDTO.getEmailid())
					.results(UserCredentials.class);
			if (user.isEmpty()) {
				user = db.where("contactnumber=?", registrationDTO.getContactnumber()).results(UserCredentials.class);
				if (user.isEmpty()) {
					Address address = new Address();
					address.setDoornumber(registrationDTO.getDoornumber());
					address.setStreet(registrationDTO.getStreet());
					address.setCity(registrationDTO.getCity());
					address.setState(registrationDTO.getState());
					address.setPin(registrationDTO.getPin());
					address.setCountry(registrationDTO.getCountry());
					db.transaction(transaction).insert(address);
					UserCredentials userCredentials = new UserCredentials();
					userCredentials.setAddressid(address.getAddressid());
					userCredentials.setEmailid(registrationDTO.getEmailid());
					userCredentials.setContactnumber(registrationDTO.getContactnumber());
					userCredentials.setFname(registrationDTO.getFname());
					userCredentials.setLname(registrationDTO.getLname());
					userCredentials.setPassword(registrationDTO.getPassword());
					userCredentials.setServices(registrationDTO.getServices().toString());
					// StringBuilder services = new StringBuilder();
					// for (int i = 0; i < registrationDTO.getServices().size(); i++) {
					// String service = registrationDTO.getServices().get(i);
					// if (i == registrationDTO.getServices().size() - 1) {
					// services.append(service);
					// } else {
					// services.append(service).append(',');
					// }
					// }
					userCredentials.setServices(registrationDTO.getServices());

					userCredentials
							.setRoleid(db.where("role='STORE_KEEPER'").results(UserRoles.class).get(0).getRoleid());
					int rowEffected = db.transaction(transaction).insert(userCredentials).getRowsAffected();
					transaction.commit();
					return rowEffected;
				} else
					return -5;
			} else
				return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}
}
