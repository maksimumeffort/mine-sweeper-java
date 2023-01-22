package minesweeper;

public class Mine {

	private boolean detonated = false;
	
	public Mine(){
		
	}
	
	public boolean hasDetonated() {
		return this.detonated;
	}
	
	public void detonate() {
		this.detonated = true;
	}

	
}
