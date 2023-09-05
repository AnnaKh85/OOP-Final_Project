package org.example.presenter;

import java.util.Date;

public interface RecordPresenter {
    void addRecord(Date date, String description);
    void searchRecordsByDate(Date date);
    void searchRecordsByWeek(Date startDate, Date endDate);
    void sortRecordsByDate();
    void saveRecordsToFile(String fileName);
    void loadRecordsFromFile(String fileName);
}
