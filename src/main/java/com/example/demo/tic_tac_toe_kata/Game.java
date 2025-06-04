package com.example.demo.tic_tac_toe_kata;

public class Game {
    private final char[][] board = new char[3][3];
    private char lastPlayer = 'X';
    private char winner = 'X';

    public void play(char player, int x, int y) {
        if (lastPlayer == player) {
            throw new IllegalStateException("You can't play more than one player");
        }

        if (x < 0 || x >= board.length) {
            throw new IllegalStateException("x out of bounds");
        }

        if (y < 0 || y >= board.length) {
            throw new IllegalStateException("y out of bounds");
        }

        board[x][y] = player;
        this.lastPlayer = player;
    }

    public char lastPlayer() {
        return lastPlayer;
    }

    public char[][] board() {
        return this.board;
    }

    public char winner() {
        return winner;
    }
}
