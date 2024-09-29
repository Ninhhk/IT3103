package NewPack;

import java.util.Scanner;

public class bai64 {
    public static int Month(String monthInput) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        for (int i = 0; i < months.length; i++) {
            // Full name (case insensitive)
            if (monthInput.equalsIgnoreCase(months[i])) {
                return i + 1;
            }
            // 3-letter abbreviation (e.g., "Jan" or "Jan.")
            if (monthInput.equalsIgnoreCase(months[i].substring(0, 3)) || 
                monthInput.equalsIgnoreCase(months[i].substring(0, 3) + ".")) {
                return i + 1;
            }
        }
        try {
            // If input is a number 
            int month = Integer.parseInt(monthInput);
            if (month >= 1 && month <= 12) {
                return month;
            }
        } catch (NumberFormatException e) {
            return -1;
        }
        return -1; // Invalid month input
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getDaysInMonth(int month, boolean isLeapYear) {
        int[] daysInMonth = {31, isLeapYear ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return daysInMonth[month - 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year, month;

        // Validate year input (e.g., not 99 but 1999)
        do {
            System.out.print("Enter year (e.g., 1999): ");
            while (!scanner.hasNextInt()) {  // Ensure the input is numeric
                System.out.print("Invalid input. Enter a valid year: ");
                scanner.next(); // Discard invalid input
            }
            year = scanner.nextInt();
        } while (year <= 0);

        // Validate month input
        do {
            System.out.print("Enter month (e.g., January, Jan, Jan., or 1): ");
            String monthInput = scanner.next();
            month = Month(monthInput);
            if (month == -1) {
                System.out.println("Invalid month. Please try again.");
            }
        } while (month < 1 || month > 12);

        boolean isLeapYear = isLeapYear(year);
        int daysInMonth = getDaysInMonth(month, isLeapYear);

        System.out.println("The month " + month + " of the year " + year + " has " + daysInMonth + " days.");
    }
}
