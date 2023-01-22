package minesweeper;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Grid {
	
	private int[][] visibleGrid = new int[10][10];
	private int[][] hiddenGrid = new int[10][10];
	public int amountOfMines = 10;
	Random random = new Random();
	
	// set logic to setup the grid
	
	public Grid() {
		
	}	
	
	// setup the mines  
	
	public void setupMines()
    {
        int loop=0;
        while(loop < amountOfMines)
        {
            int i = random.nextInt(10);
            int j = random.nextInt(10);
//            System.out.println("i: " + i + " j: " + j);
            hiddenGrid[i][j] = 100;
            loop++;
        }
        buildGrid();
    }

	public void buildGrid()
    {
        for(int i=0; i<visibleGrid.length; i++)
        {
            for(int j=0; j<visibleGrid[i].length; j++)
            {
                int count=0;
                if(hiddenGrid[i][j]!=100)
                {

                    if(i!=0)
                    {
                        if(hiddenGrid[i-1][j]==100) count++;
                        if(j!=0)
                        {
                            if(hiddenGrid[i-1][j-1]==100) count++;
                        }

                    }
                    if(i!=9)
                    {
                        if(hiddenGrid[i+1][j]==100) count++;
                        if(j!=9)
                        {
                            if(hiddenGrid[i+1][j+1]==100) count++;
                        }
                    }
                    if(j!=0)
                    {
                        if(hiddenGrid[i][j-1]==100) count++;
                        if(i!=9)
                        {
                            if(hiddenGrid[i+1][j-1]==100) count++;
                        }
                    }
                    if(j!=9)
                    {
                        if(hiddenGrid[i][j+1]==100) count++;
                        if(i!=0)
                        {
                            if(hiddenGrid[i-1][j+1]==100) count++;
                        }
                    }

                    hiddenGrid[i][j] = count;
                }
            }
        }

    }

	
	
	public int[][] getVisibleGrid() {
		return visibleGrid;
	}

	public void setVisibleGrid(int[][] visibleGrid) {
		this.visibleGrid = visibleGrid;
	}

	public int[][] getHiddenGrid() {
		return hiddenGrid;
	}

	public void setHiddenGrid(int[][] hiddenGrid) {
		this.hiddenGrid = hiddenGrid;
	}

	
	
}
