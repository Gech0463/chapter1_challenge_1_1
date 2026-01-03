# Config File Reader Challenge

This project is a Java application designed to read and validate a configuration file (`config.txt`). It demonstrates robust file handling, exception handling, and input validation practices.

## Features

*   **Robust Error Handling:** Handles various scenarios like missing files, empty files, invalid number formats, and custom logic errors (invalid version).
*   **Custom Exceptions:** Defines `InvalidConfigVersionException` to handle specific business logic violations.
*   **Try-with-Resources:** Utilizes Java 7's try-with-resources statement for automatic and safe resource management (closing file readers).
*   **Input Validation:** Checks for minimum configuration versions and verifies the existence of referenced file paths.
*   **Modular Code:** Separates logic into helper methods (`readConfigVersion`, `readFilePath`) for better readability and maintainability.

## Getting Started

### Prerequisites

*   Java Development Kit (JDK) 8 or higher.
*   An IDE (like IntelliJ IDEA, NetBeans, or Eclipse) or a command-line environment.

### Setup

1.  **Clone or Download:** Get the project files to your local machine.
2.  **Create Config File:** Ensure a file named `config.txt` exists in the root directory of the project (where the program is executed).

### Configuration File Format (`config.txt`)

The `config.txt` file should contain two lines:

1.  **Version Number:** An integer representing the configuration version (must be >= 2).
2.  **File Path:** A valid path to another file on your system.

**Example `config.txt`:**

```text
2
C:/Windows/System32/drivers/etc/hosts
```

### Running the Application

Compile and run the `Chapter1_Challenge_1_4` class.

**Output (Success):**

```text
Config read successfully!
Config Version: 2
File Path: C:/Windows/System32/drivers/etc/hosts
Config read attempt finished.
```

**Output (Failure Examples):**

*   *File not found:* `Error: Config file 'config.txt' not found.`
*   *Old Version:* `Error: Config version 1 is too old! Minimum required is 2`
*   *Invalid Path:* `Error: An I/O error occurred: File at path 'invalid/path.txt' does not exist.`

## Project Structure

*   `src/chapter1_challenge_1_4/Chapter1_Challenge_1_4.java`: Main application logic.
*   `README.md`: Project documentation.

## GitHub Description

**Title:** Robust Java Config Reader with Exception Handling

**Description:**
A Java console application that demonstrates best practices in file I/O and exception handling. It reads a configuration file, validates a version number against a minimum requirement, and verifies the existence of a specified file path. Key features include the use of custom exceptions, try-with-resources for memory safety, and modular code structure. Perfect for understanding Java's IO and Exception hierarchies.
