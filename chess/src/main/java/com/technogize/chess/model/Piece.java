package com.technogize.chess.model;

import java.util.Set;

public interface Piece {

  Set<Position> getPossiblePositions(Position position);

}
