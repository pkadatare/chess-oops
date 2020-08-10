package com.technogize.chess.io;

import static com.technogize.chess.util.MovementUtil.ALPHA_INDEXES;
import static com.technogize.chess.util.MovementUtil.NUMERIC_INDEXES;
import static com.technogize.chess.validation.Validator.validate;
import static com.technogize.chess.validation.Validator.validateInput;

import com.technogize.chess.factory.PieceFactory;
import com.technogize.chess.model.Board;
import com.technogize.chess.model.Piece;
import com.technogize.chess.model.Position;
import com.technogize.chess.model.Spot;
import java.util.Collections;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

@Slf4j
public class DriverService {

  public static final String SPACE = " ";
  private boolean isContinue = true;
  private Board board;
  private static Scanner sc = new Scanner(System.in);

  public DriverService() {
    board = new Board();
  }

  public void takeUserInput() {
    while (isContinue) {
      log.info("\nPlease enter current piece and position. Eg. King D5");
      String input = sc.nextLine();
      log.info("Your input is : " + input);
      try {
        Set<String> output = processUserInput(input);

        log.info("Your output is : " +
            output.stream().collect(Collectors.joining(",")));
        log.info("\nFor continue press 1 else press 0");
        isContinue = (1 == sc.nextInt());
        sc.nextLine();
      } catch (Exception e) {
        log.error("Exception occurred please enter valid input", e.getMessage());
      }

    }
  }

  public Set<String> processUserInput(String input) {
    Spot initialSpot = getInitialPosition(input);
    Set<Position> spots = board.getMoves(initialSpot);
    return getFormattedPossibleMoves(spots);

  }

  private Set<String> getFormattedPossibleMoves(Set<Position> spots) {
    Set<String> output = Collections.emptySet();
    if (CollectionUtils.isEmpty(spots)) {
      log.info("The piece cannot move anywhere!");
    } else {
      output = spots.stream()
          .map(position -> ALPHA_INDEXES.get(position.getY()) +
              Character.toString(NUMERIC_INDEXES.get(position.getX())))
          .collect(Collectors.toSet());
    }
    return output;
  }

  public Spot getInitialPosition(String input) {
    validateInput(input);
    String[] tokens = input.split(SPACE);
    validate(tokens);
    Piece piece = PieceFactory.getPiece(tokens[0]);
    int y = ALPHA_INDEXES.indexOf(tokens[1].charAt(0));
    int x = NUMERIC_INDEXES.indexOf(tokens[1].charAt(1));
    return new Spot(Optional.of(piece), new Position(x, y));
  }

}
