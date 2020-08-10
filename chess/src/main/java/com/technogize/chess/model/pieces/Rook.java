package com.technogize.chess.model.pieces;

import com.technogize.chess.model.Piece;
import com.technogize.chess.model.Position;
import com.technogize.chess.util.MovementUtil;
import java.util.Set;

public class Rook implements Piece {

  @Override
  public Set<Position> getPossiblePositions(Position start) {
    return MovementUtil
        .getMoves(position -> !position.equals(start) && position.isLiesOnAxis(start));
  }

}
