import java.util.Scanner;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class TRmain {
	public static void main(String args[])
	{
		// This program will prompt the user for inital tuition, yearly tuition increase, the user's APR,
		// and the user's term. Then it will calculate the total cost of 4 years of college and tell the 
		// user how much each monthly payment will be.
		// Declaring variables for the finance calculations.
		double totalTuition = 0;
		double yearlyTuition = 0;
		boolean bool = true;
		double PMT;
		// Creating scanner objects and calling private variables
		TRmain t = new TRmain();
		Scanner input = new Scanner(System.in);
		System.out.print("What is your inital tuition?");
			double initialTuition = input.nextDouble();
			t.setInitialTuition(initialTuition);
		System.out.print("What will be your yearly increase in tuition?");
			double yearlyIncrease = input.nextDouble();
			t.setYearlyIncrease(yearlyIncrease);
		System.out.print("What is your APR?");
			double apr = input.nextDouble();
			t.setApr(apr);
		System.out.print("How many years will you take to pay off the loan?");
			double term = input.nextDouble();
			t.setTerm(term);
		// Using a for loop to calculate total tuition
		// Initializing the for loop to take the sum of each years adjusted tuition
		yearlyTuition = initialTuition;
		for (int i = 1; i < 5; i++)
		{
			totalTuition = totalTuition + yearlyTuition;
			yearlyTuition = yearlyTuition + (yearlyTuition*yearlyIncrease);
		}
		// Adjusting the term and apr variables to work with the FincanceLib.pmt method
		term = term * 12;
		apr = (apr / 12);
		PMT = FinanceLib.pmt(apr, term, totalTuition, 0, bool);
		System.out.printf("The total cost of the tuition will be $%6.2f \n", totalTuition);
		System.out.printf("Each monthly payment must be $%5.2f",-PMT);
		// Not sure why the - sign is needed but otherwise the PMT prints as a negative number.
		
		
			
			
		
			
		
	
	}
	
	// Declaring private variables and generating getters and setters
	private double initialTuition;
	private double yearlyIncrease;
	private double apr;
	private double term;
	
	
	public double getInitialTuition() {
		return initialTuition;
	}

	public void setInitialTuition(double initialTuition) {
		this.initialTuition = initialTuition;
	}

	public double getYearlyIncrease() {
		return yearlyIncrease;
	}

	public void setYearlyIncrease(double yearlyIncrease) {
		this.yearlyIncrease = yearlyIncrease;
	}

	public double getApr() {
		return apr;
	}

	public void setApr(double apr) {
		this.apr = apr;
	}

	public double getTerm() {
		return term;
	}

	public void setTerm(double term) {
		this.term = term;
	}
	


	

}
