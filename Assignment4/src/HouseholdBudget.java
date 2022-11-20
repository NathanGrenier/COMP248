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
		// -----Set fund----- //
		this.fund = new Fund(fund.getLoonies(),
							 fund.getToonies(), 
							 fund.getBill_5(), 
							 fund.getBill_10(), 
							 fund.getBill_20());
		
		// -----Set expenses----- //
		// If the parameter array expenses is not empty
		if (expenses != null) {
			// Instantiate this.expenses to an Expense array with the same length as the parameter expenses[]
			this.expenses = new Expense[expenses.length];
			// Instantiate a default Expense object for every element in this.expenses
			for (int i=0; i<this.expenses.length; i++) {
				this.expenses[i] = new Expense(expenses[i].getType(),
											   expenses[i].getAmount(),
											   expenses[i].getName(),
											   String.valueOf(expenses[i].getDueDay()) + "/" + String.valueOf(expenses[i].getDueMonth())
											   );
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
	
	// TODO next func
	
	
	
	
	
	// Getters
	public Fund getFund() {
		return this.fund;
	}
	
	public Expense[] getExpenses() {
		return this.expenses;
				//Arrays.toString(this.expenses);
	}
	
}
