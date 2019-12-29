package workshop4task2;

public class Letter {
	
	char letter;
	int count = 0;
	
	public Letter(char inputLetter){
		letter = inputLetter;
	}
	
	public void addCount() {
		count += 1;
	}
	
	public char returnLetter(){
		
		return letter;
	}
		
	public int returnCount(){
		
		return count;
	}
}
