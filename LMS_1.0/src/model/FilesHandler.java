/**
 * FilesHandler Class
 * This class provides functionality to handle files, particularly for file creation.
 */
package model;

import java.io.File;
import java.io.IOException;
public final class FilesHandler {
    // The File object representing the database file
    private final File database;

    /**
     * Constructor for FilesHandler
     * @param filePath The path to the database file.
     */
    public FilesHandler(String filePath) {
         // Create a File object with the specified file path
         this.database = new File(filePath);
    }

    /**
     * Create File Method
     * This method attempts to create a new file at the specified file path.
     *
     * @return int Returns 1 if the file is successfully created, 0 if the file already exists,
     *            and -1 if an IOException occurs during the file creation process.
     */
    public int createFile() {
        try {
            if (this.database.createNewFile())
                return 1;
            else return 0;
        } catch (IOException ex) {
            return -1;
        }
    }
}
