package w6r2;


import javafx.application.Application;
import javafx.scene.control.ComboBox;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
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
		manage.begin();
		
		GridPane view = new GridPane();
		
		view.setPadding(new Insets(20, 50, 14, 20));
		
		view.add(new Label("First Name:"), 0, 0);
		view.add(firstName, 1, 0, 5, 1);
		view.add(new Label("Last Name:"), 0, 1);
		view.add(lastName, 1, 1, 5, 1);
		view.add(new Label("      City: "), 0, 2);
		view.add(city, 1, 2);
		view.add(new Label("Province: "), 2, 2);
		view.add(comboProv, 3, 2);
		view.add(new Label("Postal Code:"), 4, 2);
		view.add(postalCode, 5, 2);
		comboProv.getItems().addAll("Ontario", "Quebec", "Calgary", "Alberta", "New  Brunswick", "British Columbia");
		
		Button buttonAdd = new Button("Add");
		view.add(buttonAdd, 0, 3);
		buttonAdd.setOnAction(action -> { 
			firstNameString = firstName.getText();
			lastNameString = lastName.getText();
			cityString = city.getText();
			provinceString = comboProv.getValue();
			postalCodeString = postalCode.getText();

			manage.write(firstNameString, lastNameString, cityString, provinceString, postalCodeString);
			manage.begin();
			positionCounter = positionCounter + 1;
			totalContacts = manage.returnCounter() + 1;

			System.out.println(manage.returnCounter());
			reset();
		});

		Button buttonFirst = new Button("First");
		view.add(buttonFirst, 1, 3);

		buttonFirst.setOnAction(action -> {
			buttonActionHandlers("First");
		});
		Button buttonNext = new Button("Next");
		view.add(buttonNext, 2, 3);
		
		buttonNext.setOnAction(action -> {
			if(positionCounter != totalContacts) {
				buttonActionHandlers("Next");
				}
		});
		Button buttonPrevious = new Button("Previous");
		view.add(buttonPrevious, 3, 3);

		buttonPrevious.setOnAction(action -> {
			if(positionCounter != 1) {
			buttonActionHandlers("Previous");
			}
		});
		Button buttonLast = new Button("Last");
		view.add(buttonLast, 4, 3);
		buttonLast.setOnAction(action -> {
			buttonActionHandlers("Last");
		});
		Button buttonUpdate = new Button("Update");
		view.add(buttonUpdate, 5, 3);
		buttonUpdate.setOnAction(action -> { 
			firstNameString = firstName.getText();
			lastNameString = lastName.getText();
			cityString = city.getText();
			provinceString = comboProv.getValue();
			postalCodeString = postalCode.getText();
			manage.update(positionCounter, firstNameString, lastNameString, cityString, provinceString, postalCodeString);
		});
		view.setHgap(12);
		view.setVgap(12);

		view.getColumnConstraints().add(new ColumnConstraints(85));
		view.getColumnConstraints().add(new ColumnConstraints(85));
		view.getColumnConstraints().add(new ColumnConstraints(85));
		view.getColumnConstraints().add(new ColumnConstraints(85));
		
		Scene scene = new Scene(view);

		stage.setTitle("AddressBook");
		stage.setScene(scene);
		stage.show(); 
		
	};

    void reset() {
    	comboProv.setValue("\0");
		postalCode.setText("\0");
    	firstName.setText("\0");
		lastName.setText("\0");
		city.setText("\0");
		
    };
 
	void buttonActionHandlers(String action) {
		int pos = positionCounter;
		switch (action) {
		case "First":
			pos = 1;
			number.setText(String.valueOf(pos));
			break;
		case "Next":
			pos = pos + 1;
			if(pos <= manage.returnCounter())
			number.setText(String.valueOf(pos));
			break;
		case "Previous":
			pos = pos - 1;
			number.setText(String.valueOf(pos));
			break;
		case "Last":
			pos = manage.returnCounter();
			number.setText(String.valueOf(manage.returnCounter()));
		}
		firstName.setText(manage.sendData(pos, "firstNameString"));
		lastName.setText(manage.sendData(pos, "lastNameString"));
		city.setText(manage.sendData(pos, "cityString"));
		comboProv.setValue(manage.sendData(pos, "provinceString"));
		postalCode.setText(manage.sendData(pos, "postalCodeString"));
		positionCounter = pos;
	};
};