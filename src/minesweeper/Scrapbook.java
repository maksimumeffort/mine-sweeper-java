package minesweeper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
//import java.awt.event.KeyEvent;

public class Scrapbook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// start game
		Minesweeper game = new Minesweeper();
		
		
		System.out.print("Welcome to Minesweeper");
		System.out.println();
		System.out.println();
		boolean playerAlive = true;
		boolean everyNonMineRevealed = false;
		String message = playerAlive == false ? "You Won!" : "You Lost";
		
		while (playerAlive) {
			List<String> yAxis = game.yAxisList;
			Scanner s = new Scanner(System.in);
			game.displayWhatsVisible();
			System.out.println();
			
			System.out.println("select a row");
			System.out.print("> ");
			String guessedRow = s.nextLine().toUpperCase();
			int indexOfyAxis = yAxis.indexOf(guessedRow);
			
			System.out.println("select a column");
			System.out.print("> ");
			int guessedCol = s.nextInt();
			
			Cell selectedCell = game.fieldCellsArray[indexOfyAxis][guessedCol];
			if(selectedCell.isMine == true) {
				playerAlive = false;
			} else {
				selectedCell.opened = true;
			}
			
			
		}
		
//		game.displayWhatsVisible();
		System.out.println(message);
		
		

	}
}
