/*
* Assignment 4
* Written by: Nathan Grenier 40250986
* For COMP 248 Section T – Fall 2022
* November 17, 2022 
*  
* Purpose: The Fund class manages the funds in a household object. 
* It has attributes for:
* - Count of fund types
* - Constant value of each fund type
* 
* It contains 3 different constructors.
* 1. Default Constructor: Initializes the amount of each fund type to 0.
* 2. 5 Parameter Constructor: Initializes the amount of each fund type based on user input upon the 
* 	 creation of a new object with the new keyword. 
* 3. Copy Constructor: Initializes a new object with fund values equal to the fund values of the object that was passed. 
* 
* It also contains getter and setter methods to retrieve and manipulate the object's private variables.
* Along side these are other methods:
* - addFund(): Adds specified funds to current object 
* - fundTotal(): Returns the total fund value as an int
* - toString(): Returns a string containing the number of each fund type
* - equals(): Return true is the count of fund types are equal between 2 objects
*/

public class Fund {
	// Private variables
	private int loonies;
	private int toonies;
	private int bill_5;
	private int bill_10;
	private int bill_20;
	
	// Static constants for the value of each money type
	public static final int LOONIES_VALUE = 1;
	public static final int TOONIES_VALUE = 2;
	public static final int BILL_5_VALUE = 5;
	public static final int BILL_10_VALUE = 10;
	public static final int BILL_20_VALUE = 20;
	
	// Default constructor
	public Fund() {
		this.loonies = 0;
		this.toonies = 0;
		this.bill_5 = 0;
		this.bill_10 = 0;
		this.bill_20 = 0;
	}
	
	// 5 Parameter constructor. Sets amount of currencies in household for current object
	public Fund(int loonies, int toonies, int bill_5, int bill_10, int bill_20) {
		this.loonies = loonies;
		this.toonies = toonies;
		this.bill_5 = bill_5;
		this.bill_10 = bill_10;
		this.bill_20 = bill_20;
	}
	
	// Copy constructor. Copies values from passed object to current instance of object
	public Fund(Fund fundObj) {
		this.loonies = fundObj.loonies;
		this.toonies = fundObj.toonies;
		this.bill_5 = fundObj.bill_5;
		this.bill_10 = fundObj.bill_10;
		this.bill_20 = fundObj.bill_20;
	}
	
	// Methods //
	// Adds specified money amount to each current fund money amounts
	public void addFund(int loonies, int toonies, int bill_5, int bill_10, int bill_20) {
		this.loonies += loonies;
		this.toonies += toonies;
		this.bill_5 += bill_5;
		this.bill_10 += bill_10;
		this.bill_20 += bill_20;
	}
	
	// Returns an integer corresponding to the total dollar value of funds in a household
	public int fundTotal() {
		int sum = (this.loonies * LOONIES_VALUE) + (this.toonies * TOONIES_VALUE) + (this.bill_5 * BILL_5_VALUE) + (this.bill_10 * BILL_10_VALUE) + (this.bill_20 * BILL_20_VALUE);
		return sum;
	}
	
	// Returns a string with the count of each fund type in the household
	public String toString() {
		return "(" + this.loonies + " x $" + LOONIES_VALUE +") + (" + this.toonies + " x $" + TOONIES_VALUE +") + (" + this.bill_5 + " x $" + BILL_5_VALUE +") + (" + this.bill_10 + " x $" + BILL_10_VALUE +") + (" + this.bill_20 + " x $" + BILL_20_VALUE +")";
	}
	
	// Returns true if 2 households have the same amount of each fund type
	public static boolean equals(Fund obj1, Fund obj2) {
		if (obj1.loonies == obj2.loonies 
			&& obj1.toonies == obj2.toonies
			&& obj1.bill_5 == obj2.bill_5
			&& obj1.bill_10 == obj2.bill_10
			&& obj1.bill_20 == obj2.bill_20) 
		{
			return true;
		}
		
		return false;
	}
	
	// Getters
	public int getLoonies() {
		return this.loonies;
	}
	
	public int getToonies() {
		return this.toonies;
	}
	
	public int getBill_5() {
		return this.bill_5;
	}
	
	public int getBill_10() {
		return this.bill_10;
	}
	
	public int getBill_20() {
		return this.bill_20;
	}
	
	// Setters
	public void setLoonies(int loonies) {
		this.loonies = loonies;
	}
	
	public void setToonies(int toonies) {
		this.toonies = toonies;
	}
	
	public void setBill_5(int bill_5) {
		this.bill_5 = bill_5;
	}
	
	public void setBill_10(int bill_10) {
		this.bill_10 = bill_10;
	}
	
	public void setBill_20(int bill_20) {
		this.bill_20 = bill_20;
	}
	
}
