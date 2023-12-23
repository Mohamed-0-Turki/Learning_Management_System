package view;

import java.util.Scanner;

public class LecturerMenus {
    static public Scanner input = new Scanner(System.in);

    public static char mainMenu() {
        System.out.println("\n");
        System.out.println("==========================================");
        System.out.println("============  Lecturer Menu  =============");
        System.out.println("==========================================");
        System.out.println("1. View all courses I teach");
        System.out.println("2. Exams");
        System.out.println("3. Assignments");
        System.out.println("4. Profile");
        System.out.println("5. Logout");
        System.out.print("Enter what you want: ");
        return input.nextLine().charAt(0);
    }
    public static char lecturerExamMenu() {
        System.out.println("\n");
        System.out.println("==========================================");
        System.out.println("============  Lecturer Menu  =============");
        System.out.println("==========================================");
        System.out.println("1. Add Exam");
        System.out.println("2. Update Exam");
        System.out.println("3. Delete Exam");
        System.out.println("4. Exit");
        System.out.print("Enter what you want: ");
        return input.nextLine().charAt(0);
    }
    public static char lecturerAssignmentMenu() {
        System.out.println("\n");
        System.out.println("==========================================");
        System.out.println("============  Lecturer Menu  =============");
        System.out.println("==========================================");
        System.out.println("1. Add Assignment");
        System.out.println("2. Update Assignment");
        System.out.println("3. Delete Assignment");
        System.out.println("4. Exit");
        System.out.print("Enter what you want: ");
        return input.nextLine().charAt(0);
    }
    public static void lecturerMenu() {
        System.out.println("\n");
        System.out.println("==========================================");
        System.out.println("============  Lecturer Menu  =============");
        System.out.println("==========================================");
    }
}
