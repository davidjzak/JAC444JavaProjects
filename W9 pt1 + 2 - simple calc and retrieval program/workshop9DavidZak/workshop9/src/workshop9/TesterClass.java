/*David Zak 158458174 */
package workshop9;

import javafx.application.Application;
import javafx.stage.Stage;

public class TesterClass extends Application {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   launch(args);
	
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO Auto-generated method stub
		double num1 = (Math.random() * ((10 - 1) + 1)) + 1;
		double num2 = (Math.random() * ((10 - 1) + 1)) + 1;
		double temp;
		if(num2 > num1) {
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		 CreateArea board = new CreateArea(arg0, num1, num2);
		// board.CreateGameBoard();
		 
		 board.CreateGameBoard();
	}


}
