package org.example.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RecordModelImpl implements RecordModel{
    private List<Record> records;

    public RecordModelImpl() {
        records = new ArrayList<>();
    }

    @Override
    public void addRecord(Record record) {
        records.add(record);
    }

    @Override
    public List<Record> getRecords() {
        return records;
    }

    @Override
    public List<Record> searchRecords(Date date) {
        List<Record> matchingRecords = new ArrayList<>();
        for (Record record : records) {
            if (record.getDate().equals(date)) {
                matchingRecords.add(record);
            }
        }
        return matchingRecords;
    }

    @Override
    public List<Record> searchRecords(Date startDate, Date endDate) {
        List<Record> matchingRecords = new ArrayList<>();
        for (Record record : records) {
            Date recordDate = record.getDate();
            if (recordDate.compareTo(startDate) >= 0 && recordDate.compareTo(endDate) <= 0) {
                matchingRecords.add(record);
            }
        }
        return matchingRecords;
    }

    @Override
    public void saveRecordsToFile(String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(records);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadRecordsFromFile(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            records = (List<Record>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
