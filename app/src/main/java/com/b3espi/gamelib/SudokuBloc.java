package com.b3espi.gamelib;

import java.util.ArrayList;

/**
 * Created by clementcorreia on 22/10/2017.
 */

public class SudokuBloc {

    private ArrayList<ArrayList<Integer>> bloc;

    public SudokuBloc() {
        this.bloc = new ArrayList<ArrayList<Integer>>();
        this.bloc.add(new ArrayList<Integer>());
        this.bloc.add(new ArrayList<Integer>());
        this.bloc.add(new ArrayList<Integer>());
    }

    public SudokuBloc(ArrayList<ArrayList<Integer>> bloc) {
        this.bloc = bloc;
    }

    public void setTop(int[] line) {
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i=0; i < line.length; i++) {
            tmp.add(line[i]);
        }
        this.bloc.set(0, tmp);
    }

    public boolean contains(int e) {
        return this.getTop().contains(e) || this.getMiddleH().contains(e) || this.getBottom().contains(e);
    }

    public void setMiddleH(int[] line) {
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i=0; i < line.length; i++) {
            tmp.add(line[i]);
        }
        this.bloc.set(1, tmp);
    }

    public void setBottom(int[] line) {
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i=0; i < line.length; i++) {
            tmp.add(line[i]);
        }
        this.bloc.set(2, tmp);
    }

    public ArrayList<Integer> getTop() {
        return this.bloc.get(0);
    }

    public ArrayList<Integer> getMiddleH() {
        return this.bloc.get(2);
    }

    public ArrayList<Integer> getBottom() {
        return this.bloc.get(2);
    }

    public ArrayList<Integer> getLeft() {
        ArrayList<Integer> left = new ArrayList<Integer>();
        left.add(this.bloc.get(0).get(0));
        left.add(this.bloc.get(1).get(0));
        left.add(this.bloc.get(2).get(0));
        return left;
    }

    public ArrayList<Integer> getMiddleV() {
        ArrayList<Integer> middleV = new ArrayList<Integer>();
        middleV.add(this.bloc.get(0).get(1));
        middleV.add(this.bloc.get(1).get(1));
        middleV.add(this.bloc.get(2).get(1));
        return middleV;
    }

    public ArrayList<Integer> getRight() {
        ArrayList<Integer> right = new ArrayList<Integer>();
        right.add(this.bloc.get(0).get(2));
        right.add(this.bloc.get(1).get(2));
        right.add(this.bloc.get(2).get(2));
        return right;
    }
}
