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
				// System.out.println("removed: "+ randPos);
			}
		}
		// System.out.println("end of while loop");	
	}
	

	// loops over cellsArray and populates it with cells with the right values
	public void createCells() {
		
		// generate a minePosXlist
		generateMines(positionsX, minePosXlist);
		Integer[] minePosXarray = minePosXlist.toArray(new Integer[0]);
		System.out.println(Arrays.toString(minePosXarray));
		
		// generate a minePosYlist
		generateMines(positionsY, minePosYlist);
		Integer[] minePosYarray = minePosYlist.toArray(new Integer[0]);
		System.out.println(Arrays.toString(minePosYarray));
		
		// loop through 
		for (Integer outer = 1; outer < 11; outer++) {
//			System.out.println("outer" + outer);
			for(Integer inner= 1; inner < 11; inner++) {
				
				// get index of value 1 in minePosXarray
				Integer indexOfOuter = minePosXlist.indexOf(outer);
				// check inner = the position of minePosYarray at that index
				// if true -> mine, else normal cell
				if(inner == minePosYarray[indexOfOuter]) {
					System.out.println("mine created @" + outer + inner);
					cellsArray[outer-1][inner-1] = new Cell(true, outer, minePosYarray[indexOfOuter]);
				} else {
					cellsArray[outer-1][inner-1] = new Cell(false, outer-1, inner-1);
				}
			}
		}
	}
	
	public void checkCells(Cell selectedCell) {
		int amountOfmines = 0;
		// loop through all the surrounding cells of selectedCell, look for mines
		// increment amountOfMines value each time a mine is found in neighbour cell
		
	
	}
			
			
		
		
}
