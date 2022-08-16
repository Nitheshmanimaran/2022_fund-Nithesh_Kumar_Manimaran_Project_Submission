package fr.epita.tests;

import fr.epita.quiz.services.OpenQuestionDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
//Test for OpenQuestionDAO
public class Test2 {
    public static void main(String[] args) throws SQLException, IOException {
        OpenQuestionDAO openQuestionDAO = new OpenQuestionDAO();
        openQuestionDAO.create(new Scanner(System.in));
        openQuestionDAO.update(new Scanner(System.in));
        openQuestionDAO.search(new Scanner(System.in));
        openQuestionDAO.delete(new Scanner(System.in));
    }
}
