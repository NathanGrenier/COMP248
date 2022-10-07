// -------------------------------------------------------
// Assignment 1
// Written by: Nathan Grenier 40250986
// For COMP 248 Section T – Fall 2022
// September 16, 2022 
// 
// Purpose: This program prompts the user for 2 integer inputs (p and q) to then be used to calculate the
// coordinates of an astronomical object and the object nearest to it.
// 
// Variables:
// p,q = User inputs used in calculations
// x,y,z = Coordinates of first astronomical object calculated using p and q
// n_near,y_near,z_near = Coordinates of nearest astronomical (with respect to first object)
// input = Scanner object to record user input
//
// Constants:
// PI = Approximation of pi obtained by dividing 22 by 7
// E = Euler's constant (2.718281828)
//
// Algorithm: The user is prompted to input 2 integer values, p and q.
// These values are then used to calculate the coordinates of an astronomical object using the provided equations.
// The value of these coordinates are then displayed to the user.
// Using the coordinates of the first object, the nearest object relative to the first one can also be calculated.
// The nearest object's coordinates are also displayed to the user. 
// The program terminates with a thank you message.
// --------------------------------------------------------

// Import necessary libraries
import java.util.Scanner;

public class A1_Q1 {

	public static void main(String[] args) {
	
		// Welcome message
		System.out.println("##### Assignment 1, Question 1 #####");
		System.out.println("Welcome to the Simple 3D-Space Program:\n");
		
		// Math Constants
		final double PI = 22/7d;				// Type cast double (or adding d) ensures that result is a double
		final double E = 2.718281828f;
		
		// Create new Scanner object
		Scanner input = new Scanner(System.in);
		
		// Record input from user after they are prompted
		System.out.print("Enter integer values for p and q (seperated by a space) ranging from 50-127:");		// Prompt user to input value
		byte p = input.nextByte();												// Store value inputed 
		byte q = input.nextByte();												// Store value inputed 
		// Close Scanner object
		input.close();
		
		// Calculating Cartesian coordinates of astronomical body
		double x = ((p * PI) / E) + 50; 					// Calculation for x
		double y = ((p * PI) / E) + (50 * 12); 				// Calculation for y
		double z = q + y; 									// Calculation for z
		
		// Print coordinates of first object
		System.out.printf("\nThe Cartesian coordiantes of the first object is:\n(%f, %f, %f)\n", x, y, z);
		
		// Calculating Cartesian coordinates of nearest astronomical body
		double x_near = x;
		double y_near = x * 12;
		double z_near = q + (y_near * 6);
		
		// Print coordinates of nearest object
		System.out.printf("The Cartesian coordiantes of the first object is:\n(%f, %f, %f)\n\n", x_near, y_near, z_near);
		
		// Termination Message
		System.out.print("Thank you for your contribution to this Space Project");
		
	}

}
