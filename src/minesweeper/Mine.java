package minesweeper;

public class Mine {
	
	public boolean hasDetonated = false;
	
	public Mine() {
	}
	
	public void detonate() {
		this.hasDetonated = true;
	}
}
