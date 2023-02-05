package minesweeper;

public class Cell {

	// type of cell
	// 0 - mine
	// 1 - number
	// 2 - blank
	
	public int cellType;
	public int posX;
	public int posY;
	public boolean opened;
	public boolean isMine = false;
	
	
	public Cell(boolean isMine, int posX, int posY) {
		this.isMine = isMine;
		this.posX = posX;
		this.posY = posY;
		this.opened = false;
		
	}	
}
