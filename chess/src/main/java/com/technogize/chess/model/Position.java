package com.technogize.chess.model;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Position {

  private int x;
  private int y;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Position)) {
      return false;
    }
    Position position = (Position) o;
    return x == position.x &&
        y == position.y;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  public boolean isLiesOnDiagonal(int additionOfCoordinates, int differenceOfCoordinate){
    return (additionOfCoordinates == this.getX() + this.getY()) ||
        differenceOfCoordinate == this.getX() - this.getY();
  }
  public boolean isLiesOnAxis(Position start){
    return this.getX() == start.getX() || this.getY() == start.getY();
  }
}
