package model;

public class Course implements StringDataConvertible {
    static private int currentCourseID;
    private int courseID;
    private String courseName;
    private String description;
    private String lecturerID;


    public Course() {
        currentCourseID++;
        this.courseID = currentCourseID;
        this.courseName = null;
        this.description = null;
        this.lecturerID = null;
    }
    public Course(String courseName) {
        this();
        this.courseName = courseName;
    }
    public Course(String courseName, String description){
        this(courseName);
        this.description = description;
    }

    public Course(String courseName, String description, String lecturerID) {
        this(courseName, description);
        this.lecturerID = lecturerID;
    }
    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setLecturerID(String lecturerID){
        this.lecturerID = lecturerID;
    }

    public int getCourseID(){
        return this.courseID;
    }
    public String getCourseName() {
        return this.courseName;
    }
    public String getDescription() {
        return this.description;
    }
    public String getLecturerID() {
        return this.lecturerID;
    }

    @Override
    public String arrayStringData() {
        return "["+this.courseID+", "+this.courseName+", "+this.description+", "+this.lecturerID+"]";
    }
    @Override
    public String toString(){
        return "#Course ID: " + this.courseID + "\t|\t" + "Course Name: " + this.courseName +
                "\t|\t" + "Description: " + this.description + "\t|\t" + "Lecturer ID: " + this.lecturerID;
    }
}
