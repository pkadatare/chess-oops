package com.technogize.chess.model.pieces;

import static com.technogize.chess.validation.Validator.validPosition;

import com.technogize.chess.model.Piece;
import com.technogize.chess.model.Position;
import java.util.HashSet;
import java.util.Set;

public class Horse implements Piece {

  @Override
  public Set<Position> getPossiblePositions(Position start) {
    Set<Position> moves = new HashSet<>();
    addIfValidPosition(moves, new Position(start.getX() + 1, start.getY() + 2));
    addIfValidPosition(moves, new Position(start.getX() + 2, start.getY() + 1));
    addIfValidPosition(moves, new Position(start.getX() + 2, start.getY() - 1));
    addIfValidPosition(moves, new Position(start.getX() + 1, start.getY() - 2));
    addIfValidPosition(moves, new Position(start.getX() - 1, start.getY() - 2));
    addIfValidPosition(moves, new Position(start.getX() - 2, start.getY() - 1));
    addIfValidPosition(moves, new Position(start.getX() - 2, start.getY() + 1));
    addIfValidPosition(moves, new Position(start.getX() - 1, start.getY() + 2));
    return moves;
  }

  private void addIfValidPosition(Set<Position> moves, Position position) {
    if (validPosition(position)) {
      moves.add(position);
    }
  }

}
