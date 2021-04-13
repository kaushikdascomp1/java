package com.interview.java.designpatterns.chessgame;

public class Rook extends Piece {

    public Rook(boolean white){
        super(white);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        if(!super.isValid(board,start,end))
            return false;

        //If either the Xaxis of From and to are same or the Y axis of from and to are same
        //Then rook can move

        if(start.getX() == end.getX() || start.getY() == end.getY())
            return true;

        return false;
    }
}
