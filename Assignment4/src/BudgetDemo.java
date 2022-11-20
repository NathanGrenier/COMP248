import java.util.Arrays;

/*
* Assignment 4
* Written by: Nathan Grenier 40250986
* For COMP 248 Section T – Fall 2022
* November 17, 2022 
*  
* Purpose: TODO: Remove import java.util.Arrays
*/

public class BudgetDemo {

	public static void main(String[] args) {
		
		Fund fund1 = new Fund();
		Fund fund2 = new Fund(1,2,3,4,5);
		Fund fund3 = new Fund(fund2);
		
		/*
		System.out.println(fund1.toString());
		System.out.println(fund2.toString());
		System.out.println(fund3.toString());
		
		//fund1.setBill_10(2);
		System.out.println(fund1.getBill_10());
		System.out.println(Fund.equals(fund1, fund1));
		*/
		
		Expense expense1 = new Expense();
		Expense expense2 = new Expense("Payment", 12.95, "Videotron", "12/05");
		Expense expense3 = new Expense(expense2);
		Expense expenses[] = null;
		
		/*
		System.out.println(expense1.toString());
		System.out.println(expense2.toString());
		System.out.println(expense3.toString());
		
		System.out.println(expense2.getDueDay());
		System.out.println(expense2.getDueMonth());
		
		System.out.println(Expense.equals(expense1, expense1));
		*/
		
		HouseholdBudget budget1 = new HouseholdBudget(fund2, expenses);
		HouseholdBudget budget2 = new HouseholdBudget(fund3, expenses);
		System.out.println(HouseholdBudget.equalFunds(budget1, budget2));

		
	}

}
