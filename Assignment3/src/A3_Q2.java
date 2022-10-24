// -------------------------------------------------------
// Assignment 3
// Written by: Nathan Grenier 40250986
// For COMP 248 Section T – Fall 2022
// October 24, 2022 
// 
// Purpose:
// 
// Variables:
//
// Algorithm: 
// --------------------------------------------------------

import java.util.Scanner;

public class A3_Q2 {

	public static void main(String[] args) {
		
		// Welcome message
		System.out.println("***** Welcome to the Simple Electronic Voting System (SEVS): *****\n");
		
		// Initialize a scanner
		Scanner in = new Scanner(System.in);
		// User inputed code variable dictating what action to take
		int code;
		
		// Prompt user to input profiles of candidates
		System.out.println("Please enter a String collection of electoral candidates below:");
		// Store user input
		String candidates = in.nextLine();
				
		// Display Code options
		System.out.println(
				   "*********************************\n"
				 + "| Code >> Description           |\n"
				 + "*********************************\n"
				 + "|  1  >> Display candidates     |\n"
				 + "|  2  >> Vote a candidate       |\n"
				 + "|  3  >> Add a new candidate(s) |\n"
				 + "|  4  >> Display results        |\n"
				 + "|  0  >> End SEVS               |\n"
				 + "*********************************\n");
		

		
		do {
			// Prompt user to enter a code
			System.out.print("Enter a code, from the code table, that corresponds to your task:");
			
			// Assign user inputed value to code
			code = in.nextInt();
			
			// Evaluate the code that was inputed
			switch (code) {
				case 1: 	
					
					break;
				
				case 2:
					break;
				
				case 3:
					break;
				
				case 4:
					break;
					
				default:
					break;
			
			}
			
			
			
			
		}
		while (code != 0);
		
		// Display termination message
		System.out.println("Thank you for using our Simple Electronic Voting System (SEVS)");
			
	}

}
