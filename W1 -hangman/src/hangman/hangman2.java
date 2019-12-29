package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class hangman2 {
	
static Boolean gameOver = false;
static char playAgain = 'y';
static Scanner finishChoice = new Scanner(System.in);
	
	public static int wordPicker(int numOfWords) {
		// gets a random number between 1 and the size of the word list passed in
		int random = (int)(Math.random() * numOfWords + 1);
		return random;
	}
	
	
	public static void guessingLoop(String hangmanWord) {
		int wordLength = hangmanWord.length(); // returns number of letters in word starting from 
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
			charGuess = guess.next().charAt(0); // gets next character and put it in char for easy comparison
			charGuess = Character.toLowerCase(charGuess);
			if(!pickedLetters.contains(charGuess)) {// check if guess is already in list, if it is skip logic and give error
			pickedLetters.add(charGuess);  // else add words to list
			
			for(int i = 0; i < (wordLength - 1); i++){  // loops through word length to check for matching letters
			if(hiddenWord[i] == charGuess) {
				correctLetters.add(charGuess); // add words to correct letter array
				tempWord[i] = charGuess;
				correctGuess = true;
				
				if(correctLetters.size() >= wordLength - 1){
					gameOver = true;  //if correct letter array matches the desired number of letter then they have finished the word
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
		
		  // reads 3000 word list in from file and puts it into list
		 List<String> words = new ArrayList<>();
		  try {
			inFile1 = new Scanner(new File("./src/hangman/commonwords.txt")).useDelimiter("\n");
			
			  while(inFile1.hasNext()) { tempWord = inFile1.next(); words.add(tempWord); }
			  inFile1.close();  // closes file when complete
			  
			 
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
		 } 
		 
		do {
		guessingLoop(wordArray[wordPicker(wordLength)]); // pass in word to guessing loop, to begin the game
		
		 System.out.println("Do you want to guess another word? Enter y or n ");
		playAgain =  finishChoice.next().charAt(0);
		
		}while(playAgain == 'y' ||  playAgain ==  'Y');
		 
	}

}