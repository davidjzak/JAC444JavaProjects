package workshop5;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorld extends Application {

    public static void main(String[] args){
        launch(args);
    }
    
	
    @Override
    public void start(Stage primaryStage) {

        // Create the pane
        // GridPane pane = new GridPane();
 //making main container
    	    VBox vbox = new VBox();
    	    vbox.setPadding(new Insets(0));
    	    vbox.setSpacing(0);
//first row
    	    HBox hbox1 = new HBox();
    	    Text title1 = new Text("First Name:");
    	    title1.setFont(Font.font("Arial", FontWeight.BOLD, 14));
    	    TextField text1 = new TextField ();
    	    text1.setPrefColumnCount(56);
    	    hbox1.setSpacing(30);
    	    hbox1.setPadding(new Insets(10, 8, 15, 8));
    	    hbox1.getChildren().addAll(title1, text1);
  //second row  	    
    	    HBox hbox2 = new HBox();
    	    Text title2 = new Text("Last Name:");
    	    title2.setFont(Font.font("Arial", FontWeight.BOLD, 14));
    	    TextField text2 = new TextField ();
    	    text2.setPrefColumnCount(56);
    	    hbox2.setSpacing(30);
    	    hbox2.setPadding(new Insets(10, 8, 15, 8));
    	    hbox2.getChildren().addAll(title2, text2);
    	    
  //third row  	  
    	    
    	    HBox hbox3 = new HBox();
    	    Text title3 = new Text("City:");
    	    title3.setFont(Font.font("Arial", FontWeight.BOLD, 14));
    	    TextField text3 = new TextField ();
    	    text3.setPrefColumnCount(10);
    	    //province box styling
    	    Text title4 = new Text("Province:");
            final ComboBox provinceBox = new ComboBox();
            provinceBox .getItems().addAll(
                "Ontario",
                "Alberta",
                "Edmonton",
                "Sasketchewan",
                "British Columbia"  
            );
            provinceBox.setStyle("-fx-background-color: -fx-shadow-highlight-color, -fx-outer-border, -fx-inner-border, white;");
            
            
    	    
    	   
    	   
    	    TextField text4 = new TextField ();
    	    Text title5 = new Text("City:");
    	    title5.setFont(Font.font("Arial", FontWeight.BOLD, 14));
    	    text4.setPrefColumnCount(10);
    	    hbox3.setSpacing(30);
    	    hbox3.setPadding(new Insets(10, 8, 15, 8));
    	    hbox3.getChildren().addAll(title3, text3, title4, provinceBox, title5, text4);
    	    
    	    //footer
    	    HBox hbox = new HBox();
    	    hbox.setPadding(new Insets(10, 8, 15, 8));
    	    hbox.setSpacing(3);
    	    Text txt = new Text("Data");
    	    Button buttonCurrent = new Button("Add");
    	    buttonCurrent.setPrefSize(130, 20);

    	    Button button2 = new Button("First");
    	    button2.setPrefSize(130, 20);
    	    Button button3 = new Button("Next");
    	    button3.setPrefSize(130, 20);
    	    Button button4 = new Button("Previous");
    	    button4.setPrefSize(130, 20);
    	    Button button5 = new Button("Last");
    	    button5.setPrefSize(130, 20);
    	    Button button6 = new Button("Update");
    	    button6.setPrefSize(130, 20);
    	   
    	    hbox.getChildren().addAll(buttonCurrent, button2, button3, button4, button5, button6);
    	    
    	    
    	    
    	    vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox);
    	    Scene scene = new Scene(vbox);
        primaryStage.setTitle("Address Book");
        primaryStage.setScene(scene);
        // Display
        primaryStage.show();
    }


}
