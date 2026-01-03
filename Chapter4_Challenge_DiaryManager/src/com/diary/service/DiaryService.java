package com.diary.service;

import com.diary.model.DiaryConfig;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DiaryService {
    private static final Path ENTRIES_DIR = Paths.get("entries");
    private static final Path CONFIG_FILE = Paths.get("diary_config.ser");
    private static final DateTimeFormatter FILE_NAME_FORMATTER = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");

    public DiaryService() throws IOException {
        if (!Files.exists(ENTRIES_DIR)) {
            Files.createDirectories(ENTRIES_DIR);
        }
    }

    public void writeEntry(String content) throws IOException {
        String timestamp = LocalDateTime.now().format(FILE_NAME_FORMATTER);
        Path filePath = ENTRIES_DIR.resolve("diary_" + timestamp + ".txt");

        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            writer.write(content);
        }
    }

    public List<Path> getAllEntries() throws IOException {
        try (Stream<Path> stream = Files.list(ENTRIES_DIR)) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .filter(file -> file.getFileName().toString().startsWith("diary_"))
                    .collect(Collectors.toList());
        }
    }

    public String readEntry(Path filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public List<Path> searchEntries(String keyword) throws IOException {
        List<Path> results = new ArrayList<>();
        List<Path> allFiles = getAllEntries();

        for (Path file : allFiles) {
            try (BufferedReader reader = Files.newBufferedReader(file)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.toLowerCase().contains(keyword.toLowerCase())) {
                        results.add(file);
                        break;
                    }
                }
            }
        }
        return results;
    }

    public void saveConfig(DiaryConfig config) {
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(CONFIG_FILE))) {
            oos.writeObject(config);
        } catch (IOException e) {
            System.err.println("Error saving config: " + e.getMessage());
        }
    }

    public DiaryConfig loadConfig() {
        if (!Files.exists(CONFIG_FILE)) {
            return new DiaryConfig();
        }
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(CONFIG_FILE))) {
            return (DiaryConfig) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading config: " + e.getMessage());
            return new DiaryConfig();
        }
    }
}
