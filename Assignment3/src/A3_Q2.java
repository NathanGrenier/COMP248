/*
* Assignment 3
* Written by: Nathan Grenier 40250986
* For COMP 248 Section T – Fall 2022
* October 24, 2022 
* 
* Purpose: This program is a simple electronic voting system (SEVS). It has 4 main functions:
* 1. Display candidates
* 2. Vote for a candidate
* 3. Add new candidates
* 4. Calculate and display election results
* The program can handle invalid inputs by the user and can be terminates by entering the code 0.
* To input a candidate, enter their information in the following format: {id_1}, {name_1}; {id_2}, {name_2};......
*/

import java.util.Scanner;

public class A3_Q2 {

	public static void main(String[] args) {
		
		// Welcome message
		System.out.println("***** Welcome to the Simple Electronic Voting System (SEVS): *****\n");
		
		// Initialize a scanner
		Scanner in = new Scanner(System.in);
		// User inputed code variable dictating what action to take
		int code = 0;
		
		// Prompt user to input profiles of candidates
		System.out.println("Please enter a String collection of electoral candidates below:");
		
//----- Format user input into String array -----//
		// Store user input
		String candidates[] = in.nextLine().split(";");		// .split(";") returns an array of Strings for each value separated by the semicolon. 
															// Format: [11, Jane Doe, 12, John Doe] 
		
		// Initialize 2D array that will hold the data. dataAppended is a temp variable that is used to add an empty array to data
		String data[][] = new String[0][4];		// Format: {{id_1, name_1, votes_1, position_1}, {id_2, name_2, votes_2, position_2}}
		String dataAppended[][];
		
		// Insert values from candidates[] into data[i][]
		for (int i=data.length; i < candidates.length; i++) {
			// Add new array to data for next candidate
			dataAppended = new String[data.length + 1][4];	// new variables dataAppended needed because we can't use methods. temp variable
			
			// Copy content of data to dataAppended
			for (int j=0; j < data.length; j++) {
				for (int k=0; k <data[j].length; k++) {
					dataAppended[j][k] = data[j][k];
				}
			}
			// Set value of data to dataAppended. We have successfully added an empty array to data.
			data = dataAppended;
			
			
			// Assign values of each candidate to first array of data
			data[i] = candidates[i].split(",");
			
			// Assign 0 for number of votes and position in data[i]. This is necessary because when assigning values to data[i], .split(",") returns an array with only 2 elements. We have to make it 4 to include votes and position
			for (int k=2; k < 4; k++) {
				dataAppended = new String[data.length][4];	// new variables dataAppended needed because we can't use methods. temp variable
				// Copy content of data to dataAppended
				for (int j=0; j < data.length; j++) {
					for (int n=0; n < data[j].length; n++) {
						dataAppended[j][n] = data[j][n];
					}
				}
				
				// Add value of 0 to index k of candidate. makes the position and number of votes 0
				dataAppended[i][k] = "0";
				
				// Set value of data to dataAppended.
				data = dataAppended;
				
			}
			
			// Remove trailing whitespaces with .trim() and convert each element of nested array to uppercase
			for (int j=0; j<4; j++) {
				data[i][j] = data[i][j].trim().toUpperCase();
			}
			
		}
				
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
			System.out.print("Enter a code, from the code table, that corresponds to your task: ");
			
			// Verify is code entered is an int. If true, assign the value to code
			if (in.hasNextInt()) {
				code = in.nextInt();
			} else {
				// Assign a value to code that will never be correct (-1). This will trip the default of the switch statement below prompting the user to re-enter the value of code
				code = -1;
			}
			
			
			// Evaluate the code that was inputed
			switch (code) {
				
				// ---Display candidates---	
				case 1: 	
					// Print header
					System.out.println(
						   "*********************************\n"
						 + "| ID >> Candidate's Name        |\n"
						 + "*********************************");
					
					// Loop through each candidate
					for (int i=0; i < data.length; i++) {
						// Print candidate's information
						System.out.printf("| %s >> %-23s |\n", data[i][0], data[i][1]);
					}
					
					// Print tail
					System.out.println("*********************************");
					break;
				
				
				// ---Vote for a candidate---
				case 2:		
					// Flag for if the user has successfully voted
					boolean voted = false;
					
					do {
						// Prompt user to vote for a candidate
						System.out.print("\nPlease enter the ID of the candidate you wish to vote for: ");
						
						// If the user has entered an integer value (valid values are integers)
						if (in.hasNextInt()) {
							// Assign candidate id to vote
							int vote = in.nextInt();
							
							// Check if ID entered exists
							for (String candidate[]: data) {
								if (Integer.parseInt(candidate[0]) == vote) {
									// Add a vote
									candidate[2] = Integer.toString(Integer.parseInt(candidate[2]) + 1); 	// parse candidate[2] for an int. add 1 to that int. Convert the int back to a string
									voted = true;
									System.out.printf("Your ballot has been successfully casted for: %s bearing Candidate ID: %s\n\n", candidate[1], candidate[0]);
								}
							}
							
						} else {
							// Display error message
							System.out.println("*****Value entered was invalid*****");
						}
					}
					while (voted == false);
					break;
				
				
				// ---Add a new candidate(s)---
				case 3:		
					// Prompt User for new candidates
					System.out.println("\nPlease enter a String collection of the NEW electoral candidates below: ");
					
				//----- Format user input into String array -----//
					// Clear i/o stream
					in.nextLine();
					// Store user input
					String newCandidates[] = in.nextLine().split(";");	// .split(";") returns an array of Strings for each value separated by the semicolon. 
																		// Format: [11, Jane Doe, 12, John Doe] 

					// Keep track of initial length of data array
					int dataLengthInit = data.length;
					
					// Insert values from newCandidates[] into data[][]
					for (int i=data.length, j=0; i < (dataLengthInit + newCandidates.length); i++, j++) {
						// Add new array to data for next candidate
						dataAppended = new String[data.length + 1][4];	// new variables dataAppended needed because we can't use methods. temp variable
						
						// Copy content of data to dataAppended
						for (int n=0; n < data.length; n++) {
							for (int k=0; k <data[n].length; k++) {
								dataAppended[n][k] = data[n][k];
							}
						}
						// Set value of data to dataAppended. We have successfully added an empty array to data.
						data = dataAppended;
						
						// Assign values of each candidate to current array of data
						data[i] = newCandidates[j].split(",");
						
						// Assign 0 for number of votes and position in data[i]. This is necessary because when assigning values to data[i], .split(",") returns an array with only 2 elements. We have to make it 4 to include votes and position
						for (int k=2; k < 4; k++) {
							dataAppended = new String[data.length][4];	// new variables dataAppended needed because we can't use methods. temp variable
							// Copy content of data to dataAppended
							for (int m=0; m < data.length; m++) {
								for (int n=0; n < data[m].length; n++) {
									dataAppended[m][n] = data[m][n];
								}
							}
							
							// Add value of 0 to index k of candidate. makes the position and number of votes 0
							dataAppended[i][k] = "0";
							
							// Set value of data to dataAppended
							data = dataAppended;
						}
						
						// Remove trailing whitespaces with .trim() and convert each element of nested array to uppercase
						for (int k=0; k<4; k++) {
							data[i][k] = data[i][k].trim().toUpperCase();
						}
					}
					break;
				
				
				// ---Display election results---	
				case 4:	
					// ----- Compute Position of Candidates ----- //
					/* Algorithm:
					 * 1. Create necessary variables
					 * 2. Copy all candidates to an identical array called tempData 
					 * 3. Find candidate with the most votes. Add them to mostVotes
					 * 4. Verify if there are any other candidate with votes equal to the candidate with the most votes. Add those candidate to most votes as well
					 * 5. Delete candidates with most votes from tempData
					 * 6. Assign current position value to candidates in mostVotes
					 * 7. Copy candidates from mostVotes into a new array called newData. newData will contain the sorted candidate data with updated position values.
					 * 8. Increment the position value
					 * 9. Repeat until there are no more candidates in tempData
					 */
					
					// Create new variables. 
					String tempData[][] = new String[data.length][];	// contains a copy of the data array. After looping through each candidate, an entry in tempData will be deleted.
					String newData[][] = new String[0][];				// contains the sorted candidates with updated position data
					int pos = 1;										// contains the current position being assigned to the candidates
					
					// Copy data array into tempData
					for (int i=0; i < data.length; i++) {
						tempData[i] = data[i].clone();
					}
					
					
					// While there is still a candidate to evaluate
					while (tempData.length != 0) {
						String mostVotes[][] = new String[1][];		// Holds the candidate with the most votes
						mostVotes[0] = tempData[0].clone();			// We don't know which candidate has the most votes. Just copy the first candidate in tempData
						
						// Loop through tempData and find the candidate with the most votes
						for (String candidate[]: tempData) {
							if (Integer.parseInt(candidate[2]) > Integer.parseInt(mostVotes[0][2])) {
								// Assign current candidate to first index of mostVotes
								mostVotes[0] = candidate.clone();
							}
						}
						
						// Check if there are any other candidates with votes equal to the candidate with the most votes
						for (String candidate[]: tempData) {
							// If the current candidate isn't the same as the one in mostVotes
							if (candidate[0] != mostVotes[0][0]) {
								// If the candidate we are checking and the first candidate in mostVotes have the same number of votes
								if (Integer.parseInt(candidate[2]) == Integer.parseInt(mostVotes[0][2])) {
									// There are more than 1 candidates with the most votes. Add the candidates to the mostVotes array
									
									// Add 1 nested array to the temp variable dataAppended
									dataAppended = new String[mostVotes.length + 1][4];
									// Copy contents of mostVotes into dataAppended
									for (int i=0; i < mostVotes.length; i++) {
										for (int j=0; j < mostVotes[i].length; j++) {
											dataAppended[i][j] = mostVotes[i][j];
										}
									}
									// Add contents of current mostVotes candidate to dataAppended
									dataAppended[dataAppended.length - 1] = candidate.clone();
									
									// Copy dataAppended into mostVotes
									mostVotes = dataAppended;
								}							
							}
						}
						
						
						// Delete candidates with most votes from tempData
						for (String candidate[]: mostVotes) {
							// Remove an element from newTempData
							String newTempData[][] = new String[tempData.length - 1][];
							// Copy all the data from tempData except for the values in mostVotes to newTempData
							for (int i=0, k=0; i < tempData.length; i++) {
								if (tempData[i][0] != candidate[0]) {
									newTempData[k] = tempData[i].clone();
									k++;
								}
							}
							// Copy newTempData into tempData. This copy will exclude the elements removed
							tempData = new String[newTempData.length][4];		// Create tempData array with the same size as newTempData
							// Copy elements from newTempData into tempData
							for (int i=0; i < newTempData.length; i++) {
								for (int j=0; j < newTempData[i].length; j++) {
									tempData[i][j] = newTempData[i][j];
								}
							}
						}
							 
						
						// Assign current positions value to candidates with the most votes 
						for (String candidate[]: mostVotes) {
							candidate[3] = Integer.toString(pos);
						}
						
						// Add candidates with updated position values to newData
						for (String candidate[]: mostVotes) {
							// Add 1 nested array to the temp variable dataAppended
							dataAppended = new String[newData.length + 1][4];
							// Copy contents of newData into dataAppended
							for (int i=0; i < newData.length; i++) {
								for (int j=0; j < newData[i].length; j++) {
									dataAppended[i][j] = newData[i][j];
								}
							}
							// Add contents of current mostVotes candidate to dataAppended
							dataAppended[dataAppended.length - 1] = candidate.clone();
							
							// Copy dataAppended into newData
							newData = dataAppended;
						}
					
						pos++;		// Increment position value
					}
			
					// ----- Display Results ----- //
					
					// Print header
					System.out.println(
						   "***********************************************************\n"
						 + "| Position | Votes/Ballots | ID | Candidate's Name        |\n"
						 + "***********************************************************");
					
					// Loop through each candidate
					for (int i=0; i < newData.length; i++) {
						// Print candidate's information
						System.out.printf("| %8s | %13s | %s | %-23s |\n", newData[i][3], newData[i][2], newData[i][0], newData[i][1]);
					}
					
					// Print tail
					System.out.println("***********************************************************");
					break;
					
				// ---Terminate Program---	
				case 0:		
					// Display termination message
					System.out.println("\nThank you for using our Simple Electronic Voting System (SEVS)");
					break;
					
				
				// ---Warning message. Code entered was not valid---	
				default:	
					// Clear the scanner buffer
					in.nextLine();
					// Print error message
					System.out.println("\n*****The code you entered was not valid*****\n");
					break;
			}
		}
		// Run until user enters the code 0
		while (code != 0);
	}

}
