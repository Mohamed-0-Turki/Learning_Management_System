package model;

public class Assignment implements StringDataConvertible {
    static private int currentAssignmentID = 0;
    private int AssignmentID;
    private int courseID;
    private int numberOfQuestions;
    private double degree;
    public Assignment() {
        currentAssignmentID++;
        this.AssignmentID = currentAssignmentID;
        this.courseID = 0;
        this.numberOfQuestions = 0;
        this.degree = 0;
    }
    public Assignment(int courseID) {
        this();
        this.courseID = courseID;
    }
    public Assignment(int courseID, int numberOfQuestions) {
        this(courseID);
        this.numberOfQuestions = numberOfQuestions;
    }
    public Assignment(int courseID, int numberOfQuestions, double degree) {
        this(courseID, numberOfQuestions);
        this.degree = degree;
    }
    public void setAssignmentID(int AssignmentID) {
        this.AssignmentID = AssignmentID;
    }
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }
    public void setDegree(Double degree) { this.degree = degree; }
    public int getAssignmentID() {
        return this.AssignmentID;
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
        return "["+this.AssignmentID+", "+this.courseID+", "+this.numberOfQuestions+", "+this.degree+"]";
    }
    @Override
    public String toString() {
        return "#Assignment ID: " + this.AssignmentID + "\t|\t" + "Course ID: " + this.courseID +
                "\t|\t" + "Number Fo Questions: " + this.numberOfQuestions + "\t|\t" + "Degree: " + this.degree;
    }
}
