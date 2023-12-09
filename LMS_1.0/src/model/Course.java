package model;

public class Course {
    static private int currentCourseID;
    private int courseID;
    private String courseName;
    private String lecturerID;
    private String description;

    public Course() {
        currentCourseID++;
        this.courseID=currentCourseID;
        courseName="";
    }
    public Course(String courseName) {
        this();
        this.courseName = courseName;
    }
    public Course(String courseName, String lecturer){
        this(courseName);
        this.lecturerID=lecturer;
    }

    public Course(String courseName, String lecturer, String description) {
        this(courseName, lecturer);
        this.description = description;
    }
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public void setLecturerID(String lecturer){
        this.lecturerID=lecturer;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public int getCourseID(){
        return this.courseID;
    }
    public String getCourseName() {
        return this.courseName;
    }

    public String getLecturerID() {
        return this.lecturerID;
    }

    public String getDescription() {
        return this.description;
    }

    public String arrayStringData() {
        return "["+this.courseID+", "+this.courseName+", "+this.lecturerID+", "+this.description+"]";
    }

    @Override
    public String toString(){
        return "#course ID: " + this.courseID + "\t|\t" + "Course Name: " + this.courseName +
                "\t|\t" + "Lecturer: " + this.lecturerID + "\t|\t" + "Description: " + this.description;
    }
}
