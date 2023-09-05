package org.example.presenter;

import org.example.model.Record;
import org.example.model.RecordModel;
import org.example.view.RecordView;

import java.util.Date;
import java.util.List;

public class RecordPresenterImpl implements RecordPresenter{
    private RecordModel model;
    private RecordView view;
    public RecordPresenterImpl(RecordModel model, RecordView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void addRecord(Date date, String description) {
        Record newRecord = new Record(date, description);
        model.addRecord(newRecord);
    }

    @Override
    public void searchRecordsByDate(Date date) {
        List<Record> matchingRecords = model.searchRecords(date);
        view.displayRecords(matchingRecords);
    }

    @Override
    public void searchRecordsByWeek(Date startDate, Date endDate) {
        List<Record> matchingRecords = model.searchRecords(startDate, endDate);
        view.displayRecords(matchingRecords);
    }

    @Override
    public void sortRecordsByDate() {
        List<Record> sortedRecords = model.getRecords();
        sortedRecords.sort(Record::compareTo);
        view.displayRecords(sortedRecords);
    }

    @Override
    public void saveRecordsToFile(String fileName) {
        model.saveRecordsToFile(fileName);
        view.displayMessage("Records saved to " + fileName);
    }

    @Override
    public void loadRecordsFromFile(String fileName) {
        model.loadRecordsFromFile(fileName);
        view.displayMessage("Records loaded from " + fileName);
    }
}
