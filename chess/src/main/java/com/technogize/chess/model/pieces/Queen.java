package com.technogize.chess.model.pieces;

import com.technogize.chess.model.Piece;
import com.technogize.chess.model.Position;
import com.technogize.chess.util.MovementUtil;
import java.util.Set;
import java.util.function.Predicate;

public class Queen implements Piece {

  @Override
  public Set<Position> getPossiblePositions(Position start) {

    int additionOfCoordinates = start.getX() + start.getY();
    int differenceOfCoordinate = start.getX() - start.getY();
    return MovementUtil.getMoves(getPositionPredicate(additionOfCoordinates,
        differenceOfCoordinate, start));
  }

  private Predicate<Position> getPositionPredicate(int additionOfCoordinates,
      int differenceOfCoordinate, Position start) {
    return position -> !position.equals(start)
        && (position.isLiesOnDiagonal(additionOfCoordinates, differenceOfCoordinate)
          || position.isLiesOnAxis(start));
  }
}
