import java.util.ArrayList;
import java.util.List;

public class Winner {
	
	private int team;
	private boolean won;
	private List <Integer> winningIndexes = new ArrayList<Integer>();
	
	public Winner(){
		int team = 0;
		won = false;
		
	}
	
	
	public void setWinner(int color){
		team = color;
		won = true;
	}
	
	public int getTeam(){
		return team;
		}

	public void addToIndexes(int index1, int index2, int index3, int index4){
		winningIndexes.add(index1);
		winningIndexes.add(index2);
		winningIndexes.add(index3);
		winningIndexes.add(index4);
	}
	
	
	public List<Integer> returnWinningIndexes(){
		return  winningIndexes;
	}	
	
	
	public boolean getGameWin() {
		return won;
	}	
}
