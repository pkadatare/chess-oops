package com.technogize.chess.model;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Spot {

  private Optional<Piece> piece;
  private Position position;
}
