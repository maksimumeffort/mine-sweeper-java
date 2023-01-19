package minesweeper;

public class Cell {
	
	// create constructor for a cell
	
	// cell's position
	private final int positionX;
	private final int positionY;
	
	// cell's properties
	private final boolean isMine;
	private final boolean isVisible;
	
	public Cell(int positionX, int positionY, boolean isMine, boolean isVisible ) { 
		this.positionX = positionX;
		this.positionY = positionY;
		this.isMine = isMine;
		this.isVisible = isVisible;
	}
	

}
