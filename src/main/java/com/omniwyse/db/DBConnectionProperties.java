
package com.omniwyse.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBConnectionProperties {

	private final String host, port, user, password;

	@Autowired

	public DBConnectionProperties() {

		if (System.getenv("services_db_host") != null) {

			host = System.getenv().getOrDefault("services_db_host", System.getenv("services_db_host"));
			port = System.getenv().getOrDefault("services_db_port", System.getenv("services_db_port"));
			user = System.getenv().getOrDefault("services_db_user", System.getenv("services_db_user"));
			password = System.getenv().getOrDefault("services_db_password", System.getenv("services_db_password"));

		} else {

			host = System.getenv().getOrDefault("services_db_host", "localhost");
			port = System.getenv().getOrDefault("services_db_host", "3306");
			user = System.getenv().getOrDefault("services_db_host", "root");
			password = System.getenv().getOrDefault("services_db_host", "root");

		}

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