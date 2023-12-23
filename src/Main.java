import model.*;
import view.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            char userChoice = MainMenus.mainMenu();
            if (userChoice == '1') {
                int counter = 4;
                while (true) {
                    if (counter > 0) {
                        userChoice = MainMenus.loginOptions();
                        // login as admin
                        if (userChoice == '1') {
                            Admin admin = new Admin();
                            String userType = "admin";
                            MainMenus.loginMenu();
                            System.out.print("Enter your email: ");
                            String email = input.nextLine();
                            System.out.print("Enter your password: ");
                            String password = input.nextLine();
                            if (admin.login(userType, email, password)) {
                                while (true) {
                                    userChoice = AdminMenus.mainMenu();
                                    // users
                                    if (userChoice == '1') {
                                        while (true) {
                                            userChoice = AdminMenus.adminUsersMenu();
                                            // view all users
                                            if (userChoice == '1') {
                                                while (true) {
                                                    userChoice = AdminMenus.adminAddUserTypeMenu();
                                                    if (userChoice == '1') {
                                                        userType = "lecturer";
                                                        Person[] people = admin.viewAllPeople(userType);
                                                        if (people[0] != null) {
                                                            for (Person person: people) {
                                                                System.out.println(person);
                                                            }
                                                        }
                                                        else {
                                                            System.out.println("Users are not found");
                                                        }
                                                        System.out.print("To exit, please press enter");
                                                        input.nextLine();
                                                    }
                                                    else if (userChoice == '2') {
                                                        userType = "student";
                                                        Person[] people = admin.viewAllPeople(userType);
                                                        if (people[0] != null) {
                                                            for (Person person: people) {
                                                                System.out.println(person);
                                                            }
                                                        }
                                                        else {
                                                            System.out.println("Users are not found");
                                                        }
                                                        System.out.print("To exit, please press enter");
                                                        input.nextLine();
                                                    }
                                                    else if (userChoice == '3') {
                                                        break;
                                                    }
                                                    else {
                                                        System.out.println("Please enter a valid choice");
                                                    }
                                                }
                                            }
                                            // add user
                                            else if (userChoice == '2') {
                                                while (true) {
                                                    userChoice = AdminMenus.adminAddUserTypeMenu();
                                                    if (userChoice == '1') {
                                                        AdminMenus.addUser();
                                                        userType = "lecturer";
                                                        System.out.print("Enter name: ");
                                                        String name = input.nextLine();
                                                        System.out.print("Enter email: ");
                                                        email = input.nextLine();
                                                        System.out.print("Enter password: ");
                                                        password = input.nextLine();
                                                        Lecturer lecturer = new Lecturer(userType, name, email, password);
                                                        if (admin.addUser(userType, lecturer)) {
                                                            System.out.println("The user has been added successfully.");
                                                        }
                                                        else {
                                                            System.out.println("Please Try Again");
                                                        }
                                                    }
                                                    else if (userChoice == '2') {
                                                        AdminMenus.addUser();
                                                        userType = "student";
                                                        System.out.print("Enter name: ");
                                                        String name = input.nextLine();
                                                        System.out.print("Enter email: ");
                                                        email = input.nextLine();
                                                        System.out.print("Enter password: ");
                                                        password = input.nextLine();
                                                        Student student = new Student(userType, name, email, password);
                                                        if (admin.addUser(userType, student)) {
                                                            System.out.println("The user has been added successfully.");
                                                        }
                                                        else {
                                                            System.out.println("Please Try Again");
                                                        }
                                                    }
                                                    else if (userChoice == '3') {
                                                        break;
                                                    }
                                                    else {
                                                        System.out.println("Please enter a valid choice");
                                                    }
                                                }
                                            }
                                            // update user
                                            else if (userChoice == '3') {
                                                while (true) {
                                                    userChoice = AdminMenus.adminAddUserTypeMenu();
                                                    if (userChoice == '1') {
                                                        AdminMenus.addUser();
                                                        userType = "lecturer";
                                                        System.out.print("Enter lecturer ID: ");
                                                        String userID = input.nextLine();
                                                        if (! userID.isEmpty()) {
                                                            System.out.println("Note: If you do not want to change any value, do not put anything");
                                                            System.out.print("Enter new name: ");
                                                            String name = input.nextLine();
                                                            System.out.print("Enter new email: ");
                                                            email = input.nextLine();
                                                            System.out.print("Enter new password: ");
                                                            password = input.nextLine();
                                                            Lecturer lecturer = new Lecturer(userType, name, email, password);
                                                            if (admin.updateUser(Integer.parseInt(userID), userType, lecturer)) {
                                                                System.out.println("Update user has been successfully.");
                                                            }
                                                            else {
                                                                System.out.println("Please Try Again");
                                                            }
                                                        }
                                                        else {
                                                            System.out.println("Please Try Again");
                                                        }
                                                    }
                                                    else if (userChoice == '2') {
                                                        AdminMenus.addUser();
                                                        userType = "student";
                                                        System.out.print("Enter student ID: ");
                                                        String userID = input.nextLine();
                                                        if (! userID.isEmpty()) {
                                                            System.out.println("Note: If you do not want to change any value, do not put anything");
                                                            System.out.print("Enter new name: ");
                                                            String name = input.nextLine();
                                                            System.out.print("Enter new email: ");
                                                            email = input.nextLine();
                                                            System.out.print("Enter new password: ");
                                                            password = input.nextLine();
                                                            Student student = new Student(userType, name, email, password);
                                                            if (admin.updateUser(Integer.parseInt(userID), userType, student)) {
                                                                System.out.println("Update user has been successfully.");
                                                            }
                                                            else {
                                                                System.out.println("Please Try Again");
                                                            }
                                                        }
                                                        else {
                                                            System.out.println("Please Try Again");
                                                        }
                                                    }
                                                    else if (userChoice == '3') {
                                                        break;
                                                    }
                                                    else {
                                                        System.out.println("Please enter a valid choice");
                                                    }
                                                }
                                            }
                                            // delete user
                                            else if (userChoice == '4') {
                                                while (true) {
                                                    userChoice = AdminMenus.adminAddUserTypeMenu();
                                                    if (userChoice == '1') {
                                                        AdminMenus.addUser();
                                                        userType = "lecturer";
                                                        System.out.print("Enter lecturer ID: ");
                                                        String userID = input.nextLine();
                                                        if (! userID.isEmpty()) {
                                                            if (admin.deleteUser(Integer.parseInt(userID), userType) == 1) {
                                                                System.out.println("Delete user has been successfully.");
                                                            }
                                                            else {
                                                                System.out.println("Please Try Again");
                                                            }
                                                        }
                                                        else {
                                                            System.out.println("Please Try Again");
                                                        }
                                                    }
                                                    else if (userChoice == '2') {
                                                        AdminMenus.addUser();
                                                        userType = "student";
                                                        System.out.print("Enter student ID: ");
                                                        String userID = input.nextLine();
                                                        if (! userID.isEmpty()) {
                                                            if (admin.deleteUser(Integer.parseInt(userID), userType) == 1) {
                                                                System.out.println("Delete user has been successfully.");
                                                            }
                                                            else {
                                                                System.out.println("Please Try Again");
                                                            }
                                                        }
                                                        else {
                                                            System.out.println("Please Try Again");
                                                        }
                                                    }
                                                    else if (userChoice == '3') {
                                                        break;
                                                    }
                                                    else {
                                                        System.out.println("Please enter a valid choice");
                                                    }
                                                }
                                            }
                                            // exit
                                            else if (userChoice == '5') {
                                                break;
                                            }
                                            else {
                                                System.out.println("Please enter a valid choice");
                                            }
                                        }
                                    }
                                    // courses
                                    else if (userChoice == '2') {
                                        while (true) {
                                            userChoice = AdminMenus.adminCoursesMenu();
                                            // view all courses
                                            if (userChoice == '1') {
                                                Course[] courses = admin.viewAllCourses();
                                                if (courses[0] != null) {
                                                    for (Course course: courses) {
                                                        System.out.println(course);
                                                    }
                                                }
                                                else {
                                                    System.out.println("Courses are not found");
                                                }
                                                System.out.print("To exit, please press enter");
                                                input.nextLine();
                                            }
                                            else if (userChoice == '2') {
                                                AdminMenus.addCourse();
                                                System.out.print("Enter Course Name: ");
                                                String courseName = input.nextLine();
                                                System.out.print("Enter Course Description: ");
                                                String courseDescription = input.nextLine();
                                                System.out.print("Enter lecturer ID: ");
                                                String lecturerID = input.nextLine();
                                                Course course = new Course(courseName, courseDescription, lecturerID);
                                                if (admin.addCourse(course)) {
                                                    System.out.println("The Course has been added successfully.");
                                                }
                                                else {
                                                    System.out.println("Please Try Again");
                                                }
                                            }
                                            else if (userChoice == '3') {
                                                AdminMenus.addCourse();
                                                System.out.print("Enter course ID: ");
                                                String courseID = input.nextLine();
                                                if (! courseID.isEmpty()) {
                                                    System.out.println("Note: If you do not want to change any value, do not put anything");
                                                    System.out.print("Enter new course name: ");
                                                    String courseName = input.nextLine();
                                                    System.out.print("Enter new course description: ");
                                                    String courseDescription = input.nextLine();
                                                    System.out.print("Enter new lecturer ID: ");
                                                    String courseLecturerID = input.nextLine();
                                                    Course course = new Course(courseName, courseDescription, courseLecturerID);
                                                    course.setCourseID(Integer.parseInt(courseID));
                                                    if (admin.updateCourse(Integer.parseInt(courseID), course)) {
                                                        System.out.println("Update course has been successfully.");
                                                    }
                                                    else {
                                                        System.out.println("Please Try Again");
                                                    }
                                                }
                                                else {
                                                    System.out.println("Please Try Again");
                                                }
                                            }
                                            else if (userChoice == '4') {
                                                AdminMenus.addCourse();
                                                System.out.print("Enter course ID: ");
                                                String courseID = input.nextLine();
                                                if (! courseID.isEmpty()) {
                                                    if (admin.deleteCourse(Integer.parseInt(courseID)) == 1) {
                                                        System.out.println("Delete course has been successfully.");
                                                    }
                                                    else {
                                                        System.out.println("Please Try Again");
                                                    }
                                                }
                                                else {
                                                    System.out.println("Please Try Again");
                                                }
                                            }
                                            else if (userChoice == '5') {
                                                break;
                                            }
                                            else {
                                                System.out.println("Please enter a valid choice");
                                            }
                                        }
                                    }
                                    // Add Student To Course
                                    else if (userChoice == '3') {
                                        AdminMenus.addUser();
                                        System.out.print("Enter course ID: ");
                                        String courseID = input.nextLine();
                                        System.out.print("Enter student ID: ");
                                        String studentID = input.nextLine();
                                        if (admin.addStudentToCourse(courseID, studentID)) {
                                            System.out.println("This student has been added to the course");
                                        }
                                        else System.out.println("Please Try Again");
                                    }
                                    // block student from access content
                                    else if (userChoice == '4') {
                                        AdminMenus.addUser();
                                        System.out.print("Enter course ID: ");
                                        String courseID = input.nextLine();
                                        System.out.print("Enter student ID: ");
                                        String studentID = input.nextLine();
                                        if (admin.blockUser(courseID, studentID)) {
                                            System.out.println("The student has been successfully blocked from accessing the content");
                                        }
                                        else System.out.println("Please Try Again");
                                    }
                                    // reports
                                    else if (userChoice == '5') {
                                        while (true) {
                                            userChoice = AdminMenus.adminReportTypeMenu();
                                            if (userChoice == '1') {
                                                String type = "exam";
                                                System.out.print("Enter Course ID: ");
                                                String courseID = input.nextLine();
                                                System.out.println("----------------------------------------------------------------------------------------------------------------------");
                                                if (admin.generateReport(type, courseID).getReportType() != null) {
                                                    System.out.println(admin.generateReport(type, courseID));
                                                }
                                                else {
                                                    System.out.println("there is no report");
                                                }
                                                System.out.print("To exit, please press enter");
                                                input.nextLine();
                                            }
                                            else if (userChoice == '2') {
                                                String type = "assignment";
                                                System.out.print("Enter Course ID: ");
                                                String courseID = input.nextLine();
                                                System.out.println("----------------------------------------------------------------------------------------------------------------------");
                                                if (admin.generateReport(type, courseID).getReportType() != null) {
                                                    System.out.println(admin.generateReport(type, courseID));
                                                }
                                                else {
                                                    System.out.println("there is no report");
                                                }
                                                System.out.print("To exit, please press enter");
                                                input.nextLine();
                                            }
                                            else if (userChoice == '3') {
                                                break;
                                            }
                                            else {
                                                System.out.println("Please enter a valid choice");
                                            }
                                        }

                                    }
                                    // profile
                                    else if (userChoice == '6') {
                                        while (true) {
                                            userChoice = MainMenus.profileMenu();
                                            if (userChoice == '1') {
                                                MainMenus.profile();
                                                System.out.println(admin);
                                                System.out.print("To exit, please press enter");
                                                input.nextLine();
                                            }
                                            else if (userChoice == '2') {
                                                MainMenus.profile();
                                                System.out.print("Enter new name: ");
                                                String name = input.nextLine();
                                                System.out.print("Enter new password: ");
                                                password = input.nextLine();
                                                if (! name.isEmpty()) {
                                                    admin.setName(name);
                                                }
                                                if (! password.isEmpty()) {
                                                    admin.setPassword(password);
                                                }
                                                if (admin.updateProfile(admin)) {
                                                    System.out.println("The account has been updated successfully.");
                                                }
                                                else {
                                                    System.out.println("Please try again.");
                                                }
                                            }
                                            else if (userChoice == '3') {
                                                break;
                                            }
                                            else {
                                                System.out.println("Please enter a valid choice");
                                            }
                                        }
                                    }
                                    // logout
                                    else if (userChoice == '7') {
                                        admin.logout();
                                        break;
                                    }
                                    else {
                                        System.out.println("Please enter a valid choice");
                                    }
                                }
                            }
                            else
                                System.out.println("Please log in again");
                        }
                        // login as lecturer
                        else if (userChoice == '2') {
                            Lecturer lecturer = new Lecturer();
                            String userType = "lecturer";
                            MainMenus.loginMenu();
                            System.out.print("Enter your email: ");
                            String email = input.nextLine();
                            System.out.print("Enter your password: ");
                            String password = input.nextLine();
                            if (lecturer.login(userType, email, password)) {
                                while (true) {
                                    userChoice = LecturerMenus.mainMenu();
                                    // View all courses I teach
                                    if (userChoice == '1') {
                                        Course[] courses = lecturer.viewAllCoursesITeach(lecturer.getUserID());
                                        for (Course course: courses) {
                                            if (course != null) {
                                                System.out.println(course);
                                            }
                                            else {
                                                System.out.println("No Courses");
                                            }
                                        }
                                        System.out.print("To exit, please press enter");
                                        input.nextLine();
                                    }
                                    // Exams
                                    else if (userChoice == '2') {
                                        while (true) {
                                            userChoice = LecturerMenus.lecturerExamMenu();
                                            if (userChoice == '1') {
                                                LecturerMenus.lecturerMenu();
                                                System.out.print("Enter Course ID: ");
                                                int courseID = input.nextInt();
                                                input.nextLine();
                                                if (lecturer.ensureLecturerTeachesCourse(lecturer.getUserID(), courseID)) {
                                                    System.out.print("Enter Number Of Questions: ");
                                                    String numberOfQuestions = input.nextLine();
                                                    Question[] questions = new Question[Integer.parseInt(numberOfQuestions)];
                                                    for (int i = 0; i < Integer.parseInt(numberOfQuestions); i++) {
                                                        System.out.print("Enter Question: ");
                                                        // String inputs after integer input gets skipped in java
                                                        String que = input.nextLine();
                                                        System.out.print("Enter Answer: ");
                                                        String ans = input.nextLine();
                                                        questions[i] = new Question(que, ans);
                                                    }
                                                    System.out.print("Enter Degree: ");
                                                    double degree = input.nextDouble();
                                                    Exam exam = new Exam(courseID, Integer.parseInt(numberOfQuestions), degree);
                                                    if (lecturer.addQuestions(courseID, questions, exam)) {
                                                        System.out.println("Add exam successfully");
                                                    }
                                                    else {
                                                        System.out.println("Please try again.");
                                                    }
                                                }
                                                else {
                                                    System.out.println("You cannot take an exam for this course");
                                                }
                                            }
                                            else if (userChoice == '2') {
                                                LecturerMenus.lecturerMenu();
                                                System.out.print("Enter Course ID: ");
                                                int courseID = input.nextInt();
                                                input.nextLine();
                                                if (lecturer.ensureLecturerTeachesCourse(lecturer.getUserID(), courseID)) {
                                                    System.out.print("Enter Exam ID: ");
                                                    String examID = input.nextLine();
                                                    System.out.println("Note: Put zero if you do not want to change the score value");
                                                    System.out.print("Enter new Degree: ");
                                                    double degree = input.nextDouble();
                                                    Exam exam = new Exam(Integer.parseInt(examID), 0, degree);
                                                    if (lecturer.updateExam(Integer.parseInt(examID), exam)) {
                                                        System.out.println("Update exam successfully");
                                                    }
                                                    else {
                                                        System.out.println("Please try again.");
                                                    }
                                                }
                                                else {
                                                    System.out.println("You cannot take an exam for this course");
                                                }
                                            }
                                            else if (userChoice == '3') {
                                                LecturerMenus.lecturerMenu();
                                                System.out.print("Enter Course ID: ");
                                                int courseID = input.nextInt();
                                                input.nextLine();
                                                if (lecturer.ensureLecturerTeachesCourse(lecturer.getUserID(), courseID)) {
                                                    System.out.print("Enter Exam ID: ");
                                                    String examID = input.nextLine();
                                                    if (lecturer.deleteExamOrAssignment("exam", courseID, Integer.parseInt(examID)) == 1) {
                                                        System.out.println("Delete exam successfully");
                                                    }
                                                    else {
                                                        System.out.println("Please try again.");
                                                    }
                                                }
                                                else {
                                                    System.out.println("You cannot delete this exam");
                                                }
                                            }
                                            else if (userChoice == '4') {
                                                break;
                                            }
                                            else {
                                                System.out.println("Please enter a valid choice");
                                            }
                                        }
                                    }
                                    // Assignments
                                    else if (userChoice == '3') {
                                        while (true) {
                                            userChoice = LecturerMenus.lecturerAssignmentMenu();
                                            if (userChoice == '1') {
                                                LecturerMenus.lecturerMenu();
                                                System.out.print("Enter Course ID: ");
                                                int courseID = input.nextInt();
                                                input.nextLine();
                                                if (lecturer.ensureLecturerTeachesCourse(lecturer.getUserID(), courseID)) {
                                                    System.out.print("Enter Number Of Questions: ");
                                                    String numberOfQuestions = input.nextLine();
                                                    Question[] questions = new Question[Integer.parseInt(numberOfQuestions)];
                                                    for (int i = 0; i < Integer.parseInt(numberOfQuestions); i++) {
                                                        System.out.print("Enter Question: ");
                                                        // String inputs after integer input gets skipped in java
                                                        String que = input.nextLine();
                                                        System.out.print("Enter Answer: ");
                                                        String ans = input.nextLine();
                                                        questions[i] = new Question(que, ans);
                                                    }
                                                    System.out.print("Enter Degree: ");
                                                    double degree = input.nextDouble();
                                                    Assignment assignment = new Assignment(courseID, Integer.parseInt(numberOfQuestions), degree);
                                                    if (lecturer.addQuestions(courseID, questions, assignment)) {
                                                        System.out.println("Add assignment successfully");
                                                    }
                                                    else {
                                                        System.out.println("Please try again.");
                                                    }
                                                }
                                                else {
                                                    System.out.println("You cannot take an assignment for this course");
                                                }
                                            }
                                            else if (userChoice == '2') {
                                                LecturerMenus.lecturerMenu();
                                                System.out.print("Enter Course ID: ");
                                                int courseID = input.nextInt();
                                                input.nextLine();
                                                if (lecturer.ensureLecturerTeachesCourse(lecturer.getUserID(), courseID)) {
                                                    System.out.print("Enter Assignment ID: ");
                                                    String assignmentID = input.nextLine();
                                                    System.out.println("Note: Put zero if you do not want to change the score value");
                                                    System.out.print("Enter new Degree: ");
                                                    double degree = input.nextDouble();
                                                    Assignment assignment = new Assignment(Integer.parseInt(assignmentID), 0, degree);
                                                    if (lecturer.updateAssignment(Integer.parseInt(assignmentID), assignment)) {
                                                        System.out.println("Update assignment successfully");
                                                    }
                                                    else {
                                                        System.out.println("Please try again.");
                                                    }
                                                }
                                                else {
                                                    System.out.println("You cannot take an exam for this course");
                                                }
                                            }
                                            else if (userChoice == '3') {
                                                LecturerMenus.lecturerMenu();
                                                System.out.print("Enter Course ID: ");
                                                int courseID = input.nextInt();
                                                input.nextLine();
                                                if (lecturer.ensureLecturerTeachesCourse(lecturer.getUserID(), courseID)) {
                                                    System.out.print("Enter Assignment ID: ");
                                                    String assignmentID = input.nextLine();
                                                    if (lecturer.deleteExamOrAssignment("assignment", courseID, Integer.parseInt(assignmentID)) == 1) {
                                                        System.out.println("Delete assignment successfully");
                                                    }
                                                    else {
                                                        System.out.println("Please try again.");
                                                    }
                                                }
                                                else {
                                                    System.out.println("You cannot delete this assignment");
                                                }
                                            }
                                            else if (userChoice == '4') {
                                                break;
                                            }
                                            else {
                                                System.out.println("Please enter a valid choice");
                                            }
                                        }
                                    }
                                    // profile
                                    else if (userChoice == '4') {
                                        while (true) {
                                            userChoice = MainMenus.profileMenu();
                                            if (userChoice == '1') {
                                                MainMenus.profile();
                                                System.out.println(lecturer);
                                                System.out.print("To exit, please press enter");
                                                input.nextLine();
                                            }
                                            else if (userChoice == '2') {
                                                MainMenus.profile();
                                                System.out.print("Enter new name: ");
                                                String name = input.nextLine();
                                                System.out.print("Enter new password: ");
                                                password = input.nextLine();
                                                if (! name.isEmpty()) {
                                                    lecturer.setName(name);
                                                }
                                                if (! password.isEmpty()) {
                                                    lecturer.setPassword(password);
                                                }
                                                if (lecturer.updateProfile(lecturer)) {
                                                    System.out.println("The account has been updated successfully.");
                                                }
                                                else {
                                                    System.out.println("Please try again.");
                                                }
                                            }
                                            else if (userChoice == '3') {
                                                break;
                                            }
                                            else {
                                                System.out.println("Please enter a valid choice");
                                            }
                                        }
                                    }
                                    // logout
                                    else if (userChoice == '5') {
                                        lecturer.logout();
                                        break;
                                    }
                                    else {
                                        System.out.println("Please enter a valid choice");
                                    }
                                }
                            }
                            else
                                System.out.println("Please log in again");
                        }
                        // login as student
                        else if (userChoice == '3') {
                            Student student = new Student();
                            String userType = "student";
                            MainMenus.loginMenu();
                            System.out.print("Enter your email: ");
                            String email = input.nextLine();
                            System.out.print("Enter your password: ");
                            String password = input.nextLine();
                            if (student.login(userType, email, password)) {
                                while (true) {
                                    userChoice = StudentMenus.mainMenu();
                                    // View all courses registered for me
                                    if (userChoice == '1') {
                                        StudentMenus.studentMenu();
                                        Course[] courses = student.viewAllMyCourses(student.getUserID());
                                        if (courses[0] != null) {
                                            for (Course course: courses) {
                                                System.out.println(course);
                                            }
                                        }
                                        else {
                                            System.out.println("You are not registered in any course.");
                                        }
                                        System.out.print("To exit, please press enter");
                                        input.nextLine();
                                    }
                                    // View course content
                                    else if (userChoice == '2') {
                                        StudentMenus.studentMenu();
                                        System.out.print("Enter the course ID to view its content: ");
                                        int courseID = input.nextInt();
                                        input.nextLine();
                                        System.out.println("Course content: "+student.viewCourseContent(student.getUserID(), courseID));
                                        System.out.print("To exit, please press enter");
                                        input.nextLine();
                                    }
                                    // View currently available exams
                                    else if (userChoice == '3') {
                                        Exam[] exams = student.viewAllExamsAvailableForStudent(student.getUserID());
                                        int[] examsIDs = new int[exams.length];
                                        if (exams[0] == null) {
                                            System.out.println("There are no exams currently");
                                            System.out.print("To exit, please press enter");
                                            input.nextLine();
                                        }
                                        else {
                                            int i = 0;
                                            for (Exam exam: exams) {
                                                if (exams[i] != null) {
                                                    System.out.println(exam);
                                                    examsIDs[i] = exam.getExamID();
                                                    i++;
                                                }
                                                else break;
                                            }
                                            System.out.println("Note: If you want to exit, write -1");
                                            System.out.print("Enter your exam ID number to take the exam: ");
                                            int examID = input.nextInt();
                                            input.nextLine();
                                            int courseID = 0;
                                            if (examID != -1) {
                                                boolean check = true;
                                                double examGrade = 0.0;
                                                int numberOfQuestions = 0;
                                                i = 0;
                                                for (int id: examsIDs) {
                                                    if (examID == id) {
                                                        courseID = exams[i].getCourseID();
                                                        examGrade = exams[i].getDegree();
                                                        numberOfQuestions = exams[i].getNumberOfQuestions();
                                                        check = true;
                                                        break;
                                                    }
                                                    else check = false;
                                                    i++;
                                                }
                                                if (check) {
                                                    Question[] questions = student.getExamQuestions(courseID);
                                                    String userAnswer;
                                                    double studentGrade = 0.0;
                                                    for (Question question: questions) {
                                                        System.out.println("-------------------------------------------");
                                                        System.out.println(question);
                                                        System.out.print("Enter your answer: ");
                                                        userAnswer = input.nextLine();
                                                        if (userAnswer.equals(question.getAnswer())) {
                                                            studentGrade += (examGrade / numberOfQuestions);
                                                        }
                                                    }
                                                    System.out.println("-------------------------------------------");
                                                    System.out.println("Your Grade Is: " + studentGrade);
                                                    System.out.println(student.submitExamOrAssignment("exam", courseID, student.getUserID(), studentGrade));
                                                    System.out.print("To exit, please press enter");
                                                    input.nextLine();
                                                }
                                                else {
                                                    System.out.println("Please enter valid ID.");
                                                }
                                            }
                                        }
                                    }
                                    // View currently available assignments
                                    else if (userChoice == '4') {
                                        Assignment[] assignments = student.viewAllAssignmentsAvailableForStudent(student.getUserID());
                                        int[] assignmentsIDs = new int[assignments.length];
                                        if (assignments[0] == null) {
                                            System.out.println("There are no exams currently");
                                            System.out.print("To exit, please press enter");
                                            input.nextLine();
                                        }
                                        else {
                                            int i = 0;
                                            for (Assignment assignment: assignments) {
                                                if (assignments[i] != null) {
                                                    System.out.println(assignment);
                                                    assignmentsIDs[i] = assignment.getAssignmentID();
                                                    i++;
                                                }
                                                else break;
                                            }
                                            System.out.println("Note: If you want to exit, write -1");
                                            System.out.print("Enter your assignment ID number to take the assignment: ");
                                            int assignmentID = input.nextInt();
                                            input.nextLine();
                                            int courseID = 0;
                                            if (assignmentID != -1) {
                                                boolean check = true;
                                                double assignmentGrade = 0.0;
                                                int numberOfQuestions = 0;
                                                i = 0;
                                                for (int id: assignmentsIDs) {
                                                    if (assignmentID == id) {
                                                        courseID = assignments[i].getCourseID();
                                                        assignmentGrade = assignments[i].getDegree();
                                                        numberOfQuestions = assignments[i].getNumberOfQuestions();
                                                        check = true;
                                                        break;
                                                    }
                                                    else check = false;
                                                    i++;
                                                }
                                                if (check) {
                                                    Question[] questions = student.getAssignmentQuestions(courseID);
                                                    String userAnswer;
                                                    double studentGrade = 0.0;
                                                    for (Question question: questions) {
                                                        System.out.println("-------------------------------------------");
                                                        System.out.println(question);
                                                        System.out.print("Enter your answer: ");
                                                        userAnswer = input.nextLine();
                                                        if (userAnswer.equals(question.getAnswer())) {
                                                            studentGrade += (assignmentGrade / numberOfQuestions);
                                                        }
                                                    }
                                                    System.out.println("-------------------------------------------");
                                                    System.out.println("Your Grade In Assignment Is: " + studentGrade);
                                                    System.out.println(student.submitExamOrAssignment("assignment", courseID, student.getUserID(), studentGrade));
                                                    System.out.print("To exit, please press enter");
                                                    input.nextLine();
                                                }
                                                else {
                                                    System.out.println("Please enter valid ID.");
                                                }
                                            }
                                        }
                                    }
                                    // profile
                                    else if (userChoice == '5') {
                                        while (true) {
                                            userChoice = MainMenus.profileMenu();
                                            if (userChoice == '1') {
                                                MainMenus.profile();
                                                System.out.println(student);
                                                System.out.print("To exit, please press enter");
                                                input.nextLine();
                                            }
                                            else if (userChoice == '2') {
                                                MainMenus.profile();
                                                System.out.print("Enter new name: ");
                                                String name = input.nextLine();
                                                System.out.print("Enter new password: ");
                                                password = input.nextLine();
                                                if (! name.isEmpty()) {
                                                    student.setName(name);
                                                }
                                                if (! password.isEmpty()) {
                                                    student.setPassword(password);
                                                }
                                                if (student.updateProfile(student)) {
                                                    System.out.println("The account has been updated successfully.");
                                                }
                                                else {
                                                    System.out.println("Please try again.");
                                                }
                                            }
                                            else if (userChoice == '3') {
                                                break;
                                            }
                                            else {
                                                System.out.println("Please enter a valid choice");
                                            }
                                        }
                                    }
                                    // logout
                                    else if (userChoice == '6') {
                                        student.logout();
                                        break;
                                    }
                                    else
                                        System.out.println("Please log in again");
                                }
                            }
                            else
                                System.out.println("Please log in again");
                        }
                        else
                            break;
                        counter--;
                        System.out.println("Check your email and password, note! You have " + counter + " attempts to log in");
                    }
                    else
                        break;
                }
            }
            else if (userChoice == '2') {
                break;
            }
            else {
                System.out.println("A problem occurred. Please try again and make sure that your\n" +
                        "choice is 1 if you want to log in or 2 to exit.");
            }
        }
    }
}