package com.b3espi.gamelib;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by clementcorreia on 22/10/2017.
 */

public class SudokuGrille {

    private int[][] grille;
    private final int[][][] blocs = {{{0,0},{2,2}},   {{3,0},{5,2}},   {{6,0},{8,2}},
                                     {{0,3},{2,5}},   {{3,3},{5,5}},   {{6,3},{8,5}},
                                     {{0,6},{2,8}},   {{3,6},{5,8}},   {{6,6},{8,8}}};
    private final int[][] blocsIndex = {{0,   1,   2},
                                        {3,   4,   5},
                                        {6,   7,   8}};

    public SudokuGrille() {
        this.grille = new int[9][9];
        this.generate();
    }

    public int[] getLine(int row) {
        return this.grille[row];
    }

    public int[] getColumn(int col) {
        int[] column = new int[9];
        for(int i=0; i<9; i++) {
            column[i] = this.grille[i][col];
        }
        return column;
    }

    public int getBlocIndexByPosition(int row, int col) {
        return this.blocsIndex[this.getColIndex(col)][this.getRowIndex(row)];
    }

    public int[][] getBlocByIndex(int index) {
        int[][] coordonnees = this.blocs[index];
        int[] debut = coordonnees[0];
        int[] fin = coordonnees[1];
        int i = 0, j = 0;
        int[][] bloc = new int[3][3];
        for(int col=debut[0]; col <= fin[0]; col++) {
            for(int row=debut[1]; row <= fin[1]; row++) {
                bloc[i][j] = this.grille[row][col];
                i++;
            }
            i=0;
            j++;
        }
        return bloc;
    }

    public int[][] getBlocByPosition(int row, int col) {
        int rowIndex, colIndex;
        rowIndex = this.getRowIndex(row);
        colIndex = this.getColIndex(col);
        return this.getBlocByIndex(this.blocsIndex[colIndex][rowIndex]);
    }

    public int getRowIndex(int row) {
        int rowIndex;
        if(row >= 0 && row <= 2) {
            rowIndex = 0;
        }
        else {
            if(row >= 3 && row <= 5) {
                rowIndex = 1;
            }
            else {
                rowIndex = 2;
            }
        }
        return rowIndex;
    }

    public int getColIndex(int col) {
        int colIndex;
        if(col >= 0 && col <= 2) {
            colIndex = 0;
        }
        else {
            if(col >= 3 && col <= 5) {
                colIndex = 1;
            }
            else {
                colIndex = 2;
            }
        }
        return colIndex;
    }

    public int getCase(int row, int col) {
        return this.grille[row][col];
    }

    public int getRandom(int cpt) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        return numbers[cpt];
    }

    public boolean isFreeNumber(int row, int col, int number) {
        int blocIndex = getBlocIndexByPosition(row, col);
        return !(this.blocContains(blocIndex, number) || this.lineContains(row, number) || this.columnContains(col, number));
    }

    public boolean lineContains(int row, int e) {
        int[] line = this.getLine(row);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : line) list.add(i);
        return list.contains(e);
    }

    public boolean columnContains(int col, int e) {
        int[] column = this.getColumn(col);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i : column) list.add(i);
        return list.contains(e);
    }

    public boolean blocContains(int index, int e) {
        int[][] bloc = this.getBlocByIndex(index);
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0; i<bloc.length; i++) {
            for(int j : bloc[i])
                if(j!=0) list.add(j);
        }
        return list.contains(e);
    }

    public void initialise() {
        for( int k = 0 ; k < this.grille.length ; k++) {
            for( int j = 0 ; j < this.grille[k].length ; j++) {
                this.grille[k][j] = -1;
            }
        }
    }

    public void generate() {
        /*int[] top1 = {1, 2, 3};
        int[] middleH1 = {4, 5, 6};
        int[] bottom1 = {7, 8, 9};
        int[] top2 = {4, 5, 6};
        int[] middleH2 = {7, 8, 9};
        int[] bottom2 = {1, 2, 3};
        int[] top3 = {7, 8, 9};
        int[] middleH3 = {1, 2, 3};
        int[] bottom3 = {4, 5, 6};
        SudokuBloc b1 = new SudokuBloc(), b2 = new SudokuBloc(), b3 = new SudokuBloc();
        b1.setTop(top1);
        b1.setMiddleH(middleH1);
        b1.setBottom(bottom1);
        b2.setTop(top2);
        b2.setMiddleH(middleH2);
        b2.setBottom(bottom2);
        b3.setTop(top3);
        b3.setMiddleH(middleH3);
        b3.setBottom(bottom3);
        ArrayList<SudokuBloc> line1 = new ArrayList<>(), line2 = new ArrayList<>(), line3 = new ArrayList<>();
        line1.add(b1); line1.add(b2); line1.add(b3);
        line2.add(b2); line2.add(b3); line2.add(b1);
        line3.add(b3); line3.add(b1); line3.add(b2);*/
        int number = 0;
        Random randomGenerator = new Random();
        int cpt = randomGenerator.nextInt(9);
        int row = 0, col=0;
        for(int i=0; i<81; i++) {
            do {
                number = this.getRandom(cpt);
                if(cpt<8) cpt++;
                else cpt = 0;
            } while(!this.isFreeNumber(row, col, number));
            this.grille[row][col] = number;
            if((i+1)%9==0) {
                row++;
            }
            if((col+1)%9==0) col = 0;
            else col++;
        }
    }

    @Override
    public String toString() {
        String str = "";
        for( int k = 0 ; k < 9; k++) {
            int[] line = this.getLine(k);
            if(k==0 || k==3 || k==6) {
                if(k==3 || k==6) {
                    str += "\n";
                }
                str += "__________________________________\n";
            }
            else {
                str += "\n";
            }
            for( int j = 0 ; j < line.length; j++) {
                if(j==0) {
                    str += "| " + line[j] + " ";
                }
                else {
                    if(j==2 || j==5 || j==8) {
                        str += line[j] + " | ";
                    }
                    else {
                        str += line[j] + " ";
                    }
                }
            }
            if(k==8) {
                str += "\n";
                str += "__________________________________\n";
            }
        }
        return str;
    }

    /*public boolean isEqual(int[][] b1, int[][] b2) {
        if(b1.length!=b2.length) return false;
        for(int i=0; i<b1.length; i++) {
            if (b1[i].length != b2[i].length) return false;
            for(int j=0; j<b1[i].length; j++) {
                if(b1[i][j]!=b2[i][j]) return false;
            }
        }
        return true;
    }*/

    public static void main(String[] args) {
        SudokuGrille s = new SudokuGrille();
        //int[][] b1 = s.getBlocByIndex(1);
        //int[][] b2 = s.getBlocByPosition(2,3);
        //System.out.println(s.isEqual(b1,b2));
        System.out.println(s);
    }

}
