package minesweeper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Minesweeper {
	
	public Random rand = new Random();
	
	public Grid field = new Grid();
	
	public Cell[][] fieldCellsArray = field.cellsArray;
	public List<String> yAxisList = new ArrayList<String>(Arrays.asList("A","B","C","D","E","F","G","H","I","J")); 

	
	public String[][] hiddenField = new String[10][10];
	public String[][] visibleField = new String[10][10];
	
	public Minesweeper() {
		makeHiddenField();
		makeVisibleField();
	}
	
	// populate hiddenField
	public void makeHiddenField() {
		for(int i = 0; i < fieldCellsArray.length; i++) {
//			System.out.println("i:"+ i);
			for(int j = 0; j < fieldCellsArray[i].length; j++){

				hiddenField[i][j] = "[?]";
			}
		}
	};
	
			
	// populate visibleField
	public void makeVisibleField() {
		for(int i = 0; i < fieldCellsArray.length; i++) {
//			System.out.println("i:"+ i);
			for(int j = 0; j < fieldCellsArray[i].length; j++){
				boolean isMine = fieldCellsArray[i][j].isMine;
//				System.out.println("checking mines for: "+i+j);
				int minesAmount = field.checkCellsAround(fieldCellsArray[i][j]);
					
				if(isMine) {
					visibleField[i][j] = "[*]";
					
				} else if(minesAmount > 0) {
					visibleField[i][j] = "[" + minesAmount + "]";
					
				} else {
					visibleField[i][j] = "[ ]";
				}
				
			}
		}
	};
	
	
	// display what's visible
	public void displayWhatsVisible() {
		System.out.println("    0  1  2  3  4  5  6  7  8  9");
		System.out.println();
		
		for(int i = 0; i < fieldCellsArray.length; i++) {
			System.out.print(yAxisList.get(i) + "  ");
			for(int j= 0; j < fieldCellsArray[i].length; j++) {
				
				boolean opened = fieldCellsArray[i][j].opened;
				
				if(opened) {
					System.out.print(visibleField[i][j]);
				} else {
					System.out.print(hiddenField[i][j]);
				}
				
				
			}
			System.out.println();
		}
	};
	

}
