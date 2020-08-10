package com.technogize.chess.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.technogize.chess.model.pieces.Bishop;
import com.technogize.chess.model.pieces.Horse;
import com.technogize.chess.model.pieces.King;
import com.technogize.chess.model.pieces.Pawn;
import com.technogize.chess.model.pieces.Queen;
import com.technogize.chess.model.pieces.Rook;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.Test;

class BoardTest {

  @Test
  public void testBoardInitialisation() {
    Board board = new Board();
    assertEquals(Board.BOARD_SIZE, board.cells.length);
    assertEquals(Board.BOARD_SIZE, board.cells[0].length);
  }

  @Test
  public void testBoardForCellIndexInputValidation() {
    Board board = new Board();
    Spot spot = new Spot(Optional.of(new Pawn()), new Position(0, 9));

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      board.getMoves(spot);
    });

    String expectedMessage = "Not a valid cell position";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  public void testBoardForPieceInputValidation() {
    Board board = new Board();
    Spot spot = new Spot(Optional.empty(), new Position(0, 7));

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      board.getMoves(spot);
    });

    String expectedMessage = "Piece is not present";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void testBoardForValidInput() {
    Board board = new Board();
    Spot spot = new Spot(Optional.of(new Pawn()), new Position(2, 6));
    Set<Position> positions = board.getMoves(spot);
    assertEquals(1, positions.size());
  }

  @Test
  void getInitialPositionHorseTestMove() {
    Board board = new Board();
    Spot spot = new Spot(Optional.of(new Horse()), new Position(2, 5));
    Set<Position> positions = board.getMoves(spot);
    assertEquals(8, positions.size());
  }


  @Test
  void getInitialPositionKingTestMove() {
    Board board = new Board();
    Spot spot = new Spot(Optional.of(new King()), new Position(4, 3));
    Set<Position> positions = board.getMoves(spot);
    assertEquals(8, positions.size());
  }

  @Test
  void getInitialPositionBishopTestMove() {
    Board board = new Board();
    Spot spot = new Spot(Optional.of(new Bishop()), new Position(4, 3));
    Set<Position> positions = board.getMoves(spot);
    assertEquals(13, positions.size());
  }

  @Test
  void getInitialPositionRookTestMove() {
    Board board = new Board();
    Spot spot = new Spot(Optional.of(new Rook()), new Position(4, 3));
    Set<Position> positions = board.getMoves(spot);
    assertEquals(14, positions.size());
  }

  @Test
  void getInitialPositionQueenTestMove() {
    Board board = new Board();
    Spot spot = new Spot(Optional.of(new Queen()), new Position(4, 3));
    Set<Position> positions = board.getMoves(spot);
    assertEquals(27, positions.size());
  }

}