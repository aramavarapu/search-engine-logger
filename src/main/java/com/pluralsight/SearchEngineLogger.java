package com.pluralsight;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class SearchEngineLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        logAction("launch");
        String term;

        while (true) {
            System.out.print("Enter a search term (X or x to exit): ");
            term = scanner.nextLine();

            if (term.equalsIgnoreCase("x")) {
                break;
            }
            logAction("search : " + term);
        }
        logAction("exit");
        scanner.close();
    }

    static void logAction(String action) {
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH: mm: ss");
        String timestamp = LocalDateTime.now().format(formatter);

        try (FileWriter writer = new FileWriter("logs.txt", true)) {
            writer.write(timestamp + " " + action + "\n");
        } catch (IOException e) {
            System.out.println("Could not write to log: " + e.getMessage());
        }
    }
}
