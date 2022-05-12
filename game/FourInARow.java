package game;

public class FourInARow extends Game{ //a class of a game named four in a row
	
	public FourInARow(String player1, String player2) { //constructor that creates an object of for in a row by getting two names of players, setting a board in a size of 6X7
		super(2,3,new Player(player1,'W'),new Player(player2,'B'));
	}
	
	
	@Override
	protected boolean doesWin(int i, int j) { //checks if there is a line of 4 in which there is the same player
		if (maxLineContaining(i,j)==4)
			return true;
		return false;
	}
	
	@Override
	protected boolean onePlay(Player p) { //gets a player and plays its turn: let him enter a number of column, let him know if the column is full anf if not add the player to the bottom of the free space
		int column;
		System.out.println(p+",please enter a column: ");
		column=s.nextInt(); //get a number of column from the user
		while(isFull()==false)
		{
			for (int i=n-1;i>=0;i--) {
				if (isEmpty(i,column)==true) //check if the number of the column is valid and if it is check if the player is now the winner
				{
					set(i,column,p);
					System.out.println(toString()); 
					if (doesWin(i,column)==true)
						return true;
					return false;
				}
			}
			System.out.println("please enter another column"); //if the number of the column is not valid let the user enter another number
			column=s.nextInt();
		}
		return false;
	}
}
