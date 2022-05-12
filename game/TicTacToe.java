package game;

public class TicTacToe extends Game {
	
	public TicTacToe(String player1, String player2) {   //a game of X O
		super(3,3,new Player(player1,'X'),new Player(player2,'O')); //gets two names of players, sets a board and two new players to the array of players

	}
	
	@Override
	protected boolean doesWin(int x, int y) { //return true if the player in the spot (x,y) has a line with the length of 3
		if (maxLineContaining(x,y)==3)
			return true;
		return false;
	}
}
