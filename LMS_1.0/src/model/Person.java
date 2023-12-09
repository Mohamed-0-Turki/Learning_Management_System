package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Person Class
 * This class represents a person with basic attributes such as user ID, user type, username, email, and password.
 * It includes constructors for creating instances with various sets of attributes and methods for setting and getting
 * these attributes. The class also provides methods for generating a string representation of the data and a formatted
 * string for display purposes. handles file operations related to a person's data. It provides methods to set the database file,
 * write data to the file, read data from the file, search for a specific line based on a key and value,
 * delete a line by a specified ID, and update a line with new data. The class relies on the FilesHandler class
 * for file creation and manipulation.
 */
public class Person {
    // Static variable to track the current user ID across all instances
    static private int currentUserID = 0;

    // Instance variables representing person attributes
    private int userID;
    private String userType;
    private String userName;
    private String email;
    private String password;

    // Instance variable representing the database file
    private File database;

    /**
     * Default Constructor
     * Initializes a Person instance with default attribute values. Increments the user ID for each new instance.
     */
    public Person () {
        currentUserID++;
        this.userID = currentUserID;
        this.userType = "";
        this.userName = "";
        this.email = "";
        this.password = "";
    }
    public Person (String userType) {
        this();
        this.userType = userType;
    }
    public Person (String userType, String userName) {
        this(userType);
        this.userName = userName;
    }
    public Person (String userType, String userName, String email) {
        this(userType, userName);
        this.email = email;
    }
    public Person (String userType, String userName, String email, String password) {
        this(userType, userName, email);
        this.password = password;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Set Database Method
     * @param filePath The path to the database file.
     */
    public void setDatabase(String filePath) {
        this.database = new File(filePath);
    }


    public int getUserID () {
        return this.userID;
    }
    public String getUserType () {
        return this.userType;
    }
    public String getUserName () {
        return this.userName;
    }
    public String getEmail () {
        return this.email;
    }
    public String getPassword () {
        return this.password;
    }

    /**
     * Array String Data Method
     * Generates a string representation of the person's data in the format of an array.
     * @return String The array string representation of the data.
     */
    public String arrayStringData() {
        return "["+this.userID+", "+this.userType+", "+this.userName+", "+this.email+", "+this.password+"]";
    }

    /**
     * To String Method
     * Generates a formatted string representation of the person's data for display purposes.
     * @return String The formatted string representation of the data.
     */
    @Override
    public String toString() {
        return "#ID: " + this.userID + "\t|\t" + "User Type: " + this.userType +
                "\t|\t" + "User Name: " + this.userName + "\t|\t" + "Email: " + this.email;
    }



    public boolean login (String userType, String email, String password) {
        this.database = new File("database/users/"+userType+".txt");
        if (! this.search(3, email).equals("0") && ! this.search(3, email).equals("-1") && this.numberOfLines() > 0) {
            String data = this.search(3, email);
            String[] arrayOfUserData = data.substring(1, data.length() - 1).split(", ");
            if (arrayOfUserData[4].equals(password)) {
                this.setUserID(Integer.parseInt(arrayOfUserData[0]));
                this.setUserType(arrayOfUserData[1]);
                this.setUserName(arrayOfUserData[2]);
                this.setEmail(arrayOfUserData[3]);
                this.setPassword(arrayOfUserData[4]);
                return true;
            }
            else return false;
        }
        return false;
    }

    public void logout () {
        this.setUserID(0);
        this.setUserType(null);
        this.setUserName(null);
        this.setEmail(null);
        this.setPassword(null);
    }
    public int updateUserProfile (String userID, String userName, String email, String password) {
        int check = 1;
        for (String line: this.readAllFile().split("\n")) {
            String[] lineArray = line.substring(1, line.length() - 1).split(", ");
            if (! lineArray[0].equals(userID)) {
                if (lineArray[3].equals(email)) {
                    check = 0;
                    break;
                }
            }
        }
        if (check == 1) {
            if (! userName.isEmpty())
                this.setUserName(userName);
            if (! email.isEmpty())
                this.setEmail(email);
            if (! password.isEmpty())
                this.setPassword(password);
            if (this.updateLine(userID, this.arrayStringData()) == 1)
                return 1;
        }
        return 0;
    }


    /**
     * Write in File Method
     * Writes a line to the database file. It uses the FilesHandler class to create the file if it doesn't exist.
     * @param line The line to be written to the file.
     * @param append A boolean indicating whether to append the line to the file or overwrite it.
     * @return int Returns 1 for successful write, 0 for file creation failure, or -1 for an unexpected error.
     */
    public int writeInFile (String line, boolean append) {
        FilesHandler file = new FilesHandler(this.database.toString());
        if (file.createFile() == 1 || file.createFile() == 0) {
            try {
                FileWriter writeFile = new FileWriter(this.database, append);
                writeFile.append(line);
                writeFile.append("\n");
                writeFile.close();
                return 1;
            } catch (IOException ex) {
                return 0;
            }
        }
        return -1;
    }

    /**
     * Number of Lines Method
     * Retrieves the number of lines in the database file.
     * @return int The number of lines in the file or -1 for an unexpected error.
     */
    public int numberOfLines () {
        int count = 0;
        try {
            Scanner readFile = new Scanner(this.database);
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
     * Read All File Method
     * Reads all lines from the database file and returns them as a single string.
     * @return String All lines in the file or "-1" for an unexpected error.
     */
    public String readAllFile () {
        String lines = "";
        try {
            Scanner readFile = new Scanner(this.database);
            while (readFile.hasNextLine()) {
                lines += readFile.nextLine();
                lines += "\n";
            }
            return lines;
        } catch (IOException ex) {
            return "-1";
        }
    }

    /**
     * Search Method
     * Searches for a line in the database file based on a specified key and value.
     * @param key The index of the value to compare in each line.
     * @param value The value to search for.
     * @return String The line containing the specified value or "-1" for an unexpected error.
     */
    public String search (int key, String value) {
        String line = "";
        String[] lineArray;
        try {
            Scanner readFile = new Scanner(this.database);
            while (readFile.hasNextLine()) {
                line = readFile.nextLine();
                lineArray = line.substring(1, line.length() - 1).split(", ");
                if (lineArray[key].equals(value))
                    break;
                else line = "0";
            }
            return line;
        } catch (IOException ex) {
            return "-1";
        }
    }

    /**
     * Delete Line Method
     * Deletes a line from the database file based on a specified ID.
     * @param ID The ID used to identify the line to delete.
     * @return int Returns 1 for successful deletion, 0 if the line is not found, or -1 for an unexpected error.
     */
    public int deleteLine (String ID) {
        if (this.numberOfLines() != 0) {
            String deleteLine = this.search(0, ID);
            if (! deleteLine.equals("0")) {
                String[] lines = this.readAllFile().split("\n");
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
                        FileWriter writeFile = new FileWriter(this.database, false);
                        writeFile.append("");
                        writeFile.close();
                        return 1;
                    } catch (IOException ex) {
                        return -1;
                    }
                } else {
                    this.writeInFile(newLines[0], false);
                    for (int i = 1; i < newLines.length; i++)
                        this.writeInFile(newLines[i], true);
                    return 1;
                }
            }
            return 0; // Line not found
        }
        return 0; // No lines in the file
    }

    /**
     * Update Line Method
     * Updates a line in the database file based on a specified ID with new data.
     * @param ID The ID used to identify the line to update.
     * @param newLine The new data to write to the file.
     * @return int Returns 1 for successful update, 0 if the line is not found or cannot be deleted, or -1 for an unexpected error.
     */
    public int updateLine (String ID, String newLine) {
        if (this.deleteLine(ID) == 1) {
            return this.writeInFile(newLine, true);
        }
        return 0;
    }
}
