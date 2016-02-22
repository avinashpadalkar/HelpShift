import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		System.out.println("\n Enter Your Number Range Between : ");
		int firstNumber = readNumber();

		System.out.println("\n and  : ");
		int secondNumber = readNumber();
		
		System.out.println("\n Enter Multiple : ");
		int multiple = readNumber();
		
		if ((firstNumber >= multiple || secondNumber >= multiple)&& multiple!=0) {
			if (firstNumber <= secondNumber) {
				findDividers(secondNumber, firstNumber, multiple);
			} else {
				findDividers(firstNumber, secondNumber, multiple);
			}
		} else {
			System.out.println("\nPlease Enter Valid Multiple !!!");
		}

	}
	
	private static int readNumber() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String inputNumber = br.readLine();
			return Integer.parseInt(inputNumber);
		} catch (IOException e) {
			System.out.println("Enter valid number!!!");
			return readNumber();
		} catch (NumberFormatException e) {
			System.out.println("Enter valid number!!!");
			return readNumber();
		}
	}

//	findDividers method
	private static void findDividers(int largestNumber, int smallestNumber, int multiple) {
		System.out.println("\nReverse order of Multiples : ");
		
		largestNumber = largestNumber - (largestNumber%multiple);
		
		for (int i = largestNumber; i >= smallestNumber; i-=multiple) {
				System.out.println("\n " + i);
		}
	}
	
}
