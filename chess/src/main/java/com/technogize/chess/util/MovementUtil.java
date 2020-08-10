package com.technogize.chess.util;

import static com.technogize.chess.model.Board.BOARD_MIN_INDEX;
import static com.technogize.chess.model.Board.BOARD_SIZE;

import com.technogize.chess.model.Position;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MovementUtil {

  public static final List<Character> ALPHA_INDEXES = Arrays
      .asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H');
  public static final List<Character> NUMERIC_INDEXES = Arrays
      .asList('8', '7', '6', '5', '4', '3', '2', '1');

  private MovementUtil() {

  }

  public static Set<Position> getMoves(Predicate<Position> predicate) {
    return IntStream.rangeClosed(BOARD_MIN_INDEX, BOARD_SIZE-1)
        .mapToObj(i -> IntStream.rangeClosed(BOARD_MIN_INDEX, BOARD_SIZE-1)
            .mapToObj(j -> new Position(i, j))
            .collect(Collectors.toList()))
        .flatMap(Collection::stream)
        .filter(predicate)
        .collect(Collectors.toSet());
  }

}
