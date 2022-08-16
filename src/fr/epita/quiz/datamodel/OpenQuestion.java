package fr.epita.quiz.datamodel;

public class OpenQuestion {
    //Necessaary fields
    private String qId;
    private String qText;
    private String qTopic;
    private String qDifficulty;
    private String qTip;
    private String qCorrectAnswer;

    //Constructor
    public OpenQuestion(String qId, String qText, String qTopic, String qDifficulty, String qTip, String qCorrectAnswer) {
        this.qId = qId;
        this.qText = qText;
        this.qTopic = qTopic;
        this.qDifficulty = qDifficulty;
        this.qTip = qTip;
        this.qCorrectAnswer = qCorrectAnswer;
    }


    public OpenQuestion() {

    }

    public String getqId() {
        return qId;
    }
    //Getter Setter Methods
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

    public String getqTip() {
        return qTip;
    }

    public void setqTip(String qTip) {
        this.qTip = qTip;
    }

    public String getqCorrectAnswer() {
        return qCorrectAnswer;
    }

    public void setqCorrectAnswer(String qCorrectAnswer) {
        this.qCorrectAnswer = qCorrectAnswer;
    }
}
