package org.example.view;

import org.example.model.Record;

import java.util.List;

public interface RecordView {
    void displayRecords(List<Record> records);

    void displayMessage(String message);
}
