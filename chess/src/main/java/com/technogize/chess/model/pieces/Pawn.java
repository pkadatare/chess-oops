package com.technogize.chess.model.pieces;

import com.technogize.chess.model.Board;
import com.technogize.chess.model.Piece;
import com.technogize.chess.model.Position;
import java.util.HashSet;
import java.util.Set;


public class Pawn implements Piece {

  @Override
  public Set<Position> getPossiblePositions(Position start) {
    Set<Position> set = new HashSet<>();
    if (start.getX() > Board.BOARD_MIN_INDEX) {
      set.add(new Position(start.getX()-1, start.getY()));
    }
    return set;
  }
}
