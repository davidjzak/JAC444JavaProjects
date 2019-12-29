package workshop9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Calculations {
	
	 Set<Integer> answers = new HashSet<Integer>();

	public boolean add(int num1, int num2, int answer) {
		answers.add(answer);
		
		int result = num1 + num2;
		if(result == answer) {
			return true;
		}
		return false;
	}
	
	
public boolean subtract(int num1, int num2, int answer) {
	answers.add(answer);
		int result = num1 - num2;
		if(result == answer) {
			return true;
		}
		return false;
	}
	
	

public boolean multiply(int num1, int num2, int answer) {
	answers.add(answer);
	int result = num1 * num2;
	if(result == answer) {
		return true;
	}
	return false;
}


public boolean divide(int num1, int num2, double d) {
	answers.add((int) d);
	double result = num1 / num2;
	if(result == d) {
		return true;
	}
	return false;
}

public void clearSet() {
	answers.clear();
}

public int returnSetSize() {
	return answers.size();
}

}
