package org.example.view;

import java.text.SimpleDateFormat;
import java.util.List;
import org.example.model.Record;

public class RecordViewImpl implements RecordView{
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void displayRecords(List<Record> records) {
        if (records.isEmpty()) {
            System.out.println("No records found.");
        } else {
            System.out.println("Records:");
            for (Record record : records) {
                System.out.println("Date: " + record.getDate());
                System.out.println("Description: " + record.getDescription());
                System.out.println("-------------------------");
            }
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

}
