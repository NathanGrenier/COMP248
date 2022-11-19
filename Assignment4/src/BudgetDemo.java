/*
* Assignment 4
* Written by: Nathan Grenier 40250986
* For COMP 248 Section T – Fall 2022
* November 17, 2022 
*  
* Purpose:
*/

public class BudgetDemo {

	public static void main(String[] args) {
		Fund house1 = new Fund();
		Fund house2 = new Fund(1,2,3,4,5);
		Fund house3 = new Fund(house2);
		
		System.out.println(house1.toString());
		System.out.println(house2.toString());
		System.out.println(house3.toString());
		
		//house2.setBill_10(2);
		System.out.println(house2.getBill_10());
		System.out.println(Fund.equals(house2, house2));
		
	}

}
