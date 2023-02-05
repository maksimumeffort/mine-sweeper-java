package minesweeper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Grid {
	
	Random rand = new Random();
	private int amountOfBombs = 10;
	public  Cell[][] cellsArray = new Cell[10][10];
	
	// lists for available initial x and y positions 
	public List<Integer> positionsX = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
	public List<Integer> positionsY = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
	
	// lists of random x and y positions for generation of mines
	List<Integer> minePosXlist = new ArrayList<Integer>();
	List<Integer> minePosYlist = new ArrayList<Integer>();
	
	// INSTANTIATION
	public Grid() {
		createCells();
	}
	
	// METHODS
	
	// generate a list of integers picked at random from a list
	public void generateMines(List origList, List newList) {
		
		while (newList.size() !=  10) {
			Integer randPos = rand.nextInt(1, 11);
			if(origList.contains(randPos)) {
				newList.add(randPos);
				Integer posInList = origList.indexOf(randPos);
				origList.remove(origList.get(posInList));
			}
		}	
	}
	

	// loops over cellsArray and populates it with cells with the right values
	public void createCells() {
		
		// generate a minePosXlist
		generateMines(positionsX, minePosXlist);
		Integer[] minePosXarray = minePosXlist.toArray(new Integer[0]);
		
		// generate a minePosYlist
		generateMines(positionsY, minePosYlist);
		Integer[] minePosYarray = minePosYlist.toArray(new Integer[0]);
		
		// loop through 
		for (Integer outer = 0; outer < cellsArray.length; outer++) {

			for(Integer inner = 0; inner < cellsArray[outer].length; inner++) {
				
				// get index of value 1 in minePosXarray
				Integer indexOfOuter = minePosXlist.indexOf(outer+1);
				// check inner = the position of minePosYarray at that index
				// if true -> mine, else normal cell
				if(inner+1 == minePosYarray[indexOfOuter]) {
					cellsArray[outer][inner] = new Cell(true, outer, minePosYarray[indexOfOuter]);
				} else {
					cellsArray[outer][inner] = new Cell(false, outer, inner);
				}
			}
		}
	}
	
	public Integer checkCellsAround(Cell selectedCell) {
		int amountOfmines = 0;
		int[] coords = {0, -1, +1};
		String[] checker = {"both", "left", "right"};
		int[] selectedPositions = {selectedCell.posX, selectedCell.posY};
		List<Integer> cellPosXList = new ArrayList<Integer>();
		List<Integer> cellPosYList = new ArrayList<Integer>();
		
		for(int turnInd = 0; turnInd < 3; turnInd++) {
	
			for(int checkInd = 0; checkInd < 3; checkInd++) {
				// chech which checker is activated 
				if(checker[turnInd] == "both") {
					// increment both x and y positions
					cellPosXList.add(selectedPositions[0]+coords[checkInd]);
					cellPosYList.add(selectedPositions[1]+coords[checkInd]);
					
				} else if (checker[turnInd] == "left") {
					// increment positions y only
					cellPosXList.add(selectedPositions[0]);
					cellPosYList.add(selectedPositions[1]+coords[checkInd]);
					
				} else {
					// increment positions x only
					cellPosXList.add(selectedPositions[0]+coords[checkInd]);
					cellPosYList.add(selectedPositions[1]);
				}
			}
		}
		
		for (int pos = 0; pos < cellPosXList.size(); pos++) {
			// delete initial coordinates
			if(pos == 0) {
				cellPosXList.remove(pos);
				cellPosYList.remove(pos);
			}
			
			int x = cellPosXList.get(pos);
			int y = cellPosYList.get(pos);
			boolean validPos = x >= 0 && x < 10 && y >= 0 && y < 10;
			
			if(validPos && cellsArray[x][y].isMine == true) {
				amountOfmines++;
			}
		}
			
		return amountOfmines;
		
	}
			
			
		
		
}
