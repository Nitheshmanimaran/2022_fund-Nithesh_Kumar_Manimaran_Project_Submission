package fr.epita.quiz.services;

import fr.epita.quiz.datamodel.OpenQuestion;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

import static java.lang.System.getProperties;

public class OpenQuestionDAO {

    public void create(Scanner sc) throws SQLException, IOException {

        System.out.println("Enter the question: ");
        String qText = sc.nextLine();
        System.out.println("Enter the question topic: ");
        String qTopic = sc.nextLine();
        System.out.println("Enter the question difficulty: ");
        String qDifficulty = sc.nextLine();
        System.out.println("Enter the question tip: ");
        String qTip = sc.nextLine();
        System.out.println("Enter the question correct answer: ");
        String qCorrectAnswer = sc.nextLine();
        try {
            //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quiz-manager-db", "postgres", "postgres");
            Connection connection = connect();
            String createOpenQuestion = "CREATE TABLE IF NOT EXISTS open_question (qid SERIAL PRIMARY KEY, qtext VARCHAR(255), qtopic VARCHAR(255), qdifficulty VARCHAR(255), qtip VARCHAR(255), qcorrectanswer VARCHAR(255))";
            String insertOpenQuestion = "INSERT INTO open_question (qtext, qtopic, qdifficulty, qtip, qcorrectanswer) VALUES ( ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(createOpenQuestion);
            ps.executeUpdate();
            PreparedStatement ps1 = connection.prepareStatement(insertOpenQuestion);
            ps1.setString(1, qText);
            ps1.setString(2, qTopic);
            ps1.setString(3, qDifficulty);
            ps1.setString(4, qTip);
            ps1.setString(5, qCorrectAnswer);
            ps1.executeUpdate();
            System.out.println("Open Question created successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public void delete(Scanner sc) throws SQLException, IOException {
        System.out.println("Enter the question id to delete: ");
        String qid = sc.nextLine();
        try {
            //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quiz-manager-db", "postgres", "postgres");
            Connection connection = connect();
            String deleteOpenQuestion = "DELETE FROM open_question WHERE qid = '" + qid + "'";
            Statement statement = connection.createStatement();
            statement.executeUpdate(deleteOpenQuestion);
            System.out.println("Open Question deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Scanner sc) throws IOException {
        System.out.println("Enter the question id to update: ");
        String qid = sc.nextLine();
        System.out.println("Enter the question: ");
        String qText = sc.nextLine();
        System.out.println("Enter the question topic: ");
        String qTopic = sc.nextLine();
        System.out.println("Enter the question difficulty: ");
        String qDifficulty = sc.nextLine();
        System.out.println("Enter the question tip: ");
        String qTip = sc.nextLine();
        System.out.println("Enter the question correct answer: ");
        String qCorrectAnswer = sc.nextLine();
        try {
            Connection connection = connect();
            //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quiz-manager-db", "postgres", "postgres");
            String updateOpenQuestion = "UPDATE open_question SET qtext = '" + qText + "', qtopic = '" + qTopic + "', qdifficulty = '" + qDifficulty + "', qtip = '" + qTip + "', qcorrectanswer = '" + qCorrectAnswer + "' WHERE qid = '" + qid + "'";
            Statement statement = connection.createStatement();
            statement.executeUpdate(updateOpenQuestion);
                        System.out.println("Open Question updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void search(Scanner sc) throws IOException {
        //Search by topic
        String topicQuery = "SELECT DISTINCT qtopic FROM open_question";
        try {
            Connection connection = connect();
            //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quiz-manager-db", "postgres", "postgres");
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
            Connection connection = connect();
            String searchMCQ = "SELECT qid,qtext FROM open_question WHERE qtopic = ?";
            PreparedStatement ps = connection.prepareStatement(searchMCQ);
            ps.setString(1, qtopic);
            ResultSet rs = ps.executeQuery();
            System.out.println("Available Questions for topic " + qtopic + ": ");
            while (rs.next()) {
                System.out.println("Question id: " + rs.getString("qid"));
                System.out.println("Question text: " + rs.getString("qtext"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //To get full question details
        System.out.println("Enter the question id to get full question details: ");
        Integer qid = Integer.valueOf(sc.nextLine());
        try {
            //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quiz-manager-db", "postgres", "postgres");
            Connection connection = connect();
            String getFullQuestionDetails = "SELECT * FROM open_question WHERE qid = ?";
            PreparedStatement ps = connection.prepareStatement(getFullQuestionDetails);
            ps.setInt(1, qid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Question id: " + rs.getString("qid"));
                System.out.println("Question text: " + rs.getString("qtext"));
                System.out.println("Question topic: " + rs.getString("qtopic"));
                System.out.println("Question difficulty: " + rs.getString("qdifficulty"));
                System.out.println("Question tip: " + rs.getString("qtip"));
                System.out.println("Question correct answer: " + rs.getString("qcorrectanswer"));
            }
            System.out.println("Open Question found successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //method to get all the open questions
    public static void getAllOpenQuestions() throws IOException {
        try {
            //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quiz-manager-db", "postgres", "postgres");
            Connection connection = connect();
            String getAllOpenQuestions = "SELECT qid,qtext FROM open_question order by qid";
            PreparedStatement ps = connection.prepareStatement(getAllOpenQuestions);
            ps.executeQuery();
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Question Id: " + rs.getString(1));
                System.out.println("Question: " + rs.getString(2));
                //System.out.println("Question Topic: " + rs.getString(3));
                //System.out.println("Question Difficulty: " + rs.getString(4));
                //System.out.println("Question Tip: " + rs.getString(5));
                //System.out.println("Question Correct Answer: " + rs.getString(6));

            }
            System.out.println("Open Questions found successfully");
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
        //To get all the topics
        try {
            //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quiz-manager-db", "postgres", "postgres");
            Connection connection = connect();
            String topicQuery = "SELECT DISTINCT qtopic FROM open_question";
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
        //gives the difficulty of the question
        try {
            //Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/quiz-manager-db", "postgres", "postgres");
            Connection connection = connect();
            String difficultyQuery = "SELECT DISTINCT qdifficulty FROM open_question";
            PreparedStatement ps = connection.prepareStatement(difficultyQuery);
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

