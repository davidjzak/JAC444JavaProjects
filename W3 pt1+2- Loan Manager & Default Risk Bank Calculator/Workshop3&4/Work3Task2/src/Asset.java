
import java.util.GregorianCalendar;

public class Asset {

	


		
		private static double amount; 
		private static int loanerId;
		private static int loaneeId;
		GregorianCalendar dateCreated;
		private static double interestRate;
		
		public Asset( int loaner, int loanee,  double interestPercent){
			dateCreated = new GregorianCalendar();
			loanerId = loaner;
			loaneeId = loanee;
			interestRate = interestPercent;
		}
		
		
		public Asset( int loaner, int loanee,  double interestPercent, GregorianCalendar date){
			dateCreated = date;
			loanerId = loaner;
			loaneeId = loanee;
			interestRate = interestPercent;
		}
		
		

	

	
	
}
