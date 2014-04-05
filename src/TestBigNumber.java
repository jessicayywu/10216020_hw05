import java.util.Scanner;
import java.util.Arrays;

public class TestBigNumber {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the first number: ");
		String number1 = input.nextLine();
		
		System.out.print("Enter the second number: ");
		String number2 = input.nextLine();
		
		String answer = arrayToString(divide(numberToArray(number1), numberToArray(number2)));
		//boolean answer = isBiggerOrEquals(numberToArray(number1), numberToArray(number2));
		
		System.out.println("The answer is: ");
		System.out.println(answer);
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
		
		System.arraycopy(bigNumber1, 0, bigNum1, length - bigNumber1.length, bigNumber1.length);
		System.arraycopy(bigNumber2, 0, bigNum2, length - bigNumber2.length, bigNumber2.length);

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
		int[] big = new int[length];
		int[] small = new int[length];
		
		boolean bigger = isBiggerOrEquals(bigNumber1, bigNumber2);
		
		if (bigger) {
			System.arraycopy(bigNumber1, 0, big, length - bigNumber1.length, bigNumber1.length);
			System.arraycopy(bigNumber2, 0, small, length - bigNumber2.length, bigNumber2.length);
		}
		else {
			System.arraycopy(bigNumber1, 0, small, length - bigNumber1.length, bigNumber1.length);
			System.arraycopy(bigNumber2, 0, big, length - bigNumber2.length, bigNumber2.length);
		}
		
		for (int i = 0; i < length; i++)
			difference[i] = big[i] - small[i];
			
		for (int j = 1; j < length; j++) {
			if (difference[length - j] < 0) {
				difference[length - j - 1]--;
				difference[length - j] += 10000;
			}
		}
		
		if (bigger == false) {
			difference[0] = -difference[0];
		}
		
		return difference;
	}
	
	public static int[] multiply(int[] bigNumber1, int[] bigNumber2) {
		int length = bigNumber1.length * bigNumber2.length;
		int[] product = new int[length];
		int[] bigNum1 = new int[length];
		int[] bigNum2 = new int[length];
		
		System.arraycopy(bigNumber1, 0, bigNum1, length - bigNumber1.length, bigNumber1.length);
		System.arraycopy(bigNumber2, 0, bigNum2, length - bigNumber2.length, bigNumber2.length);
		
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
	
	public static boolean isBiggerOrEquals(int[] bigNumber1, int[] bigNumber2) {
		int length = (bigNumber1.length > bigNumber2.length) ? bigNumber1.length : bigNumber2.length;
		int[] bigNum1 = new int[length];
		int[] bigNum2 = new int[length];
		
		System.arraycopy(bigNumber1, 0, bigNum1, length - bigNumber1.length, bigNumber1.length);
		System.arraycopy(bigNumber2, 0, bigNum2, length - bigNumber2.length, bigNumber2.length);
		
		boolean iboe = false;
		
		for (int i = 0; i < length; i++) {
			if(bigNum1[i] > bigNum2[i]) {
				iboe = true;
				break;
			}
		}
		
		if (Arrays.equals(bigNum1, bigNum2))
			iboe = true;
		
		return iboe;
	}
	
	public static int[] addInteger(int[] bigNumber, int n) {
		int length = bigNumber.length + 1;
		int[] bigNum = new int[length];
		
		System.arraycopy(bigNumber, 0, bigNum, length - bigNumber.length, bigNumber.length);
			
		bigNum[length - 1] = bigNum[length - 1] + n;
		
		for (int j = 1; j < length; j++) {
			bigNum[length - j - 1] += bigNum[length - j] / 10000;
			bigNum[length - j] %= 10000;
		}
		
		return bigNum;
	}
	
	public static int[] divide(int[] bigNumber1, int[] bigNumber2) {
		int length = bigNumber1.length;
		int[] quotient = new int[length];
		int[] remainder = new int[length];
		int[] temp;
		
		System.arraycopy(bigNumber1, 0, remainder, 0, bigNumber1.length);

		while(isBiggerOrEquals(remainder, bigNumber2)) {
			temp = minus(remainder, bigNumber2);
			if (temp[0] < 0)
				break;
			
			System.arraycopy(temp, 0, remainder, length - temp.length, temp.length);
			quotient = addInteger(quotient, 1);
		}
		
		return quotient;
	}
	
	public static String arrayToString(int[] bigNumber) {
		String result = "";
		
		for(int i = 0; i < bigNumber.length; i++)
			result += String.valueOf(bigNumber[i]);
		
		while (result.charAt(0) == '0') {
			if (result.length() < 2)
				break;
			
			result = result.substring(1);
		}
		return result;
	}
}