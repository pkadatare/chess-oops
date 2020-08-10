package com.technogize.chess.model.pieces;

import com.technogize.chess.model.Piece;
import com.technogize.chess.model.Position;
import com.technogize.chess.validation.Validator;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class King implements Piece {

  @Override
  public Set<Position> getPossiblePositions(Position start) {

    return IntStream.rangeClosed(-1, 1)
        .mapToObj(i -> IntStream.rangeClosed(-1, 1)
        .mapToObj(j -> new Position(start.getX() + i, start.getY() + j))
        .collect(Collectors.toList()))
        .flatMap(Collection::stream)
        .filter(position -> !position.equals(start))
        .filter(Validator::validPosition)
        .collect(Collectors.toSet());
  }
}
