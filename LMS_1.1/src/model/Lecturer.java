package model;

public class Lecturer extends Person {
    public Lecturer() {
        super();
    }
    public Lecturer(String userType) {
        super(userType);
    }
    public Lecturer(String userType, String name) {
        super(userType, name);
    }
    public Lecturer(String userType, String name, String email) {
        super(userType, name, email);
    }
    public Lecturer(String userType, String name, String email, String password) {
        super(userType, name, email, password);
    }
    public Course[] viewAllCoursesITeach(int currentUserID) {
        super.setFilePath("database/courses/course.txt");
        super.setFile();
        String[] lines = super.getFile().readAllFile().split("\n");
        String myCourses = "";
        for (String line: lines) {
            String[] dataLine = line.substring(1, line.length() - 1).split(", ");
            if (dataLine[3].equals(Integer.toString(currentUserID))) {
                myCourses += line + "\n";
            }
        }
        lines = myCourses.split("\n");
        Course[] courses = new Course[lines.length];
        int i = 0;
        for (String line: lines) {
            String[] dataLine = line.substring(1, line.length() - 1).split(", ");
            if (dataLine[3].equals(Integer.toString(currentUserID))) {
                courses[i] = new Course(dataLine[1], dataLine[2], dataLine[3]);
                courses[i].setCourseID(Integer.parseInt(dataLine[0]));
                i++;
            }
        }
        return courses;
    }
    public boolean addExam(int courseID, Question[] questions, Exam exam) {
        super.setFilePath("database/exams/exam.txt");
        super.setFile();
        if (super.search(1, Integer.toString(courseID)).equals("0")) {
            if (super.add(exam.arrayStringData())) {
                super.setFilePath("database/exams/"+courseID+"_exam.txt");
                super.setFile();
                if (super.getFile().createFile() == 1) {
                    for (Question question: questions) {
                        super.add(question.arrayStringData());
                    }
                    return true;
                }
            }
        }
        return false;
    }
    public boolean updateExam(int examID, Exam newExam) {
        super.setFilePath("database/exams/exam.txt");
        super.setFile();
        String line = super.search(0, Integer.toString(examID));
        if (! line.equals("0")) {
            String[] examData = line.substring(1, line.length() - 1).split(", ");
            newExam.setExamID(examID);
            newExam.setCourseID(Integer.parseInt(examData[1]));
            newExam.setNumberOfQuestions(Integer.parseInt(examData[2]));
            if (newExam.getDegree() == 0) {
                newExam.setDegree(Double.parseDouble(examData[3]));
            }
            line = newExam.arrayStringData();
            return super.update(examID, line);
        }
        return false;
    }
    public boolean addAssignment(int courseID, Question[] questions, Assignment assignment) {
        super.setFilePath("database/assignments/assignment.txt");
        super.setFile();
        if (super.search(1, Integer.toString(courseID)).equals("0")) {
            if (super.add(assignment.arrayStringData())) {
                super.setFilePath("database/assignments/"+courseID+"_assignment.txt");
                super.setFile();
                if (super.getFile().createFile() == 1) {
                    for (Question question: questions) {
                        super.add(question.arrayStringData());
                    }
                    return true;
                }
            }
        }
        return false;
    }
    public boolean updateAssignment(int examID, Assignment newAssignment) {
        super.setFilePath("database/assignments/assignment.txt");
        super.setFile();
        String line = super.search(0, Integer.toString(examID));
        if (! line.equals("0")) {
            String[] examData = line.substring(1, line.length() - 1).split(", ");
            newAssignment.setAssignmentID(examID);
            newAssignment.setCourseID(Integer.parseInt(examData[1]));
            newAssignment.setNumberOfQuestions(Integer.parseInt(examData[2]));
            if (newAssignment.getDegree() == 0) {
                newAssignment.setDegree(Double.parseDouble(examData[3]));
            }
            line = newAssignment.arrayStringData();
            return super.update(examID, line);
        }
        return false;
    }
    public int deleteExamOrAssignment(String type, int courseID, int ID) {
        String folder = "";
        String file = "";
        if (type.equals("exam")) {
            folder = "exams";
            file = "exam";
        }
        else {
            folder = "assignments";
            file = "assignment";
        }
        super.setFilePath("database/"+folder+"/"+courseID+"_"+file+".txt");
        super.setFile();
        if (getFile().removeFile() == 1) {
            super.setFilePath("database/"+folder+"/"+file+".txt");
            super.setFile();
            return delete(ID);
        }
        return 0;
    }
    public boolean ensureLecturerTeachesCourse (int lecturerID, int courseID) {
        super.setFilePath("database/courses/course.txt");
        super.setFile();
        String line = super.search(0, Integer.toString(courseID));
        if (! line.equals("0")) {
            String[] courseData = line.substring(1, line.length() - 1).split(", ");
            return courseData[3].equals(Integer.toString(lecturerID));
        }
        return false;
    }
}
