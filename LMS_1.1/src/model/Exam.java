package model;

public class Exam implements StringDataConvertible {
    static private int currentExamID = 0;
    private int examID;
    private int courseID;
    private int numberOfQuestions;
    private double degree;
    public Exam() {
        currentExamID++;
        this.examID = currentExamID;
        this.courseID = 0;
        this.numberOfQuestions = 0;
        this.degree = 0;
    }
    public Exam(int courseID) {
        this();
        this.courseID = courseID;
    }
    public Exam(int courseID, int numberOfQuestions) {
        this(courseID);
        this.numberOfQuestions = numberOfQuestions;
    }
    public Exam(int courseID, int numberOfQuestions, double degree) {
        this(courseID, numberOfQuestions);
        this.degree = degree;
    }
    public void setExamID(int examID) {
        this.examID = examID;
    }
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }
    public void setDegree(double degree) { this.degree = degree; }
    public int getExamID() {
        return this.examID;
    }
    public int getCourseID() {
        return this.courseID;
    }
    public int getNumberOfQuestions() {
        return this.numberOfQuestions;
    }
    public double getDegree() {
        return this.degree;
    }
    @Override
    public String arrayStringData() {
        return "["+this.examID+", "+this.courseID+", "+this.numberOfQuestions+", "+this.degree+"]";
    }
    public String toString() {
        return "#Exam ID: " + this.examID + "\t|\t" + "Course ID: " + this.courseID +
                "\t|\t" + "Number Fo Questions: " + this.numberOfQuestions + "\t|\t" + "Degree: " + this.degree;
    }
}
