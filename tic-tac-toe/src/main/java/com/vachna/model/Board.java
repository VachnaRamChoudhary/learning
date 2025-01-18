package com.vachna.model;


import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;


public class Board {
    public int size;
    public PlayingPiece[][] playingPieces;

    public Board(int size) {
        this.size = size;
        this.playingPieces = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int col, PlayingPiece playingPiece){
        if(playingPieces[row][col] != null){
            return false;
        }
        playingPieces[row][col] = playingPiece;
        return true;
    }

    public List<Pair<Integer, Integer>> getFreeCells() {
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (playingPieces[i][j] == null) {
                    Pair<Integer, Integer> rowColumn = Pair.of(i,j);
                    freeCells.add(rowColumn);
                }
            }
        }

        return freeCells;
    }

    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (playingPieces[i][j] != null) {
                    System.out.print(playingPieces[i][j].piece.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }


}
