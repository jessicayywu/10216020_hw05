import java.util.Scanner;

public class TestReadFile {

	public static void main(String[] args) throws Exception {
		java.io.File file = new java.io.File("password.txt");
		
		String password = "";
		
		if (file.exists()) {
			Scanner readFile = new Scanner(file);
			password = readFile.nextLine();
			System.out.println(password);
			readFile.close();
		}
		else {
			Scanner input = new Scanner(System.in);
			
			java.io.PrintWriter output = new java.io.PrintWriter(file);
			System.out.print("Input Password: ");
			password = input.nextLine();
			output.print(password);
			input.close();
			output.close();
		}
	}
}
