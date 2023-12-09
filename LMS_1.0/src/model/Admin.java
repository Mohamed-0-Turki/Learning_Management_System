package model;

public class Admin extends Person {
    public int addUser(Person user) {
        this.setDatabase("database/users.txt");
        String arrayOfDataAsString = user.arrayStringData();
        return this.writeInFile(arrayOfDataAsString, true);
    }

    public int addCourse(Course course) {
        this.setDatabase("database/courses.txt");
        String arrayOfDataAsString = course.arrayStringData();
        return this.writeInFile(arrayOfDataAsString, true);
    }
    public int deleteCourse(int courseID) {
        this.setDatabase("database/courses.txt");
        return this.deleteLine(Integer.toString(courseID));
    }
}