import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bank {

	private int id;
	private double balance;

	private List <Loan> loans = new ArrayList<Loan>();
	//not used but added for easy expansion of program to reclaim and track defaulted loans
  private List <Loan> unsafe = new ArrayList<Loan>();

	public Bank() {
		id = 0;
		balance = 0;
	}
	
	
	public Bank(int nId, double nBalance) {
		id = nId;
		balance = nBalance;
	}
	
	public int getId(){
		return id;
	}
	
	public double getBalance(){
		return balance;
	}
	
	// balance including "safe" loans
	public double getRealBalance(){
		
		double  tBalance = balance;
		double realBalance = 0;
		//i starts at 1 because size starts at 1, loops through and gets all balances in valid loans array
		for(int i = 0; i < loans.size(); i++) {
		realBalance +=  loans.get(i).getLoanBalance();	

		}	
		
		return realBalance + tBalance;
	}
	
	public void addLoan(int loaneeId, double loanAmount){
	
		 
		loans.add(new Loan(id, loaneeId, loanAmount, 0));	
	}
	
	// not needed but allows for easy upgrades to program functionality
	/*
	 * public void addToUnsafeLoans(Loan defaulted){ unsafe.add(defaulted); }
	 */	
	public void findUnsafeLoans(List<Integer> unsafeId){
		int loanSize = loans.size(); 
		int unsafeSize = unsafeId.size();
		
		for(int i = 0; i < loanSize; i++) {
			
			for(int j = 0; j < unsafeSize; j++) {
			
				//if unsafe loan is found remove it from the loan list and add it to unsafe loan list
				if(unsafeId.get(j) == loans.get(i).getLoaneeId()){
				loans.remove(i);
				}
				
			}
			
		}	
	}
	
	
	
}
