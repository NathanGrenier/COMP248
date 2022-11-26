/*
* Assignment 4
* Written by: Nathan Grenier 40250986
* For COMP 248 Section T – Fall 2022
* November 17, 2022 
*  
* Purpose: The Expense class creates an object for a specific expense.
* It has attributes for:
* - The type of expense
* - The amount in dollars of the expense
* - The company name of the expense
* - The due date of the expense
* 
* It contains 3 different constructors:
* 1. Default Constructor: Initializes all attributes to 0 or and empty string
* 2. 4 Parameter Constructor: Initializes the expense type, name, amount and due date based on user input upon the 
* 	 creation of a new object with the new keyword. If the due date values are invalid, they are assigned the value of 0.
* 3. Copy Constructor: Initializes a new Expense object with the same attribute values as the expense object that was passed to the constructor as a parameter.
* 
* It also contains getter methods to retrieve object's private attributes as well as setter methods to set the values of dueDate and dueMonth.
* Along side these are other methods:
* - toString(): Returns a string containing formated information about the expense. Extra formatting for dueDate and dueMonth. 
* - equals(): Returns true if the attribute values of 2 expense objects are the same.
*
* Note: The dueDate array has the following format: dueDate = {dueDay, dueMonth}
*/

public class Expense {
	// Private Variables
	private String type;
	private double amount;
	private String name;
	private int dueDay;
	private int dueMonth;
	
	// Default Constructor
	public Expense() {
		this.type = "";
		this.amount = 0;
		this.name = "";
		this.dueDay = 0;
		this.dueMonth = 0;
	}
	
	// 4 Parameter Constructor
	public Expense(String type, double amount, String name, String dueDate) {
		this.type = type;
		this.amount = amount;
		this.name = name; 
		// If dueDay is not between 1 and 31, assign it to 0
		if (Integer.parseInt(dueDate.split("/")[0]) < 1 || Integer.parseInt(dueDate.split("/")[0]) > 31) {	// DueDate will have the format: "day/month"
			this.dueDay = 0;
		} else {
			this.dueDay = Integer.parseInt(dueDate.split("/")[0]);
		}
		// If dueMonth is not between 1 and 12, assign it to 0
		if (Integer.parseInt(dueDate.split("/")[1]) < 1 || Integer.parseInt(dueDate.split("/")[1]) > 12) {
			this.dueMonth = 0;
		} else {
			this.dueMonth = Integer.parseInt(dueDate.split("/")[1]);
		}
	}
	
	// Copy constructor
	public Expense(Expense obj) {
		this.type = obj.type;
		this.amount = obj.amount;
		this.name = obj.name;
		this.dueDay = obj.dueDay;
		this.dueMonth = obj.dueMonth;
	}
	
	// -----Methods----- //
	// Returns a string of the expense data.
	public String toString() {		
		// Format dueDay
		String strDueDay;
		if (this.dueDay < 10) {
			strDueDay = "0" + this.dueDay;
		} else {
			strDueDay = Integer.toString(this.dueDay);
		}
		
		// Format dueMonth
		String strDueMonth;
		if (this.dueMonth < 10) {
			strDueMonth = "0" + this.dueMonth;
		} else {
			strDueMonth = Integer.toString(this.dueMonth);
		}
		
		return this.type + " - $" + this.amount + " - " + this.name + " - " + strDueDay + "/" + strDueMonth;
	}
	
	// Returns true if two objects of type expense are identical (i.e same attributes)
	public static boolean equals(Expense obj1, Expense obj2) {
		if (obj1.type == obj2.type
			&& obj1.amount == obj2.amount
			&& obj1.name == obj2.name
			&& obj1.dueDay == obj2.dueDay
			&& obj1.dueMonth == obj2.dueMonth) 
		{
			return true;
		}
		
		return false;
	}
	
	// Getters
	public String getType() {
		return this.type;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getDueDay() {
		return this.dueDay;
	}
	
	public int getDueMonth() {
		return this.dueMonth;
	}
	
	// Setters
	public void setDueDay(int dueDay) {
		if (dueDay < 1 || dueDay > 31) {
			this.dueDay = 0;			
		} else {
			this.dueDay = dueDay;	
		}
	}
	
	public void setDueMonth(int dueMonth) {
		if (dueMonth < 1 || dueMonth > 12) {
			this.dueMonth = 0;			
		} else {
			this.dueMonth = dueMonth;	
		}
	}
	
}
