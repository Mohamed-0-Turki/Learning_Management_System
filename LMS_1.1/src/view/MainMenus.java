package view;

import java.util.Scanner;

public class MainMenus {
    public static char mainMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("============================================");
        System.out.println("=======  Learning Management System  =======");
        System.out.println("============================================");
        System.out.println("1. Login");
        System.out.println("2. Exit");
        System.out.print("Enter what you want: ");
        return input.nextLine().charAt(0);
    }

    public static char loginOptions () {
        Scanner input = new Scanner(System.in);
        System.out.println("=============================================");
        System.out.println("==================  Login  ==================");
        System.out.println("=============================================");
        System.out.println("1. Admin");
        System.out.println("2. Lecturer");
        System.out.println("3. Student");
        System.out.println("4. Exit");
        System.out.print("Enter what you want: ");
        return input.nextLine().charAt(0);
    }
    public static void loginMenu () {
        System.out.println("=============================================");
        System.out.println("==================  Login  ==================");
        System.out.println("=============================================");
    }
    public static char profileMenu () {
        Scanner input = new Scanner(System.in);
        System.out.println("===============================================");
        System.out.println("==================  Profile  ==================");
        System.out.println("===============================================");
        System.out.println("1. Show Profile");
        System.out.println("2. Update Profile");
        System.out.println("3. Exit");
        System.out.print("Enter what you want: ");
        return input.nextLine().charAt(0);
    }
    public static void profile () {
        System.out.println("===============================================");
        System.out.println("==================  Profile  ==================");
        System.out.println("===============================================");
    }
}
