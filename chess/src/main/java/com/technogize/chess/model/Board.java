package com.technogize.chess.model;

import static com.technogize.chess.validation.Validator.validate;

import java.util.Set;

public class Board {

  public static final int BOARD_SIZE = 8;
  public static final int BOARD_MIN_INDEX = 0;
  Spot[][] cells;

  public Board() {
    cells = new Spot[BOARD_SIZE][BOARD_SIZE];
  }

  public Set<Position> getMoves(Spot spot) {
    validate(spot);
    return spot.getPiece().get().getPossiblePositions(spot.getPosition());
  }

}
