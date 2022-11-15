/*
* Assignment 3
* Written by: Nathan Grenier 40250986
* For COMP 248 Section T – Fall 2022
* October 24, 2022 
*  
* Purpose: This program allows users from the ground station to send encrypted messages to individuals in space.
* It also allows for the decryption of messages that the user may recieve. The program first processes the message to ensure that the 
* first and last characters are not spaces. It then evaluates the length of the message to determine the type of encryption/decryption.
*/

import java.util.Scanner;

public class A3_Q1 {

	public static void main(String[] args) {
		
		// Welcome message
		System.out.println("***** Welcome to the 3D-Space Encryption-Decryption Program: *****\n");
		
		// Initialize a scanner
		Scanner in = new Scanner(System.in);
		// Variable for plain text input
		String message = "";
		
		// Prompt user for string input
		System.out.println("Please enter a string to Encrypt / Decrypt: ");
		
		// Validate user input (string that has no spaces at the start or end)
		if (in.hasNextLine()) {
			// Store user input
			message = in.nextLine();
			
			// Close Scanner
			in.close();
			
			// Note: you can also use String.trim() to remove the white spaces
			
			// While there are whitespaces at the start or end of message, remove them until they are all gone
			while (message.indexOf(" ") == 0 || message.lastIndexOf(" ") == message.length() -1) {
				// If the whitespace is at the start, remove it
				if (message.indexOf(" ") == 0) {
					message = message.substring(1, message.length());	// Removes first character of string by creating a new string without the space using substring
				} else {	// if else, whitespace is at the end, remove it
					message = message.substring(0, message.length() - 1);	// Removes last character of a string by creating a new string without the space
				}
			}
		}
		
		// Variable for encrypted message
		String ciphertext = "";
		
		// Verify if message has an even or odd number of characters
		if (message.length() % 2 == 0) {
			/* Even Cipher Algorithm:
			 * 1. Start from the first character in the string
			 * 2. Get the character at the even and odd index (0 is considered to be even)
			 * 3. Concatenate the odd character to the output variable ciphertext first, then the even character
			 * 4. Increase the index of the current evaluated character by 2
			 * 5. Repeat until you reach the second last character in the string
			 */
			
			// Apply the even cipher algorithm
			for (int i = 0; i < message.length() - 1; i += 2) {
				// Get char at even and odd index
				char evenChar = message.charAt(i);
				char oddChar = message.charAt(i + 1);
				
				// Concatenate odd char first
				ciphertext += oddChar;
				// Concatenate even char second
				ciphertext += evenChar;
			}
			
		} else {
			/* Odd Cipher Algorithm:
			 * 1. Add the first character in the input string to the output string ciphertext. 
			 *    Since the string has an odd number of characters, we must skip the first one for the algorithm to work
			 * 2. Start from the second character in the string
			 * 3. Get the character at the odd and even index
			 * 4. Concatenate the even character to the output variable ciphertext first, then the odd character
			 * 5. Increase the index of the current evaluated character by 2
			 * 6. Repeat until you reach the second last character in the string
			 */
			// Apply odd cipher algorithm
			
			// Add char at index 0 to ciphertext (it should not be altered)
			ciphertext += message.charAt(0);
			
			for (int i = 1; i < message.length() - 1; i += 2) {
				// Get char at even and odd index
				char oddChar = message.charAt(i);
				char evenChar = message.charAt(i + 1);
				
				// Concatenate even char first
				ciphertext += evenChar;
				// Concatenate odd char second
				ciphertext += oddChar;
			}
			
		}
		
		// Print encrypted message to user
		System.out.printf("\nKindly find below your encrypted text output: \n%s\n", ciphertext);
		
		// Termination message
		System.out.println("\nThank you for your contribution to this Space Project.");
		

	}

}
