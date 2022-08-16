package fr.epita.quiz.datamodel;

public class MCQQuestion {
    //Necessaary fields
    private String qId;
    private String qText;
    private String qTopic;
    private String qDifficulty;
    private String qCorrectAnswer;
    private String qWrongAnswer1;
    private String qWrongAnswer2;
    private String qWrongAnswer3;

    //Constructor
    public MCQQuestion(String qId, String qText, String qTopic, String qDifficulty, String qCorrectAnswer, String qWrongAnswer1, String qWrongAnswer2, String qWrongAnswer3) {
        this.qId = qId;
        this.qText = qText;
        this.qTopic = qTopic;
        this.qDifficulty = qDifficulty;
        this.qCorrectAnswer = qCorrectAnswer;
        this.qWrongAnswer1 = qWrongAnswer1;
        this.qWrongAnswer2 = qWrongAnswer2;
        this.qWrongAnswer3 = qWrongAnswer3;
    }

    public MCQQuestion() {
    }

    //Getter Setter Methods
    public String getqId() {
        return qId;
    }

    public void setqId(String qId) {
        this.qId = qId;
    }

    public String getqText() {
        return qText;
    }

    public void setqText(String qText) {
        this.qText = qText;
    }

    public String getqTopic() {
        return qTopic;
    }

    public void setqTopic(String qTopic) {
        this.qTopic = qTopic;
    }

    public String getqDifficulty() {
        return qDifficulty;
    }

    public void setqDifficulty(String qDifficulty) {
        this.qDifficulty = qDifficulty;
    }

    public String getqCorrectAnswer() {
        return qCorrectAnswer;
    }

    public void setqCorrectAnswer(String qCorrectAnswer) {
        this.qCorrectAnswer = qCorrectAnswer;
    }

    public String getqWrongAnswer1() {
        return qWrongAnswer1;
    }

    public void setqWrongAnswer1(String qWrongAnswer1) {
        this.qWrongAnswer1 = qWrongAnswer1;
    }

    public String getqWrongAnswer2() {
        return qWrongAnswer2;
    }

    public void setqWrongAnswer2(String qWrongAnswer2) {
        this.qWrongAnswer2 = qWrongAnswer2;
    }

    public String getqWrongAnswer3() {
        return qWrongAnswer3;
    }

    public void setqWrongAnswer3(String qWrongAnswer3) {
        this.qWrongAnswer3 = qWrongAnswer3;
    }

    @Override
    public String toString() {
        return "MCQQuestion{" +
                "qId='" + qId + '\'' +
                ", qText='" + qText + '\'' +
                ", qTopic='" + qTopic + '\'' +
                ", qDifficulty='" + qDifficulty + '\'' +
                ", qCorrectAnswer='" + qCorrectAnswer + '\'' +
                ", qWrongAnswer1='" + qWrongAnswer1 + '\'' +
                ", qWrongAnswer2='" + qWrongAnswer2 + '\'' +
                ", qWrongAnswer3='" + qWrongAnswer3 + '\'' +
                '}';
    }
}