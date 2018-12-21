package com.site.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Locale;
import java.util.Properties;

public class DataBaseConnector {

    private String url;
    private String userName;
    private String password;

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void loadProperties(){
        Properties properties = new Properties();
        try {
            properties.load(DataBaseConnector.class.getClassLoader().getResourceAsStream("application.properties"));
            url = properties.getProperty("url");
            userName = properties.getProperty("name");
            password = properties.getProperty("pass");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void connect() {
        loadProperties();
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }

        try {

            connection = DriverManager.getConnection(url, userName, password);
            Locale.setDefault(Locale.ENGLISH);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
