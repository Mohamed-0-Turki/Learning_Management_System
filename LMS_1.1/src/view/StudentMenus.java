package view;

import java.util.Scanner;

public class StudentMenus {
    static public Scanner input = new Scanner(System.in);
    public static char mainMenu() {
        System.out.println("=============================================");
        System.out.println("==============  Student Menu  ===============");
        System.out.println("=============================================");
        System.out.println("1. View all courses registered for me");
        System.out.println("2. View course content");
        System.out.println("3. View currently available exams");
        System.out.println("4. View currently available assignments");
        System.out.println("5. View my exam scores");
        System.out.println("6. Profile");
        System.out.println("7. Logout");
        System.out.print("Enter what you want: ");
        return input.nextLine().charAt(0);
    }
    public static void studentMenu() {
        System.out.println("=============================================");
        System.out.println("==============  Student Menu  ===============");
        System.out.println("=============================================");
    }
}
