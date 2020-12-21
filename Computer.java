package taxescomputer;

import java.util.Scanner;

public class Computer {
	
	static Scanner scan = new Scanner(System.in);
	
	private double income;
	private boolean marriage;
	private boolean test;
	private String marriagetest;
	private boolean marriageloop = false;

	
	//taxable income thresholds
	private final double LOWEST_INCOME = 0;
	
	private final double SINGLE_MEDIUM = 8000;
	private final double SINGLE_HIGHEST = 32000;
	
	private final double MARRIED_MEDIUM = 16000;
	private final double MARRIED_HIGHEST = 64000;
	
	
	Computer()
	{
		
	}
	
	
	public void TaxReturn()
	{
		//not sure if income will include doubles
		System.out.println("Enter Your Taxable Income (Double Values are Allowed): ");
		test = scan.hasNextDouble();
		if(test)
		{
			income = scan.nextDouble();
		}
		while(!test)
		{
			System.out.println("Error: Not a number");
			System.out.println("Please Re-enter: ");
			scan.nextLine();
			test = scan.hasNextDouble();
			if(test)
			{
				income = scan.nextDouble();
			}
		}
		System.out.println("Please Enter Your Marriage Status: ");
		System.out.println("M for Married");
		System.out.println("S for Single");
		scan.nextLine();
		marriagetest = scan.next();
		while(!marriageloop)
		{
			if(marriagetest.equals("M"))
			{
				marriage = true;
				marriageloop = true;
			}
			else if(marriagetest.equals("S"))
			{
				marriage = false;
				marriageloop = true;
			}
			else 
			{
				marriageloop = false;
				System.out.println("Error: Incorrect Input");
				System.out.println("Please enter Either \"M\" or \"S\" ");
				scan.nextLine();
				marriagetest = scan.next();
			}

		}
		if(!marriage)
		{
			if(income > LOWEST_INCOME && income < SINGLE_MEDIUM)
			{
				System.out.println("You owe " + 0.10 * income);
			}
			else if(income > SINGLE_MEDIUM && income < SINGLE_HIGHEST)
			{
				System.out.println("You owe " + (800 + 0.15 * (income - SINGLE_MEDIUM)));
			}
			else if(income > SINGLE_HIGHEST)
			{
				System.out.println("You owe " + (4400 + 0.25 * (income - SINGLE_HIGHEST)));
			}
		}
		else if(marriage)
		{
			if(income > LOWEST_INCOME && income < MARRIED_MEDIUM)
			{
				System.out.println("You owe " + 0.10 * income);
			}
			else if(income > MARRIED_MEDIUM && income < MARRIED_HIGHEST)
			{
				System.out.println("You owe " + (1600 + 0.15 * (income - MARRIED_MEDIUM)));
			}
			else if(income > MARRIED_HIGHEST)
			{
				System.out.println("You owe " + (8800 + 0.25 * (income - MARRIED_HIGHEST)));
			}
		}
		
	}

}
