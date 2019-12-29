import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Account {
 // declare starting variables
	private static int id;
	//balance is loan amount
	private static double balance;
	private static double annualInterestRate;
	private static Date dateCreated;
	private static int paymentsMade;
	private static double loanAmount;
	private static int loanMonths;
	
	
	public Account(){
		id = 0;
		balance = 0;
		annualInterestRate = 0;
		loanAmount = 1000;
	}
	
	public Account( int Nid, double Nbalance) {
		id = Nid;
		balance = Nbalance;
		paymentsMade = 0;
		
	}
	
	
	public Date getDateCreated(){
		dateCreated = new Date();
		
		return dateCreated;
	}
	
	public GregorianCalendar getdateCalendar(){
		GregorianCalendar today = new GregorianCalendar();
		return today;
	}
	
	
	
	// getters
	public int getId(){
		return id;
	}
	
	public double getLoan(){
		return loanAmount;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getInterestRate(){
		return annualInterestRate;
	}
	
	public double getMonthlyInterestRate(){
		return annualInterestRate / 12;
	}
	
	public double getMonthlyInterest(){
		return balance * getMonthlyInterestRate();
	}

	
	// edit money
	public void withdraw(double withdrawal){
		balance -= withdrawal;
	}
	
	
	public void deposit(double money) {
		balance += money;
		paymentsMade += 1;
	}
	
	
	// setters
	
	public void setAnnualInterestRate(double rate ) {
		annualInterestRate = rate;
	}
	
	// adds new loan to any existing loan plan
	public void setLoan(double loan) {
		loanAmount += loan;
	}
	
	public void setLoanMonths(int months){
		loanMonths = months;
	}
	
	
	//subtracts current date from creation date of loan settings to get time left on loan in months
	public int monthsRemainingLoan() {
		GregorianCalendar today = new GregorianCalendar();
		GregorianCalendar startDate =  getdateCalendar();
	
		 int monthsDiff = today.get(Calendar.MONTH) 
                 - startDate.get(Calendar.MONTH);

		 //return months remaining on the loan 
		 int monthsRemaining = loanMonths - monthsDiff;
	   
		 return monthsRemaining;

	}
	
	
	public double averagePayment(){
	
		double principal = loanAmount;
        double months = (double) monthsRemainingLoan();
        System.out.println("months are " + months);
		double interest = getMonthlyInterestRate();
		
		for(int i = 0; i < months; i++) {
			principal += (principal*interest);
		}
		
		if(months != 0) {
		
		return principal / months;
		}else {
			return 0;
		}
		
		
	}
	
	
	
	
	public void AccountStatus() {
		// cast decimal to 2 digits
		DecimalFormat df = new DecimalFormat("0.00");
		//print output
		System.out.println("Account Info");
		System.out.println("--------------------------------");
		System.out.println("Account created on " + dateCreated);
		System.out.println("Loan balance is: " + loanAmount);
		System.out.println("Balance is : " + balance);
		System.out.println("Payments made: " + paymentsMade);
		System.out.println("Payments due on 15th of month, average payment is  " + df.format(averagePayment()) );
		System.out.println("There are " +  monthsRemainingLoan() + " payments left. Loan will be paid on " + LocalDate.now().plusMonths(monthsRemainingLoan()));
		
	}
	
	
	
}
