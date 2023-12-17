package model;

public class Question implements StringDataConvertible {
    static private int currentQuestionID = 0;
    private int questionID;
    private String question;
    private String answer;
    public Question() {
        currentQuestionID++;
        this.questionID = currentQuestionID;
        this.question = null;
        this.answer = null;
    }
    public Question(String question) {
        this();
        this.question = question;
    }
    public  Question(String question, String answer) {
        this(question);
        this.answer = answer;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public int getQuestionID() {
        return this.questionID;
    }
    public String getQuestion() {
        return this.question;
    }
    public String getAnswer() {
        return this.answer;
    }
    @Override
    public String arrayStringData() {
        return "["+this.questionID+", "+this.question+", "+this.answer+"]";
    }
    @Override
    public String toString() {
        return "Question: "+this.question;
    }

}
