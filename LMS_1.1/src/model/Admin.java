package model;

public class Admin extends Person {
    public Person[] viewAllPeople(String userType) {
        super.setFilePath("database/users/"+userType+".txt");
        super.setFile();
        String[] lines = super.getFile().readAllFile().split("\n");
        Person[] people = new Person[lines.length];
        int i = 0;
        if (super.numberOfLines() != 0) {
            for (String line: lines) {
                String[] data = line.substring(1, line.length() - 1).split(", ");
                people[i] = new Person(data[1], data[2], data[3], data[4]);
                people[i].setUserID(Integer.parseInt(data[0]));
                i++;
            }
        }
        return people;
    }
    public boolean addUser (String userType, Person user) {
        super.setFilePath("database/users/"+userType+".txt");
        super.setFile();
        String line = user.arrayStringData();
        return super.add(line);
    }

    public boolean updateUser (int userID, String userType, Person newUser) {
        super.setFilePath("database/users/"+userType+".txt");
        super.setFile();
        String line = newUser.search(0, Integer.toString(userID));
        if (! line.equals("0")) {
            String[] userData = line.substring(1, line.length() - 1).split(", ");
            newUser.setUserID(userID);
            if (newUser.getName().isEmpty()) {
                newUser.setName(userData[2]);
            }
            if (newUser.getEmail().isEmpty()) {
                newUser.setEmail(userData[3]);
            }
            if (newUser.getPassword().isEmpty()) {
                newUser.setPassword(userData[4]);
            }
            line = newUser.arrayStringData();
            return super.update(userID, line);
        }
        return false;
    }

    public int deleteUser (int userID, String userType) {
        super.setFilePath("database/users/"+userType+".txt");
        super.setFile();
        return super.delete(userID);
    }
    public Course[] viewAllCourses() {
        super.setFilePath("database/courses/course.txt");
        super.setFile();
        String[] lines = super.getFile().readAllFile().split("\n");
        Course[] courses = new Course[lines.length];
        int i = 0;
        for (String line: lines) {
            String[] data = line.substring(1, line.length() - 1).split(", ");
            courses[i] = new Course(data[1], data[2], data[3]);
            courses[i].setCourseID(Integer.parseInt(data[0]));
            i++;
        }
        return courses;
    }
    public boolean addCourse(Course course) {
        super.setFilePath("database/courses/course.txt");
        super.setFile();
        String line = course.arrayStringData();
        return super.add(line);
    }
    public boolean updateCourse(int courseID, Course newCourse) {
        super.setFilePath("database/courses/course.txt");
        super.setFile();
        String line = super.search(0, Integer.toString(courseID));
        if (! line.equals("0")) {
            String[] courseData = line.substring(1, line.length() - 1).split(", ");
            newCourse.setCourseID(courseID);
            if (newCourse.getCourseName().isEmpty()) {
                newCourse.setCourseName(courseData[1]);
            }
            if (newCourse.getDescription().isEmpty()) {
                newCourse.setDescription(courseData[2]);
            }
            if (newCourse.getLecturerID().isEmpty()) {
                newCourse.setLecturerID(courseData[3]);
            }
            line = newCourse.arrayStringData();
            return super.update(courseID, line);
        }
        return false;
    }
    public int deleteCourse(int courseID) {
        super.setFilePath("database/courses/course.txt");
        super.setFile();
        return super.delete(courseID);
    }

    public boolean addStudentToCourse(String courseID, String studentID) {
        super.setFilePath("database/courses/course.txt");
        super.setFile();
        if (super.search(0, courseID).equals("0")) {
            return false;
        }
        super.setFilePath("database/users/student.txt");
        super.setFile();
        if (super.search(0, studentID).equals("0")) {
            return false;
        }
        super.setFilePath("database/users/students/"+studentID+"_courses.txt");
        super.setFile();
        if (super.getFile().fileExist()) {
            if (super.search(0, courseID).equals("0")) {
                String line = "["+courseID+"]";
                return super.add(line);
            }
            return true;
        }
        String line = "["+courseID+"]";
        return super.add(line);
    }

    public boolean blockUser(String courseID, String userID) {
        super.setFilePath("database/users/students/"+userID+"_courses.txt");
        super.setFile();
        if (super.getFile().fileExist()) {
            return super.delete(Integer.parseInt(courseID)) == 1;
        }
        return false;
    }

    public Report generateReport(String type, String courseID) {
        String folder = "exams";
        if (type.equals("assignment")) {
            folder = "assignments";
        }
        super.setFilePath("database/"+folder+"/grades/"+courseID+"_grade.txt");
        super.setFile();
        int numOfStudents = super.numberOfLines();
        double totalGrades = 0;
        String[] lines = super.getFile().readAllFile().split("\n");
        for (String line: lines) {
            String[] data = line.substring(1, line.length() - 1).split(", ");
            totalGrades += Double.parseDouble(data[2]);
        }
        return new Report(type, totalGrades, numOfStudents);
    }
}
