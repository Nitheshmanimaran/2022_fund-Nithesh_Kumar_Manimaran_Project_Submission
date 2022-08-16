package fr.epita.quiz.datamodel;

public class Options extends MCQQuestion{
    //Necessary fields
    String Title=null;
    Boolean isCorrect=null;
    //getter setter methods
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Boolean getCorrect() {
        return isCorrect;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }
}
