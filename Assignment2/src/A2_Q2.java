// -------------------------------------------------------
// Assignment 2
// Written by: Nathan Grenier 40250986
// For COMP 248 Section T – Fall 2022
// October 7, 2022 
// 
//Purpose: 
// 
// Variables:
//
// Constants:
//
// Algorithm: 
// --------------------------------------------------------

import java.util.Scanner;

public class A2_Q2 {

	public static void main(String[] args) {

		// Welcome message
		System.out.println("***** Welcome to Farms Distribution Center Price Index Program *****\n");
		
		// Declare Constants and variable
		final double W = 1.4672;
		
		double P = 0.0;
		
		// Prompt user for Month and Market values
		System.out.print("Please enter a Month and Market, respectively: ");
		
		// Initialize a scanner
		Scanner in = new Scanner(System.in);
		
		// Store user inputs
		String month = in.next();
		String market = in.next();
		
		// Variable corresponding to domestic or international
		int isDomestic = 0;	// 1: Domestic, 0: International
		
		// ##### Validate if month and markets inputs are valid #####
		
		// Market Validation
		switch(market.toLowerCase()) {
			case "domestic":
				isDomestic = 1;
				break;
			case "international":
				isDomestic = 0;
				break;
			default:
				System.out.print("Error: An invalid value has been entered for the 'Market' varaible. Please try again!");
				// Terminate program
				System.exit(0);
		
		}
		
		// Month Validation and percentage of harvest value assignment
		switch (month.toLowerCase()) {
			case "january":
				switch (isDomestic) {
					// 1 equivalent to true for isDomestic
					case 1:
						P = 75.25;
						break;
					// 0 equivalent to false for isDomestic
					case 0:
						P = 24.75;
						break;
				}
				break;
			
			case "febuary":
				switch (isDomestic) {
					case 1:
						P = 62.86;
						break;
					case 0:
						P = 37.14;
						break;
				}
				break;
			
			case "march":
					switch (isDomestic) {
						case 1:
							P = 54.78;
							break;
						case 0:
							P = 45.22;
							break;
				}
				break;
			
			case "april":
				switch (isDomestic) {
					case 1:
						P = 68.46;
						break;
					case 0:
						P = 31.54;
						break;
				}
				break;
			
			case "may":
				switch (isDomestic) {
					case 1:
						P = 35.89;
						break;
					case 0:
						P = 64.11;
						break;
				}
				break;
			
			case "june":
				switch (isDomestic) {
					case 1:
						P = 28.94;
						break;
					case 0:
						P = 71.06;
						break;
				}
				break;
			
			case "july":
				switch (isDomestic) {
					case 1:
						P = 42.50;
						break;
					case 0:
						P = 57.5;
						break;
				}
				break;
			
			case "august":
				switch (isDomestic) {
					case 1:
						P = 86.1;
						break;
					case 0:
						P = 13.9;
						break;
				}
				break;
			
			case "september":
				switch (isDomestic) {
					case 1:
						P = 69.7;
						break;
					case 0:
						P = 30.3;
						break;
				}
				break;
			
			case "october":
				switch (isDomestic) {
					case 1:
						P = 85.4;
						break;
					case 0:
						P = 14.6;
						break;
				}
				break;
			
			case "november":
				switch (isDomestic) {
					case 1:
						P = 75.9;
						break;
					case 0:
						P = 24.1;
						break;
				}
				break;
			
			case "december":
				switch (isDomestic) {
					case 1:
						P = 76.8;
						break;
					case 0:
						P = 23.2;
						break;
				}
				break;
			
			default:
				System.out.println("\"Error: An invalid value has been entered for the 'Month' varaible. Please try again!\"");
				// Terminate Program
				System.exit(0);	
		}
		
		// Calculating price index "I"
		double I = (1.0/20.0) * (P * W);
		
		// Display Price index
		System.out.printf("\nThe value of the Price Index, 'I', is: %.2f", I);
		
		// Termination Message
		System.out.println("\nThank you for using Farms Distribution Center Price Index Program!");

	}

}
