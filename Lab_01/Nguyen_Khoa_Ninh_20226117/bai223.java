package NewPack;
//Example 3: HelloNameDialog. java
import javax.swing. JOptionPane;
public class bai223{
	public static void main(String[] args){
		String result;
		result = JOptionPane. showInputDialog("Please enter your name:");
		JOptionPane.showMessageDialog(null, "Hi "+ result + "!");
		System.exit(0);
	}
}