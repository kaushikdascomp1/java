package com.interview.java.designpatterns.chessgame;

public class Queen extends Piece {

    public Queen(boolean white){
        super(white);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        if(!super.isValid(board,start,end)){
            return false;
        }

        //Queen can move both in diagonal direction as well as in straight direction
        //Possesses characters of rook and bishop
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());

        if(x == y)
            return true;
        if(start.getX() == end.getX() || start.getY() == end.getY())
            return true;

        return false;
    }
}
