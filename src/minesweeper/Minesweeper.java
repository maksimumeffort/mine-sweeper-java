package minesweeper;

import java.util.Random;
import java.util.Scanner;

public class Minesweeper extends Display {
	
	// display start of the game message
	
	Grid grid = new Grid();
	public int[][] visibleGrid = grid.getVisibleGrid();
	public int[][] hiddenGrid = grid.getHiddenGrid();
	
	// game logic 

	public void startGame() {
		System.out.println("-------Welcome to Minesweeper---------");
		grid.setupMines();
		
		boolean inGame = true;
		// while no mines have been selected
		while(inGame) {
			
			displayVisible(visibleGrid);
			inGame = playMove();
			if(checkWin()) {
				
				displayHidden(hiddenGrid);
				System.out.println("-------You Won!---------");
				break;
			}
		}
	}
	
	
	public boolean playMove()
    {
        Scanner s= new Scanner(System.in);
        System.out.print("\nEnter Row Number: ");
        int i= s.nextInt();
        System.out.print("Enter Column Number: ");
        int j= s.nextInt();

        if(i<0 || i>9 || j<0 || j>9 || visibleGrid[i][j]!=0)
        {
            System.out.print("\nIncorrect Input!!");
            return true;
        }

        if(hiddenGrid[i][j]==100)
        {
            displayHidden(hiddenGrid);
            System.out.print("You hit a mine!\n--------GAME OVER----------");
            return false;
        }
        else if(hiddenGrid[i][j]==0)
        {
            fixVisible(i, j, visibleGrid, hiddenGrid);
        }
        else
        {
            fixNearFields(i, j, visibleGrid, hiddenGrid);
        }

        return true;
    }
	
	
    public boolean checkWin()
    {
        for(int i=0; i<10; i++)
        {
            for(int j=0; j<10; j++)
            {
                if(visibleGrid[i][j]==0)
                {
                    if(hiddenGrid[i][j]!=100)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    

}
