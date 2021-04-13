package com.interview.java.designpatterns.chessgame;

public class Knight extends Piece {

    public Knight(boolean white){
        super(white);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        if(!super.isValid(board,start,end))
            return false;


        if(end.getPiece().isWhite() == this.isWhite())
            return false;

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        if(x*y == 2)
            return true;
        return false;
    }
}
