


import javafx.scene.control.Button;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class CreateGame {
	
	Stage stage;
	static GridPane view;
	public GameLogic game = new GameLogic();
	static Text gameOver;
	public CreateGame(Stage gamestage) {
		stage = gamestage;
		
	};
	
	public void CreateGameBoard(){
		view = new GridPane();
		view.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 150, .5), CornerRadii.EMPTY, Insets.EMPTY)));
		view.setPadding((new Insets(40, 20, 20, 20)));
		view.setHgap(10);
		view.setVgap(10);
	  Button drop = new Button("drop");
	  drop.setOnAction(event -> {
		  
		  game.findPieceSlot(0);
		 });
	  
	  Button drop2 = new Button("drop");
	  drop2.setOnAction(event -> {
		  game.findPieceSlot(1);
	  });
	  
	  Button drop3 = new Button("drop");
	  drop3.setOnAction(event -> {
		  game.findPieceSlot(2);
	  });
	  
	  Button drop4 = new Button("drop");
	  drop4.setOnAction(event -> {
		  game.findPieceSlot(3);
	  });
	  
	  
	  Button drop5 = new Button("drop");
	  drop5.setOnAction(event -> {
		  game.findPieceSlot(4);
	  });
	  
	  Button drop6 = new Button("drop");
	  drop6.setOnAction(event -> {
		  game.findPieceSlot(5);
	  });
	  
	  Button drop7 = new Button("drop");
	  drop7.setOnAction(event -> {
		  game.findPieceSlot(6);
	  });
	  
	  view.add(drop, 0,0);
	  view.add(drop2, 1,0);
	  view.add(drop3, 2,0);
	  view.add(drop4, 3,0);
	  view.add(drop5, 4,0);
	  view.add(drop6, 5,0);
	  view.add(drop7, 6,0);
	 
		for(int i = 1; i < 7; i++) {
			for(int j = 0; j < 7; j++) {
				Circle circle = new Circle(50, 50, 40);
				view.add(circle, j, i);
			}
		}
		//return node from 0 to 41 - changes color to red
		//((Shape) view.getChildren().get(41)).setFill(javafx.scene.paint.Color.RED);
		
		
		gameOver = new Text();
		GridPane.setMargin(gameOver, new Insets(0, 0, 70, 0));
		view.add(gameOver, 0, 0);

		Scene scene = new Scene(view);

		stage.setTitle("Connect 4");
		stage.setScene(scene);
		stage.show(); 
		
	}
	
	
	public static void clearFields(){
		
	}
	
	// 2 for team yellow, 1 for team red
	public static void  setPiece(int pos, int team ){
		
		System.out.println("enter set piece");
		if(team == 1) {
			((Shape) view.getChildren().get(pos)).setFill(javafx.scene.paint.Color.RED);
		}else if(team == 2) {
			((Shape) view.getChildren().get(pos)).setFill(javafx.scene.paint.Color.YELLOW);
		}
		
	}
	
	//2 for team yellow, 1 for team red
	public static void declareWinner(int team){
		
		if(team == 1) {
			gameOver.setText("Red Team Wins");
		}else if(team == 2) {
			gameOver.setText("Yellow Team Wins");

		}
		
	
	}	
	
}
