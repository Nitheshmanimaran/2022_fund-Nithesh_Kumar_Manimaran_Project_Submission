package fr.epita.quiz.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class StudentLogin {

    public boolean login(String username, String password) throws SQLException {
        //query to get the student details from the database
        String authenticationQuery = "SELECT * FROM student WHERE name = ? AND password = ?";
        //Check the entered username and password against the database
        //If they match, return true
        //If they don't match, return false
        Connection connection = connect();
        PreparedStatement statement = connection.prepareStatement(authenticationQuery);
        statement.setString(1, username);
        statement.setString(2, password);
        ResultSet resultSet = statement.executeQuery();
        //If the result set is empty, return false
        if (resultSet.next()) {
            return true;
        } else {
            return false;
        }
    }
    private static Properties getdbProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("./database.properties"));
        } catch (IOException e) {
            System.out.println("Sorry, the program is not finding the required files, check your setup " +
                    "(authentication is not possible)");
            return null;
        }
        return properties;
    }

    //Method to connect to the database

    private static Connection connect() throws SQLException {
        Properties properties = getdbProperties();
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("dbpassword");
        Connection connection  = DriverManager.getConnection(url, user, password);
        return connection;
    }
}

