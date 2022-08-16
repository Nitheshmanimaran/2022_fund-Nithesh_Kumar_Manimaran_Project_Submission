package fr.epita.quiz.datamodel;

public class OpenQuiz extends OpenQuestion{
    //Necessaary fields
    public OpenQuiz() {
        super();
    }
    //ToString Method
    @Override
    public String toString() {
        return "OpenQuiz{" +
                "tips='" + tips + '\'' +
                '}';
    }

    private String tips;

    public OpenQuiz(String qId, String qText, String qTopic, String qDifficulty, String qTip, String qCorrectAnswer) {
        super(qId, qText, qTopic, qDifficulty, qTip, qCorrectAnswer);
    }
    //Getter Setter Methods
    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
