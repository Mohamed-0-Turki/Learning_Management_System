import model.*;
import view.Menus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exit = true;
        while (exit) {
            char userChoice = Menus.mainMenu();
            if (userChoice == '1') {
                int counter = 4;
                while (exit) {
                    if (counter > 0) {
                        userChoice = Menus.loginOptions();
                        if (userChoice == '1') {
                            Admin admin = new Admin();
                            Menus.loginMenu();
                            String userType = "admin";
                            System.out.print("Enter your email: ");
                            String email = input.nextLine();
                            System.out.print("Enter your password: ");
                            String password = input.nextLine();
                            if (admin.login(userType, email, password)) {
                                while (true) {
                                    userChoice = Menus.adminPanel();
                                    if (userChoice == '1') {

                                    } else if (userChoice == '2') {

                                    } else if (userChoice == '3') {
                                        userChoice = Menus.userProfile();
                                        if (userChoice == '1') {
                                            System.out.println(admin);
                                            System.out.print("Click Enter To Exit");
                                            input.nextLine();
                                        }
                                        if (userChoice == '2') {
                                            Menus.updateProfile();
                                            System.out.print("Enter New name: ");
                                            String newUserName = input.nextLine();
                                            System.out.print("Enter New Email: ");
                                            String newEmail = input.nextLine();
                                            System.out.print("Enter New Password: ");
                                            String newPassword = input.nextLine();
                                            String userID = Integer.toString(admin.getUserID());
                                            if (admin.updateUserProfile(userID, newUserName, newEmail, newPassword) == 1)
                                                System.out.println("The user has been updated");
                                            else System.out.println("The user cannot be updated because new email is already exist.");
                                        }
                                    } else if (userChoice == '4') {
                                        admin.logout();
                                        break;
                                    } else {
                                        System.out.println("""
                                                        A problem occurred. Please try again and make sure that
                                                        your choice is 1 if you want to view all users and do some
                                                        operations or 2 if you want to view all courses or 3
                                                        to show your profile or 4 to logout.
                                                """);
                                    }
                                }
                            }
                            else System.out.println("Please log in again");
                        } else if (userChoice == '2') {

                        } else if (userChoice == '3') {

                        } else break;
                        counter--;
                        System.out.println("Check your email and password, note! You have " + counter + " attempts to log in");
                    } else exit = false;
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