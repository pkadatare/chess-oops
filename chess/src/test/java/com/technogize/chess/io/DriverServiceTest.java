package com.technogize.chess.io;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.technogize.chess.model.Spot;
import com.technogize.chess.model.pieces.King;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class DriverServiceTest {

  DriverService service = new DriverService();


  @Test
  void inputValidationForInvalidPiece() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      service.getInitialPosition("Kid D5");
    });

    String expectedMessage = "Not a valid input";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void inputValidationForInvalidPositionY() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      service.getInitialPosition("Kid D9");
    });

    String expectedMessage = "Not a valid Y index";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void inputValidationForInvalidPositionX() {
    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      service.getInitialPosition("Kid K5");
    });

    String expectedMessage = "Not a valid X index";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  void getInitialPosition() {
    Spot spot = service.getInitialPosition("King A5");
    assertEquals(3,spot.getPosition().getX());
    assertEquals(0,spot.getPosition().getY());
    assertTrue(spot.getPiece().isPresent());
    assertTrue(spot.getPiece().get() instanceof King);
  }

  @Test
  void processUserInput() {
    Set<String> spot = service.processUserInput("Pawn D5");
    assertEquals(1, spot.size());
  }

  @Test
  void getInitialPositionPawnTestNoMove() {
    Set<String> output = service.processUserInput("Pawn E8");
    assertTrue(output.isEmpty());
  }

  @Test
  void getInitialPositionPawnTestMove() {
    Set<String> output = service.processUserInput("Pawn E7");
    assertEquals(1, output.size());
    assertTrue(output.contains("E8"));
  }

  @Test
  void getInitialPositionHorseTestMove() {
    Set<String> output = service.processUserInput("Horse E3");
    Set<String> expectedOutPut = new HashSet<>(Arrays.asList("F5",	"G4",	"G2",	"F1",	"D1",	"C2",	"C4",	"D5"));
    assertEquals(8, output.size());
    assertTrue(equals(output, expectedOutPut));
  }


  @Test
  void getInitialPositionKingTestMove() {
    Set<String> output = service.processUserInput("King D5");
    assertEquals(8, output.size());
    Set<String> expectedOutPut = new HashSet<>(Arrays.asList("D6","E6","E5","E4","D4","C4","C5","C6"));
    assertTrue(equals(output, expectedOutPut));
  }

  @Test
  void getInitialPositionBishopTestMove() {
    Set<String> output = service.processUserInput("Bishop D5");
    assertEquals(13, output.size());
  }

  @Test
  void getInitialPositionRookTestMove() {
    Set<String> output = service.processUserInput("Rook D5");
    assertEquals(14, output.size());
  }

  @Test
  void getInitialPositionQueenTestMove() {
    Set<String> output = service.processUserInput("Queen D5");
    assertEquals(27, output.size());
  }

  public static boolean equals(Set<?> set1, Set<?> set2){

    if(set1 == null || set2 ==null){
      return false;
    }

    if(set1.size()!=set2.size()){
      return false;
    }

    return set1.containsAll(set2);

  }
}