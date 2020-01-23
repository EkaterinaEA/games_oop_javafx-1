package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Test
    public void moveTrue() {
        BishopBlack figure = new BishopBlack(Cell.C1);
        Logic logic = new Logic();
        logic.add(figure);
        boolean actual = logic.move(Cell.C1, Cell.G5);
        Assert.assertTrue(actual);
    }

    @Test
    public void moveFalse() {
        BishopBlack figure = new BishopBlack(Cell.C1);
        BishopBlack obstacle = new BishopBlack(Cell.E3);
        Logic logic = new Logic();
        logic.add(figure);
        logic.add(obstacle);
        boolean actual = new Logic().move(Cell.C1, Cell.G5);
        System.out.println(actual);
        Assert.assertFalse(actual);
    }
}