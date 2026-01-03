package com.diary.service;

import java.io.IOException;
import java.nio.file.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.stream.Stream;

public class BackupService {
    private static final Path ENTRIES_DIR = Paths.get("entries");

    public void createBackup(String zipFileName) throws IOException {
        Path zipFilePath = Paths.get(zipFileName);

        try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipFilePath));
                Stream<Path> files = Files.list(ENTRIES_DIR)) {

            files.filter(path -> !Files.isDirectory(path))
                    .forEach(path -> {
                        ZipEntry zipEntry = new ZipEntry(path.getFileName().toString());
                        try {
                            zos.putNextEntry(zipEntry);
                            Files.copy(path, zos);
                            zos.closeEntry();
                        } catch (IOException e) {
                            System.err.println("Failed to backup file: " + path + " - " + e.getMessage());
                        }
                    });
        }
    }
}
