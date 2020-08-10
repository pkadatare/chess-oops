package com.technogize.chess.validation;

import static com.technogize.chess.model.Board.BOARD_SIZE;
import static com.technogize.chess.util.MovementUtil.ALPHA_INDEXES;
import static com.technogize.chess.util.MovementUtil.NUMERIC_INDEXES;

import com.technogize.chess.model.Board;
import com.technogize.chess.model.Position;
import com.technogize.chess.model.Spot;
import org.springframework.util.StringUtils;

public class Validator {

  private Validator(){

  }

  public static void validateInput(String input) {
    if (StringUtils.isEmpty(input)) {
      throw new IllegalArgumentException("Empty or Null string");
    }
    if (!input.contains(" ")) {
      throw new IllegalArgumentException("Not a valid space separated input");
    }

  }

  public static void validate(String[] tokens) {
    if (tokens.length != 2) {
      throw new IllegalArgumentException("Not a valid input");
    }
    if (!ALPHA_INDEXES.contains(tokens[1].charAt(0))) {
      throw new IllegalArgumentException("Not a valid X index");
    }
    if (!NUMERIC_INDEXES.contains(tokens[1].charAt(1))) {
      throw new IllegalArgumentException("Not a valid Y index");
    }
  }

  public static boolean validPosition(Position position) {
    return (position.getX() >= Board.BOARD_MIN_INDEX && position.getX() < BOARD_SIZE)
        && (position.getY() >= Board.BOARD_MIN_INDEX && position.getY() < BOARD_SIZE);
  }

  public static void validate(Spot spot) {
    if (!isCellPositionValid(spot.getPosition().getX()) ||
        !isCellPositionValid(spot.getPosition().getY())) {
      throw new IllegalArgumentException("Not a valid cell position");
    }
    if (!spot.getPiece().isPresent()) {
      throw new IllegalArgumentException("Piece is not present");
    }
  }

  private static boolean isCellPositionValid(int index) {
    return index >= 0 && index < BOARD_SIZE;
  }

}
