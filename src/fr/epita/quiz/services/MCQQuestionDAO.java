package fr.epita.quiz.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

import static java.lang.System.getProperties;

public class MCQQuestionDAO {
    //MCQQuestion Table Creation and Insertion
    public void create(Scanner sc) throws IOException {

        System.out.println("Enter the question");
        String qtext = sc.nextLine();
        System.out.println("Enter the question topic: ");
        String qtopic = sc.nextLine();
        System.out.println("Enter the question difficulty: ");
        String qdifficulty = sc.nextLine();
        System.out.println("Enter the question answer: ");
        String qCorrectAnswer = sc.nextLine();
        System.out.println("Enter the question choice 1: ");
        String qWrongAnswer1 = sc.nextLine();
        System.out.println("Enter the question choice 2: ");
        String qWrongAnswer2 = sc.nextLine();
        System.out.println("Enter the question choice 3: ");
        String qWrongAnswer3 = sc.nextLine();


        try {
            //connecting to the database
            Connection connection = connect();
            //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quiz-manager-db", "postgres", "postgres");
            String createMCQ = "CREATE TABLE IF NOT EXISTS mcq_question (qid SERIAL PRIMARY KEY, qtext VARCHAR(255), qtopic VARCHAR(255), qdifficulty VARCHAR(255), qcorrectanswer VARCHAR(255), qwronganswer1 VARCHAR(255), qwronganswer2 VARCHAR(255), qwronganswer3 VARCHAR(255))";
            String insertMCQ = "INSERT INTO mcq_question (qtext, qtopic, qdifficulty, qcorrectanswer, qwronganswer1, qwronganswer2, qwronganswer3) VALUES (?, ?, ?, ?, ?, ?, ?)";
            //Creating a statement to execute the query
            PreparedStatement ps = connection.prepareStatement(createMCQ);
            ps.executeUpdate();

            PreparedStatement ps1 = connection.prepareStatement(insertMCQ);
            ps1.setString(1, qtext);
            ps1.setString(2, qtopic);
            ps1.setString(3, qdifficulty);
            ps1.setString(4, qCorrectAnswer);
            ps1.setString(5, qWrongAnswer1);
            ps1.setString(6, qWrongAnswer2);
            ps1.setString(7, qWrongAnswer3);
            ps1.executeUpdate();
            System.out.println("MCQ Question created successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //MCQQuestion Table Deletion
    public void delete(Scanner sc) throws IOException {

        System.out.println("Enter the question id to be deleted: ");
        String qid = sc.nextLine();
        try {
            //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quiz-manager-db", "postgres", "postgres");
            //Delete from MCQQuestions
            //connecting to the database
            Connection connection = connect();
            //query to delete the question
            String deleteMCQ = "DELETE FROM mcq_question WHERE qId = '" + qid + "'";
            Statement statement = connection.createStatement();
            statement.executeUpdate(deleteMCQ);
            System.out.println("MCQ Question deleted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //MCQQuestion Table Update
    public void update(Scanner sc) throws IOException {
        System.out.println("Enter the question id to be updated: ");
        String qid = sc.nextLine();
        System.out.println("Enter the question");
        String qtext = sc.nextLine();
        System.out.println("Enter the question topic: ");
        String qtopic = sc.nextLine();
        System.out.println("Enter the question difficulty: ");
        String qdifficulty = sc.nextLine();
        System.out.println("Enter the question answer: ");
        String qCorrectAnswer = sc.nextLine();
        System.out.println("Enter the question choice 1: ");
        String qWrongAnswer1 = sc.nextLine();
        System.out.println("Enter the question choice 2: ");
        String qWrongAnswer2 = sc.nextLine();
        System.out.println("Enter the question choice 3: ");
        String qWrongAnswer3 = sc.nextLine();
        try {
            //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quiz-manager-db", "postgres", "postgres");
            //Update MCQQuestions
            //connecting to the database
            Connection connection = connect();
            //query to update the question
            String updateMCQ = "UPDATE mcq_question SET qtext = '" + qtext + "', qtopic = '" + qtopic + "', qdifficulty = '" + qdifficulty + "', qcorrectanswer = '" + qCorrectAnswer + "', qwronganswer1 = '" + qWrongAnswer1 + "', qwronganswer2 = '" + qWrongAnswer2 + "', qwronganswer3 = '" + qWrongAnswer3 + "' WHERE qid = '" + qid + "'";
            Statement statement = connection.createStatement();
            statement.executeUpdate(updateMCQ);
            System.out.println("MCQ Question updated successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //MCQQuestion Question Search
    public static void search(Scanner sc) throws IOException {
        //Search using the Topic in Database
        //query to search the question
        String topicQuery = "SELECT DISTINCT qtopic FROM mcq_question";
        try {
            //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quiz-manager-db", "postgres", "postgres");
            //connecting to the database
            Connection connection = connect();
            PreparedStatement ps = connection.prepareStatement(topicQuery);
            ResultSet rs = ps.executeQuery();
            System.out.println("Available Topics: ");
            while (rs.next()) {
                System.out.println(rs.getString("qtopic"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

        System.out.println("Enter the question topic to be searched: ");
        String qtopic = sc.nextLine();
        try {
            //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quiz-manager-db", "postgres", "postgres");
            //connecting to the database
            Connection connection = connect();
            //query to search the question
            String searchMCQ = "SELECT qid,qText FROM mcq_question WHERE qtopic = ?";
            PreparedStatement ps = connection.prepareStatement(searchMCQ);
            ps.setString(1, qtopic);
            ResultSet rs = ps.executeQuery();
            System.out.println("Available Questions in " + qtopic + ": ");
            while (rs.next()) {
                System.out.println("Question Id: " + rs.getString("qid"));
                System.out.println("Question Text: " + rs.getString("qtext"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //to get the complete question details
        System.out.println("Enter the question id to be searched: ");
        Integer qid = Integer.valueOf(sc.nextLine());

        try {
            //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quiz-manager-db", "postgres", "postgres");
            Connection connection = connect();
            //query to search the question
            String searchMCQ = "SELECT * FROM mcq_question WHERE qid = ?";
            PreparedStatement ps = connection.prepareStatement(searchMCQ);
            ps.setInt(1, qid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Question Id: " + rs.getString("qid"));
                System.out.println("Question Text: " + rs.getString("qtext"));
                System.out.println("Question Topic: " + rs.getString("qtopic"));
                System.out.println("Question Difficulty: " + rs.getString("qdifficulty"));
                System.out.println("Question Correct Answer: " + rs.getString("qcorrectanswer"));
                System.out.println("Question Wrong Answer 1: " + rs.getString("qwronganswer1"));
                System.out.println("Question Wrong Answer 2: " + rs.getString("qwronganswer2"));
                System.out.println("Question Wrong Answer 3: " + rs.getString("qwronganswer3"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Method to display all MCQQuestions
    public static void displayAll() {
        try {
            //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quiz-manager-db", "postgres", "postgres");
            //Display all MCQQuestions
            Connection connection = connect();
            String displayMCQ = "SELECT qid,qtext FROM mcq_question order by qid";
            PreparedStatement ps = connection.prepareStatement(displayMCQ);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Question id: " + rs.getString("qid"));
                System.out.println("Question text: " + rs.getString("qtext"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Reading url,uer and dbpassword from properties file
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

    public void topicgiver(){
        try {
            //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quiz-manager-db", "postgres", "postgres");
            Connection connection = connect();
            String topicQuery = "SELECT DISTINCT qtopic FROM mcq_question";
            PreparedStatement ps = connection.prepareStatement(topicQuery);
            ResultSet rs = ps.executeQuery();
            System.out.println("Available Topics: ");
            while (rs.next()) {
                System.out.println(rs.getString("qtopic"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    public void difficultygiver(){
        try {
            //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quiz-manager-db", "postgres", "postgres");
            Connection connection = connect();
            String topicQuery = "SELECT DISTINCT qdifficulty FROM mcq_question order by qdifficulty";
            PreparedStatement ps = connection.prepareStatement(topicQuery);
            ResultSet rs = ps.executeQuery();
            System.out.println("Available Difficulty: ");
            while (rs.next()) {
                System.out.println(rs.getString("qdifficulty"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }


}