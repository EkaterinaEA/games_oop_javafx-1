package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.swing.text.Position;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    private static final String SEPARATOR = System.getProperty("line.separator");

    @Test
    public void position() {
        BishopBlack figure = new BishopBlack(Cell.A4);
        Cell expected = figure.position();
        assertThat(expected, is(Cell.A4));
    }

    @Test
    public void copy() {
        BishopBlack figure = new BishopBlack(Cell.A4);
        Figure copyFigure = figure.copy(Cell.A1);
        assertThat(copyFigure.position(), is(Cell.A1));
    }

    @Test
    public void way() {
        BishopBlack figure = new BishopBlack(Cell.C1);
        Cell[] way = figure.way(figure.position(), Cell.G5);
        Cell[] expected = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(way, is(expected));
    }

    @Test
    public void wayDiagonalIsNotPossible() throws IllegalStateException {
        BishopBlack figure = new BishopBlack(Cell.C1);
        Throwable thrown = assertThrows(IllegalStateException.class, () -> {
            Cell[] way = figure.way(figure.position(), Cell.G4);
        });
        assertNotNull(thrown.getMessage());
    }
}