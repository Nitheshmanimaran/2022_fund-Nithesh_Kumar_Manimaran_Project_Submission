package fr.epita.quiz.launcher;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import fr.epita.quiz.datamodel.MCQQuiz;
import fr.epita.quiz.datamodel.OpenQuiz;
import fr.epita.quiz.datamodel.Options;
import fr.epita.quiz.services.*;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import static java.lang.System.getProperties;

public class Main {
    public static void main(String[] args) throws IOException, SQLException, DocumentException {
        //Welcome Screen
        String menuResponse="";
        //While loop to keep the program running until the user decides to exit
        while(!menuResponse.equals("exit")){
            System.out.println("Welcome to the Quiz Application");
            System.out.println("1. Admin - Enter 1 for Admin To perform CRUD Operations");
            System.out.println("2. Student - Enter 2 for  Student To Take a Quiz");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            Scanner scan = new Scanner(System.in);
            //Setting the menuResponse to the user's choice
            String choice = scan.nextLine();
            int choiceInt = Integer.parseInt(choice);
            //Setting menuresponse to exit if the user chooses to exit
            if(choiceInt==3){menuResponse="exit";}
            //Welcome Screen Switch Statement
            switch (choiceInt) {
                case 1:
                    //Admin
                    //Authentication for Admin
                    System.out.println("Enter the Admin Username");
                    String username = scan.nextLine();
                    System.out.println("Enter the Admin Password");
                    String password = scan.nextLine();
                    //Getting the properties file
                    Properties properties =  getProperties();
                    if (properties == null){
                        System.out.println("Error in preading properties file");
                        return;
                    }
                    //Getting the admin username and password from the properties file
                    String defaultusername = properties.getProperty("userName");
                    String defaultpassword = properties.getProperty("password");
                    boolean authenticated = username.equals(defaultusername)
                            && password.equals(defaultpassword);
                    if (!authenticated) {
                        // we leave
                        System.out.println("not authenticated, bye!");
                        return;
                    }
                    System.out.println("credentials ok, welcome!");
                    //Admin menu screen
                    String adminResponse = "";
                    //While loop to keep the program running until the user decides to exit
                    while (!adminResponse.equals("exit")){
                        System.out.println("1. Create a question");
                        System.out.println("2. Delete a question");
                        System.out.println("3. Update a question")  ;
                        System.out.println("4. Read question");
                        System.out.println("5. Search a question");
                        System.out.println("6. Export a quiz as plain text");
                        System.out.println("7. Export a quiz as pdf");
                        System.out.println("8. To Perform CRUD Operations on a Student");
                        System.out.println("0. Exit");

                        //admin choice
                        System.out.println("Enter your choice : ");
                        //Setting the choice
                        String adminChoice = scan.nextLine();
                        int adminChoiceInt = Integer.parseInt(adminChoice);
                        //Setting adminResponse to exit if the user chooses to exit
                        if (adminChoiceInt == 0) {
                            adminResponse = "exit";
                        }
                        //Admin menu screen switch statement
                        switch (adminChoiceInt){
                            case 1:
                                //Creating a question
                                String adminResponse1 = "";
                                while (!adminResponse1.equals("exit")) {
                                    System.out.println("Select which type of question you want to create : ");
                                    System.out.println("1. MCQ");
                                    System.out.println("2. Open");
                                    System.out.println("3. Exit");
                                    System.out.println("Enter your choice : ");
                                    String adminChoice1 = scan.nextLine();
                                    int adminChoiceInt1 = Integer.parseInt(adminChoice1);
                                    if (adminChoiceInt1 == 3) {adminResponse1 = "exit";}
                                    //Type of question switch statement
                                    switch(adminChoiceInt1){
                                        case 1:
                                            //Creating a MCQ Question
                                            MCQQuestionDAO createDAO = new MCQQuestionDAO();
                                            createDAO.create(scan);
                                            break;
                                        case 2:
                                            //Creating a Open Question
                                            OpenQuestionDAO openQuestionDAO = new OpenQuestionDAO();
                                            openQuestionDAO.create(scan);
                                            break;
                                        default:
                                            System.out.println("Invalid Choice");
                                            break;
                                    }
                                }
                                break;
                            case 2:
                                //Delete a question
                                String adminResponse2 = "";
                                //While loop to keep the program running until the user decides to exit
                                while (!adminResponse2.equals("exit")) {
                                    System.out.println("Select which type of question you want to delete : ");
                                    System.out.println("1. MCQ");
                                    System.out.println("2. Open");
                                    System.out.println("3. Exit");
                                    System.out.println("Enter your choice : ");
                                    String adminChoice2 = scan.nextLine();
                                    int adminChoiceInt2 = Integer.parseInt(adminChoice2);
                                    if (adminChoiceInt2 == 3) {adminResponse2 = "exit";}
                                    //Type of question switch statement
                                    switch(adminChoiceInt2){
                                        case 1:
                                            //Deleting a MCQ Question
                                            MCQQuestionDAO deleteDAO = new MCQQuestionDAO();
                                            deleteDAO.delete(scan);
                                            break;
                                        case 2:
                                            //Deleting a Open Question
                                            OpenQuestionDAO openQuestionDAO = new OpenQuestionDAO();
                                            openQuestionDAO.delete(scan);
                                            break;
                                        default:
                                            System.out.println("Invalid Choice");
                                            break;
                                    }
                                }
                                break;
                            case 3:
                                //Update a Question
                                String adminResponse3 = "";
                                //While loop to keep the program running until the user decides to exit
                                while (!adminResponse3.equals("exit")) {
                                    System.out.println("Select which type of question you want to update : ");
                                    System.out.println("1. MCQ");
                                    System.out.println("2. Open");
                                    System.out.println("3. Exit");
                                    System.out.println("Enter your choice : ");
                                    String adminChoice3 = scan.nextLine();
                                    int adminChoiceInt3 = Integer.parseInt(adminChoice3);
                                    if (adminChoiceInt3 == 3) {adminResponse3 = "exit";}
                                    //Type of question switch statement
                                    switch(adminChoiceInt3){
                                        case 1:
                                            //Updating a MCQ Question
                                            MCQQuestionDAO updateDAO = new MCQQuestionDAO();
                                            updateDAO.update(scan);
                                            break;
                                        case 2:
                                            //Updating a Open Question
                                            OpenQuestionDAO openQuestionDAO = new OpenQuestionDAO();
                                            openQuestionDAO.update(scan);
                                            break;
                                        default:
                                            System.out.println("Invalid Choice");
                                            break;
                                    }
                                }
                            case 4:
                                //Read question
                                String adminResponse4 = "";
                                //While loop to keep the program running until the user decides to exit
                                while(!adminResponse4.equals("exit")) {
                                    System.out.println("Select which type of question you want to read : ");
                                    System.out.println("1. MCQ");
                                    System.out.println("2. Open");
                                    System.out.println("3. Exit");
                                    System.out.println("Enter your choice : ");
                                    String adminChoice4 = scan.nextLine();
                                    int adminChoiceInt4 = Integer.parseInt(adminChoice4);
                                    if (adminChoiceInt4 == 3) {adminResponse4 = "exit";}
                                    //Type of question switch statement
                                    switch (adminChoiceInt4) {
                                        case 1:
                                            //MCQ
                                            //Reading a MCQ Question
                                            MCQQuestionDAO readDAO = new MCQQuestionDAO();
                                            readDAO.displayAll();
                                            break;
                                        case 2:
                                            //Open
                                            //Reading a Open Question
                                            OpenQuestionDAO openQuestionDAO = new OpenQuestionDAO();
                                            openQuestionDAO.getAllOpenQuestions();
                                            break;
                                        default:
                                            System.out.println("Invalid choice");
                                            break;
                                    }
                                }
                                break;
                            case 5:
                                //Search a question by Topic
                                String adminResponse5 = "";
                                //While loop to keep the program running until the user decides to exit
                                while (!adminResponse5.equals("exit")) {
                                    System.out.println("Select which type of question you want to search : ");
                                    System.out.println("1. MCQ");
                                    System.out.println("2. Open");
                                    System.out.println("3. Exit");
                                    System.out.println("Enter your choice : ");
                                    String adminChoice5 = scan.nextLine();
                                    int adminChoiceInt5 = Integer.parseInt(adminChoice5);
                                    if (adminChoiceInt5 == 3) {adminResponse5 = "exit";}
                                    //Type of question switch statement
                                    switch(adminChoiceInt5){
                                        case 1:
                                            //Searching a MCQ Question
                                            MCQQuestionDAO searchDAO = new MCQQuestionDAO();
                                            searchDAO.search(scan);
                                            break;
                                        case 2:
                                            //Searching a Open Question
                                            OpenQuestionDAO openQuestionDAO = new OpenQuestionDAO();
                                            openQuestionDAO.search(scan);
                                            break;
                                        default:
                                            System.out.println("Invalid Choice");
                                            break;
                                    }
                                }
                                break;
                            case 6:
                                //Exporting a quiz to txt file
                                String adminResponse6 = "";
                                //While loop to keep the program running until the user decides to exit
                                while(!adminResponse6.equals("exit")) {
                                    System.out.println("Select which type of question you want to export : ");
                                    System.out.println("1. MCQ");
                                    System.out.println("2. Open");
                                    System.out.println("3. Exit");
                                    System.out.println("Enter your choice : ");
                                    String adminChoice6 = scan.nextLine();
                                    int adminChoiceInt6 = Integer.parseInt(adminChoice6);
                                    if (adminChoiceInt6 == 3) {adminResponse6 = "exit";}
                                    //Type of question switch statement
                                    switch (adminChoiceInt6) {
                                        case 1:
                                            //MCQ
                                            CreateQuiz createQuiz = new CreateQuiz();
                                            //Available Topics
                                            MCQQuestionDAO takeDAO = new MCQQuestionDAO();
                                            takeDAO.topicgiver();
                                            System.out.println("Enter the topic of the quiz you want to export: ");
                                            String topic = scan.nextLine();
                                            ArrayList<MCQQuiz> questions = CreateQuiz.createMCQQuiz(topic);
                                            //Asking the admin to enter the name of the file
                                            System.out.println("Enter the name of the file without extension (i.e. without .txt) : ");
                                            String fileName = scan.nextLine();
                                            fileName = fileName + ".txt";
                                            String filePath = getProperties().getProperty("filePath") + fileName;
                                            //Create the file
                                            File file = new File(filePath);
                                            FileOutputStream fos = new FileOutputStream(file);
                                            PrintWriter pw = new PrintWriter(fos);
                                            pw.println("MCQ Quiz" + "\n" + "Topic: " + topic + "\n" + "\n");
                                            int i = 0;
                                            int j = 0;
                                            //Loop to print the questions and answers
                                            for (MCQQuiz question : questions) {
                                                i++;
                                                pw.println("Question-" + i + ". " + question.getqText() + "\n");
                                                for (Options options : question.getOptions()) {
                                                    j++;
                                                    pw.println("Option." + j + "." + options.getTitle());
                                                }
                                                j = 0;
                                                pw.println("\n");
                                            }
                                            //Close the file
                                            pw.flush();
                                            pw.close();
                                            System.out.println("Quiz exported to file successfully");

                                            break;
                                        case 2:
                                            //OpenQuestion
                                            CreateQuiz createQuiz1 = new CreateQuiz();
                                            //Available Topics
                                            OpenQuestionDAO takeDAO1 = new OpenQuestionDAO();
                                            takeDAO1.topicgiver();
                                            System.out.println("Enter the topic of the quiz you want to export: ");
                                            String topic1 = scan.nextLine();
                                            ArrayList<OpenQuiz> questions1 = CreateQuiz.createOpenQuiz(topic1);
                                            //Asking the admin to enter the name of the file
                                            System.out.println("Enter the name of the file without extension (i.e. without .txt) : ");
                                            String fileName1 = scan.nextLine();
                                            fileName1 = fileName1 + ".txt";
                                            String filePath1 = getProperties().getProperty("filePath") + fileName1;
                                            //Create the file
                                            File file1 = new File(filePath1);
                                            FileOutputStream fos1 = new FileOutputStream(file1);
                                            PrintWriter pw1 = new PrintWriter(fos1);
                                            pw1.println("Open Quiz" + "\n" + "Topic: " + topic1 + "\n" + "\n");
                                            int i1 = 0;
                                            int j1 = 0;
                                            //Loop to print the questions and answers
                                            for (OpenQuiz question : questions1) {
                                                i1++;
                                                pw1.println("Question-" + i1 + ". " + question.getqText() + "\n");
                                                //Displaying the Question Tip
                                                pw1.println("Question Tip: " + question.getqTip() + "\n");
                                                pw1.println("\n");
                                            }
                                            //Close the file
                                            pw1.flush();
                                            pw1.close();
                                            System.out.println("Quiz exported to file successfully");


                                            break;
                                        default:
                                            System.out.println("Invalid choice");
                                            break;
                                    }
                                }
                                break;
                            case 7:
                                //Exporting a quiz to pdf file
                                String adminResponse7 = "";
                                //While loop to keep the program running until the user decides to exit
                                while(!adminResponse7.equals("exit")) {
                                    System.out.println("Select which type of question you want to export : ");
                                    System.out.println("1. MCQ");
                                    System.out.println("2. Open");
                                    System.out.println("3. Exit");
                                    System.out.println("Enter your choice : ");
                                    String adminChoice7 = scan.nextLine();
                                    int adminChoiceInt7 = Integer.parseInt(adminChoice7);
                                    if (adminChoiceInt7 == 3) {adminResponse7 = "exit";}
                                    //Type of question switch statement
                                    switch (adminChoiceInt7) {
                                        case 1:
                                            //MCQ
                                            CreateQuiz createQuiz = new CreateQuiz();
                                            //Available Topics
                                            MCQQuestionDAO takeDAO = new MCQQuestionDAO();
                                            takeDAO.topicgiver();
                                            System.out.println("Enter the topic of the quiz you want to export: ");
                                            String topic = scan.nextLine();
                                            ArrayList<MCQQuiz> questions = CreateQuiz.createMCQQuiz(topic);
                                            //Asking the admin to enter the name of the file
                                            System.out.println("Enter the name of the file without extension (i.e. without .pdf) : ");
                                            String fileName = scan.nextLine();
                                            fileName = fileName + ".pdf";
                                            String filePath = getProperties().getProperty("filePath") + fileName;
                                            //Create the file
                                            Document document = new Document();
                                            File file = new File(filePath);
                                            FileOutputStream fos = new FileOutputStream(file);
                                            PdfWriter.getInstance(document, fos);
                                            document.open();
                                            document.add(new Paragraph("MCQ Quiz" + "\n" + "Topic: " + topic + "\n" + "\n"));
                                            int i = 0;
                                            int j = 0;
                                            //Loop to print the questions and answers
                                            for (MCQQuiz question : questions) {
                                                i++;
                                                document.add(new Paragraph("Question-" + i + ". " + question.getqText() + "\n"));
                                                for (Options options : question.getOptions()) {
                                                    j++;
                                                    document.add(new Paragraph("Option." + j + "." + options.getTitle()));
                                                }
                                                j = 0;
                                                document.add(new Paragraph("\n"));
                                            }
                                            //Close the file
                                            document.close();
                                            fos.flush();
                                            fos.close();
                                            System.out.println("Quiz exported to file successfully");
                                            break;
                                        case 2:
                                            //OpenQuestion
                                            CreateQuiz createQuiz1 = new CreateQuiz();
                                            //Available Topics
                                            OpenQuestionDAO takeDAO1 = new OpenQuestionDAO();
                                            takeDAO1.topicgiver();
                                            System.out.println("Enter the topic of the quiz you want to export: ");
                                            String topic1 = scan.nextLine();
                                            ArrayList<OpenQuiz> questions1 = CreateQuiz.createOpenQuiz(topic1);
                                            //Asking the admin to enter the name of the file
                                            System.out.println("Enter the name of the file without extension (i.e. without .pdf) : ");
                                            String fileName1 = scan.nextLine();
                                            fileName1 = fileName1 + ".pdf";
                                            String filePath1 = getProperties().getProperty("filePath") + fileName1;
                                            //Create the file
                                            Document document1 = new Document();
                                            File file1 = new File(filePath1);
                                            FileOutputStream fos1 = new FileOutputStream(file1);
                                            PdfWriter.getInstance(document1, fos1);
                                            document1.open();
                                            document1.add(new Paragraph("Open Quiz" + "\n" + "Topic: " + topic1 + "\n" + "\n"));
                                            int i1 = 0;
                                            //Loop to print the questions and answers
                                            for (OpenQuiz question : questions1) {
                                                i1++;
                                                document1.add(new Paragraph("Question-" + i1 + ". " + question.getqText() + "\n"));
                                                //Displaying the Question Tip
                                                document1.add(new Paragraph("Question Tip: " + question.getqTip() + "\n"));
                                                document1.add(new Paragraph("\n"));
                                            }
                                            break;
                                    }
                                }
                                break;

                            case 8:
                                //CRUD operations on a Student
                                String adminResponse8 = "";
                                //While loop to keep the program running until the user decides to exit
                                while(!adminResponse8.equals("exit")) {
                                    System.out.println("Select which type of operation you want to perform : ");
                                    System.out.println("1. Create a Student");
                                    System.out.println("2. Read a Student");
                                    System.out.println("3. Update a Student");
                                    System.out.println("4. Delete a Student");
                                    System.out.println("0. Exit");
                                    System.out.println("Enter your choice : ");
                                    String adminChoice8 = scan.nextLine();
                                    int adminChoiceInt8 = Integer.parseInt(adminChoice8);
                                    if (adminChoiceInt8 == 0) {adminResponse8 = "exit";}
                                    //Type of operation switch statement
                                    switch (adminChoiceInt8) {
                                        case 1:
                                            //Create a Student
                                            StudentDAO studentDAO = new StudentDAO();
                                            studentDAO.createStudent();
                                            break;
                                        case 2:
                                            //Read a Student
                                            StudentDAO studentDAO1 = new StudentDAO();
                                            studentDAO1.readStudent();
                                            break;
                                        case 3:
                                            //Update a Student
                                            StudentDAO studentDAO2 = new StudentDAO();
                                            studentDAO2.updateStudent();
                                            break;
                                        case 4:
                                            //Delete a Student
                                            StudentDAO studentDAO3 = new StudentDAO();
                                            studentDAO3.deleteStudent();
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Invalid choice");
                                            break;
                                    }
                                }
                                break;
                            case 0:
                                //Exiting the system
                                System.out.println("Exiting the admin menu, Thanks for using our system");
                                break;
                            default:
                                System.out.println("Invalid Choice");
                        }
                    }
                    break;
                case 2:
                    //Student
                    //Authentication for Student

                    System.out.println("Authentication Required");
                    System.out.println("Enter the Details your Professor Provided you : ");
                    System.out.println("Enter your name : ");
                    String enteredname = scan.nextLine();
                    System.out.println("Enter your password : ");
                    String enteredpassword = scan.nextLine();
                    StudentLogin studentLogin = new StudentLogin();
                    boolean isStudentLoggedIn = studentLogin.login(enteredname, enteredpassword);
                    if (!isStudentLoggedIn){
                        System.out.println("Invalid credentials");
                        break;
                    }
                    System.out.println("Welcome " + enteredname);
                    String studentResponse="";

                    while(!studentResponse.equals("exit")){
                        //Student Menu
                        System.out.println("1. Take a normal quiz");
                        System.out.println("2. Take a quiz based on difficulty level");
                        System.out.println("0. Exit");
                        System.out.println("Enter your choice : ");
                        String studentChoice = scan.nextLine();
                        int studentChoiceInt = Integer.parseInt(studentChoice);
                        if(studentChoiceInt==0){
                            //Exiting the system
                            studentResponse="exit";
                        }
                        //Switch statement for student menu
                        switch (studentChoiceInt){
                            case 1:
                                //Take a Quiz
                                String studentResponse1 = "";
                                while(!studentResponse1.equals("exit")) {
                                    System.out.println("Select which type of question you want to take : ");
                                    System.out.println("1. MCQ");
                                    System.out.println("2. Open");
                                    System.out.println("0. Exit");
                                    System.out.println("Enter your choice : ");
                                    String studentChoice1 = scan.nextLine();
                                    int studentChoiceInt1 = Integer.parseInt(studentChoice1);
                                    if (studentChoiceInt1 == 0) {
                                        studentResponse1 = "exit";
                                    }
                                    //Switch statement for quiz type
                                    switch (studentChoiceInt1) {
                                        case 1:
                                            //MCQ
                                            MCQQuestionDAO takeDAO = new MCQQuestionDAO();
                                            takeDAO.topicgiver();
                                            System.out.println("Enter the quiz topic:");
                                            String topic = scan.nextLine();
                                            CreateQuiz createQuiz = new CreateQuiz();
                                            ArrayList<MCQQuiz> questions = CreateQuiz.createMCQQuiz(topic);
                                            //for loop to display the questions
                                            int score = 0;
                                            for (MCQQuiz question : questions) {
                                                System.out.println(question.getqText());
                                                for (Options options : question.getOptions()) {
                                                    System.out.println(options.getTitle());
                                                }
                                                System.out.println("Enter the answer : ");
                                                String answer = scan.nextLine();
                                                //check if the answer is correct
                                                if (answer.equals(question.getqCorrectAnswer())) {
                                                    score++;
                                                }
                                            }
                                            //Total Questions you attended
                                            System.out.println("You attended " + questions.size() + " questions");
                                            //Total correct answers
                                            System.out.println("You got " + score + " correct answers");
                                            //Percentage of correct answers
                                            System.out.println("You got " + (score * 100 / questions.size()) + "% correct answers");
                                            //Asking if user wants to export user' quiz report
                                            ExportStudentResult exportStudentResults = new ExportStudentResult();
                                            exportStudentResults.extractMCQ(scan, enteredname, topic, questions, score);
                                            break;
                                        case 2:
                                            //Open
                                            OpenQuestionDAO takeDAO1 = new OpenQuestionDAO();
                                            takeDAO1.topicgiver();
                                            System.out.println("Enter the quiz topic:");
                                            String topic1 = scan.nextLine();
                                            CreateQuiz createQuiz1 = new CreateQuiz();
                                            ArrayList<OpenQuiz> questions1 = CreateQuiz.createOpenQuiz(topic1);
                                            //for loop to display the questions
                                            int score1 = 0;
                                            for (OpenQuiz question : questions1) {
                                                System.out.println(question.getqText());
                                                //Displaying the Question Tip
                                                System.out.println("Question Tip: " + question.getqTip() + "\n");
                                                System.out.println("Enter the answer : ");
                                                String answer1 = scan.nextLine();
                                                //check if the answer is correct
                                                if (answer1.equals(question.getqCorrectAnswer())) {
                                                    score1++;
                                                }
                                            }
                                            //Total Questions you attended
                                            System.out.println("You attended " + questions1.size() + " questions");
                                            //Total correct answers
                                            System.out.println("You got " + score1 + " correct answers");
                                            //Percentage of correct answers
                                            System.out.println("You got " + (score1 * 100 / questions1.size()) + "% correct answers");
                                            //Asking if user wants to export user' quiz report
                                            ExportStudentResult exportStudentResult = new ExportStudentResult();
                                            exportStudentResult.extractOpen(scan, enteredname, topic1, questions1, score1);
                                            break;
                                        default:
                                            System.out.println("Invalid choice");
                                            break;
                                    }
                                }
                                break;
                            case 2:
                                //Take a Quiz based on difficulty level
                                String studentResponse2 = "";
                                while(!studentResponse2.equals("exit")) {
                                    System.out.println("Select which type of question you want to take : ");
                                    System.out.println("1. MCQ");
                                    System.out.println("2. Open");
                                    System.out.println("0. Exit");
                                    System.out.println("Enter your choice : ");
                                    String studentChoice2 = scan.nextLine();
                                    int studentChoiceInt2 = Integer.parseInt(studentChoice2);
                                    if (studentChoiceInt2 == 0) {
                                        studentResponse2 = "exit";
                                    }
                                    switch (studentChoiceInt2) {
                                        case 1:
                                            //MCQ quiz based on difficulty level
                                            MCQQuestionDAO takeDAO2 = new MCQQuestionDAO();
                                            takeDAO2.difficultygiver();
                                            System.out.println("Enter the difficulty level:");
                                            String difficulty = scan.nextLine();
                                            CreateQuiz createQuiz2 = new CreateQuiz();
                                            ArrayList<MCQQuiz> questions2 = CreateQuiz.createMCQQuiz_difficult(difficulty);
                                            //for loop to display the questions with serial number
                                            int score2 = 0;
                                            for (MCQQuiz question : questions2) {
                                                System.out.println(question.getqText());
                                                for (Options options : question.getOptions()) {
                                                    System.out.println(options.getTitle());
                                                }
                                                System.out.println("Enter the answer : ");
                                                String answer2 = scan.nextLine();
                                                //check if the answer is correct
                                                if (answer2.equals(question.getqCorrectAnswer())) {
                                                    score2++;
                                                }
                                            }
                                            //Total Questions you attended
                                            System.out.println("You attended " + questions2.size() + " questions");
                                            //Total correct answers

                                            System.out.println("You got " + score2 + " correct answers");
                                            //Percentage of correct answers
                                            System.out.println("You got " + (score2 * 100 / questions2.size()) + "% correct answers");
                                            //Asking if user wants to export user' quiz report
                                            ExportStudentResult exportStudentResult = new ExportStudentResult();
                                            exportStudentResult.extractMCQD(scan, enteredname, difficulty, questions2, score2);
                                            break;
                                        case 2:
                                            //Open
                                            OpenQuestionDAO takeDAO3 = new OpenQuestionDAO();
                                            takeDAO3.difficultygiver();
                                            System.out.println("Enter the difficulty level:");
                                            String difficulty1 = scan.nextLine();
                                            CreateQuiz createQuiz3 = new CreateQuiz();
                                            ArrayList<OpenQuiz> questions3 = CreateQuiz.createOpenQuiz_difficult(difficulty1);
                                            //for loop to display the questions with serial number
                                            int score3 = 0;
                                            for (OpenQuiz question : questions3) {
                                                System.out.println(question.getqText());
                                                //Displaying the Question Tip
                                                System.out.println("Question Tip: " + question.getqTip() + "\n");
                                                System.out.println("Enter the answer : ");
                                                String answer3 = scan.nextLine();
                                                //check if the answer is correct
                                                if (answer3.equals(question.getqCorrectAnswer())) {
                                                    score3++;
                                                }
                                            }
                                            //Total Questions you attended
                                            System.out.println("You attended " + questions3.size() + " questions");
                                            //Total correct answers
                                            System.out.println("You got " + score3 + " correct answers");
                                            //Percentage of correct answers
                                            System.out.println("You got " + (score3 * 100 / questions3.size()) + "% correct answers");
                                            //Asking if user wants to export user' quiz report
                                            ExportStudentResult exportStudentResult1 = new ExportStudentResult();
                                            exportStudentResult1.extractOpenD(scan, enteredname, difficulty1, questions3, score3);
                                            break;
                                        case 0:
                                            break;
                                        default:
                                            System.out.println("Invalid choice");
                                            break;
                                    }
                                }
                                break;
                            case 0:
                                System.out.println("Exiting student menu, Thanks for using our system");
                                break;
                            default:
                                System.out.println("Unexpected value: " + studentChoiceInt);
                        }

                    }
                    break;
                case 3:
                    //Exit
                    System.out.println("Thank you for using the Quiz Application");
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;

            }
        }

    }

    private static Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("./credentials.properties"));
        } catch (IOException e) {
            System.out.println("Sorry, the program is not finding the required files, check your setup " +
                    "(authentication is not possible)");
            return null;
        }
        return properties;
    }

}
