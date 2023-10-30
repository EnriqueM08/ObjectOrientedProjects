package hw2;

/**
 * This class ScoreTracker is used to determine who won the game based on the version
 * and the current scores.
 */
public class ScoreTracker {
	
	/**
	* Prints to screen the current score with two players based on version
	* @param game the WarGame that will be used to determine scores
	*/
	public void printScores(WarVersionOne game) {
		for(int i = 0; i < game.players.length; i++) {
			System.out.print("Player " + (i + 1) + " has a score of ");
			if(game.getVersion() == 1)
				System.out.println(game.players[i].getHeldDeckSize() + 
						game.players[i].getWonDeckSize());
			else
				System.out.println(game.players[i].getWonDeckSize());
		}
	}
	
	/**
	* Determines the winner when there are two players based on war version one
	* @param game the WarGame that will be used to determine winner
	*/
	public void determineWinnerVersionOne(WarVersionOne game) {
		int playerOneScore = game.players[0].getHeldDeckSize() +
							 game.players[0].getWonDeckSize();
		int playerTwoScore = game.players[1].getHeldDeckSize() +
							 game.players[1].getWonDeckSize();

		if(playerOneScore > playerTwoScore)
			System.out.println("Player 1 Wins!");
		else if(playerTwoScore > playerOneScore)
			System.out.println("Player 2 Wins!");
		else
			System.out.println("TIE!");
	}
	
	/**
	* Determines the winner when there are three players based on war version
	* @param game the WarGame that will be used to determine winner
	*/
	public void determineWinnerVersionTwoAndThree(WarVersionTwoAndThree game) {
		boolean winner;
		
		for(int i = 0; i < game.players.length; i++) {
			winner = true;
			for(int j = 0; j < game.players.length; j++) {
				if(i != j && game.players[i].getWonDeckSize() < game.players[j].getWonDeckSize()) {
					winner = false;
				}
			}
			if(winner) {
				System.out.println("Player " + (i + 1) + " Wins!");
				return;
			}
		}
		
		System.out.println("TIE!");
		
		winner = true;
	}
}
