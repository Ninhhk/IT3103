package NewPack;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

public class bai66 {
    public static void main(String args[]) throws InterruptedException {
        int a, b;
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of rows of matrix:");
        a = sc.nextInt();
        System.out.println("Number of columns of matrix:");
        b = sc.nextInt();

        int[][] array1 = new int[a][b];
        int[][] array2 = new int[a][b];
        int[][] sum = new int[a][b];

        System.out.println("Input elements of the first matrix:");
        for (int x = 0; x < a; x++) {
            for (int y = 0; y < b; y++) {
                array1[x][y] = sc.nextInt();
            }
        }

        System.out.println("Input the elements of the second matrix:");
        for (int x = 0; x < a; x++) {
            for (int y = 0; y < b; y++) {
                array2[x][y] = sc.nextInt();
            }
        }

        // Lock to synchronize access to shared matrix sum array
        ReentrantLock lock = new ReentrantLock();

        // threads to handle row-wise addition concurrently
        Thread[] threads = new Thread[a];
        for (int i = 0; i < a; i++) {
            final int row = i;
            threads[i] = new Thread(() -> {
                // Perform row-wise matrix addition in parallel
                for (int j = 0; j < b; j++) {
                    lock.lock(); // Synchronize access to the sum array
                    try {
                        sum[row][j] = array1[row][j] + array2[row][j];
                    } finally {
                        lock.unlock();
                    }
                }
            });
            threads[i].start(); // Start the thread
        }

        // Wait for all threads to finish
        for (int i = 0; i < a; i++) {
            threads[i].join();
        }

        // Print the result
        System.out.println("Sum of the matrices: ");
        for (int x = 0; x < a; x++) {
            for (int y = 0; y < b; y++) {
                System.out.print(sum[x][y] + "\t");
            }
            System.out.println();
        }

        sc.close();
    }
}
