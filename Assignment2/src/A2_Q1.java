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

public class A2_Q1 {

	public static void main(String[] args) {

		// Welcome message
		System.out.println("***** Welcome to the City Recycling Program: *****\n");
		
		// Display Recycling codes and corresponding items
		System.out.println("Recycling Code. |--> Item samples"
						 + "\n---------------------------------------\n"
						 + "1. |--> [Soft drink bottles/Trash cans]\n"
						 + "2. |--> [Shampoo bottles/Yogurt container]\n"
						 + "3. |--> [Plastic bags]\n"
						 + "4. |--> [Storage bins/Brooms/Brushes]\n"
						 + "5. |--> [Garden hoses/Piping]\n"
						 + "6. |--> [Carry-out food containers]\n"
						 + "7. |--> [Plastics straws/Chip bags/coffee pods]\n"
						 + "8. |--> [cell phone/Computer/Camera/Batteries]\n"
						 + "9. |--> [TV Remote/Flashlight batteries]\n"
						 + "10.|--> [Car batteries]\n"
						 + "11.|--> [Cereal/Snack Cardboard boxes]\n"
						 + "12.|--> [Newspaper/Books/Wallpaper]\n"
						 + "---------------------------------------\n");
		
		// Prompt user to enter a recycling code
		System.out.print("Please enter a recycling code that corresponds to the item you would like to recycle: ");
		
		// Initialize a scanner
		Scanner in = new Scanner(System.in);
		
		// Store value (Recycling code number) inputed by user
		int code = in.nextInt();
		
		// Close scanner instance
		in.close();
		
		// Check if the inputed code is valid. If true, display its type and the action instructions
		if(code >= 1 && code <= 5) {																							// Recycled Plastics
			// Display Type
			System.out.println("This is a Recycled Plastics item.");
			// Display Action
			System.out.println("Item required to be put in the blue household recycling bin.");
		} else if(code >= 6 && code <= 7) {																						// Non-Recycled Plastics
			System.out.println("This is a Non-Recycled Plastics item.");
			System.out.println("Item required to be put in the gray household garbage bin.");			
		} else if(code >= 8 && code <= 10) {																					// Batteries
			System.out.println("This is a Batteries item.");
			System.out.println("Item required to be taken to your local recycling depot or nearby store for disposal.");			
		} else if(code >= 11 && code <= 12) {																					// Paper
			System.out.println("This is a Paper item.");
			System.out.println("Item required to be put in the blue household recycling bin.");		
		} else if(code >= 13 && code <= 127) {																					// N/A
			System.out.println("This is N/A.");
			System.out.println("Item code not handled by the city recycling system.\n"
					+ "Kindly check the nearby city(ies) for possible recycling availability.");			
		} else if(code >= -128 && code <= 0) {																					// Hazardous
			System.out.println("This is a Hazardous Material.");
			System.out.println("Material required to be put in a hazardous dumpster diving.\n"
					+ "Kindly check your area for the nearby one.");			
		} else {
			System.out.println("Error: Your recycling Code is not a valid integer between -128 to 127. Kindly retry again!");
			// Terminate Program
			System.exit(0);
		}
		
		// Termination Message
		System.out.println("\nThank you for saving the planet!");

	}

}
