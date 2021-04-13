package com.interview.java.designpatterns.chessgame;

public class Bishop extends Piece {

    public Bishop(boolean white){
        super(white);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        if(!super.isValid(board,start,end))
            return false;

        //You cannot move in the end side if there already exists a piece of your color
        if(end.getPiece().isWhite() == this.isWhite())
            return false;
        //For Bishop can move only in diagonal direction
        // when x==y liner curve and no pieces should be present between them
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());

        if(x==y){
            //If no pieces are present between x and Y
            //Todo
            return true;
        }
        return false;
    }
}
