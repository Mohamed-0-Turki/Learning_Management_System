package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * The Person class represents a general person with attributes such as user ID, user type,
 * name, email, and password. It implements the StringDataConvertible interface, providing a
 * standardized way to obtain a string representation of its data as an array.
 * This class uses static and instance variables to keep track of user IDs and store individual
 * person attributes. It also includes methods to set and retrieve these attributes, as well as
 * methods to interact with a file using the FileHandler class for reading, writing, updating,
 * and deleting data.
 * The Person class ensures encapsulation by providing setter methods for its attributes and
 * follows the constructor overloading pattern to create instances with different sets of
 * attributes. It also implements the arrayStringData method to fulfill the contract of the
 * StringDataConvertible interface, allowing the object's data to be represented as a formatted
 * string array.
 * Example Usage:
 * ```Example
     * Person p = new Person(1, "Student", "John Doe", "john@example.com", "password123");
     * person.setFilePath("path/to/file.txt");
     * person.setFile();
     * person.getFile().createFile();
     * person.getFile().writeInFile(person.arrayStringData(), true);
 * ```
 * The toString method is overridden to provide a human-readable string representation of the
 * person's data, suitable for logging and debugging.
 * Note: It is assumed that the FileHandler class is available and functional.
 */

public class Person implements StringDataConvertible {
    // Static variable to track the current user ID across all instances
    static private int currentUserID = 0;

    // Instance variables representing person attributes
    private int userID;
    private String userType;
    private String name;
    private String email;
    private String password;
    private static FileHandler file;
    private static String filePath;

    // All possible Constructors
    public Person () {
        currentUserID++;
        this.userID = currentUserID;
        this.userType = null;
        this.name = null;
        this.email = null;
        this.password = null;
    }
    public Person (String userType) {
        this();
        this.userType = userType;
    }
    public Person (String userType, String name) {
        this(userType);
        this.name = name;
    }
    public Person (String userType, String name, String email) {
        this(userType, name);
        this.email = email;
    }
    public Person (String userType, String name, String email, String password) {
        this(userType, name, email);
        this.password = password;
    }

    // Setter
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setFilePath(String path) {
        filePath = path;
    }
    public void setFile() {
        file = new FileHandler(filePath);
    }

    // Getter
    public int getUserID () {
        return this.userID;
    }
    public String getUserType () {
        return this.userType;
    }
    public String getName () {
        return this.name;
    }
    public String getEmail () {
        return this.email;
    }
    public String getPassword () {
        return this.password;
    }
    public String getFilePath() {
        return filePath;
    }
    public FileHandler getFile() {
        return file;
    }

    /**
     * Adds a new line to the associated file using the specified content.
     * This method invokes the 'writeInFile' method of the associated 'file' object,
     * which is an instance of the 'FileHandler' class. It appends the provided 'line'
     * to the content of the associated file, and it returns a boolean value indicating
     * the success of the operation.
     *
     * @param line The content to be added as a new line to the associated file.
     * @return A boolean indicating the success of the add operation.
     *         - true if the content was successfully added to the file.
     *         - false if there was an error or the operation failed.
     */
    public boolean add(String line) {
        // Invokes the 'writeInFile' method to append the specified 'line' to the file
        return file.writeInFile(line, true);
    }

    /**
     * The `numberOfLines` method in the `FileHandler` class calculates the total number of lines
     * in the specified file. It opens the file, reads each line, increments a counter for each
     * line, and returns the total count. If an IOException occurs during file reading, it returns
     * -1 to indicate an error.
     *
     * @return The total number of lines in the file or -1 if an error occurs.
     */
    public int numberOfLines () {
        File database = new File(filePath);
        int count = 0;
        try {
            Scanner readFile = new Scanner(database);
            while (readFile.hasNextLine()) {
                readFile.nextLine();
                count++;
            }
            return count;
        } catch (IOException ex) {
            return -1;
        }
    }

    /**
     * The `search` method in the `FileHandler` class looks for a line in the specified file
     * where the value at the given index matches the specified value. It reads each line in the
     * file, extracts the values from the line, and compares the value at the specified index
     * with the provided value. If a match is found, it returns the matching line; otherwise,
     * it returns "0". If an IOException occurs during file reading or the index is out of bounds,
     * it returns "-1" to indicate an error.
     *
     * @param index The index of the value to compare.
     * @param value The value to search for.
     * @return The matching line or "0" if no match is found, or "-1" if an error occurs.
     */
    public String search (int index, String value) {
        File database = new File(filePath);
        String line = "";
        String[] lineArray;
        try {
            // lineArray = [1, userType, name, email, password]
            Scanner readFile = new Scanner(database);
            while (readFile.hasNextLine()) {
                line = readFile.nextLine();
                lineArray = line.substring(1, line.length() - 1).split(", ");
                if (index >= lineArray.length)
                    return "-1";
                else {
                    if (lineArray[index].equals(value))
                        break;
                    else line = "0";
                }
            }
            if (line.isEmpty()) {
                line = "0";
            }
            return line;
        } catch (IOException ex) {
            return "-1";
        }
    }

    /**
     * The `delete` method in the `FileHandler` class removes a line from the file based on the
     * provided ID. It utilizes the `search` method to find the line with the specified ID and
     * then deletes that line from the file. If the line is successfully deleted, it returns 1;
     * if the line is not found, it returns 0; if an error occurs, it returns -1.
     *
     * @param id The ID to search for and delete.
     * @return 1 if the line is deleted, 0 if the line is not found, or -1 if an error occurs.
     */
    public int delete(int id) {
        String ID = Integer.toString(id);
        File database = new File(filePath);
        if (this.numberOfLines() != 0) {
            String deleteLine = this.search(0, ID);
            if (! deleteLine.equals("0")) {
                String[] lines = file.readAllFile().split("\n");
                int lengthNewArray = (lines.length != 1) ? lines.length - 1 : 1;
                String[] newLines = new String[lengthNewArray];
                for (int i = 0, j = 0; i < lines.length; i++) {
                    if (!lines[i].equals(deleteLine)) {
                        newLines[j] = lines[i];
                        j++;
                    }
                }
                if (newLines[0] == null) {
                    try {
                        FileWriter writeFile = new FileWriter(database, false);
                        writeFile.append("");
                        writeFile.close();
                        return 1;
                    } catch (IOException ex) {
                        return -1;
                    }
                } else {
                    file.writeInFile(newLines[0], false);
                    for (int i = 1; i < newLines.length; i++)
                        file.writeInFile(newLines[i], true);
                    return 1;
                }
            }
            return 0;
        }
        return 0;
    }

    /**
     * The `update` method in the `FileHandler` class replaces a line in the file based on the
     * provided ID with a new line. It internally uses the `delete` method to remove the existing
     * line and then uses the `writeInFile` method to append the updated line. If the update is
     * successful, it returns true; otherwise, it returns false.
     *
     * @param ID The ID of the line to update.
     * @param newLine The new line to replace the existing line.
     * @return True if the update is successful, false otherwise.
     */
    public boolean update(int ID, String newLine) {
        if (this.delete(ID) == 1) {
            return file.writeInFile(newLine, true);
        }
        return false;
    }

    /**
     * The `login` method in the `Person` class attempts to authenticate a user based on the provided
     * user type, email, and password. It sets the file path to the appropriate user type's file, then
     * searches for the user's email in the file. If the email is found, it checks whether the provided
     * password matches the stored password. If both email and password match, it sets the user attributes
     * with the retrieved data and returns true, indicating successful authentication. If the email is not
     * found, the file read encounters an error, or the provided credentials do not match, it returns false.
     *
     * @param userType The type of the user (e.g., Student, Lecturer, Admin).
     * @param email The email associated with the user account.
     * @param password The password associated with the user account.
     * @return True if authentication is successful, false otherwise.
     */
    public boolean login (String userType, String email, String password) {
        // Set the file path based on the user type
        filePath = "database/users/"+userType+".txt";

        // Check if the email exists in the file and if there are any records
        if (! this.search(3, email).equals("0") && ! this.search(3, email).equals("-1") && this.numberOfLines() > 0) {
            // Retrieve user data associated with the email
            String data = this.search(3, email);
            String[] arrayOfUserData = data.substring(1, data.length() - 1).split(", ");

            // Check if the provided password matches the stored password
            if (arrayOfUserData[4].equals(password)) {
                // Set the user attributes with the retrieved data
                this.userID = Integer.parseInt(arrayOfUserData[0]);
                this.userType = arrayOfUserData[1];
                this.name = arrayOfUserData[2];
                this.email = arrayOfUserData[3];
                this.password = arrayOfUserData[4];
                // Authentication successful
                return true;
            }
            else {
                // Password does not match, authentication failed
                return false;
            }
        }
        // Email not found, file read error, or no records in the file, authentication failed
        return false;
    }

    /**
     * Updates the user profile information in the corresponding user data file.
     * This method takes the current user's information, converts it to a string,
     * and updates the user data file with the new information.
     *
     * @param currentUser The Person object representing the current user.
     * @return A boolean indicating whether the profile update was successful or not.
     */
    public boolean updateProfile (Person currentUser) {
        // Set the file path to the user-specific data file
        filePath = "database/users/"+this.userType+".txt";
        // Initialize the FileHandler object to interact with the file
        this.setFile();
        // Convert the current user's information to a string
        String line = currentUser.arrayStringData();
        // Update the user data file with the new information
        return this.update(this.userID, line);
    }

    /**
     * Logs out the current user by resetting all user-related information to null or default values.
     * This method is called to clear the current user's data after logging out.
     */
    public void logout () {
        // Reset user-related information to default or null values
        this.setUserID(0);
        this.setUserType(null);
        this.setName(null);
        this.setEmail(null);
        this.setPassword(null);
    }

    @Override
    public String arrayStringData() {
        return "["+this.userID+", "+this.userType+", "+this.name+", "+this.email+", "+this.password+"]";
    }
    @Override
    public String toString() {
        return "#ID: " + this.userID + "\t|\t" + "User Type: " + this.userType + "\t|\t" + "User Name: " + this.name + "\t|\t" + "Email: " + this.email;
    }
}
