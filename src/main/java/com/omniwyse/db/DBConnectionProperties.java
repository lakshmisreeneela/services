

package com.omniwyse.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBConnectionProperties {

    private final String host, port, user, password;

    @Autowired
    public DBConnectionProperties() {
         host = System.getenv().getOrDefault("service_db_host", "localhost");
            port = System.getenv().getOrDefault("service_db_port", "3306");
            user = System.getenv().getOrDefault("service_db_user", "vagrant");
            password = System.getenv().getOrDefault("service_db_password", "vagrant");
        }
    

    public String host() {
        return host;
    }

    public String port() {
        return port;
    }

    public String user() {
        return user;
    }

    public String password() {
        return password;
    }
}