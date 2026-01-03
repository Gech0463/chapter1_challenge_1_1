# 📔 Personal Diary Manager (CLI Edition)

[![Java](https://img.shields.io/badge/Java-17%2B-ED8B00)](https://www.oracle.com/java/)
[![Standard](https://img.shields.io/badge/Interface-CLI-lightgrey)](https://en.wikipedia.org/wiki/Command-line_interface)

A robust, terminal-based reflection tool designed for professionals. Built with advanced Java I/O techniques, NIO.2, and secure object serialization.

---

## 🌟 Core Features

- **🚀 Instant Write Mode**: Quick entry creation via terminal with automatic timestamped file naming.
- **📖 Comprehensive Read Mode**: Navigate through your reflection history using a simple numeric selector.
- **🔍 Deep Content Search**: Search through the text of all your entries instantly to find specific memories.
- **🛡️ State Persistence**: Application state (last run and entry count) is securely serialized in `diary_config.ser`.
- **📦 Reliable Backups**: Package your entire diary library into a timestamped ZIP archive with one command.

---

## 🛠️ Technical Implementation

This project showcases several advanced Java concepts:

| Technical Requirement | Implementation Detail |
| :--- | :--- |
| **I/O Operations** | Utilizes **BufferedReader** and **BufferedWriter** for efficient text handling. |
| **File Management** | Powered by the modern **java.nio.file (NIO.2)** API for robust directory and file manipulation. |
| **Time Management** | Uses **LocalDateTime** and **DateTimeFormatter** for precise, sortable file naming. |
| **Serialization** | Implements **ObjectOutputStream/ObjectInputStream** to persist application configuration. |
| **Compression** | Leverages **ZipOutputStream** to create portable archives of entry folders. |

---

## 🏗️ Project Structure

```text
Chapter4_Challenge_DiaryManager/
├── src/com/diary/
│   ├── DiaryManager.java      # Main CLI Logic & Menu
│   ├── model/
│   │   └── DiaryConfig.java   # Serialized App State
│   └── service/
│       ├── DiaryService.java  # File I/O & Search Logic
│       └── BackupService.java # ZIP Encryption & Backup
├── entries/                   # Secure Directory for .txt Reflections
├── diary_config.ser           # Serialized Application Data
└── README.md                  # Comprehensive Documentation
```

---

## 📖 How to Use

### Prerequisites
- Java JDK 17 or higher

### Launch
1. Open your terminal in the project directory.
2. Compile and run:
   ```bash
   # From the src directory
   javac -d ../bin com/diary/DiaryManager.java
   cd ../bin
   java com.diary.DiaryManager
   ```

### Navigation
- Follow the on-screen menu instructions.
- When writing an entry, type **`SAVE`** on a new line to finish and persist your note.
- Select the **Backup** option to generate a secure archive of your thoughts.

---

> [!NOTE]
> All diary entries are saved with filenames following the structure: `diary_YYYY_MM_DD_HH_MM_SS.txt`, making them easily sortable and organized.

Developed by **Antigravity** for the Chapter 4 Challenge.
