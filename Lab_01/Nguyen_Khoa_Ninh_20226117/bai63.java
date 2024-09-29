package NewPack;
import java.util.*;
public class bai63 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n = scanner.nextInt();
		for (int i = 1; i <= n; i++) {
			//khoang trong
			for (int j = 1; j <= n-i; j++) {
				System.out.printf(" ");
			}
			for (int j = 1; j <= 2*i-1; j++) {
				System.out.printf("*");
			}
			System.out.println();
		}

	}

}
