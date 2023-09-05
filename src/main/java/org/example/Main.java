package org.example;

import org.example.model.RecordModel;
import org.example.model.RecordModelImpl;
import org.example.presenter.RecordPresenter;
import org.example.presenter.RecordPresenterImpl;
import org.example.view.RecordView;
import org.example.view.RecordViewImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RecordModel model = new RecordModelImpl();
        RecordView view = new RecordViewImpl();
        RecordPresenter presenter = new RecordPresenterImpl(model, view);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Record");
            System.out.println("2. Search Records by Date");
            System.out.println("3. Search Records by Week");
            System.out.println("4. Sort Records by Date");
            System.out.println("5. Save Records to File");
            System.out.println("6. Load Records from File");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter date (yyyy-MM-dd HH:mm:ss): ");
                    String dateString = scanner.nextLine();
                    Date date = parseDate(dateString);
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();
                    presenter.addRecord(date, description);
                    break;
                case 2:
                    System.out.print("Enter date (yyyy-MM-dd): ");
                    dateString = scanner.nextLine();
                    date = parseDate(dateString);
                    presenter.searchRecordsByDate(date);
                    break;
                case 3:
                    System.out.print("Enter start date (yyyy-MM-dd): ");
                    String startDateString = scanner.nextLine();
                    Date startDate = parseDate(startDateString);
                    System.out.print("Enter end date (yyyy-MM-dd): ");
                    String endDateString = scanner.nextLine();
                    Date endDate = parseDate(endDateString);
                    presenter.searchRecordsByWeek(startDate, endDate);
                    break;
                case 4:
                    presenter.sortRecordsByDate();
                    break;
                case 5:
                    System.out.print("Enter file name to save records: ");
                    String saveFileName = scanner.nextLine();
                    presenter.saveRecordsToFile(saveFileName);
                    break;
                case 6:
                    System.out.print("Enter file name to load records: ");
                    String loadFileName = scanner.nextLine();
                    presenter.loadRecordsFromFile(loadFileName);
                    break;
                case 7:
                    System.out.println("Exiting application.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static Date parseDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return dateFormat.parse(dateString);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd HH:mm:ss.");
            return null;
        }
    }
}