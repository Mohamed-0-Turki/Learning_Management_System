package model;

public class Student extends Person {
    public Student() {
        super();
    }
    public Student(String userType) {
        super(userType);
    }
    public Student(String userType, String name) {
        super(userType, name);
    }
    public Student(String userType, String name, String email) {
        super(userType, name, email);
    }
    public Student(String userType, String name, String email, String password) {
        super(userType, name, email, password);
    }

    public Course[] viewAllMyCourses(int studentID) {
        String[] coursesIDs = this.getAllCoursesIDForStudent(studentID);
        int i = 0;
        super.setFilePath("database/courses/course.txt");
        super.setFile();
        Course[] courses = new Course[coursesIDs.length];
        for (String courseID: coursesIDs) {
            String line = super.search(0, courseID);
            String[] courseData = line.substring(1, line.length() - 1).split(", ");
            courses[i] = new Course(courseData[1], courseData[2], courseData[3]);
            courses[i].setCourseID(Integer.parseInt(courseData[0]));
            i++;
        }
        return courses;
    }
    public String viewCourseContent(int studentID, int courseID) {
        super.setFilePath("database/users/students/"+studentID+"_courses.txt");
        super.setFile();
        if (! super.search(0, Integer.toString(courseID)).equals("0")) {
            super.setFilePath("database/courses/course.txt");
            super.setFile();
            String line = super.search(0, Integer.toString(courseID));
            String[] courseData = line.substring(1, line.length() - 1).split(", ");
            return courseData[2];
        }
        return "You are not registered in this course";
    }

    public Exam[] viewAllExamsAvailableForStudent(int studentID) {
        String[] studentCourses = getAllCoursesIDForStudent(studentID);
        Exam[] exams = new Exam[studentCourses.length];
        super.setFilePath("database/exams/exam.txt");
        super.setFile();
        int i = 0;
        for (String courseID: studentCourses) {
            if (! super.search(1, courseID).equals("0")) {
                String line = super.search(1, courseID);
                String[] examData = line.substring(1, line.length() - 1).split(", ");
                exams[i] = new Exam(Integer.parseInt(examData[1]), Integer.parseInt(examData[2]), Double.parseDouble(examData[3]));
                exams[i].setExamID(Integer.parseInt(examData[0]));
                i++;
            }
        }
        return exams;
    }

    public Question[] getExamQuestions(int courseID) {
        super.setFilePath("database/exams/"+courseID+"_exam.txt");
        super.setFile();
        Question[] questions = new Question[super.numberOfLines()];
        String[] lines = super.getFile().readAllFile().split("\n");
        int i = 0;
        for (String line: lines) {
            String[] questionData = line.substring(1, line.length() - 1).split(", ");
            questions[i] = new Question(questionData[1], questionData[2]);
            questions[i].setQuestionID(Integer.parseInt(questionData[0]));
            i++;
        }
        return questions;
    }

//    public boolean submitExam(int courseID)

    public String[] getAllCoursesIDForStudent(int studentID) {
        super.setFilePath("database/users/students/"+studentID+"_courses.txt");
        super.setFile();
        String[] coursesIDs = super.getFile().readAllFile().split("\n");
        int i = 0;
        for (String courseID: coursesIDs) {
            courseID = courseID.substring(1, courseID.length() - 1);
            coursesIDs[i] = courseID;
            i++;
        }
        return coursesIDs;
    }
}
