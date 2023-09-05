package org.example.model;

import java.util.Date;
import java.util.List;

public interface RecordModel {
    void addRecord(Record record);
    List<Record> getRecords();
    List<Record> searchRecords(Date date);
    List<Record> searchRecords(Date startDate, Date endDate);
    void saveRecordsToFile(String fileName);
    void loadRecordsFromFile(String fileName);
}
