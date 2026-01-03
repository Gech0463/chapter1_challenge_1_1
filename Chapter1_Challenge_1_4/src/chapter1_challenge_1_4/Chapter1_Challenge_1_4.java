package chapter1_challenge_1_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Custom exception for invalid config version
class InvalidConfigVersionException extends Exception {
    public InvalidConfigVersionException(String message) {
        super(message);
    }
}

public class Chapter1_Challenge_1_4 {

    private static final String CONFIG_FILE_NAME = "config.txt";
    private static final int MIN_CONFIG_VERSION = 2;

    public static void main(String[] args) {
        processConfigFile();
    }

    private static void processConfigFile() {
        File configFile = new File(CONFIG_FILE_NAME);

        // Feature: Use try-with-resources for automatic resource management
        try (BufferedReader reader = new BufferedReader(new FileReader(configFile))) {
            
            // 1. Read and validate config version
            int configVersion = readConfigVersion(reader);
            
            // 2. Read and validate file path
            String filePath = readFilePath(reader);

            System.out.println("Config read successfully!");
            System.out.println("Config Version: " + configVersion);
            System.out.println("File Path: " + filePath);

        } catch (FileNotFoundException e) {
            System.err.println("Error: Config file '" + CONFIG_FILE_NAME + "' not found.");
            System.err.println("Please ensure 'config.txt' exists in the project root directory.");
        } catch (NumberFormatException e) {
            System.err.println("Error: Invalid number format in config file: " + e.getMessage());
        } catch (InvalidConfigVersionException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: An I/O error occurred: " + e.getMessage());
        } finally {
            System.out.println("Config read attempt finished.");
        }
    }

    private static int readConfigVersion(BufferedReader reader) throws IOException, InvalidConfigVersionException {
        String versionLine = reader.readLine();
        if (versionLine == null) {
            throw new IOException("Config file is empty.");
        }
        
        int configVersion;
        try {
            configVersion = Integer.parseInt(versionLine.trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Version line '" + versionLine + "' is not a valid integer.");
        }

        if (configVersion < MIN_CONFIG_VERSION) {
            throw new InvalidConfigVersionException("Config version " + configVersion + " is too old! Minimum required is " + MIN_CONFIG_VERSION);
        }
        return configVersion;
    }

    private static String readFilePath(BufferedReader reader) throws IOException {
        String filePath = reader.readLine();
        if (filePath == null || filePath.trim().isEmpty()) {
            throw new IOException("File path is missing in config file.");
        }
        
        filePath = filePath.trim();
        File fileToCheck = new File(filePath);
        if (!fileToCheck.exists()) {
            throw new IOException("File at path '" + filePath + "' does not exist.");
        }
        return filePath;
    }
}
