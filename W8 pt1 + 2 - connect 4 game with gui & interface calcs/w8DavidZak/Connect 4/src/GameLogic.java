
public class GameLogic {

	private int team = 1;
	int placedArray[] = new int [42];
	public void switchTurn(){ 
		
		if (team == 0) {
			team = 1;
		}else if(team == 1){
			team = 0;
		}
	}
	
	public int getTeam() {
		return team;
	}
	
	public int determineWinner(){
		
		
		return team;// winner variable
	}
	
	//chooses slot 0 to 6 and presses enter
 public Winner findPieceSlot(int column){
	 
	 if(team == 2) {
		 team = 1;
	 }else if(team == 1) {
		 team = 2;
	 }
	 
	Winner winner = new Winner();
	int pos = column;
		
	 while(pos < placedArray.length + 7){
	
			if(pos > 41) {
				pos-=7;
				break;
			}
			else if(placedArray[pos] == 0){
					pos += 7;
			}else if(placedArray[pos] > 0 && (pos - 7) >= 0){
					pos-=7;
					break;
				}
			else{
				 if(team == 2) {
					 team = 1;
				 }else if(team == 1) {
					 team = 2;
				 }
				
					break;
				}
			}//end case 0 while loop

		//end of function, if pos greaater than length of fields its invalid
		//if pos under 42 call check winner function
		System.out.println(pos);
		if(pos > 41) {
			return winner;
		}
		placedArray[pos] = team;
		CreateGame game = new CreateGame(null);
		
		 winner = checkWinner();
		 CreateGame.setPiece(pos+7, team); // because of buttons add 7
		
		 return winner;
 }


public Winner checkWinner(){
	
	// try catch to handle arrays out of bounds
	Winner winner = new Winner();
	
	for(int i = 0; i < placedArray.length; i++) {
	//vertical
	try {
		if(placedArray[i] != 0 && placedArray[i] == placedArray[i + 7] && placedArray[i] == placedArray[i + 7*2] 
				&&  placedArray[i] == placedArray[i + 7*3]) {
			winner.setWinner(placedArray[i]);
			winner.addToIndexes(placedArray[i], placedArray[i + 7], placedArray[i + 7*2], placedArray[i + 7*3]);
		}
	}catch(Exception err) {
		
	}
	
	//horizontal
	try {
		if(placedArray[i] != 0 && placedArray[i] == placedArray[i + 1] && placedArray[i] == placedArray[i + 2] 
				&&  placedArray[i] == placedArray[i + 3]) {
			winner.setWinner(placedArray[i]);
			winner.addToIndexes(placedArray[i], placedArray[i + 1], placedArray[i + 2] , placedArray[i + 3]);
		}
	}catch(Exception err) {
		
	}
	
	// down diagonal
	try {
		
		if(placedArray[i] != 0 && placedArray[i] == placedArray[i + 7 + 1] && placedArray[i] == placedArray[i + 7*2 + 1] 
				&&  placedArray[i] == placedArray[i + 7*3 + 1]) {
			winner.setWinner(placedArray[i]);
			winner.addToIndexes(placedArray[i], placedArray[i + 7 + 1], placedArray[i + 7*2 + 1], placedArray[i + 7*3 + 1]);
		}
		
	}catch(Exception err) {
		
	}
	
	try {
		
		if(placedArray[i] != 0 && placedArray[i] == placedArray[(i - 7) + 1] && placedArray[i] == placedArray[(i - 7*2) + 1] 
				&&  placedArray[i] == placedArray[(i - 7*3) + 1]) {
			winner.setWinner(placedArray[i]);
			winner.addToIndexes(placedArray[i], placedArray[(i - 7) + 1] , placedArray[(i - 7*2) + 1], placedArray[(i - 7*3) + 1]);
		}
		
		
	}catch(Exception err) {
		
	}
	
}
  
	
	if(winner.getGameWin()) {
		CreateGame game = new CreateGame(null);
		game.declareWinner(winner.getTeam());
	}
	return winner;
	
}



}