package NewPack;

import java.util.Scanner;

public class bai65 {

    // input array elements
    private static void nhapMang(int[] a, int n, Scanner sc) {
        for (int i = 0; i < n; i++) {
            System.out.print("Phan tu thu " + (i + 1) + " la: ");
            a[i] = sc.nextInt();
        }
    }

    // display the array
    private static void hienThi(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + "\t");
        }
        System.out.println(); // For a cleaner output
    }

    // sort the array 
    private static void sapXepTangDan(int[] a, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    int tg = a[i];
                    a[i] = a[j];
                    a[j] = tg;
                }
            }
        }
    }

    // calculate the sum and average of the array
    private static void Tinh(int[] a, int n) {
        int sum = 0;
        double aver;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        aver = (double) sum / n; // Cast to double for floating-point division
        System.out.println("\nTong cua mang la: " + sum);
        System.out.println("Gia tri trung binh cua mang la: " + aver);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao so luong phan tu n = ");
        int n = sc.nextInt();
        int[] a = new int[n]; 

        System.out.println("Nhap vao mang cac so nguyen:");
        nhapMang(a, n, sc); 

        // Display the input array
        System.out.println("Mang vua nhap la:");
        hienThi(a, n);

        // Sort the array 
        System.out.println("Mang sau khi sap xep tang dan la:");
        sapXepTangDan(a, n);
        hienThi(a, n); // Display 

        // Calculate and display sum and average
        Tinh(a, n);

        sc.close(); 
    }
}
