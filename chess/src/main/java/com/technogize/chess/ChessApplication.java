package com.technogize.chess;

import com.technogize.chess.io.DriverService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChessApplication {

  public static void main(String[] args) {
    DriverService service = new DriverService();
    service.takeUserInput();
  }

}
