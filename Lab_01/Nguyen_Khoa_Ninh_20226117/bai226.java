package NewPack;
import java.util.*;
import java.lang.Math;

public class bai226 {
    
    // Solving first-degree equation ax + b = 0
    static void first_degree() {
        Scanner sc = new Scanner(System.in);
        double a, b, x;

        // Input validation loop for 'a'
        while (true) {
            System.out.print("a = ");
            a = sc.nextDouble();
            if (a != 0) break;
            System.out.println("a cannot be 0! Please re-enter.");
        }

        System.out.print("b = ");
        b = sc.nextDouble();

        x = -b / a;
        System.out.println("x = " + x);
    }

    // Solving second-degree equation ax^2 + bx + c = 0
    static void second_deg() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter coefficients a, b, and c: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int delta = b * b - 4 * a * c;
        
        if (delta < 0) {
            System.out.println("No solution.");
        } else if (delta == 0) {
            System.out.printf("One solution: x = %.2f\n", (float) -b / (2 * a));
        } else {
            double sqrtDelta = Math.sqrt(delta);
            float x1 = (float) (-b + sqrtDelta) / (2 * a);
            float x2 = (float) (-b - sqrtDelta) / (2 * a);
            if (x1 < x2) {
                System.out.printf("Two solutions: x1 = %.2f, x2 = %.2f\n", x1, x2);
            } else {
                System.out.printf("Two solutions: x1 = %.2f, x2 = %.2f\n", x2, x1);
            }
        }
    }

    // Solving a system of two first-degree equations with two variables
    static void bacNhat2an() {
        Scanner scan = new Scanner(System.in);
        double a11, a12, b1, a21, a22, b2;
        double D, D1, D2;

        System.out.print("a11 = ");
        a11 = scan.nextDouble();
        System.out.print("a12 = ");
        a12 = scan.nextDouble();
        System.out.print("b1 = ");
        b1 = scan.nextDouble();
        System.out.print("a21 = ");
        a21 = scan.nextDouble();
        System.out.print("a22 = ");
        a22 = scan.nextDouble();
        System.out.print("b2 = ");
        b2 = scan.nextDouble();

        D = a11 * a22 - a21 * a12;
        D1 = b1 * a22 - b2 * a12;
        D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else if (D == 0 && (D1 != 0 || D2 != 0)) {
            System.out.println("No solution.");
        } else {
            System.out.println("Infinite solutions: " + a11 + "x1 + " + a12 + "x2 = " + b1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Solve first-degree equation (ax + b = 0)");
            System.out.println("2. Solve system of two first-degree equations");
            System.out.println("3. Solve second-degree equation (ax^2 + bx + c = 0)");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    first_degree();
                    break;
                case 2:
                    bacNhat2an();
                    break;
                case 3:
                    second_deg();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
