package com.diary.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DiaryConfig implements Serializable {
    private static final long serialVersionUID = 1L;

    private String lastUser;
    private LocalDateTime lastRun;
    private int totalEntries;

    public DiaryConfig() {
        this.lastUser = "Guest";
        this.lastRun = LocalDateTime.now();
        this.totalEntries = 0;
    }

    public String getLastUser() {
        return lastUser;
    }

    public void setLastUser(String lastUser) {
        this.lastUser = lastUser;
    }

    public LocalDateTime getLastRun() {
        return lastRun;
    }

    public void setLastRun(LocalDateTime lastRun) {
        this.lastRun = lastRun;
    }

    public int getTotalEntries() {
        return totalEntries;
    }

    public void setTotalEntries(int totalEntries) {
        this.totalEntries = totalEntries;
    }

    @Override
    public String toString() {
        return "DiaryConfig{" +
                "lastUser='" + lastUser + '\'' +
                ", lastRun=" + lastRun +
                ", totalEntries=" + totalEntries +
                '}';
    }
}
