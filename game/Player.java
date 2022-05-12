package game;

public class Player { //contains details of the player- name and a mark
	private String name;
	private char mark;
	
	
	public Player(String name, char mark) { //gets a string of name and a char and builds an object of player
		this.name=name;
		this.mark=mark;
	}
	
	public String getName() { //returns the name of the player
		return name;
	}
	
	public char getMark() { //returns the mark of the player
		return mark;
	}
	
	public String toString() { //print the player like this: pilpel(P)

		return name+"("+mark+")";
	}

}
