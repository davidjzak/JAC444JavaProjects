import java.util.ArrayList;
import java.util.List;

public class PhoneNumber {

	char[] phoneNumber = new char[7];
	// corresponds to numbers 2 to 9, starting from 2 to use subtract 2 from number
	// in phone number because array starts from 0
	char[][] letters = new char[][] { { 'A', 'B', 'C' }, { 'D', 'E', 'F' }, { 'G', 'H', 'I' }, { 'J', 'K', 'L' },
			{ 'M', 'N', 'O' }, { 'P', 'R', 'S' }, { 'T', 'U', 'V' }, { 'W', 'X', 'Y' } };
	char[] tempword = new char[7];
	List<char[]> possibleCombos = new ArrayList<char[]>();

	public PhoneNumber(char[] pNumber) throws Exception {
		phoneNumber = pNumber;
		// loops through possible number, handles result with case
		for (int a = 0; a < 3; a++) {
			for (int b = 0; b < 3; b++) {
				for (int c = 0; c < 3; c++) {
					for (int d = 0; d < 3; d++) {
						for (int e = 0; e < 3; e++) {
							for (int f = 0; f < 3; f++) {
								for (int g = 0; g < 3; g++) {
									//prints out all possible letter combinations for a 7 digit phone number
									  System.out.println(letters[Character.getNumericValue(phoneNumber[0]) - 2][a] + "" + letters[Character.getNumericValue(phoneNumber[1]) -
									  2][b] + "" + letters[Character.getNumericValue(phoneNumber[2]) - 2][c] + "" +  letters[Character.getNumericValue(phoneNumber[3]) - 2][d] + "" + 
									  letters[Character.getNumericValue(phoneNumber[4]) - 2][e] +  "" + letters[Character.getNumericValue(phoneNumber[5]) - 2][f] +  "" + 
									  letters[Character.getNumericValue(phoneNumber[6]) - 2][g]);
									 
									

								}

							}

						}

					}

				}

			}

		}

	}

}

/*
 * switch(phoneNumber[i]){ case 2: break; case 3: break; case 4: break; case 5:
 * break; case 6: break; case 7: break; case 8: break; case 9: break; default:
 * throw new Exception("invalid Case Number"); }
 */