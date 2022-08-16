package fr.epita.quiz.datamodel;

import java.util.ArrayList;

public class MCQQuiz extends MCQQuestion{
    //Necessary fields
    private ArrayList<Options> options;

    //Constructor
    public MCQQuiz() {
        this.options = null;
    }
    //Getter Setter Methods
    public ArrayList<Options> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Options> options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "MCQQuiz{" +
                "options=" + options +
                '}';
    }
}
