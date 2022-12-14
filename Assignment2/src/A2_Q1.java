// -------------------------------------------------------
// Assignment 2
// Written by: Nathan Grenier 40250986
// For COMP 248 Section T – Fall 2022
// October 7, 2022 
// 
// Purpose: This program allows the user to input an integer code. 
// This code is used to display, to the user, 
// what type of material that code corresponds to and how to dispose of it. 
// 
// Variables:
// code = stores the user inputed code as an integer.
// in = Scanner object to read user input
//
// Algorithm: Program prompts the user with a welcome message and a table that shows which 
// recycling code corresponds to what items. The user is then prompted to enter a code.
// The inputed code is then evaluated in a series of if statement to determine the right output message to display.
// If the code is not valid. An error message is sent and the program is terminated.
// If the code is valid, the type of material and information on how to dispose of it is displayed to the user.
// The program terminates with a goodbye message.
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
		
		byte code = 0;		// stores recycling code entered by user
		
		// Store value (Recycling code number) inputed by user
		if (in.hasNextByte()) {			// Validate if user is entering a byte value
			code = in.nextByte();		// Assign byte value to code
		} else {
			System.out.print("Error: Your recycling Code is not a valid integer between -128 to 127. Kindly retry again!");
			System.exit(0); 		// Terminate code as user has entered a non-byte value 
		}
		
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
