package fr.epita.tests;

import fr.epita.quiz.services.CreateQuiz;
import fr.epita.quiz.services.StudentDAO;

import java.sql.SQLException;
import java.util.Scanner;

public class Test3 {
    //Test for StudentDAO
    public static void main(String[] args) throws SQLException {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.createStudent();
        studentDAO.updateStudent();
        studentDAO.deleteStudent();
        studentDAO.readStudent();
    }
}

