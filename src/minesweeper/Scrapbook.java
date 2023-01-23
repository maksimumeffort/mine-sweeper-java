package minesweeper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Scrapbook {
	
	
	public class Mine {
		
		public boolean hasDetonated;
		
		public Mine() {
			this.hasDetonated = false;
		}
		
		public void detonate() {
			this.hasDetonated = true;
		}
	}
	
	public class Cell {
		
		// type of cell
		// 0 - mine
		// 1 - number
		// 2 - blank
		
		public int cellType;
		public int position;
		public boolean opened;
		
		public Cell(int cellType, int position) {
			this.cellType = cellType;
			this.position = position;
			this.opened = false;
		}	
		
	}
	
	public class Grid {
		
		Random rand = new Random();
		private int amountOfBombs = 10;
		private int rows = 10;
		private int columns = 10;
		private ArrayList<Integer> minesArray = new ArrayList<>();
		public static ArrayList<Cell> cellsArray = new ArrayList<>();
		
		
		
		public Grid() {
			createCells();
		}
		
		public ArrayList<Integer> checkForMines(int position) {
			
			ArrayList<Integer> cellsAroundArray = new ArrayList<>();
			int[] values = {+1, -1, +10, -10, +9, +11, -9, -11};
			ArrayList<Integer> cellsAround = new ArrayList<>();
			for(int i = 0; i < 8; i++) {
				cellsAroundArray.add(position + values[i]);
			}
			
			return cellsAroundArray;
		}
		
		public void createCells() {
			// build a list of mines with position
			while(minesArray.stream().distinct().count() != amountOfBombs)
				for(int i = 0; i < amountOfBombs; i++) {
					int randPosition = rand.nextInt(rows * columns);
					if(!minesArray.contains(randPosition)) {
						minesArray.add(randPosition);
				}
			}
			for (int i = 0; i < rows * columns; i++) {
				if(minesArray.contains(i)) {
					// 0 = bomb
					cellsArray.add(new Cell(0, i));
				} else {
					if(minesArray.contains())
				}
		
				
			}
		}
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String[][] matrix3 = {
				{"?", "?", "?", "?", "?", "?", "?", "?", "?", "?"},
				{"?", "?", "?", "?", "?", "?", "?", "?", "?", "?"},
				{"?", "?", "?", "?", "?", "?", "?", "?", "?", "?"},
				{"?", "?", "?", "?", "?", "?", "?", "?", "?", "?"},
				{"?", "?", "?", "?", "?", "?", "?", "?", "?", "?"},
				{"?", "?", "?", "?", "?", "?", "?", "?", "?", "?"},
				{"?", "?", "?", "?", "?", "?", "?", "?", "?", "?"},
				{"?", "?", "?", "?", "?", "?", "?", "?", "?", "?"},
				{"?", "?", "?", "?", "?", "?", "?", "?", "?", "?"},
				{"?", "?", "?", "?", "?", "?", "?", "?", "?", "?"}
				
		};
		
		
		
		
		// create 10 bombs
		Random rand = new Random();
		
//		Grid mineField = new Grid();
		ArrayList<Cell> cellsArray = new ArrayList<>();
//		Cell[][] matrix1 = new Cell[10][10];
		
		// build a list of mines with position
		ArrayList<Integer> mines = new ArrayList<>();
		
//			while(mines.stream().distinct().count() != 10)
//				for(int i = 0; i < 10; i++) {
//					int randPosition = rand.nextInt(10 * 10);
//					if(!mines.contains(randPosition)) {
//						mines.add(randPosition);
//				}
//			}
//		
//		System.out.println(10+ +1 );
		
		// build a list of cells with position
		ArrayList<Cell> cells = new ArrayList<>();
			
//		for (int i = 0; i < 100; i++) {
//			if(mines.contains(i)) {
//				cellsArray.add(new Cell(0, i));
//			}
//		}
		
		Integer position = 35;
		
		ArrayList<Integer> cellsAroundArray = new ArrayList<>();
		
		int neighbourCount = 8;
		int[] values = {+1, -1, +10, -10, +9, +11, -9, -11};
		
		for(int i = 0; i < neighbourCount; i++) {
			
			
			
			cellsAroundArray.add(position + values[i]);
		}
			
		System.out.println(cellsAroundArray);
		
		
		
//		int[] iRandomArray = new int[10];
//		int[] jRandomArray = new int[10];
//		
//		int[][] randomBombCoords = new int[10][10];
//		
//		for(int i = 0; i < 10; i++) {
//			for(int j = 0; j < 10; j++) {
//				while(iRandomArray[i] == jRandomArray[i]) {
//					int iRandom = rand.nextInt(10);
//					int jRandom = rand.nextInt(10);
//					randomBombCoords[i] = int[iRandom];
//					
//				}
//			}
//		}
//		
//		for(int i = 0; i < 10; i++) {
//			int iRandom = rand.nextInt(10);
//			iRandomArray[i] = iRandom;
//		}
//		
//		for(int j = 0; j < 10; j++) {
//			int jRandom = rand.nextInt(10);
//			jRandomArray[j] = jRandom;
//		}
//		
//		for(int i = 0; i < 10; i++) {
//			while(iRandomArray[i] == jRandomArray[i]) {
//				int iRandom = rand.nextInt(10);
//				iRandomArray[i] = iRandom;
//				
//				int jRandom = rand.nextInt(10);
//				jRandomArray[i] = jRandom;
//			}
//		}
//		
//		for(int i = 0; i < 10; i++) {
//			System.out.printf("the corrds are [%d, %d]\n", iRandomArray[i], jRandomArray[i]);
//		}
//		
//		
//		System.out.println(Arrays.toString(iRandomArray));
//		System.out.println(Arrays.toString(jRandomArray));
//		
//		
//		System.out.println("   0 1 2 3 4 5 6 7 8 9");
//		System.out.println();
//		
//		
//		for(int i = 0; i < matrix3.length; i++) {
//			System.out.print(i + "  ");
//			for(int j= 0; j < matrix3[i].length; j++) {
//				
////				if(matrix3[i]) 
//				
//
//				System.out.print(matrix3[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		

	}
}
