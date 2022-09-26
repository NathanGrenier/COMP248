package test;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		/*
		int mil50 = 50000000;
		long value = 1000L * mil50;

		double price = 4.35;
		double quantity = 1000000;
		double total = price / quantity;
		*/
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your age: ");
		int num1 = input.nextInt();
		int num2 = input.nextInt();

		
		System.out.println(num1 + " " + num2);
		input.close();
		
	}

}
