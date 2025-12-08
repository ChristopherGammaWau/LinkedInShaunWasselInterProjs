package shaunwassel.learning;

import java.io.Serializable;

public class SaveObject implements Serializable {
	private int totalWins;
	private int totalGames;
	
	// For new save files
	public SaveObject() {
		this.totalGames = 0;
		this.totalWins = 0;
	}
	
	public int getTotalWins() {
		return totalWins;
	}
	public void setTotalWins(int totalWins) {
		this.totalWins = totalWins;
	}
	public int getTotalGames() {
		return totalGames;
	}
	public void setTotalGames(int totalGames) {
		this.totalGames = totalGames;
	}

	
}
