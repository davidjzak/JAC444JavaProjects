package workshop5;
import javafx.application.Application;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;


public class HelloWorld extends Application {

    private static final Pane grid = null;


	public static void main(String[] args){
        launch(args);
    }
    
	
    @Override
    public void start(Stage primaryStage) {

        // Create the pane
        // GridPane pane = new GridPane();
    	Color[] colors = {Color.WHITE, Color.BLACK};
    	 GridPane grid = new GridPane();

    	for (int row = 0; row < 8; row++) {
    	    for (int col = 0; col < 8; col++) {
    	        int nextColor = (row + col) % 2;
    	        Rectangle square = new Rectangle();
    	        square.setWidth(65);
    	        square.setHeight(65);
    	        square.setFill(colors[nextColor]);
    	        GridPane.setRowIndex(square, row);
    	        GridPane.setColumnIndex(square, col);
    	        grid.getChildren().addAll(square);
    	    }
    	}

      
        Scene scene = new Scene(grid);
        primaryStage.setTitle("ChessBoard");
        primaryStage.setScene(scene);
        // Display
        primaryStage.show();
    }


}
