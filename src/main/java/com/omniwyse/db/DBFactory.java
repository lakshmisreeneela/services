package com.omniwyse.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dieselpoint.norm.Database;

@Service
public class DBFactory {


    private final DBConnectionProperties dbProperties;
    private final Database serviceDB;

    @Autowired
    public DBFactory(DBConnectionProperties dbProperties) {
        this.dbProperties = dbProperties;
        System.setProperty("norm.jdbcUrl", dbUrl("service"));
        System.setProperty("norm.user", dbProperties.user());
        System.setProperty("norm.password", dbProperties.password());
        serviceDB = new Database();
    }



    public Database getServiceDb() {
        return serviceDB;
    }

    private String dbUrl(String schema) {
        return "jdbc:mysql://" + dbProperties.host() + ":" + dbProperties.port() + "/" + schema + "?useSSL=false";
    }


}