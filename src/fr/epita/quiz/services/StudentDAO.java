package fr.epita.quiz.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class StudentDAO {
    public void createStudent() throws SQLException {
        //Getting the properties file
        //Connecting to the database
        Connection connection = connect();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter student name");
        String name = scan.nextLine();
        System.out.println("Enter student password");
        String password = scan.nextLine();
        //Query to Create a student table
        //Query to insert the student into the database
        String createStudentTable = "CREATE TABLE IF NOT EXISTS student (id SERIAL PRIMARY KEY , name VARCHAR(255), password VARCHAR(255))";
        String insertStudent = "INSERT INTO student (name, password) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(createStudentTable);
        statement.executeUpdate();
        PreparedStatement statement1 = connection.prepareStatement(insertStudent);
        statement1.setString(1, name);
        statement1.setString(2, password);
        statement1.executeUpdate();
        System.out.println("Student created successfully");
    }


    public void readStudent() {
        try {
            //Getting the properties file
            //Connecting to the database
            Connection con = connect();
            System.out.println("Enter student id to read details of student");
            Scanner scan = new Scanner(System.in);
            String id = scan.nextLine();
            //Query to read the student details
            String query = "SELECT * FROM student WHERE id = " + id;
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                System.out.println("Student id: " + rs.getInt("id"));
                System.out.println("Student name: " + rs.getString("name"));
                System.out.println("Student password: " + rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent () {
        try {
            //Getting the properties file
            //Connecting to the database
            Scanner scan = new Scanner(System.in);
            Connection con = connect();
            Statement stmt = con.createStatement();
            System.out.println("Enter student id to update");
            int id = Integer.parseInt(scan.nextLine());
            System.out.println("Enter student name");
            String name = scan.nextLine();
            System.out.println("Enter student password");
            String password = scan.nextLine();
            //Query to update the student details
            String query = "UPDATE student SET name = '" + name + "', password = '" + password + "' WHERE id = " + id;
            stmt.executeUpdate(query);
            System.out.println("Student updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent () {
        try {
            //Getting the properties file
            //Connecting to the database
            Scanner scan = new Scanner(System.in);
            Connection con = connect();
            Statement stmt = con.createStatement();
            System.out.println("Enter student id to delete");
            int id = Integer.parseInt(scan.nextLine());
            //Query to delete the student details
            String query = "DELETE FROM student WHERE id = " + id;
            stmt.executeUpdate(query);
            System.out.println("Student deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
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
    private static Connection connect() throws SQLException {
        Properties properties = getdbProperties();
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("dbpassword");
        Connection connection  = DriverManager.getConnection(url, user, password);
        return connection;
    }

    }


