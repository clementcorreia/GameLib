package com.b3espi.gamelib.demineur;


import java.util.Random;

/**
 * Created by pitch on 13/10/17.
 */

public class Grid {

    public static int[][] grid (int bombes){
        int bomb_grid[][] = new int[10][10];
        int i = 0;
        while (i<10){
            int j = 0;
            while (j<10){
                bomb_grid[i][j]=0;
                j++;
            }
            i++;
        }

        int bombes_placees = 0;
        while(bombes_placees<bombes){
            bomb_grid=place_bombe(bomb_grid);
            bombes_placees++;
        }

        bomb_grid=localise_bombes(bomb_grid);
        return bomb_grid;
    }

    public static int[][] place_bombe (int [][]bomb_grid){
        Random rand = new Random();
        int bombx=rand.nextInt(9);
        int bomby=rand.nextInt(9);
        if (bomb_grid[bombx][bomby]==0){
            bomb_grid[bombx][bomby]=9;
        }
        else{
            place_bombe(bomb_grid);
        }

        return bomb_grid;
    }

    public static int[][] localise_bombes(int [][]bomb_grid){
        int i = 0;
        while (i<10){
            int j = 0;
            while (j<10){
                if (bomb_grid[i][j]>8){
                    if (i != 0 && i!= 10){
                        bomb_grid[i-1][j]=bomb_grid[i-1][j]+1;
                        bomb_grid[i+1][j]=bomb_grid[i+1][j]+1;
                        if (j !=0 && j!=10){
                            bomb_grid[i-1][j-1]=bomb_grid[i-1][j-1]+1;
                            bomb_grid[i-1][j+1]=bomb_grid[i-1][j+1]+1;
                            bomb_grid[i][j-1]=bomb_grid[i][j-1]+1;
                            bomb_grid[i][j+1]=bomb_grid[i][j+1]+1;
                            bomb_grid[i+1][j-1]=bomb_grid[i+1][j-1]+1;
                            bomb_grid[i+1][j+1]=bomb_grid[i+1][j+1]+1;
                        }
                        else if (j==0){
                            bomb_grid[i-1][j+1]=bomb_grid[i-1][j+1]+1;
                            bomb_grid[i][j+1]=bomb_grid[i][j+1]+1;
                            bomb_grid[i+1][j+1]=bomb_grid[i+1][j+1]+1;
                        }
                        else if (j==10){
                            bomb_grid[i-1][j-1]=bomb_grid[i-1][j-1]+1;
                            bomb_grid[i][j-1]=bomb_grid[i][j-1]+1;
                            bomb_grid[i+1][j-1]=bomb_grid[i+1][j-1]+1;
                        }
                    }
                    else if (i == 0){
                        bomb_grid[i+1][j]=bomb_grid[i+1][j]+1;
                        if (j !=0 && j!=10){
                            bomb_grid[i][j-1]=bomb_grid[i][j-1]+1;
                            bomb_grid[i][j+1]=bomb_grid[i][j+1]+1;
                            bomb_grid[i+1][j-1]=bomb_grid[i+1][j-1]+1;
                            bomb_grid[i+1][j+1]=bomb_grid[i+1][j+1]+1;
                        }
                        else if (j==0){
                            bomb_grid[i][j+1]=bomb_grid[i][j+1]+1;
                            bomb_grid[i+1][j+1]=bomb_grid[i+1][j+1]+1;
                        }
                        else if (j==10) {
                            bomb_grid[i][j - 1] = bomb_grid[i][j - 1] + 1;
                            bomb_grid[i + 1][j - 1] = bomb_grid[i + 1][j - 1] + 1;
                        }
                    }
                    else if (i == 10){
                        bomb_grid[i-1][j]=bomb_grid[i-1][j]+1;
                        if (j !=0 && j!=10){
                            bomb_grid[i-1][j-1]=bomb_grid[i-1][j-1]+1;
                            bomb_grid[i-1][j+1]=bomb_grid[i-1][j+1]+1;
                            bomb_grid[i][j-1]=bomb_grid[i][j-1]+1;
                            bomb_grid[i][j+1]=bomb_grid[i][j+1]+1;
                        }
                        else if (j==0){
                            bomb_grid[i-1][j+1]=bomb_grid[i-1][j+1]+1;
                            bomb_grid[i][j+1]=bomb_grid[i][j+1]+1;
                        }
                        else if (j==10){
                            bomb_grid[i-1][j-1]=bomb_grid[i-1][j-1]+1;
                            bomb_grid[i][j-1]=bomb_grid[i][j-1]+1;
                        }
                    }
                }
                j++;
            }
            i++;
        }
        return bomb_grid;
    }
}
