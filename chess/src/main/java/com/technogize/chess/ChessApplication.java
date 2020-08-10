package com.technogize.chess;

import com.technogize.chess.io.IOService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChessApplication {

  public static void main(String[] args) {
    IOService service = new IOService();
    service.takeUserInput();
  }

}
