package com.example.demo.tic_tac_toe_kata;

import java.util.Arrays;
import java.util.Objects;

public class Board {
    private final int[][] board;

    public Board() {
        this.board = new int[3][3];
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Board board1)) return false;
        return Objects.deepEquals(board, board1.board);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(board);
    }

    public int length() {
        return board.length;
    }
}
