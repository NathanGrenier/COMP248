import java.util.Arrays;

/*
* Assignment 4
* Written by: Nathan Grenier 40250986
* For COMP 248 Section T – Fall 2022
* November 17, 2022 
*  
* Purpose:	TODO: Remove import java.util.Arrays
*/

public class HouseholdBudget {
	// Private Variables
	private Fund fund;			// Singular Fund object
	private Expense[] expenses;	// Array of type Expenses
	
	// Default Constructor
	public HouseholdBudget () {
		this.fund = new Fund();
		this.expenses = null;
	}
	
	// 2 Parameter Constructor
	public HouseholdBudget (Fund fund, Expense expenses[]) {
		// --Set fund-- //
		this.fund = new Fund(fund);		// Uses copy constructor of class Fund
		
		// --Set expenses-- //
		// If the parameter array expenses is not empty
		if (expenses != null) {
			// Instantiate this.expenses to an Expense array with the same length as the parameter expenses[]
			this.expenses = new Expense[expenses.length];
			// Instantiate an Expense object for every element in this.expenses
			for (int i=0; i<this.expenses.length; i++) {
				this.expenses[i] = new Expense(expenses[i]);	// Uses copy constructor of class Expense
			}		
		} else {
			// There are no expenses, set the reference of expenses to null
			this.expenses = null;		// This line is not necessary but makes the code's intent explicit
		}
	}
	
	// -----Methods----- //
	// Returns true if the total value of 2 funds of the inputed HouseholdBudget objects are equal in value
	public static boolean equalFunds(HouseholdBudget obj1, HouseholdBudget obj2) {
		// If the sums of the funds of HouseholdBudget object 1 and 2 are equal
		if (obj1.fund.fundTotal() == obj2.fund.fundTotal()) {
			return true;
		}
		
		return false;
	}
	
	// Returns true if 2 HouseholdBudget objects have the same number of each fund type
	public static boolean equalFundType(HouseholdBudget obj1, HouseholdBudget obj2) {
		if (Fund.equals(obj1.fund, obj2.fund)) {
			return true;
		}
		
		return false;
	}
	
	// Returns the total value ($) of a HouseholdBudget object's fund
	public int totalFundValue() {
		return this.fund.fundTotal();
	}
	
	// Returns the number of expenses of a HouseholdBudget
	public int expenseCount() {
		// If this.expenses is equal to null, return 0 as there are no expenses
		if (this.expenses == null) {
			return 0;
		}
		
		// If there are values in this.expenses, return the length
		return this.expenses.length;
	}
	
	// Adds a new expense to the HouseholdBudget object. Returns the number of expenses.
	public int addExpense(Expense expense) {
		// --Add an expense-- //
		  
		// If the this.expenses array is != null, copy its values. Else, there is nothing to copy
		if (this.expenses != null) {
			/* Create a temp array called tempExpenses. 
			   The length of this array is 1 more than the existing expenses array. 
			   Will be used to add an element to expenses.*/
			Expense tempExpenses[] = new Expense[this.expenseCount() + 1];
			
			// Copy contents from this.expenses array to tempExpenses.
			// Loop over all existing Expenses in this.expenses
			for (int i=0; i<this.expenseCount(); i++) {
				// Copy values from current this.expense to tempExpenses at index i
				tempExpenses[i] = new Expense(this.expenses[i]);
				
				// Add the Expense argument expense to tempExpenses
				tempExpenses[tempExpenses.length - 1] = new Expense(expense);
				
			}
			// Copy tempExpress into this.expenses (element has been added)
			this.expenses = tempExpenses;
		
		} else {
			// this.expenses is null. Create an array of size 1 and add the Expense argument expense
			this.expenses = new Expense[1];
			this.expenses[0] = new Expense(expense);
		}
		
		// --Return the update expense count of the HouseholdObject-- //
		return this.expenseCount();
	} 
	
	// Removes an expense from the HouseholdBudget at the specified index. Returns true if the expense was successfully removed.
	public boolean removeExpense(int removeIndex) {
		// --Remove an expense-- //
		// Check to see if there are any expenses to remove and if the removeIndex is in range of this.expenses
		if (this.expenses != null && removeIndex < this.expenseCount()) {
			// Create a temp array called tempExpenses with 1 less element than this.expenses. 
			Expense tempExpenses[] = new Expense[this.expenseCount() - 1];
			
			System.out.println(this.expenseCount());
			// Copy elements from this.expenses to tempExpenses. Skip over the element with the specified index (it is to be deleted)
			for (int i=0,k=0; i<this.expenseCount(); i++) {
				System.out.println(i);
				if (i != removeIndex) {
					tempExpenses[k] = new Expense(this.expenses[i]);
					k++;	// Increment index of tempExpenses which has 1 less element than this.expenses
				}
			}
			// Copy tempExpenses into this.expenses (element at specified index has been removed)
			this.expenses = tempExpenses;
			
			// Check to see if there are any elements in this.expenses. If not, set the value of this.expenses to null
			if (this.expenseCount() == 0) {
				this.expenses = null;
			}
			
			// Return true as we have successfully deleted an element from expenses
			return true;
			
		} else {
			// There are no expenses to remove. Return false
			return false;
		}
	}
	
	// Updates the due day and month of a specified expense
	public void updateDueDate(int updateIndex, String dueDate) {
		// Check to see if the updateIndex is in range of this.expenses
		if (updateIndex < this.expenseCount()) {
			// dueDate format: {dueDay, dueMonth}
			this.expenses[updateIndex].setDueDay(Integer.parseInt(dueDate.split("/")[0]));
			this.expenses[updateIndex].setDueMonth(Integer.parseInt(dueDate.split("/")[1]));			
		}
	}
	
	// Adds a fund to the HouseholdBudget. Returns the new total value of the HouseholdBudget object's fund
	public int addFund(int newLoonies, int newToonies, int newBill_5, int newBill_10, int newBill_20) {
		// Add new funds to existing fund
		this.fund.setLoonies(this.fund.getLoonies() + newLoonies);
		this.fund.setToonies(this.fund.getToonies() + newToonies);
		this.fund.setBill_5(this.fund.getBill_5() + newBill_5);
		this.fund.setBill_10(this.fund.getBill_10() + newBill_10);
		this.fund.setBill_20(this.fund.getBill_20() + newBill_20);
		
		// Return new total value of the fund
		return this.totalFundValue();
	}
	
	// Returns true if the total value of fund and the number of expenses of two HouseholdBudget objects are equal
	public static boolean equal(HouseholdBudget obj1, HouseholdBudget obj2) {
		if (HouseholdBudget.equalFunds(obj1, obj2) && (obj1.expenseCount() == obj2.expenseCount())) {
			return true;
		}
		
		return false;
	}
	
	// TODO: Add toString() and fundBreakdown() methods. Add comments and test
	
	
	// Getters
	public Fund getFund() {
		return this.fund;
	}
	
	// NOT FINISHED
	public Expense[] getExpenses() {
		System.out.println(Arrays.toString(this.expenses));
		return this.expenses;
		
	}
	
}
