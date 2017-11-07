package com.omniwyse.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;
import com.omniwyse.db.DBFactory;
import com.omniwyse.models.UserCredentials;
import com.omniwyse.models.UserRoles;
import com.omniwyse.utils.LoginResponse;

@Service
public class LoginService {

    @Autowired
    private DBFactory database;

    private Database db;


    @Autowired
    private LoginResponse response;

    public LoginResponse getUser(UserCredentials userCredentials) {
    	
        db = database.getServiceDb();
        List<UserCredentials> user= db.where("emailid=? and password=?",userCredentials.getEmailid(),userCredentials.getPassword()).results(UserCredentials.class);
       if(!user.isEmpty())
       {
    	UserCredentials userdetails=user.get(0);
        String role = db.where("id=?", userdetails.getRoleid()).results(UserRoles.class).get(0).getRole();
        response.setUserrole(role);
        response.setUsername(userdetails.getEmailid());
        response.setUserId(userdetails.getId());
        response.setStatus(200);
       }
       return response;
}
}
