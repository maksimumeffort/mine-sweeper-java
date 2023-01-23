package minesweeper;

import java.util.Random;

public abstract class Display {
	
	public void displayVisible(int[][] visibleGrid)
    {
        System.out.print("\t ");
        for(int i=0; i<10; i++)
        {
            System.out.printf(" %d  ", i);
        }
        System.out.print("\n");
        for(int i=0; i<10; i++)
        {
            System.out.print(i + "\t| ");
            for(int j=0; j<10; j++)
            {
                if(visibleGrid[i][j]==0)
                {
                    System.out.print("?");
                }
                else if(visibleGrid[i][j]==50)
                {
                    System.out.print(" ");
                }
                else
                {
                    System.out.print(visibleGrid[i][j]);
                }
                System.out.print(" | ");
            }
            System.out.print("\n");
        }
    }
	
	public void displayHidden(int[][] hiddenGrid)
    {
        System.out.print("\t ");
        for(int i=0; i<10; i++)
        {
            System.out.print(" " + i + "  ");
        }
        System.out.print("\n");
        for(int i=0; i<10; i++)
        {
            System.out.print(i + "\t| ");
            for(int j=0; j<10; j++)
            {
                if(hiddenGrid[i][j]==0)
                {
                    System.out.print(" ");
                }
                else if(hiddenGrid[i][j]==100)
                {
                    System.out.print("X");
                }
                else
                {
                    System.out.print(hiddenGrid[i][j]);
                }
                System.out.print(" | ");
            }
            System.out.print("\n");
        }
    }
	
	public void fixVisible(int i, int j, int[][] visibleGrid, int[][] hiddenGrid)
    {
        visibleGrid[i][j] = 50;
        if(i!=0)
        {
            visibleGrid[i-1][j] = hiddenGrid[i-1][j];
            if(visibleGrid[i-1][j]==0) visibleGrid[i-1][j] = 50;
            if(j!=0)
            {
                visibleGrid[i-1][j-1] = hiddenGrid[i-1][j-1];
                if(visibleGrid[i-1][j-1]==0) visibleGrid[i-1][j-1]=50;

            }
        }
        if(i!=9)
        {
            visibleGrid[i+1][j]=hiddenGrid[i+1][j];
            if(visibleGrid[i+1][j]==0) visibleGrid[i+1][j]=50;
            if(j!=9)
            {
                visibleGrid[i+1][j+1]= hiddenGrid[i+1][j+1];
                if(visibleGrid[i+1][j+1]==0) visibleGrid[i+1][j+1] = 50;
            }
        }
        if(j!=0)
        {
            visibleGrid[i][j-1]=hiddenGrid[i][j-1];
            if(visibleGrid[i][j-1]==0) visibleGrid[i][j-1] = 50;
            if(i!=9)
            {
                visibleGrid[i+1][j-1]=hiddenGrid[i+1][j-1];
                if(visibleGrid[i+1][j-1]==0) visibleGrid[i+1][j-1] = 50;
            }
        }
        if(j!=9)
        {
            visibleGrid[i][j+1]=hiddenGrid[i][j+1];
            if(visibleGrid[i][j+1]==0) visibleGrid[i][j+1] = 50;
            if(i!=0)
            {
                visibleGrid[i-1][j+1]=hiddenGrid[i-1][j+1];
                if(visibleGrid[i-1][j+1]==0) visibleGrid[i-1][j+1] = 50;
            }
        }
    }

    public void fixNearFields(int i, int j, int[][] visibleGrid, int[][] hiddenGrid)
    {
        Random random = new Random();
        int x = random.nextInt()%4;

        visibleGrid[i][j] = hiddenGrid[i][j];

        if(x==0)
        {
            if(i!=0)
            {
                if(hiddenGrid[i-1][j]!=100)
                {
                    visibleGrid[i-1][j] = hiddenGrid[i-1][j];
                    if(visibleGrid[i-1][j]==0)  visibleGrid[i-1][j] = 50;
                }
            }
            if(j!=0)
            {
                if(hiddenGrid[i][j-1]!=100)
                {
                    visibleGrid[i][j-1] = hiddenGrid[i][j-1];
                    if(visibleGrid[i][j-1]==0)  visibleGrid[i][j-1] = 50;
                }

            }
            if(i!=0 && j!=0)
            {
                if(hiddenGrid[i-1][j-1]!=100)
                {
                    visibleGrid[i-1][j-1] = hiddenGrid[i-1][j-1];
                    if(visibleGrid[i-1][j-1]==0)  visibleGrid[i-1][j-1] = 50;
                }

            }
        }
        else if(x==1)
        {
            if(i!=0)
            {
                if(hiddenGrid[i-1][j]!=100)
                {
                    visibleGrid[i-1][j] = hiddenGrid[i-1][j];
                    if(visibleGrid[i-1][j]==0)  visibleGrid[i-1][j] = 50;
                }
            }
            if(j!=9)
            {
                if(hiddenGrid[i][j+1]!=100)
                {
                    visibleGrid[i][j+1] = hiddenGrid[i][j+1];
                    if(visibleGrid[i][j+1]==0)  visibleGrid[i][j+1] = 50;
                }

            }
            if(i!=0 && j!=9)
            {
                if(hiddenGrid[i-1][j+1]!=100)
                {
                    visibleGrid[i-1][j+1] = hiddenGrid[i-1][j+1];
                    if(visibleGrid[i-1][j+1]==0)  visibleGrid[i-1][j+1] = 50;
                }
            }
        }
        else if(x==2)
        {
            if(i!=9)
            {
                if(hiddenGrid[i+1][j]!=100)
                {
                    visibleGrid[i+1][j] = hiddenGrid[i+1][j];
                    if(visibleGrid[i+1][j]==0)  visibleGrid[i+1][j] = 50;
                }
            }
            if(j!=9)
            {
                if(hiddenGrid[i][j+1]!=100)
                {
                    visibleGrid[i][j+1] = hiddenGrid[i][j+1];
                    if(visibleGrid[i][j+1]==0)  visibleGrid[i][j+1] = 50;
                }

            }
            if(i!=9 && j!=9)
            {
                if(hiddenGrid[i+1][j+1]!=100)
                {
                    visibleGrid[i+1][j+1] = hiddenGrid[i+1][j+1];
                    if(visibleGrid[i+1][j+1]==0)  visibleGrid[i+1][j+1] = 50;
                }
            }
        }
        else
        {
            if(i!=9)
            {
                if(hiddenGrid[i+1][j]!=100)
                {
                    visibleGrid[i+1][j] = hiddenGrid[i+1][j];
                    if(visibleGrid[i+1][j]==0)  visibleGrid[i+1][j] = 50;
                }
            }
            if(j!=0)
            {
                if(hiddenGrid[i][j-1]!=100)
                {
                    visibleGrid[i][j-1] = hiddenGrid[i][j-1];
                    if(visibleGrid[i][j-1]==0)  visibleGrid[i][j-1] = 50;
                }

            }
            if(i!=9 && j!=0)
            {
                if(hiddenGrid[i+1][j-1]!=100)
                {
                    visibleGrid[i+1][j-1] = hiddenGrid[i+1][j-1];
                    if(visibleGrid[i+1][j-1]==0)  visibleGrid[i+1][j-1] = 50;
                }
            }
        }
    }
    
	
}
