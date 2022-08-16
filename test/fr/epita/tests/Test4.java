package fr.epita.tests;

import fr.epita.quiz.services.StudentDAO;
import fr.epita.quiz.services.StudentLogin;

import java.sql.SQLException;

public class Test4 {
    //StudentLogin test
    public static void main(String[] args) throws SQLException {
        StudentLogin studentLogin = new StudentLogin();
        boolean check = studentLogin.login("Bruno","brunopwd");
        boolean check1 =studentLogin.login("Bruno","bruno");
        boolean check2 =studentLogin.login("Nobody","Nobody");
        if(check){
            System.out.println("Login Successful");
        }
        else{
            System.out.println("Login Failed");
        }
        if(check1){
            System.out.println("Login Successful");
        }
        else{
            System.out.println("Login Failed");
        }
        if(check2){
            System.out.println("Login Successful");
        }
        else{
            System.out.println("Login Failed");
        }
        
    }
}
