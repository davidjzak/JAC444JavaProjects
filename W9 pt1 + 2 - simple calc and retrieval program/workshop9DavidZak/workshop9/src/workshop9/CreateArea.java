package workshop9;

import java.util.Optional;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CreateArea {
	
	
	
	Stage stage;
	static GridPane view;
	static Text gameOver;
	int num1;
	int num2;
	
	public CreateArea(Stage gamestage, double n1, double n2) {
		stage = gamestage;
		num1 = (int)n1;
		num2 = (int)n2;
	};
	
	
	public void CreateGameBoard(){
		GridPane view = new GridPane();
		Calculations calc = new Calculations();
		view.setPrefWidth(500);

		
		view.setPadding(new Insets(20, 50, 14, 20));
		 Label ladd = new Label("What is the addition of " + num1 + " and " + num2);
		view.add(ladd, 0, 0);
		TextField add = new TextField ();
		view.add(add, 4, 0);
		Label lsubtract = new Label("What is the result of subtracting " + num1 + " from " + num2);
		view.add(lsubtract, 0, 1);
		TextField subtract = new TextField ();
		view.add(subtract, 4, 1);
		Label lmulti = new Label("What is the result of multiplying " + num1 + " and " + num2);
		view.add(lmulti, 0, 2);
		TextField multi = new TextField ();
		view.add(multi, 4, 2);
		Label ldivision = new Label("What is the result of dividing " + num1 + " from " + num2);
		view.add(ldivision, 0, 3);
		TextField division = new TextField ();
		view.add(division, 4, 3);
		
		Text rightA = new Text();
		view.add(rightA, 3, 4);
		Text wrongA = new Text();
		view.add(wrongA, 3, 5);
		
		Text duplicate = new Text();
		
		HBox htab = new HBox(duplicate);
		htab.setPadding(new Insets(15, 12, 15, 12));
		
		Button submit = new Button("Submit");
		duplicate.setText("");
		submit.setOnAction(e -> {
			// removes all elements from set
			calc.clearSet();
			int correct = 0;
			int wrong = 0;
			
			if (calc.add(num1, num2, Integer.parseInt(add.getText()))) {
				correct +=1;
			}else {
				wrong +=1;
			}
			
			
			if (calc.subtract(num1, num2, Integer.parseInt(subtract.getText()))) {
				correct +=1;
			}else {
				wrong +=1;
			}
			
			if (calc.multiply(num1, num2, Integer.parseInt(multi.getText()))) {
				correct +=1;
			}else {
				wrong +=1;
			}
			
			if (calc.divide(num1, num2, Double.parseDouble(division.getText()))) {
				correct +=1;
			}else {
				wrong +=1;
			}
			
			
			
			
			rightA.setText("Number of Correct Answers: " + correct);
			
			wrongA.setText("Number of Wrong Answers: " + wrong);
			if(calc.returnSetSize() != 4) {
				rightA.setText("");
				wrongA.setText("");
				duplicate.setText("Error Please make sure there are no duplicates");
		
			}
			
			
		});
		view.add(submit, 3, 7);
		
		Button retry = new Button("Play Again");
		retry.setOnAction(e -> {
			multi.setText("");
			division.setText("");
			subtract.setText("");
			add.setText("");
			rightA.setText("");
			wrongA.setText("");
			duplicate.setText("");
			
			num1 = (int) ((Math.random() * ((10 - 1) + 1)) + 1);
			 num2 = (int) ((Math.random() * ((10 - 1) + 1)) + 1);
			int temp;
			if(num2 > num1) {
				temp = num1;
				num1 = num2;
				num2 = temp;
			}
			
			ladd.setText("What is the addition of " + num1 + " and " + num2);
			 lsubtract.setText("What is the result of subtracting " + num1 + " from " + num2);
			 lmulti.setText("What is the result of multiplying " + num1 + " and " + num2);
			ldivision.setText("What is the result of dividing " + num1 + " from " + num2);
			
		});
		
		view.add(retry, 4, 7);
		
		VBox main = new VBox(view, htab);
		Scene scene = new Scene(main);
	

		stage.setTitle("Quiz Application");
		stage.setScene(scene);
		stage.show(); 
		
	}
	
}




