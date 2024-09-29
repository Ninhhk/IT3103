package NewPack;
import java.util.*;
public class bai225 {
	public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int num1= scanner.nextInt();
        int num2= scanner.nextInt();
        
        System.out.println(num1+num2);
        System.out.println(num1-num2);
        System.out.println(num1*num2);
        if (num2 == 0) {
			return;
		} else {
			double thuong =(double) num1/num2;
			System.out.println(thuong);
		}
        scanner.close();
    }
}
