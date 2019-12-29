import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manage {
	
	
	private static int numOfBanks;
	private  double limit;
	private  static List <Integer> unsafeBankIds = new ArrayList<Integer>();
	private  static List <Bank> banks = new ArrayList<Bank>();
	private static Scanner manage = new Scanner(System.in);
	private static int tempBankId = 0;
	private static double tempLoanAmount = 0;
	private Helper Helper = new Helper();
	//private static Helper helper = new Helper();
;	
	public void start() {
		
		System.out.println("Enter Number of Banks:");
		
		numOfBanks = Helper.getInt();
		
		System.out.println("Enter Asset Safety Limit (Banks under this limit are unsafe and cannot repay there loans:");
		
		limit = Helper.getDouble();
		
		
		displayBankNames();
		
		
		System.out.println("Enter Bank Details");
		System.out.println("-------------------------------");
		
		
		double tempbalance = 0;
		double tempBankLoans = 0;
		
		
		for(int i = 0; i < numOfBanks; i++) {
			
			System.out.println("For Bank Id " + i);
			System.out.println("Enter Balance: ");
			tempbalance = Helper.getDouble();
			
			banks.add(new Bank(i, tempbalance));
			
			
			
			System.out.println("Number of Loans: ");
			tempBankLoans = Helper.getInt();
			
			
			for(int k = 0; k < tempBankLoans; k++ ) {
				tempLoanAmount = 0;
				
				System.out.println("Loan " + k + " is to Bank with Id: ");
				
				
				//user inputs bank in range
				boolean dataEntered = false; // flag
				while(dataEntered == false) {
				try {
				tempBankId = Helper.getIntRange(0, numOfBanks);
				//checks for self loaning
				if (tempBankId == i) {
					throw new Exception("Cannot loan to self, please enter Id again: ");
				}
				dataEntered = true;
				}catch(Exception err){
					 dataEntered = false;
					System.out.println(err);
				}
				}
				
				System.out.println("Enter Amount Loaned to Bank " + tempBankId + ": ");
				tempLoanAmount = Helper.getDouble();
				
				banks.get(i).addLoan(tempBankId, tempLoanAmount);
			}
			
		
		}
		
		
		
		manage.close();
	}
	
	
	public boolean checkForUnsafe() {
		
		boolean unsafeExists = false;
		for(int i = 0; i < banks.size(); i++) {
			
			  
			double assets =  banks.get(i).getRealBalance();
			// if assets less than limits add to unsafe bank list
			if(assets < limit){
				
				if (!unsafeBankIds.contains(banks.get(i).getId())) {
				unsafeBankIds.add(banks.get(i).getId());
				banks.remove(i);
				}
				unsafeExists = true; // prevent going through unneeded loops if no unsafe loans
		    }
			
		}
		return unsafeExists;
	}
	
	
	public void manageUnsafeLoans() {
		
		boolean unsafeExists = checkForUnsafe();
		
		while(unsafeExists && banks.size() != 0){
		for (int i = 0;	i < banks.size(); i++) {
						banks.get(i).findUnsafeLoans(unsafeBankIds);
		
			unsafeExists = checkForUnsafe();
			
			
		}
		
		
		
	}
	}
	
	
	
	
		
		public  void displayBankNames(){
			
			System.out.println("Bank List");
			System.out.println("-------------------------------");
			
			for(int i = 0; i < numOfBanks; i++) {
				System.out.println( i + ". Bank Id: " +  i);
				
			}
			
			
		}
	
		
		public void displayResults(){
			
		Helper.printTitle("Safe Banks");
			
	// safe code revise later
		
		  for(int j = 0; j < banks.size(); j++){ if
		  (!unsafeBankIds.contains(banks.get(j).getId())){ System.out.println(
		  "Bank Id " + j + " total assets " + banks.get(j).getRealBalance()); }
		  System.out.println(); }
		 
			
			Helper.printTitle("UnSafe Banks");
		
			for(int i = 0; i < unsafeBankIds.size(); i++) {
			/*
			 * if (unsafeBankIds.contains(banks.get(i).getId())) { System.out.println(
			 * "Bank Id " + i + "total assets " + banks.get(i).getRealBalance()); }
			 */
				System.out.println("Bank " + unsafeBankIds.get(i));
			}
		
		
	

		}
}
