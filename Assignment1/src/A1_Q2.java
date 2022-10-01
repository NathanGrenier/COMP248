// -------------------------------------------------------
// Assignment 1
// Written by: Nathan Grenier 40250986
// For COMP 248 Section T – Fall 2022
// September 16, 2022 
// 
// Purpose: This program prompts the user for 2 temperature values, one in celsius and the other in fahrenheit. 
// These values will be converted to their equivalent value in the opposite scale then displayed. 
// 2 arbitrary values,x and y, will also be calculated and displayed based on the following formulas:
// x = new_fahrenheit % new_celsius  |  y = new_fahrenheit^new_celsius 
//
//
// Variables:
// temp_fahrenheit,temp_celsius = User inputed temperature values used in calculations
// new_fahrenheit,new_celsius = Converted temperature values. Variable name corresponds to the new units
// x,y = Arbitrary values calculated using converted temperature values (equations above)
// input = Scanner object to record user input
//
//
// Algorithm: The user is prompted to enter 2 temperature values, 1 in fahrenheit and celsius. 
// These values are then converted to their equivalent temperatures in the opposite units. 
// These converted values are then displayed to the user. 
// 2 more values, x and y, are calculated and displayed to the user using the newly converted temperatures.
// The program terminates with a thank you message.
// --------------------------------------------------------

// PROBLEM WITH TEST CASE #2 (for x). Pretty sure sample2 output is wrong. Verified in online modulo calculator

// Import necessary libraries
import java.util.Scanner;

public class A1_Q2 {

	public static void main(String[] args) {

		// Welcome message
		System.out.println("##### Assignment 1, Question 2 #####");
		System.out.println("Welcome to the Simple Meteorological Program:\n");
		
		// Create new Scanner object
		Scanner input = new Scanner(System.in);
		
		// Record input from user after they are prompted
		System.out.print("Enter integer values for 'Fahrenheit' and 'Celsius' (seperated by a space), simultaneoulsy:");		// Prompt user to input value
		double temp_fahrenheit = input.nextInt();											// Store value inputed 
		double temp_celsius = input.nextInt();												// Store value inputed 
		// Close Scanner object
		input.close();
		
		// Calculating equivalent temperatures for inputed values
		double new_celsius = (10/18d) * (temp_fahrenheit - 32);
		double new_fahrenheit = ((temp_celsius * 18d) / 10) + 32;
		
		// Display converted values
		System.out.printf("\nThe corresponding temperature in Celsius unit is: %f", new_celsius);	// Celsius
		System.out.printf("\nThe corresponding temperature in Fahrenheit unit is: %f", new_fahrenheit);	// Fahrenheit
		
		// Computing value of x
		double x = Math.round(new_fahrenheit) % Math.round(new_celsius);			/* Modulus operator returns the remainder of a division between 2 integers. 
																					Math.round() converts the new temperatures which are doubles to integers while taking into 
																					account the value of the decimal. Using type cast would lose accuracy (value would not be rounded)*/
		
		// Display value of x
		System.out.printf("\nThe corresponding value for x is: %f", x);
		
		// Computing value of y
		double y = Math.pow(new_fahrenheit, new_celsius);
		
		// Display value of y
		System.out.printf("\nThe corresponding value for y is: %E", y);		//%E turns y value into exponential notation
		
		// Termination Message
		System.out.println("\n\nThank you for using my bespoke Meteorological program!");
	}

}
