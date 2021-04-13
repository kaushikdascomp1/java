package com.interview.java.designpatterns.chessgame;

import lombok.Data;

@Data
public class Move {

    private Player player;
    private Box start;
    private Box end;
    private Piece pieceMoved;
    private Piece pieceKilled;
    private boolean isCaslingMove = false;

    public Move(Player player, Box start, Box end){
        this.player = player;
        this.start = start;
        this.end = end;
        this.pieceMoved = start.getPiece();
    }

    public boolean isCaslingMove(){
        return this.isCaslingMove;
    }

    public void setCaslingMove(boolean caslingMove){
        this.isCaslingMove = caslingMove;
    }
}
