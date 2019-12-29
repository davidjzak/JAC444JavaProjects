package w6r2;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.ComboBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;

public class Contacts extends Application {

	
	static int positionCounter = 0;
	static int totalContacts = 0;

	public static void main(String[] args){
		
        launch(args);
        
    }
    
	
	String order;
	String firstNameString;
	String lastNameString;
	String cityString;
	String provinceString;
	String postalCodeString;
	TextField number = new TextField();
	TextField firstName = new TextField();
	TextField lastName = new TextField();
	TextField city = new TextField();
	TextField postalCode = new TextField();
	ComboBox<String> comboProv = new ComboBox<String>();	
	
	ManageLine manage = new ManageLine();
	
	public void start(Stage stage) {
		InitializeFiles files = new InitializeFiles();
		manage.begin();
		
		GridPane view = new GridPane();
		
		view.setPadding(new Insets(20, 50, 14, 20));
		 Label lyear = new Label("Enter the Year:");
		view.add(lyear, 0, 0);
		TextField year = new TextField ();
		view.add(year, 2, 0);
		Label lgender = new Label("Gender (M/F):");
		view.add(lgender, 0, 1);
		TextField gender = new TextField ();
		view.add(gender, 2, 1);
		Label lname = new Label("Enter the Name");
		view.add(lname, 0, 2);
		TextField name = new TextField();
		view.add(name, 2, 2);
		
		
	 Text results = new Text("Last Name:");
		
		

		Button buttonSubmit = new Button("Submit");
		view.add(buttonSubmit, 2, 4);

		buttonSubmit.setOnAction(action -> {
			results.setText(files.findName(name.getText(), gender.getText().charAt(0), year.getText()));
			view.add(results, 2, 3);
		});
		
		Button buttonExit = new Button("Exit");
		Text choice = new Text("Do you want to search again?");
		choice.setVisible(false);
	

		Button buttonConfirmExit = new Button("No");
		buttonConfirmExit.setVisible(false);
		buttonConfirmExit.setOnAction(action -> {
			Platform.exit();
			System.exit(0);

         });
		
		Button buttonContinue = new Button("Yes");
		buttonContinue.setVisible(false);
		buttonContinue.setOnAction(action -> {
					year.setVisible(true);
					gender.setVisible(true);
					name.setVisible(true);
					results.setVisible(true);
					lgender.setVisible(true);
					lyear.setVisible(true);
					lname.setVisible(true);
					buttonContinue.setVisible(false);
					reset(year, gender, name, results);
					buttonSubmit.setVisible(true);
					choice.setVisible(false);
					buttonConfirmExit.setVisible(false);
					buttonExit.setVisible(true);
					
		});
		
		
	
	
		buttonExit.setOnAction(action -> {
			year.setVisible(false);
			gender.setVisible(false);
			name.setVisible(false);
			results.setVisible(false);
			lgender.setVisible(false);
			lyear.setVisible(false);
			lname.setVisible(false);
			buttonExit.setVisible(false);
			buttonContinue.setVisible(true);
			buttonConfirmExit.setVisible(true);
			buttonSubmit.setVisible(false);
		
			choice.setVisible(true);
			
			
		});
		

		view.add(buttonConfirmExit, 1, 2);
		view.add(choice, 1, 1);
		
		view.add(buttonContinue, 2, 2);
		view.add(buttonExit, 0, 4);
		
		view.setHgap(12);
		view.setVgap(12);

		view.getColumnConstraints().add(new ColumnConstraints(85));
		view.getColumnConstraints().add(new ColumnConstraints(85));
		view.getColumnConstraints().add(new ColumnConstraints(85));
		view.getColumnConstraints().add(new ColumnConstraints(85));
		
		Scene scene = new Scene(view);

		stage.setTitle("Search Name Ranking Application");
		stage.setScene(scene);
		stage.show(); 
		
	};

    void reset(TextField year, TextField gender, TextField name, Text results) {
    	year.setText("\0");
		gender.setText("\0");
    	name.setText("\0");
		results.setText("\0");
    };
 
    
	void buttonActionHandlers(String action) {
		int pos = positionCounter;
		switch (action) {
		case "Submit Query":
			pos = 1;
			number.setText(String.valueOf(pos));
			break;
		case "Exit":
			pos = pos + 1;
			if(pos <= manage.returnCounter())
			number.setText(String.valueOf(pos));
			break;
		}
		firstName.setText(manage.sendData(pos, "firstNameString"));
		lastName.setText(manage.sendData(pos, "lastNameString"));
		city.setText(manage.sendData(pos, "cityString"));
		comboProv.setValue(manage.sendData(pos, "provinceString"));
		postalCode.setText(manage.sendData(pos, "postalCodeString"));
		positionCounter = pos;
	};
};