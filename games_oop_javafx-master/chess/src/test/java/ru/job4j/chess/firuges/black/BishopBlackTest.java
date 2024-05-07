package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    void whenPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C8);
        assertThat(bishopBlack.position()).isEqualTo(Cell.C8);

    }

    @Test
    void whenCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.D4);
        bishopBlack.copy(Cell.D4);
        assertThat(bishopBlack.position()).isEqualTo(Cell.D4);
    }

    @Test
    void whenWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] exception = new Cell[]{Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(bishopBlack.way(Cell.G5)).isEqualTo(exception);
    }

    @Test
    void whenDiagonal() {
        BishopBlack diagonal = new BishopBlack(Cell.B1);
        assertThrows(ImpossibleMoveException.class,
                () -> diagonal.way(Cell.D1));
    }
}