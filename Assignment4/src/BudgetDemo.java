/*
* Assignment 4
* Written by: Nathan Grenier 40250986
* For COMP 248 Section T – Fall 2022
* November 17, 2022 
*  
*/

import java.util.Scanner;

public class BudgetDemo {
	
	// Returns true if the reference of the array budgets is not equal to null
	private static boolean budgetExists(HouseholdBudget budgets[]) {
		if (budgets != null) {
			return true;
		}
		return false;
	}
	
	// Prints the available commands to the console
	private static void showOptions() {
		// Options
		System.out.println("What would you like to do?\n"
						  + "  1. See the possessions of all householdBudgets\n"
						  + "  2. See the possessions of one householdBudget\n"
						  + "  3. List householdBudgets with same total amount of fund\n"
						  + "  4. List householdBudgets with same fund denomination(s)\n"
						  + "  5. List householdBudgets with same total amount of fund and same number of expenses\n"
						  + "  6. Add an expense to an existing householdBudget\n"
						  + "  7. Remove an existing expense from a householdBudget\n"
						  + "  8. Update the payment due date of an existing expense\n"
						  + "  9. Add fund to a householdBudget\n"
						  + "  0. To quit\n"
						  );
	}
	
	// Prompts the user for a code. Validates if the code is an int and between 0 and 9. If not, re-prompts the user
	private static int promptUser() {
		Scanner in = new Scanner(System.in);
		// Prompt User
		System.out.print("Please enter your choice and press <Enter>:");
		int code = -1;
		
		// Validate user input
		if (in.hasNextInt()) {
			code = in.nextInt();
			
			// If the inputed code is not between 0 and 9, re-prompt
			if (!(code >= 0 && code <=9)) {
				System.out.println("Code must be between 0 and 9. Try Again.\n");
				// User entered an invalid code, re-prompt them
				code = promptUser();	// code should equal the last input from the recursive stack. In other words, the last call will be the value of code that is returned
			}
		} else {
			System.out.println("Sorry, that is not a valid choice. Try Again.\n");
			// User entered an invalid code, re-prompt them
			code = promptUser();	// code should equal the last input from the recursive stack. In other words, the last call will be the value of code that is returned
		}
		
		return code;
	}
	
	public static void main(String[] args) {
		// --Generate Boilerplate Budgets-- //
		// Funds
		Fund fund1 = new Fund(1,2,3,4,5);
		Fund sameTotalAs1 = new Fund(0,0,0,0,8);
		Fund fund2 = new Fund(10,9,8,7,6);
		
		// Expenses
		Expense expense1 = new Expense("Payment", 12.95, "Videotron", "22/11");
		Expense expense2 = new Expense("Purchase", 13.37, "Best Buy", "09/10");
		Expense expense3 = new Expense("Bill", 1234.99, "Concordia", "01/03");
		Expense none[] = null;
		Expense expenses1[] = {expense1};
		Expense expenses2[] = {expense1, expense2, expense3};
		
		// Budgets
		HouseholdBudget budget1 = new HouseholdBudget(fund1, expenses1);	// Identical to budget2
		HouseholdBudget budget2 = new HouseholdBudget(fund1, expenses1);	// Identical to budget1
		
		HouseholdBudget budget3 = new HouseholdBudget(sameTotalAs1, expenses2);	// Same total fund value of budget1 and budget2, 3 expenses
		
		HouseholdBudget budget4 = new HouseholdBudget(fund2,none);	// Same fund and expense count as budget5
		HouseholdBudget budget5 = new HouseholdBudget(fund2,none);	// Same fund and expense count as budget4
		
		// --Main-- //
		// Variables
		int code;	// Code that determines action to take
		HouseholdBudget budgets[] = {budget1, budget2, budget3, budget4, budget5};	// Array of HouseholdBudgets
		
		// Welcome User
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
						 + "\n"
						 + "Welcome to COMP248 Geek's HouseholdBudget_2022 Application\n"
						 + "\n"
						 + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		do {
			showOptions();			// Prints the option list to the console
			code = promptUser();	// Prompt the user for a code
			
			// Evaluate the code that was inputed
			switch (code) {
				
				// ---Display fund and expenses of every HouseholdBudget---
				case 1:
					// Check to see if there are any budgets
					if (budgetExists(budgets)) {
						System.out.println("Content of each HouseholdBudget:\n"
								+ "--------------------");
						
						// Display HouseholdBudgets
						for (int i=0; i<budgets.length; i++) {
							System.out.println("HouseholdBudget #"+ i +":");
							System.out.println(budgets[i].toString() + "\n");
						}	
					} else {
						System.out.println("No budgets exist\n");
					}
					
					break;
				
				// ---Terminate Program---
				case 0:
					// Display termination message
					System.out.println("Thank you for using COMP248 Geek's HouseholdBudget application!");
					break;
					
				default:
					System.out.println(code);
					break;
			
			}
		
		} while (code !=0);
		
		

		
	}

}
