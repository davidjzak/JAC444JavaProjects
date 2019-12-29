package hangman;

import java.util.Scanner;

public class wordgenerator {
	
	String tempWord = "";
	Scanner inFile1 = new Scanner(new File("commonwords.txt")).useDelimiter("\n");
	List<String> words = new ArrayList<>();
	
	
	while(inFile1.hasNext()) {
		tempWord = inFile1.hasNext();
		words.add(tempWord);
	}
	inFile1.close();
	for (String s : words) {
	      System.out.println(s);
	    }
}
