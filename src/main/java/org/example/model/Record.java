package org.example.model;

import java.util.Date;

public class Record implements Comparable<Record> {
    private Date date;
    private String description;

    public Record(Date date, String description) {
        this.date = date;
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(Record other) {
        // Compare records based on their date
        return this.date.compareTo(other.date);
    }

    @Override
    public String toString() {
        return "Date: " + date + "\nDescription: " + description;
    }
}
