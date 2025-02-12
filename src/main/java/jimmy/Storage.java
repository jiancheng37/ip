package jimmy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.time.format.DateTimeParseException;

import java.util.ArrayList;

/**
 * Handles the loading and saving of tasks to a file for persistent storage.
 * Ensures that the file and its directories exist, and supports reading from
 * and writing to the file in a specific format.
 */
public class Storage {
    private Path filePath;

    /**
     * Constructs a {@code Storage} object with the specified file path.
     * Ensures that the file and its parent directories exist.
     *
     * @param filePath the path to the file where tasks will be stored.
     */
    public Storage(String filePath) {
        this.filePath = Paths.get(filePath);
        assert filePath != null && !filePath.isEmpty() : "File path should not be null or empty";
        ensureFileExists();
    }

    /**
     * Ensures the file and its parent directories exist.
     * Creates them if they do not exist.
     */
    private void ensureFileExists() {
        try {
            Path dir = filePath.getParent();
            if (dir != null && !Files.exists(dir)) {
                Files.createDirectories(dir);
            }
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
            assert Files.exists(filePath) : "File creation failed";
        } catch (IOException e) {
            System.out.println("Error ensuring file exists: " + e.getMessage());
        }
    }

    /**
     * Loads tasks from the file into an {@code ArrayList}.
     * Parses each line of the file to recreate the corresponding {@code Task} objects.
     *
     * @return a list of tasks loaded from the file.
     * @throws JimmyException if an I/O error occurs during file reading.
     */
    public ArrayList<Task> load() throws JimmyException {
        ArrayList<Task> tasks = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath.toString()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" \\| ");
                Task task;
                switch (parts[0]) {
                case "T":
                    task = new Todo(parts[2]);
                    break;
                case "D":
                    try {
                        task = new Deadline(parts[2], parts[3]);
                    } catch (DateTimeParseException e) {
                        System.out.println("Error: Invalid date format in file.");
                        continue;
                    }
                    break;
                case "E":
                    try {
                        task = new Event(parts[2], parts[3], parts[4]);
                    } catch (DateTimeParseException e) {
                        System.out.println("Error: Invalid date format in file.");
                        continue;
                    }
                    break;
                default:
                    continue;
                }
                if (parts[1].equals("1")) {
                    task.mark();
                }
                tasks.add(task);
            }
        } catch (IOException e) {
            throw new JimmyException("Error loading tasks from file.");
        }

        return tasks;
    }

    /**
     * Saves the provided list of tasks to the file.
     * Each task is converted to a file-friendly format before saving.
     *
     * @param tasks the list of tasks to be saved.
     * @throws JimmyException if an I/O error occurs during file writing.
     */
    public void save(ArrayList<Task> tasks) throws JimmyException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath.toString()))) {
            for (Task task : tasks) {
                bw.write(task.toFileFormat());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new JimmyException("Error saving tasks to file.");
        }
    }
}
