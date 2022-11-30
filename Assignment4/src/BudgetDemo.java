/*
* Assignment 4
* Written by: Nathan Grenier 40250986
* For COMP 248 Section T – Fall 2022
* November 17, 2022 
*  
* Purpose: Driver code for HouseholdBudgets.
* The driver has a few static methods for interacting with the user: 
* - showOptions(): Prints the available commands to the console
* - promptUser(): Prompts the user for a code. Validates the code. Returns the code (int)
* - selectBudget(): Prompts the user for an index corresponding to the HouseholdBudget they want to select. 
*  					Validates the index. Returns the index (int).
* - selectExpense(): Prompts user for index of Expense they want to modify. 
* 					 Validate the index. Returns the index (int).
* 
* The driver has boilerplate code for generating funds, expenses, and budgets.
* 
* The Driver has 10 different commands whose codes correspond to the numbers below:
* 1. Displays fund and expenses of every HouseholdBudget
* 2. Displays the fund and expenses of a specific HousholdBudget
* 3. Displays the pairs of HouseholdBudgets with the same total fund value ($). No Duplicates
* 4. Displays the pairs of HouseholdBudgets with the same fund distribution. No Duplicates
* 5. Displays all HouseholdBudgets with the same total fund values and number of expenses. No duplicates
* 6. Add user specified expense to an existing HouseholdBudget
* 7. Remove a specific expense (at a certain index) from a specified HouseholdBudget
* 8. Update the due date of an expense in a specified HouseholdBudget
* 9. Add specified fund types to a HouseholdBudget's fund
* 0. Terminates the program
*/

import java.util.Scanner;

public class BudgetDemo {
	
	// Returns true if the reference of the array budgets is not equal to null
	private static boolean budgetExists(HouseholdBudget budgetList[]) {
		if (budgetList != null) {
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
	
	// Prompts the user for an index corresponding to the HouseholdBudget they want to select. Returns the index (int)
	private static int selectBudget(HouseholdBudget[] list, String prompt) {
		Scanner in = new Scanner(System.in);
		int index = -1;		// -1 is the sentinel value
		
		// Edge case. If HouseholdBudget[] array is null
		if (list == null) {
			System.out.println("There are no HouseholdBudgets");
			return -1;
		}
		
		// Prompt user
		System.out.print(prompt);
		// Display available indexes to choose from
		System.out.printf(" (Enter number from 0 to %d): ", (list.length - 1));
		
		// Validate user input
		if (in.hasNextInt()) {
			index = in.nextInt();
			
			// The inputed code is not between 0 and the length of the array list -1
			if (!(index >= 0 && index < list.length)) {
				System.out.printf("Index must be between 0 and %d. Try Again.", (list.length - 1));
				// User entered an invalid code, re-prompt them
				index = selectBudget(list, "");		// Pass empty string as user does not need to see the prompt message again
			}
		
		} else {
			System.out.printf("Input must be an integer between 0 and %d. Try Again.", (list.length - 1));
			// User entered an invalid code (not of type int), re-prompt them
			index = selectBudget(list, "");		// Pass empty string as user does not need to see the prompt message again
		}
		return index;
	}
	
	// Prompts user for index of Expense they want to modify. Returns index
	private static int selectExpense(HouseholdBudget budget, String prompt) {
		Scanner in = new Scanner(System.in);
		int index = -1;		// -1 is the sentinel value
		
		// Edge case. If Expense[] array is null
		if (budget.expenseCount() == 0) {
			System.out.println("Sorry that HouseholdBudget has no expenses\n");
			return -1;
		}
		
		// Prompt user
		System.out.print(prompt);
		// Display available indexes to choose from
		System.out.printf(" (Enter number from 0 to %d): ", (budget.expenseCount() - 1));
		
		// Validate user input
		if (in.hasNextInt()) {
			index = in.nextInt();
			
			// The inputed code is not between 0 and the length of the expense array -1
			if (!(index >= 0 && index < budget.expenseCount())) {
				System.out.printf("Index must be between 0 and %d. Try Again.", (budget.expenseCount() - 1));
				// User entered an invalid code, re-prompt them
				index = selectExpense(budget, "");	// Pass empty string as user does not need to see the prompt message again
			}
		} else {
			System.out.printf("Input must be an integer between 0 and %d. Try Again.", (budget.expenseCount() - 1));
			// User entered an invalid code (not of type int), re-prompt them
			index = selectExpense(budget, "");	// Pass empty string as user does not need to see the prompt message again
		}
		return index;
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
		HouseholdBudget budget0 = new HouseholdBudget(fund1, expenses1);	// Identical to budget1
		HouseholdBudget budget1 = new HouseholdBudget(fund1, expenses1);	// Identical to budget0
		
		HouseholdBudget budget2 = new HouseholdBudget(sameTotalAs1, expenses2);	// Same total fund value of budget0 and budget1, 3 expenses
		
		HouseholdBudget budget3 = new HouseholdBudget(fund2,none);	// Same fund and expense count as budget4
		HouseholdBudget budget4 = new HouseholdBudget(fund2,none);	// Same fund and expense count as budget3
		
		// --Main-- //
		// Variables
		int code;			// Code that determines action to take
		int budgetIndex;	// Index of specific budget
		int expenseIndex;	// Index of specific expense
		HouseholdBudget budgetList[] = {budget0, budget1, budget2, budget3, budget4};	// Array of HouseholdBudgets
		
		String type;		// Type of expense
		double amount;		// Amount ($) of expense
		String name;		// Name of expense
		String dueDate;		// Due date of expense
		
		int loonies;		// Number of loonies
		int toonies;		// Number of toonies
		int bill_5;			// Number of bill_5
		int bill_10;		// Number of bill_10
		int bill_20;		// Number of bill_20
		
		Scanner in = new Scanner(System.in);	// Initialize a scanner
		
		// Welcome User
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n"
						 + "\n"
						 + "Welcome to COMP248 Geek's HouseholdBudget_2022 Application\n"
						 + "\n"
						 + "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		do {
			showOptions();			// Prints the option list to the console
			code = promptUser();	// Prompt the user to enter a code
			
			
			// Evaluate the code that was inputed
			switch (code) {
				
				// ---Display fund and expenses of every HouseholdBudget---
				case 1:
					// Check to see if there are any budgets
					if (budgetExists(budgetList)) {
						System.out.println("Content of each HouseholdBudget:\n"
										 + "--------------------");
						
						// Display HouseholdBudgets
						for (int i=0; i<budgetList.length; i++) {
							System.out.println("HouseholdBudget #"+ i +":");
							System.out.println(budgetList[i].toString() + "\n");
						}	
					} else {
						System.out.println("No budgets exist\n");
					}
					
					break;

				// ---Display the fund and expenses of a specific HousholdBudget---
				case 2:
					// Prompt user to choose a specific budget
					budgetIndex = selectBudget(budgetList, "Which HouseholdBudget do you want to see the possessions of?");
					
					// Display budget
					System.out.println(budgetList[budgetIndex].toString() + "\n");
					break;
					
					
				// ---Displays the pairs of HouseholdBudgets with the same total fund value ($). No Duplicates---
				case 3:
					System.out.println("List of HouseholdBudgets with the same total fund:\n");
					
					/* Compare budgets to find the pairs. We only need to compare the permutations
					 * of the budgetList because we don't want any duplicates.
					 */
					
					// Loop over every budget in the list except for the last one.
					for (int i=0; i<budgetList.length - 1; i++) {
						// Loop over all other budgets starting from the current budget (i) + 1
						for (int j=i+1; j<budgetList.length; j++) {
							// Compare the fund values
							if (HouseholdBudget.equalFunds(budgetList[i], budgetList[j])) {
								System.out.printf("\tHouseholdBudget %d and %d both have %d$\n", i, j, budgetList[i].totalFundValue());
							}							
						}
					}
					System.out.println();
					break;
				
					
				// ---Displays the pairs of HouseholdBudgets with the same fund distribution. No Duplicates---
				case 4:
					System.out.println("List of HouseholdBudgets with the same Fund:\n");
					
					/* Compare budgets to find the pairs. We only need to compare the permutations
					 * of the budgetList because we don't want any duplicates.
					 */
					
					// Loop over every budget in the list except for the last one.
					for (int i=0; i<budgetList.length - 1; i++) {
						// Loop over all other budgets starting from the current budget (i) + 1
						for (int j=i+1; j<budgetList.length; j++) {
							// Compare the fund denominations
							if (HouseholdBudget.equalFundType(budgetList[i], budgetList[j])) {
								System.out.printf("\tHouseholdBudget %d and %d both have %s\n", i, j, budgetList[i].getFund());
							}							
						}
					}
					System.out.println();
					break;
					
					
				// ---Displays all HouseholdBudgets with the same total fund values and number of expenses. No duplicates---
				case 5:
					System.out.println("List of HouseholdBudgets with the same amount of money and same number of expenses:\n");
					
					/* Compare budgets to find the pairs. We only need to compare the permutations
					 * of the budgetList because we don't want any duplicates.
					 */
					
					// Loop over every budget in the list except for the last one.
					for (int i=0; i<budgetList.length - 1; i++) {
						// Loop over all other budgets starting from the current budget (i) + 1
						for (int j=i+1; j<budgetList.length; j++) {
							// Compare the fund values and number of expenses
							if (HouseholdBudget.equals(budgetList[i], budgetList[j])) {
								System.out.printf("\tHouseholdBudget %d and %d\n", i, j);
							}							
						}
					}
					System.out.println();
					break;
				
					
				// ---Add user specified expense to an existing HouseholdBudget---
				case 6:
					// Prompt user for budget index
					budgetIndex = selectBudget(budgetList, "Which HouseholdBudget do you want to add an Expense to?");
					
					// --Prompt user for expense data-- //
					System.out.println("Please enter the following information so that we may complete the expense:");

					
					// Expense type
					System.out.print(" --> Type of expense (Bill, Purchase, etc...): ");
					type = in.nextLine();
					// Expense amount
					System.out.print(" --> Amount of the expense: ");
					amount = in.nextDouble();
					in.nextLine();	// Clear scanner. After nextDouble(), a space character is left in the scanner. We need to remove it
					// Expense name
					System.out.print(" --> Name of the buisness: ");
					name = in.nextLine();
					// Expense due date
					System.out.print(" --> Payment due day and month (seperated by a /): ");
					dueDate = in.nextLine();
					
					// Create new expense
					Expense newExpense = new Expense(type, amount, name, dueDate);
					
					// Add expense to selected budget
					budgetList[budgetIndex].addExpense(newExpense);
					
					// Display number of expenses in selected budget
					System.out.printf("You now have %d expense(s)\n\n", budgetList[budgetIndex].expenseCount());
					break;
					
					
				// ---Remove a specific expense (at a certain index) from a specified HouseholdBudget---
				case 7:
					// Prompt user for budget index
					budgetIndex = selectBudget(budgetList, "Which HouseholdBudget do you want to remove an expense from?");
					
					// Prompt user for expense index
					expenseIndex = selectExpense(budgetList[budgetIndex], "Select index of expense to remove");
					
					// Remove expense
					if (expenseIndex != -1) {	// -1 is the sentinel value. If it is -1, there are no expenses in the budget
						budgetList[budgetIndex].removeExpense(expenseIndex);
						System.out.println("Expense was removed successfully\n");
					}
					break;
				
					
				// ---Update the due date of an expense in a specified HouseholdBudget---
				case 8:
					// Prompt user for budget index
					budgetIndex = selectBudget(budgetList, "Which HouseholdBudget do you want to update an expense from?");
					
					// Prompt user for expense index
					expenseIndex = selectExpense(budgetList[budgetIndex], "Which expense do you want to update?");
					
					// Verify if there are any expenses in the budget
					if (expenseIndex != -1) {	// -1 is the sentinel value. If it is -1, there are no expenses in the budget
						// Prompt user for new due date of expense
						System.out.print(" --> Enter new payment due day and month (seperated by a /): ");
						dueDate = in.nextLine();
						
						// Update due date
						budgetList[budgetIndex].updateDueDate(expenseIndex, dueDate);
						System.out.println("Due Date updated\n");						
					}
					break;
					
					
				// ---Add specified fund types to a HouseholdBudget's fund---
				case 9:
					// Prompt user for budget index
					budgetIndex = selectBudget(budgetList, "Which HouseholdBudget do you want to add Fund to?");
					
					// Prompt user for funds to add
					System.out.println("How many loonies, toonies, 5$, 10$, 20$ bills do you want to add?");
					System.out.print("Enter 5 numbers seperated by a space: ");
					
					// Assign values
					loonies = in.nextInt();
					toonies = in.nextInt();
					bill_5 = in.nextInt();
					bill_10 = in.nextInt();
					bill_20 = in.nextInt();
					
					// Add funds to budget
					budgetList[budgetIndex].addFund(loonies, toonies, bill_5, bill_10, bill_20);
					
					// Display updated total fund value
					System.out.printf("You now have %d$\n\n", budgetList[budgetIndex].totalFundValue());
					break;
					
					
				// ---Terminate Program---
				case 0:
					// Display termination message
					System.out.println("Thank you for using COMP248 Geek's HouseholdBudget application!");
					break;
					
				default:
					break;
			
			}
		
		} while (code !=0);
	}
}
