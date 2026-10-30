package com.pluralsight;
import java.io.*;
import java.time.LocalDateTime;
import java.util.Scanner;
public class SearchEngineLogger {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        logAction("launch");

        while (true) {
            System.out.print("Enter a search term (X or x to exit): ");
            String term = scanner.nextLine().trim();

            if (term.equalsIgnoreCase("x")) {
                break;
            }
            logAction("search : " + term);
        }
        logAction("exit");
    }

    static void logAction(String action) {
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String timestamp = LocalDateTime.now().format(formatter);

        try (FileWriter writer = new FileWriter("logs.txt", true)) {
            writer.write(timestamp + " " + action + "\n");
        } catch (IOException e) {
            System.out.println("Could not write to log: " + e.getMessage());
        }
    }
}
