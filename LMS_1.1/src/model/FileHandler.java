package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * The FileHandler class provides methods to handle file operations such as
 * creating a file, writing to a file, and reading the entire content of a file.
 * It encapsulates the functionality related to file manipulation.
*/
public class FileHandler {
    // The path of the file to be manipulated
    private String filePath;
    // Represents the File object associated with the file path
    private File file;

    // Default constructor for FileHandler.
    public FileHandler() {  }
    /**
     * Parameterized constructor for FileHandler, allowing the specification
     * of the file path during object creation.
     * @param filePath The path of the file to be manipulated.
     */
    public FileHandler (String filePath) {
        this.filePath = filePath;
    }

    /**
     * Set the file path for the FileHandler object.
     * @param filePath The path of the file to be manipulated.
     */
    public void setFilePath (String filePath) {
        this.filePath = filePath;
    }

    /**
     * Retrieve the current file path associated with the FileHandler object.
     * @return The current file path.
     */
    public String getFilePath() {
        return this.filePath;
    }

    /**
     * Create a new file at the specified file path.
     * @return  1 if the file is created successfully,
     *          0 if the file already exists,
     *         -1 if an IOException occurs during file creation.
     */
    public int createFile () {
        this.file = new File(this.filePath);
        try {
            if (this.file.createNewFile())
                return 1; // File created successfully
            else
                return 0; // File already exists
        } catch (IOException ex) {
            return -1; // IOException during file creation
        }
    }

    /**
     * Checks if the file associated with the current FileHandler object exists.
     * This method creates a File object based on the specified file path (filePath)
     * associated with the current FileHandler object and checks whether the file exists.
     * If the file exists, it returns true; otherwise, it returns false.
     *
     * @return A boolean indicating the existence of the associated file.
     *         - true if the file exists.
     *         - false if the file does not exist.
     */
    public boolean fileExist() {
        // Create a File object based on the specified file path
        this.file = new File(this.filePath);
        // Check if the file exists
        return this.file.exists();
    }

    /**
     * Removes the file associated with the current FileHandler object.
     * This method attempts to delete the file specified by the filePath
     * associated with the current FileHandler object. If the deletion is successful,
     * it returns 1; otherwise, it returns 0 to indicate failure.
     *
     * @return An integer indicating the success of the file removal operation.
     *         - 1 if the file is successfully removed.
     *         - 0 if the file removal operation fails.
     */
    public int removeFile () {
        // Create a File object based on the specified file path
        this.file = new File(this.filePath);
        // Attempt to delete the file
        if (this.file.delete())
            return 1; // Return 1 to indicate successful file removal
        else
            return 0; // Return 0 to indicate failure in the file removal operation
    }

    /**
     * Write a line of text to the file. The 'append' parameter determines
     * whether the text is appended to the end of the file or overwrites
     * the existing content.
     * @param line   The line of text to be written to the file.
     * @param append true if the text should be appended, false to overwrite.
     * @return true if the write operation is successful, false otherwise.
     */
    public boolean writeInFile (String line, boolean append) {
        this.file = new File(this.filePath);
        // line => [value, value, value, value]
        try {
            FileWriter writeFile = new FileWriter(this.file, append);
            writeFile.append(line);
            writeFile.append("\n");
            writeFile.close();
            return true; // Write operation successful
        } catch (IOException ex) {
            return false; // IOException during write operation
        }
    }

    /**
     * Read the entire content of the file and return it as a single string.
     * @return The entire content of the file as a string.
     */
    public String readAllFile () {
        String lines = "";
        this.file = new File(this.filePath);
        try {
            Scanner readFile = new Scanner(this.file);
            while (readFile.hasNextLine()) {
                lines += readFile.nextLine();
                lines += "\n";
            }
            return lines; // Content successfully read
        } catch (IOException ex) {
            return "-1"; // IOException during read operation
        }
    }
}
