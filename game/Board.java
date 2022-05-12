package game;

public class Board {// a class that contains the board of the game, sets the board of the game with players and calculates the max line in which a player in dot I,j is

	protected Player[][] board;
	protected int n,m;
	
	public Board(int n, int m) {//constructor that build a board
		board=new Player[n][m];
		this.n=n;
		this.m=m;
	}
	
	public boolean isEmpty(int i, int j) {// checks if a spot in the board is empty. returns true if it 
		if (board[i][j]==null)
		{
			return true;
		}
		return false;
	}
	
	protected boolean set(int i, int j, Player p) { //gets a player and puts it in the place I,j if empty
		if (isEmpty(i,j)==false)
		{
			return false;
		}
		board[i][j]=p;
		return true;
	}
 
	public Player get(int i, int j) { //returns the player in the spot i,j
		return board[i][j];
	}
	
	public boolean isFull() {//returns true if the board is full and otherwise false
		for (int i=0;i<n;i++)
		{
			for (int j=0;j<m;j++) {
				if (isEmpty(i,j)==true) {
					return false;
				}
			}
		}
		return true;
	}
	
	public String toString() { //prints the board
		String str="";
		for (int i=0;i<n;i++)
		{
			for (int j=0;j<m;j++) {
				if (isEmpty(i,j)==true)
				{
					str+=".";
				}
				else
					str+=(board[i][j].getMark());
			}
			str+="\n";
		}
		return str;
	}
	
	
	private boolean inboard(int i,int j) {    //checks if a dot i,j is in the board. returns true if it is
		if ((i>=0 && i<n) && (j>=0 && j<m)) {
			return true;
		}
		return false;
	}
	
	private  int rayLength(int x, int y, int dx, int dy)  //counts the number of times the player shows up in a row/column..etc by the values of dx, dy

	{
		int count=0;
		char marki=(board[x][y]).getMark();
		while( (inboard(x,y)==true) && (board[x][y]!=null) && ((board[x][y]).getMark()==marki)) //if we are still in the board&the spot is not empty&the spit hag the value of the player we were looking for count++
		{
			count++;	//move to the next in the row/column/etc..
			x=x+dx;
			y=y+dy;
		}
		return count;	
	}

	protected int maxLineContaining(int i, int j) { //calculates the max length of the line that is created from the dot
		int column,row,left,right,max;
		column=rayLength(i,j,-1,0)-1; //calculate column line
		column+=rayLength(i,j,1,0);
		row=rayLength(i,j,0,1)-1; //calculate row line
		row+=rayLength(i,j,0,-1);
		left=rayLength(i,j,-1,-1)-1; //calculate left slant line
		left+=rayLength(i,j,1,1);
		right=rayLength(i,j,-1,1)-1; //calculate right slant line
		right+=rayLength(i,j,1,-1);
		max=Math.max(column,row); 
		max=Math.max(max,right);
		max=Math.max(max,left);
		return max;  //return maximum of all
	}

}
