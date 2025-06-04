package com.example.demo.tic_tac_toe_kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {


    @Test
    void testGameCanNotRepeatTurn() {
        Game game = new Game();

        assertThrows(IllegalStateException.class,
                () -> game.play('X', 0, 0));
    }

    @Test
    void testCantPlayOutOfTheBoard() {
        Game game = new Game();

        assertThrows(IllegalStateException.class,
                () -> game.play('X', 2, 2));
    }

    @Test
    void testWhenPlayerXDoUpLineFilledWins() {
        Game game = new Game();
        game.play('0', 1, 1);
        game.play('X', 0, 0);
        game.play('0', 2, 2);
        game.play('X', 0, 1);
        game.play('0', 2, 1);
        game.play('X', 0, 2);

        assertEquals('X', game.winner());
    }

    @Test
    void testWhenPlayerODoUpLineFilledWins() {
        Game game = new Game();
        game.play('0', 0, 0);
        game.play('X', 2, 2);
        game.play('0', 1, 0);
        game.play('X', 0, 1);
        game.play('0', 2, 0);
        game.play('X', 0, 2);

        assertEquals('O', game.winner());
    }
}

