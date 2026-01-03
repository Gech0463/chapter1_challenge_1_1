package com.diary;

import com.diary.model.DiaryConfig;
import com.diary.service.BackupService;
import com.diary.service.DiaryService;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class DiaryManager {
    private final DiaryService diaryService;
    private final BackupService backupService;
    private final Scanner scanner;
    private DiaryConfig config;

    public DiaryManager() throws IOException {
        this.diaryService = new DiaryService();
        this.backupService = new BackupService();
        this.scanner = new Scanner(System.in);
        this.config = diaryService.loadConfig();
    }

    public void start() {
        System.out.println("========================================");
        System.out.println("   Welcome to Personal Diary Manager    ");
        System.out.println("========================================");
        System.out.println("Last run: " + config.getLastRun());
        System.out.println("Total entries on record: " + config.getTotalEntries());

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine();
            try {
                switch (choice) {
                    case "1" -> handleWrite();
                    case "2" -> handleRead();
                    case "3" -> handleSearch();
                    case "4" -> handleBackup();
                    case "5" -> {
                        running = false;
                        exitApp();
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        }
    }

    private void printMenu() {
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1. Write New Entry");
        System.out.println("2. Read Entry");
        System.out.println("3. Search Entries");
        System.out.println("4. Backup (ZIP)");
        System.out.println("5. Exit");
        System.out.print("Enter choice: ");
    }

    private void handleWrite() throws IOException {
        System.out.println("\nEnter your diary entry (type 'SAVE' on a new line to finish):");
        StringBuilder content = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("SAVE"))
                break;
            content.append(line).append(System.lineSeparator());
        }

        if (content.toString().trim().isEmpty()) {
            System.out.println("Empty entry. Save cancelled.");
            return;
        }

        diaryService.writeEntry(content.toString());
        config.setTotalEntries(config.getTotalEntries() + 1);
        System.out.println("Entry saved successfully!");
    }

    private void handleRead() throws IOException {
        List<Path> entries = diaryService.getAllEntries();
        if (entries.isEmpty()) {
            System.out.println("No entries found.");
            return;
        }

        System.out.println("\n--- Available Entries ---");
        for (int i = 0; i < entries.size(); i++) {
            System.out.println((i + 1) + ". " + entries.get(i).getFileName());
        }
        System.out.print("Select entry # to read: ");
        try {
            int index = Integer.parseInt(scanner.nextLine()) - 1;
            if (index >= 0 && index < entries.size()) {
                System.out.println("\n--- Content of " + entries.get(index).getFileName() + " ---");
                System.out.println(diaryService.readEntry(entries.get(index)));
                System.out.println("----------------------------------------");
            } else {
                System.out.println("Invalid selection.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }

    private void handleSearch() throws IOException {
        System.out.print("\nEnter keyword to search: ");
        String keyword = scanner.nextLine();
        List<Path> results = diaryService.searchEntries(keyword);

        if (results.isEmpty()) {
            System.out.println("No entries found containing: " + keyword);
        } else {
            System.out.println("Entries containing '" + keyword + "':");
            for (Path path : results) {
                System.out.println("- " + path.getFileName());
            }
        }
    }

    private void handleBackup() throws IOException {
        String timestamp = LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd_HHmm"));
        String zipName = "diary_backup_" + timestamp + ".zip";
        backupService.createBackup(zipName);
        System.out.println("Backup created: " + zipName);
    }

    private void exitApp() {
        config.setLastRun(LocalDateTime.now());
        diaryService.saveConfig(config);
        System.out.println("Cleaning up and exiting... Goodbye!");
    }

    public static void main(String[] args) {
        try {
            new DiaryManager().start();
        } catch (IOException e) {
            System.err.println("Fatal error: " + e.getMessage());
        }
    }
}
