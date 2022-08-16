package fr.epita.tests;

import fr.epita.quiz.services.MCQQuestionDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

//Test for MCQQuestionDAO

public class Test1 {
    public static void main(String[] args) throws SQLException, IOException {
        MCQQuestionDAO mcqDAO = new MCQQuestionDAO();
        mcqDAO.create(new Scanner(System.in));
        mcqDAO.delete(new Scanner(System.in));
        mcqDAO.update(new Scanner(System.in));
        MCQQuestionDAO.search(new Scanner(System.in));
    }
}