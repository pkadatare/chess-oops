package com.technogize.chess.factory;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.technogize.chess.model.pieces.Bishop;
import com.technogize.chess.model.pieces.Horse;
import com.technogize.chess.model.pieces.King;
import com.technogize.chess.model.pieces.Pawn;
import com.technogize.chess.model.pieces.Queen;
import com.technogize.chess.model.pieces.Rook;
import java.util.Objects;
import org.junit.jupiter.api.Test;

class PieceFactoryTest {

  @Test
  public void testGetInstance() {

    assertTrue(Objects.nonNull(PieceFactory.getInstance()));
  }


  @Test
  public void testGetPieceForInputValidation() {

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      PieceFactory.getPiece("Dummy");
    });

    String expectedMessage = "Not a valid input";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  public void testForKing() {
    assertTrue(PieceFactory.getPiece("King") instanceof King, "Should return a King object");
  }

  @Test
  public void testForQueen() {
    assertTrue(PieceFactory.getPiece("Queen") instanceof Queen, "Should return a Queen object");
  }

  @Test
  public void testForBishop() {
    assertTrue(PieceFactory.getPiece("Bishop") instanceof Bishop, "Should return a Bishop object");
  }

  @Test
  public void testForRook() {
    assertTrue(PieceFactory.getPiece("Rook") instanceof Rook, "Should return a Rook object");
  }

  @Test
  public void testForHorse() {
    assertTrue(PieceFactory.getPiece("Horse") instanceof Horse, "Should return a Horse object");
  }

  @Test
  public void testForPawn() {
    assertTrue(PieceFactory.getPiece("Pawn") instanceof Pawn, "Should return a King object");
  }



}