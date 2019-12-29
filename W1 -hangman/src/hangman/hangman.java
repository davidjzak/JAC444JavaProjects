package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class hangman {
	
static Boolean gameOver = false;
	
	public static int wordPicker(int numOfWords) {
		int random = (int)(Math.random() * numOfWords + 1);
		return random;
	}
	
	
	public static void guessingLoop(String hangmanWord) {
		int wordLength = hangmanWord.length(); // returns number of letters in word starting from 1
		/*
		 * System.out.println(hangmanWord);
		 * System.out.println(" wordlength initialized as " + wordLength);
		 */
		char [] hiddenWord = hangmanWord.toCharArray();
		char tempWord[] = new char[wordLength];
		List<Character> correctLetters = new ArrayList<Character>();
		List<Character> pickedLetters = new ArrayList<Character>();
		for(int i = 0; i < (wordLength - 1); i++) {
			tempWord[i] = '*';
					}
		Scanner guess = new Scanner(System.in);
		char charGuess;
		boolean correctGuess;
		int count = 0;
		while(gameOver == false) {
			
			correctGuess = false; //used to flag message for incorrect letter if it is not matched to temp word
			System.out.print("(Guess) enter a letter in the word " +  new String(tempWord));
			charGuess = guess.next().charAt(0); 
			if(!pickedLetters.contains(charGuess)) {
			pickedLetters.add(charGuess);
			
			for(int i = 0; i < (wordLength - 1); i++){
			if(hiddenWord[i] == charGuess) {
				correctLetters.add(charGuess);
				tempWord[i] = charGuess;
				correctGuess = true;
				//System.out.println("correctLetters " + correctLetters.size() + "wordLength " + wordLength);
				if(correctLetters.size() >= wordLength - 1){
				//	System.out.println(" enter game over box");
					//you win this means correct letter equals word length and you completed the game
					gameOver = true;
					break;
				}	
			}
			
			}//end for loop
			if(!correctGuess) {
						System.out.println(charGuess + " is not in the word");
						++count;
									   };
			} else { // end if to check for duplicates , start else
				
				System.out.println(charGuess + " is already in the guessed");
			}
			
		}// end while
		System.out.println("You win, the word was "  + new String(hiddenWord));
		System.out.println("You missed " + count + " times");
		
	}
	 
	public static List<String>  wordGenerator() {
		String tempWord = "";
		Scanner inFile1;
		
		  
		 List<String> words = new ArrayList<>();
		  try {
			inFile1 = new Scanner(new File("./src/hangman/commonwords.txt")).useDelimiter("\n");
			
			  while(inFile1.hasNext()) { tempWord = inFile1.next(); words.add(tempWord); }
			  inFile1.close(); 
			  
			 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		  return words;
	
	}

	public static void main(String args[]) {
		List<String> words = wordGenerator();
		 int wordLength = words.size();
		 String[] wordArray = new String [wordLength];
		 
		 for (int i = 0; i < wordLength; i++){ 
			wordArray[i] = words.get(i);
		// System.out.println(wordArray[i]);
		 } 
		 
		 
		guessingLoop(wordArray[wordPicker(wordLength)]);
		 
	}

}