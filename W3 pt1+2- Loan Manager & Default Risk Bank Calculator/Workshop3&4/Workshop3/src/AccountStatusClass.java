import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountStatusClass {
	int id = 0;
	double balance = 0;
	int interestChoice;
	double annInterestChoice;
	int [] monthsLoan = {60, 48, 24, 12, 6};
	double [] annInterest = {.0495, .0395, .0295, .0195, .0099};
	boolean gameloop = true;
	
	boolean dataEntered = false;
	List<Account> accounts = new ArrayList<>();
	List<Integer> accountIds = new ArrayList<>();
;		

	
	public void getAccountInfo(){
		Scanner info = new Scanner(System.in);
		System.out.println("Hi Please, enter your account Info");

		dataEntered = false;
		while(dataEntered == false) {
			
		try{
		
		System.out.println("Enter a valid account Id: ");
		id = info.nextInt();
		dataEntered = true;
		  
		}catch( Exception err){
			dataEntered = false;
			
			System.out.println(err);
			System.out.println("Account Number Invalid please try again");
			info.next();
			}
		}
		
		dataEntered = false;
		
		//if list contains id display account info else continue creating new account
		if(accountIds.contains(id)) {
			
			// finds index where account is
			int index = accountIds.indexOf(id);
			// gets status of account
		    accounts.get(index).AccountStatus();
			
		}else {
			
			
			while(dataEntered == false) {
			try{
			
			System.out.println("Enter a valid balance: ");
			balance = info.nextDouble();
			dataEntered = true;
			  
			}catch( Exception err){
				dataEntered = false;
				
				System.out.println(err);
				System.out.println("[ Invalid please try again");
				info.next();
				}
			}// exit once gets valid
			dataEntered = false; // sets flag back to false
			
			
			
			// add interest rate
			while(dataEntered == false) {
				try{
				
				System.out.println("Please enter a valid selection for your interest rate and loan");
			 System.out.println("0: - 4.95% (5 Years)");
				 System.out.println("1: - 3.95% (4 Years)");
				 System.out.println("2: - 2.95% (2 years)");
				 System.out.println("3: - 1.95% (1 year)");
				 System.out.println("4: - 0.99%(6 months)");
				
				interestChoice = info.nextInt();
				
				if(interestChoice > 4 || interestChoice < 0) {
					throw new Exception("Invalid selection");
				}
				annInterestChoice = annInterest[interestChoice];
				dataEntered = true; 
				  
				}catch( Exception err){
					dataEntered = false;
					
					System.out.println(err);
					System.out.println(" Invalid please try again");
					info.next();
					}
				}// exit once gets valid selection
			dataEntered = false;
			
			Account newAccount = new Account(id, balance);
			newAccount.setAnnualInterestRate(annInterestChoice);
			newAccount.setLoanMonths(monthsLoan[interestChoice]);
			
			
			// add accounts to list for tracking purposes, can compare id with account list
			accounts.add(newAccount);
			accountIds.add(id);
			
			//calls menu for account
			// passes in index where id is stored , will be same index as where account is stored
			AccountSlection(accountIds.indexOf(id), id);
		
			
		}
		
		info.close();
		
		
	};
	
	public void AccountSlection(int id, int accId) {
		boolean stop = false;
		Scanner select = new Scanner(System.in);
		while(stop == false) {
		System.out.println("---------------------------------------------");
		System.out.println("Main Menu - Account Id " + accId );  
		System.out.println("---------------------------------------------" + '\n' + '\n');
		System.out.println("Enter a selection");
		System.out.println("---------------------------------------------");
		int selection = 0;
		
		System.out.println("1: Deposit");
		System.out.println("2: Withdrawal");
		System.out.println("3: Account status");
		System.out.println("4: How long to pay back loan");
		System.out.println("5: Borrow Money (loan)");
	
		
		while(dataEntered == false) {
			try{
			
			System.out.println("Enter a valid selection: ");
			selection = select.nextInt();
			dataEntered = true;
			if(selection > 5 || selection < 1) {
				throw new Exception("Invalid selection, try again");
			}
			}catch( Exception err){
				dataEntered = false;
				
				System.out.println(err);
				
				select.next();
				}
			}// exit once gets valid
			dataEntered = false; // sets flag back to false
			
			
			switch(selection) {
			case 1:
				double mon = 0;
				while(dataEntered == false) {
				try{
					
					System.out.println("Enter a deposit: ");
					mon = select.nextDouble();
					dataEntered = true;
					  
					}catch( Exception err){
						dataEntered = false;
						
						System.out.println(err);
						select.next();
					}
				}
				dataEntered = false;
				accounts.get(id).deposit(mon);
				
				System.out.println("money deposited");
				
				
				break;
				
			case 2: 
				
				double mon1 = 0;
				while(dataEntered == false) {
				try{
					
					System.out.println("Enter a withdrawal: ");
					mon = select.nextDouble();
					dataEntered = true;
					  
					}catch( Exception err){
						dataEntered = false;
						
						System.out.println(err);
						select.next();
					}
				}
				dataEntered = false;
				accounts.get(id).withdraw(mon1);
				System.out.println("money withdrawn");
				
				break;
				
				
			
			case 3:
				accounts.get(id).AccountStatus();
				break;
				
			case 4: 
				if(accounts.get(id).getLoan() > 0) {
				try {
			 int pay = accounts.get(id).monthsRemainingLoan();
				System.out.println("There are " + pay + " payments left you will be payed off by " +  LocalDate.now().plusMonths(pay));
				}catch(Exception err) {
					System.out.println(err);
				}}else {
					System.out.println("You don't currently owe any moeny");
				}
			break;
			
			case 5: 
				double amount  = 0;
				while(dataEntered == false) {
					try{
					
					System.out.println("Enter a loan amount, amount will be added to your existing loan plan: ");
					amount = select.nextDouble();
					dataEntered = true;
					  
					}catch( Exception err){
						dataEntered = false;
						System.out.println(err);
						select.next();
					}}
				dataEntered = false;
					accounts.get(id).setLoan(amount);
				break;	
				
			}
			
			
		
		
		System.out.println("Do you want to perform more actions? Enter 1 for exit, 2 to continue:  ");
		int choice = 2;
		while(dataEntered == false) {
		try {
		
		 choice = Helper.getInt();
		 dataEntered = true;
		 if (choice == 1 || choice == 2) {
			if(choice == 1) {
				stop = true;
			}
			
			if(choice == 2) {
				stop = false;
			}
			
		 }else {
				throw new Exception("Invalid selection try again");
		 }
			
		 
		}catch(Exception ex){
			System.out.println(ex);
		
		}		
		
		}
		dataEntered = false;

				
	}
select.close();
	
					
}
	
}
