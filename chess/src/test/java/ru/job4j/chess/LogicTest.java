package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class,
                () -> {
                    logic.move(Cell.C1, Cell.H6);
                });

        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    void whenNotFree() throws OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A5));
        logic.add(new PawnBlack(Cell.B4));
        OccupiedCellException exception = assertThrows(OccupiedCellException.class,
                () -> {
                    logic.move(Cell.A5, Cell.B4);
                });
        assertThat(exception.getMessage()).isEqualTo("There is another figure on the way");
    }

}