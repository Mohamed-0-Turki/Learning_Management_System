package view;

import java.util.Scanner;

public class AdminMenus {
    static public Scanner input = new Scanner(System.in);

    public static char mainMenu() {
        System.out.println("\n");
        System.out.println("===========================================");
        System.out.println("==============  Admin Menu  ===============");
        System.out.println("===========================================");
        System.out.println("1. Users");
        System.out.println("2. Courses");
        System.out.println("3. Add Student To Course");
        System.out.println("4. Block student from access content");
        System.out.println("5. Reports");
        System.out.println("6. Profile");
        System.out.println("7. Logout");
        System.out.print("Enter what you want: ");
        return input.nextLine().charAt(0);

    }

    public static char adminUsersMenu() {
        System.out.println("\n");
        System.out.println("===========================================");
        System.out.println("===========  Admin Users Menu  ============");
        System.out.println("===========================================");
        System.out.println("1. View All Users");
        System.out.println("2. Add User");
        System.out.println("3. Update User");
        System.out.println("4. Delete User");
        System.out.println("5. Exit");
        System.out.print("Enter what you want: ");
        return input.nextLine().charAt(0);
    }
    public static char adminAddUserTypeMenu() {
        System.out.println("\n");
        System.out.println("===========================================");
        System.out.println("===========  Admin Users Menu  ============");
        System.out.println("===========================================");
        System.out.println("1. Lecturer");
        System.out.println("2. Student");
        System.out.println("3. Exit");
        System.out.print("Enter what you want: ");
        return input.nextLine().charAt(0);
    }
    public static char adminReportTypeMenu() {
        System.out.println("\n");
        System.out.println("===========================================");
        System.out.println("===========  Admin Users Menu  ============");
        System.out.println("===========================================");
        System.out.println("1. Exams");
        System.out.println("2. Assignments");
        System.out.println("3. Exit");
        System.out.print("Enter what you want: ");
        return input.nextLine().charAt(0);
    }
    public static void addUser() {
        System.out.println("\n");
        System.out.println("===========================================");
        System.out.println("===========  Admin Users Menu  ============");
        System.out.println("===========================================");
    }

    public static char adminCoursesMenu() {
        System.out.println("\n");
        System.out.println("===========================================");
        System.out.println("===========  Admin Courses Menu  ============");
        System.out.println("===========================================");
        System.out.println("1. View All Courses");
        System.out.println("2. Add Course");
        System.out.println("3. Update Course");
        System.out.println("4. Delete Course");
        System.out.println("5. Exit");
        System.out.print("Enter what you want: ");
        return input.nextLine().charAt(0);
    }

    public static void addCourse() {
        System.out.println("\n");
        System.out.println("===========================================");
        System.out.println("===========  Admin Courses banal ============");
        System.out.println("===========================================");
    }
}
