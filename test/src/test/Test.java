package test;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		for (int i = 1; i<=5; i++) {
			System.out.println("This: " + i);
			switch (i) {	
			
			case 1:
				System.out.println(i);
				break;
			
			case 2:
				System.out.println(i);
				break;
			
			case 3:
				System.out.println(i);
				break;
			default:
				System.out.println("default: " + i);
			}
		}

	}
}