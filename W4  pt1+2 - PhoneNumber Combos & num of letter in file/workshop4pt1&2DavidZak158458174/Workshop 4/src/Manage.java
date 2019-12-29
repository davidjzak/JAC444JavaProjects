import java.util.Scanner;

public class Manage {


	char[] tempnum = new char [7];
	
	public  void start(){
		Helper.printTitle("Please enter 7 digit phone number (Do not include area code)");
		tempnum = this.checkValidPhoneNumber(2000000, 9999999);
		try {
			PhoneNumber selectNumber = new PhoneNumber(tempnum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public char[] checkValidPhoneNumber(int min, int max){
		  Scanner manage = new Scanner(System.in);
           boolean dataEntered = false;
           char [] numChar = new char [7];
		
		int num = 0;
		while(dataEntered == false) {
			
			try {
				
			 num = manage.nextInt();
			if(num < min || num > max ) {
				throw new Exception("Input must be 7 numbers, with no 1s or 0s");
			}
			
			 numChar = ("" + num).toCharArray();
			for(int i = 0; i < numChar.length; i++) {
				if(numChar[i] == 0 || numChar[i] == 1) {
					throw new Exception("Phone number must not include 0 or 1");
				}
				
			}
			dataEntered = true;
			  
			}catch( Exception err ){
				dataEntered = false;
				
				System.out.println(err);
				System.out.println("Invalid entry try again");
				
			}
			manage.nextLine();
			}
		
        manage.close();
        System.out.println(numChar);
		return numChar;
	}
	
	
}
