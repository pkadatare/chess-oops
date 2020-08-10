package com.technogize.chess.factory;

import com.technogize.chess.model.Piece;
import com.technogize.chess.model.pieces.Bishop;
import com.technogize.chess.model.pieces.Horse;
import com.technogize.chess.model.pieces.King;
import com.technogize.chess.model.pieces.Pawn;
import com.technogize.chess.model.pieces.Queen;
import com.technogize.chess.model.pieces.Rook;

public class PieceFactory {

    private static PieceFactory pieceFactory = new PieceFactory();

    private PieceFactory() {
    }

    public static Piece getPiece(String piece) {
        Piece player;
        switch (piece) {
            case "Queen":
                player = new Queen();
                break;
            case "King":
                player = new King();
                break;
            case "Bishop":
                player = new Bishop();
                break;
            case "Rook":
                player = new Rook();
                break;
            case "Horse":
                player = new Horse();
                break;
            case "Pawn":
                player = new Pawn();
                break;
            default:
                throw new IllegalArgumentException("Not a valid input");
        }
        return player;
    }

    public static PieceFactory getInstance() {
        return pieceFactory;
    }
}
