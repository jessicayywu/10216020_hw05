import java.util.Scanner;

public class TestBigNumber {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the first number: ");
		String number1 = input.nextLine();
		
		System.out.print("Enter the second number: ");
		String number2 = input.nextLine();
		
		String sum = arrayToString(add(numberToArray(number1), numberToArray(number2)));
		
		System.out.println("The sum is: ");
		System.out.println(sum);
		
		System.out.print("Enter the first number: ");
		String number3 = input.nextLine();
		
		System.out.print("Enter the second number: ");
		String number4 = input.nextLine();
		
		String product = arrayToString(multiply(numberToArray(number3), numberToArray(number4)));
		
		System.out.println("The product is: ");
		System.out.println(product);
		
		System.out.print("Enter the first number: ");
		String number5 = input.nextLine();
		
		System.out.print("Enter the second number: ");
		String number6 = input.nextLine();
		
		String difference = arrayToString(minus(numberToArray(number5), numberToArray(number6)));
		
		System.out.println("The difference is: ");
		System.out.println(difference);
	}
	
	public static int[] numberToArray(String number) {
		int length = (int)Math.ceil((double)number.length() / 4);
		int[] bigNumber = new int[length];
		
		String temp;
		
		for (int i = 1; i <= length; i++) {
			if ( i == 0)
				temp = number.substring(number.length() - 4 * i);
			else if (number.length() - 4 * i < 0)
				temp = number.substring(0, number.length() - 4 * (i - 1));
			else
				temp = number.substring(number.length() - 4 * i, number.length() - 4 * (i - 1));
			
			bigNumber[length - i] = Integer.parseInt(temp);
		}
		
		return bigNumber;
	}
	
	public static int[] add(int[] bigNumber1, int[] bigNumber2) {
		int length = (bigNumber1.length > bigNumber2.length) ? bigNumber1.length + 1 : bigNumber2.length + 1;
		int[] sum = new int[length];
		int[] bigNum1 = new int[length];
		int[] bigNum2 = new int[length];
		
		for(int m = 1; m <= bigNumber1.length; m++)
			bigNum1[bigNum1.length - m] = bigNumber1[bigNumber1.length - m];
			
		for(int n = 1; n <= bigNumber2.length; n++)
			bigNum2[bigNum2.length - n] = bigNumber2[bigNumber2.length - n];
		
		for (int i = 0; i < length; i++)
			sum[i] = bigNum1[i] + bigNum2[i];
			
		for (int j = 1; j < length; j++) {
			sum[length - j - 1] += sum[length - j] / 10000;
			sum[length - j] %= 10000;
		}
		
		return sum;
	}
	
	public static int[] minus(int[] bigNumber1, int[] bigNumber2) {
		int length = (bigNumber1.length > bigNumber2.length) ? bigNumber1.length : bigNumber2.length;
		int[] difference = new int[length];
		int[] bigNum1 = new int[length];
		int[] bigNum2 = new int[length];
		
		for(int m = 1; m <= bigNumber1.length; m++)
			bigNum1[bigNum1.length - m] = bigNumber1[bigNumber1.length - m];
	
		for(int n = 1; n <= bigNumber2.length; n++)
			bigNum2[bigNum2.length - n] = bigNumber2[bigNumber2.length - n];
		
		for (int i = 0; i < length; i++)
			difference[i] = bigNum1[i] - bigNum2[i];
			
		for (int j = 1; j < length; j++) {
			if (difference[j] < 0) {
				difference[j + 1] -= 1000;
				difference[j] += 10000;
			}
		}
		
		return difference;
	}
	
	public static int[] multiply(int[] bigNumber1, int[] bigNumber2) {
		int length = bigNumber1.length * bigNumber2.length;
		int[] product = new int[length];
		int[] bigNum1 = new int[length];
		int[] bigNum2 = new int[length];
		
		for(int m = 1; m <= bigNumber1.length; m++)
			bigNum1[bigNum1.length - m] = bigNumber1[bigNumber1.length - m];
			
		for(int n = 1; n <= bigNumber2.length; n++)
			bigNum2[bigNum2.length - n] = bigNumber2[bigNumber2.length - n];
		
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (i + j < length)
					product[i + j] += bigNum1[i] * bigNum2[j];
			}
		}
		
		for (int k = 1; k < length; k++) {
			product[length - k - 1] += product[length - k] / 10000;
			product[length - k] %= 10000;
		}
		
		return product;
	}
	
	public static String arrayToString(int[] bigNumber) {
		String result = "";
		
		for(int i = 0; i < bigNumber.length; i++)
			result += String.valueOf(bigNumber[i]);
		
		if (result.charAt(0) == '0')
			result = result.substring(1);
		
		return result;
	}
}