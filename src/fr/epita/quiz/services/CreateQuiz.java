package fr.epita.quiz.services;

import fr.epita.quiz.datamodel.MCQQuestion;
import fr.epita.quiz.datamodel.MCQQuiz;
import fr.epita.quiz.datamodel.OpenQuiz;
import fr.epita.quiz.datamodel.Options;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

public class CreateQuiz {
    //Method to create a quiz with Open Questions
    public static ArrayList<OpenQuiz> createOpenQuiz(String title) throws SQLException {
        //getting all questions from the database

        ArrayList<OpenQuiz> questions = new ArrayList<OpenQuiz>();
        //Query to get all questions from the database
        String query = "SELECT * FROM open_question WHERE qtopic = '" + title + "'";
        //Connecting to the database
        Connection connect = connect();
        //Creating a statement to execute the query
        Statement stmt = connect.createStatement();
        //Executing the query
        ResultSet rs = stmt.executeQuery(query);
        //Looping through the resultset to get all the questions
        while (rs.next()) {
            OpenQuiz question = new OpenQuiz();
            question.setqId(rs.getString("qid"));
            question.setqText(rs.getString("qtext"));
            question.setqTopic(rs.getString("qtopic"));
            question.setqDifficulty(rs.getString("qdifficulty"));
            question.setqCorrectAnswer(rs.getString("qcorrectanswer"));
            question.setqTip(rs.getString("qtip"));
            questions.add(question);
        }
        return questions;
    }
    //Method to create a quiz with MCQ Questions
    public static ArrayList<MCQQuiz> createMCQQuiz(String topic) throws SQLException {
        //getting all the questions from the database
        ArrayList<MCQQuiz> questions = new ArrayList<>();
        //Query to get all the questions from the database
        String query = "SELECT * FROM mcq_question WHERE qtopic = '" + topic + "'";
        //Connecting to the database
        Connection connect = connect();
        //Creating a statement to execute the query
        Statement statement = connect.createStatement();
        //Executing the query
        ResultSet rs = statement.executeQuery(query);
        //Looping through the resultset to get all the questions
        while (rs.next()) {
            MCQQuiz obj = new MCQQuiz();
            //Settinng the values
            obj.setqId(rs.getString("qid"));
            obj.setqText(rs.getString("qtext"));
            obj.setqTopic(rs.getString("qtopic"));
            obj.setqDifficulty(rs.getString("qdifficulty"));
            obj.setqCorrectAnswer(rs.getString("qcorrectanswer"));
            obj.setqWrongAnswer1(rs.getString("qwronganswer1"));
            obj.setqWrongAnswer2(rs.getString("qwronganswer2"));
            obj.setqWrongAnswer3(rs.getString("qwronganswer3"));
            //Adding the question to the arraylist
            Options opt1 = new Options();
            opt1.setTitle(rs.getString("qcorrectanswer"));
            opt1.setCorrect(true);
            Options opt2 = new Options();
            opt2.setTitle(rs.getString("qwronganswer1"));
            opt2.setCorrect(false);
            Options opt3 = new Options();
            opt3.setTitle(rs.getString("qwronganswer2"));
            opt3.setCorrect(false);
            Options opt4 = new Options();
            opt4.setTitle(rs.getString("qwronganswer3"));
            opt4.setCorrect(false);
            ArrayList<Options> options = new ArrayList<>();
            options.add(opt1);
            options.add(opt2);
            options.add(opt3);
            options.add(opt4);
            Collections.shuffle(options);
            obj.setOptions(options);
            questions.add(obj);
        }
        return questions;

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
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
    //Method to create a quiz with MCQ Questions
    public static ArrayList<MCQQuiz> createMCQQuiz_difficult(String difficulty) throws SQLException {
        //getting all the questions from the database
        ArrayList<MCQQuiz> questions = new ArrayList<>();
        //Query to get all the questions from the database
        String query = "SELECT * FROM mcq_question WHERE qdifficulty = '" + difficulty + "'";
        //Connecting to the database
        Connection connect = connect();
        Statement statement = null;
        try {
            //Creating a statement to execute the query
            statement = connect.createStatement();
            //Executing the query
            ResultSet rs = statement.executeQuery(query);
            //Looping through the resultset to get all the questions
            while (rs.next()) {
                MCQQuiz obj = new MCQQuiz();
                obj.setqId(rs.getString("qid"));
                obj.setqText(rs.getString("qtext"));
                obj.setqTopic(rs.getString("qtopic"));
                obj.setqDifficulty(rs.getString("qdifficulty"));
                obj.setqCorrectAnswer(rs.getString("qcorrectanswer"));
                obj.setqWrongAnswer1(rs.getString("qwronganswer1"));
                obj.setqWrongAnswer2(rs.getString("qwronganswer2"));
                obj.setqWrongAnswer3(rs.getString("qwronganswer3"));
                Options opt1 = new Options();
                opt1.setTitle(rs.getString("qcorrectanswer"));
                opt1.setCorrect(true);
                Options opt2 = new Options();
                opt2.setTitle(rs.getString("qwronganswer1"));
                opt2.setCorrect(false);
                Options opt3 = new Options();
                opt3.setTitle(rs.getString("qwronganswer2"));
                opt3.setCorrect(false);
                Options opt4 = new Options();
                opt4.setTitle(rs.getString("qwronganswer3"));
                opt4.setCorrect(false);
                ArrayList<Options> options = new ArrayList<>();
                options.add(opt1);
                options.add(opt2);
                options.add(opt3);
                options.add(opt4);
                Collections.shuffle(options);
                obj.setOptions(options);
                questions.add(obj);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return questions;
    }
    //create openquiz by difficulty
    public static ArrayList<OpenQuiz> createOpenQuiz_difficult(String difficulty) throws SQLException {
        //getting all the questions from the database
        ArrayList<OpenQuiz> questions = new ArrayList<>();
        //Query to get all the questions from the database
        String query = "SELECT * FROM open_question WHERE qdifficulty = '" + difficulty + "'";
        //Connecting to the database
        Connection connect = connect();
        //Creating a statement to execute the query
        Statement statement = null;
        try {
            statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                OpenQuiz obj = new OpenQuiz();
                obj.setqId(rs.getString("qid"));
                obj.setqText(rs.getString("qtext"));
                obj.setqTopic(rs.getString("qtopic"));
                obj.setqDifficulty(rs.getString("qdifficulty"));
                obj.setqCorrectAnswer(rs.getString("qcorrectanswer"));
                obj.setqTip(rs.getString("qtip"));
                questions.add(obj);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return questions;
    }
}