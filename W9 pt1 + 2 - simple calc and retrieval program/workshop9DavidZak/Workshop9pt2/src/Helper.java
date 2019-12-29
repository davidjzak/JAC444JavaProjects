
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Helper {
	
	private static  List <String> yesList = Arrays.asList("yes", "Yes", "YES", "y", "Y", "Ye", "YE" );
	private static  List <String> noList = Arrays.asList("n", "N", "no", "NO", "No", "nO");
	
	private static  Scanner manage = new Scanner(System.in);
	
	//overrided get double with error message
	public static double getDouble(String catchMessage){
		
		boolean dataEntered = false;
		double doubleData = 0;
		while(dataEntered == false) {
			
		try {
		
		dataEntered = true;
		doubleData = manage.nextDouble();
		  
		}catch( Exception err){
			dataEntered = false;
			
			System.out.println(err);
			System.out.println(catchMessage);
			manage.next();
			}
		}
		
		return doubleData;
		
	}
	
	
	
public static double getDouble(){
		
		boolean dataEntered = false;
		double doubleData = 0;
		while(dataEntered == false) {
			
		try {
		doubleData = manage.nextDouble();
		
		dataEntered = true;
		  
		}catch( Exception err){
			dataEntered = false;
			
			System.out.println(err);
			System.out.println("Invalid entry please try again");
			manage.next();
			}
		}
		
		return doubleData;
		
	}
	
	
	
	public static int getInt(){
		
		boolean dataEntered = false;
		int intData = 0;
		while(dataEntered == false) {
			
		try {
		
		dataEntered = true;
		intData = manage.nextInt();
		
		  
		}catch( Exception err ){
			dataEntered = false;
			
			System.out.println(err);
			System.out.println("Invalid entry please try again");
			manage.next();
			}
		}
		
		return intData;
		
	}
	
	
	public static int getInt(String catchMessage){
		
		boolean dataEntered = false;
		int intData = 0;
		while(dataEntered == false) {
			
		try {
		intData = manage.nextInt();
		dataEntered = true;
		  
		}catch( Exception err ){
			dataEntered = false;
			
			System.out.println(err);
			System.out.println(catchMessage);
			manage.next();
			}
		}
		
		return intData;
		
	}
	
	
	
	
	
public static char getChar(){
		
		boolean dataEntered = false;
		char charData = 'n';
		while(dataEntered == false) {
			
		try {
		
		charData = manage.next().charAt(0);
		Character.toLowerCase(charData);
		dataEntered = true;
		  
		}catch( Exception err ){
			dataEntered = false;
			
			System.out.println(err);
			System.out.println("Invalid Entry Please try Again");
			manage.next();
			}
		}
		
		return charData;
	}
	
	
	
	
	public static char getChar(String catchMessage){
		
		boolean dataEntered = false;
		char charData = 'n';
		while(dataEntered == false) {
			
		try {
		
		charData = manage.next().charAt(0);
		Character.toLowerCase(charData);
		dataEntered = true;
		  
		}catch( Exception err ){
			dataEntered = false;
			
			System.out.println(err);
			System.out.println(catchMessage);
			manage.next();
			}
		}
		
		return charData;
	}
	
	
	public static String getStringToLowerCase(){
		
		boolean dataEntered = false;
		String stringData = null;
		while(dataEntered == false) {
			
		try {
		
		stringData = manage.nextLine().toLowerCase();

		dataEntered = true;
		  
		}catch( Exception err ){
			dataEntered = false;
			
			System.out.println(err);
			manage.next();
			}
		}
		
		return stringData;
	}
	
	
	public  static boolean yesOrNo() {
		boolean yesNoReturn = false;
		boolean dataEntered = false;
		
		
		while(dataEntered == false) {
			
			if(manage.hasNextLine()) {
			
			try {
			
				  
			String yesNoInput = manage.nextLine();
			if(!yesList.contains(yesNoInput) &&!noList.contains(yesNoInput)) {
				throw new Exception();
			}
			dataEntered = true;
			if(yesList.contains(yesNoInput)) {
				return true;
			}else if(noList.contains(yesNoInput)){
				return false;
			}
			
		
			
			}catch( Exception err ){
				dataEntered = false;
				
				System.out.println(err);
				System.out.println("Invalid entry must "
						+ "enter (Y or N)");
			
				
				}
			}
		}
		
		return  yesNoReturn;
	}
	
	
	
	public static int getIntRange(int min, int max) {
	
		boolean dataEntered = false;
		
		int num = 0;
		while(dataEntered == false) {
			
			try {
				
			 num = manage.nextInt();
			if(num < min || num >= max ) {
				throw new Exception("Input must be equal to or greater than " + min + " and less than " + max);
			}
			
		
			dataEntered = true;
			  
			}catch( Exception err ){
				dataEntered = false;
				
				System.out.println(err);
				System.out.println("Invalid entry try again");
				
			}
			manage.nextLine();
			}
		

		return num;
	}
	
	
	public static double getDoubleRange(int min, int max) {
		manage.nextLine();
		boolean dataEntered = false;
		
		double num = 0;
		while(dataEntered == false) {
			
			try {
			 num = manage.nextInt();
			if(num < min || num > max ) {
				throw new Exception("Input must be between" + min + " and " + max);
			}
			
		
			dataEntered = true;
			  
			}catch( Exception err ){
				dataEntered = false;
				
				System.out.println(err);
				System.out.println("Invalid entry try again");
			
				manage.next();
				}
			}
		
		
		return num;
	}
	
	
	
	public static void printTitle(String title) {
		System.out.println(title);
		System.out.println("--------------------------------");
	}

		
}
