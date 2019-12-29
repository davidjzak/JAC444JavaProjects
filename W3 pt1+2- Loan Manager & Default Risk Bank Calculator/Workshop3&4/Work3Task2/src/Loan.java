import java.util.GregorianCalendar;

public class Loan {
	
	private static double loanBalance; 
	private static int loanerId;
	private static int loaneeId;
	GregorianCalendar dateCreated;
	private static double interestRate;
	
	public Loan( int loaner, int loanee, double lAmount,  double interestPercent){
		loanBalance = lAmount;
		dateCreated = new GregorianCalendar();
		loanerId = loaner;
		loaneeId = loanee;
		interestRate = interestPercent;
	}
	
	
	public Loan( int loaner, int loanee, double lAmount,  double interestPercent, GregorianCalendar date){
		loanBalance = lAmount;
		dateCreated = date;
		loanerId = loaner;
		loaneeId = loanee;
		interestRate = interestPercent;
	}
	
	
	public double getLoanBalance() {
		
		return loanBalance;
	}
	
	public int getLoaneeId() {
		return loaneeId;
	}
	

}
