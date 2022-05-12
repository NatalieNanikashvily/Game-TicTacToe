package game;

import java.util.Scanner;

public class Game extends Board{ //a class of a game, contains methods that check if a player won let the user play
	protected Player[] players=new Player[2];
	protected Scanner s=new Scanner(System.in);
	
	public Game(int n, int m, Player p1, Player p2) //a constructor that gets the size of the board, sets it and sets an array of two players
	{
		super(n,m);
		players[0]=p1;
		players[1]=p2;
	}
	
	protected boolean doesWin(int i, int j) {  //a method that checks if a player is the winner
		if (i==0 && j==0)
		{
			return true;
		}
		return false;
	}
	
	protected boolean onePlay(Player p) { //a method where one player plays his turn, lets the player enter the spot where he wants to be located and puts him there if possible
		int x, y;
		System.out.println(p+",please enter x and y: ");
		x=s.nextInt();
		y=s.nextInt();
		while (set(x,y,p)==false) //check if the dot x,y is valid, if not give the user another option to choose
		{
			System.out.println("There is a piece there already...");
			System.out.println(p+",please enter x and y: ");
			x=s.nextInt();
			y=s.nextInt();
		}
		System.out.println(toString());
		if (doesWin(x,y)==true) //check if the move has made the player the winner
			return true;
		return false;
	}
	
	public Player play() { //a game played by 2 players.
		Player win;
		while(true)
		{
			if (onePlay(players[0])==true) { //let player 1 play, if he won print a message and break the loop
				win=players[0];
				System.out.println(players[0]+" won!");
				break;
			}
			else if (isFull()==true) //if the board is full return null
				return null;
		
			if (onePlay(players[1])==true) { //let player 2 play, if he won print a message and break the loop
				win=players[1];
				System.out.println(players[1]+" won!");
				break;
			}
			else if (isFull()==true) //if the board is full return null
				return null;
		}
		return win; //return the winner of the two players

	}
}
