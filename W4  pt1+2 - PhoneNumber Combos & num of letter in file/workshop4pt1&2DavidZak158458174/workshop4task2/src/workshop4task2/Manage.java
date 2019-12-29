package workshop4task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manage {
	 List <Letter> letters = new ArrayList<Letter>();
	
public void start() {

	char tempChar;
	Scanner inFile1 = null;
	String filepath;
	
	Helper.printTitle("Please enter a filename");
	filepath = Helper.getString();
	

	//creating list filled with classes to hold all 26 letter in lower and upper case
	char capAnon;
	for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
		  //++counter;
		  Letter anon = new Letter(alphabet);
		  letters.add(anon);
		  Letter anonUpper = new Letter(Character.toUpperCase(alphabet));
		  letters.add(anonUpper);
	
	  }
	 
	//open file and read letters, if it finds a letter call 
	//appropriate letter class to increase count
	 try {
			inFile1 = new Scanner(new File(filepath)).useDelimiter(""); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	 while(inFile1.hasNext()){ 
		  tempChar = inFile1.next().charAt(0);
		  
		  for(int i = 0; i < letters.size(); i++) {
			  if(letters.get(i).returnLetter() == tempChar){
				  letters.get(i).addCount();
		           }
		  
		  }
	 
	 
	} // end while
     inFile1.close();  // closes file when complete
  } // end start function


//prints out totals for each letter that appeared in the file
public void displayLetters() {
	
	Helper.printTitle("The File contains:");

	for(int i = 0; i < letters.size(); i++) {
	if(letters.get(i).returnCount() > 0) {	
	   System.out.println("Number of " +   letters.get(i).returnLetter() + "'s is: "  + letters.get(i).returnCount());
	}       
	  
	  }
	
	
}

}


