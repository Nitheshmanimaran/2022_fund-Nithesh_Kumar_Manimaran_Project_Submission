package fr.epita.quiz.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import fr.epita.quiz.datamodel.MCQQuiz;
import fr.epita.quiz.datamodel.OpenQuiz;
import fr.epita.quiz.datamodel.Options;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import static java.lang.System.getProperties;

public class ExportStudentResult {
    //Method to export the results of the student to a pdf file
    public static void extractOpen(Scanner scan, String enteredname, String topic1, ArrayList<OpenQuiz> questions1, int score1) throws DocumentException, IOException {
        System.out.println("Do you want to export your quiz report (y/n) : ");
        String export1 = scan.nextLine();
        if (export1.equals("y")) {
            //Export the quiz report
            //String fileName = scan.nextLine();
            String fileName = enteredname + "_" + topic1 + "_" + "QuizReport.pdf";
            String filePath = getProperties().getProperty("filePath") + fileName;
            //Create the file
            Document document = new Document();
            File file = new File(filePath);
            FileOutputStream fos = new FileOutputStream(file);
            PdfWriter.getInstance(document, fos);
            document.open();
            //Add the content to the file

            document.add(new Paragraph("Quiz Report" + "\n" + "Topic: " + topic1 + "\n" + "\n"));
            document.add(new Paragraph("Total Questions: " + questions1.size() + "\n" + "Total Correct Answers: " + score1 + "\n" + "Percentage of Correct Answers: " + (score1 * 100 / questions1.size()) + "\n" + "\n"));

            int i = 0;
            int j = 0;
            //Looping through the questions and answers to add to the file
            for (OpenQuiz question : questions1) {
                i++;
                document.add(new Paragraph("Question-" + i + ". " + question.getqText() + "\n"));
                //Displaying the Question Tip
                document.add(new Paragraph("Question Tip: " + question.getqTip() + "\n"));
                document.add(new Paragraph("\n"));
                //Displaying the Question Answer
                document.add(new Paragraph("Correct Answer: " + question.getqCorrectAnswer() + "\n"));
                document.add(new Paragraph("\n"));
            }
            //Close the document
            document.close();
            fos.flush();
            fos.close();
            System.out.println("Quiz Report exported successfully");
        }
    }
    //Method to export the results of the student to a pdf file
    public static void extractMCQ(Scanner scan, String enteredname, String topic, ArrayList<MCQQuiz> questions, int score) throws DocumentException, IOException {
        System.out.println("Do you want to export your quiz report (y/n) : ");
        String export = scan.nextLine();
        if (export.equals("y")) {
            //Export the quiz report
            //String fileName = scan.nextLine();
            String fileName = enteredname + "_" + topic + "_" + "QuizReport.pdf";
            String filePath = getProperties().getProperty("filePath") + fileName;
            //Create the file
            Document document = new Document();
            File file = new File(filePath);
            FileOutputStream fos = new FileOutputStream(file);
            PdfWriter.getInstance(document, fos);
            document.open();
            //Add the content to the file

            document.add(new Paragraph("Quiz Report" + "\n" + "Topic: " + topic + "\n" + "\n"));
            document.add(new Paragraph("Total Questions: " + questions.size() + "\n" + "Total Correct Answers: " + score + "\n" + "Percentage of Correct Answers: " + (score * 100 / questions.size()) + "\n" + "\n"));

            int i = 0;
            int j = 0;
            //Looping through the questions and answers to add to the file
            for (MCQQuiz question : questions) {
                i++;
                document.add(new Paragraph("Question-" + i + ". " + question.getqText() + "\n"));
                //Displaying the Question Choices
                for (Options options : question.getOptions()) {
                    j++;
                    document.add(new Paragraph("Options-" + j + ". " + options.getTitle() + "\n"));
                }
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("Correct Answer: " + question.getqCorrectAnswer() + "\n"));
                document.add(new Paragraph("\n"));
            }
            //Close the document
            document.close();
            fos.flush();
            fos.close();
            System.out.println("Quiz Report exported successfully");
        }
    }
    //Method to export the results of the student to a pdf file
    public void extractMCQD(Scanner scan, String enteredname, String difficulty, ArrayList<MCQQuiz> questions2, int score2) throws FileNotFoundException {
        System.out.println("Do you want to export your quiz report (y/n) : ");
        String export = scan.nextLine();
        if (export.equals("y")) {
            //Export the quiz report
            //String fileName = scan.nextLine();
            String fileName = enteredname + "_" + difficulty + "_" + "QuizReport.pdf";
            String filePath = getProperties().getProperty("filePath") + fileName;
            //Create the file
            Document document = new Document();
            File file = new File(filePath);
            FileOutputStream fos = new FileOutputStream(file);
            try {
                PdfWriter.getInstance(document, fos);
                document.open();
                //Add the content to the file
                document.add(new Paragraph("Quiz Report" + "\n" + "Difficulty: " + difficulty + "\n" + "\n"));
                document.add(new Paragraph("Total Questions: " + questions2.size() + "\n" + "Total Correct Answers: " + score2 + "\n" + "Percentage of Correct Answers: " + (score2 * 100 / questions2.size()) + "\n" + "\n"));
                int i = 0;
                int j = 0;
                //Looping through the questions and answers to add to the file
                for (MCQQuiz question : questions2) {
                    i++;
                    document.add(new Paragraph("Question-" + i + ". " + question.getqText() + "\n"));
                    //Displaying the Question Choices
                    for (Options options : question.getOptions()) {
                        j++;
                        document.add(new Paragraph("Options-" + j + ". " + options.getTitle() + "\n"));
                    }
                    document.add(new Paragraph("\n"));
                    document.add(new Paragraph("Correct Answer: " + question.getqCorrectAnswer() + "\n"));
                    document.add(new Paragraph("\n"));
                }
                //Close the document
                document.close();
                fos.flush();
                fos.close();
                System.out.println("Quiz Report exported successfully");
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //Method to export the results of the student to a pdf file
    public void extractOpenD(Scanner scan, String enteredname, String topic, ArrayList<OpenQuiz> questions3, int score3) throws DocumentException, IOException {
        System.out.println("Do you want to export your quiz report (y/n) : ");
        String export = scan.nextLine();
        if (export.equals("y")) {
            //Export the quiz report
            //String fileName = scan.nextLine();
            String fileName = enteredname + "_" + topic + "_" + "QuizReport.pdf";
            String filePath = getProperties().getProperty("filePath") + fileName;
            //Create the file
            Document document = new Document();
            File file = new File(filePath);
            FileOutputStream fos = new FileOutputStream(file);
            PdfWriter.getInstance(document, fos);
            document.open();
            //Add the content to the file

            document.add(new Paragraph("Quiz Report" + "\n" + "Topic: " + topic + "\n" + "\n"));
            document.add(new Paragraph("Total Questions: " + questions3.size() + "\n" + "Total Correct Answers: " + score3 + "\n" + "Percentage of Correct Answers: " + (score3 * 100 / questions3.size()) + "\n" + "\n"));
            int i = 0;
            int j = 0;
            //Looping through the questions and answers to add to the file
            for (OpenQuiz question : questions3) {
                i++;
                document.add(new Paragraph("Question-" + i + ". " + question.getqText() + "\n"));
                //Displaying the Question Tip
                document.add(new Paragraph("Question Tip: " + question.getqTip() + "\n"));
                //Displaying the Question Answer
                document.add(new Paragraph("\n"));
                document.add(new Paragraph("Correct Answer: " + question.getqCorrectAnswer() + "\n"));
                document.add(new Paragraph("\n"));
            }
            //Close the document
            document.close();
            fos.flush();
            fos.close();
            System.out.println("Quiz Report exported successfully");
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
