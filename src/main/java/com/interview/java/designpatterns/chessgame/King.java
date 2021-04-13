package com.interview.java.designpatterns.chessgame;

public class King extends Piece {

    boolean castlingDone = false;

    public King(boolean white){
        super(white);
    }

    public boolean isCastlingDone(){
        return this.castlingDone;
    }

    public void setCastlingDone(boolean castlingDone){
        this.castlingDone = castlingDone;
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        if(!super.isValid(board,start,end))
            return false;
        //Start is the position where the current piece of King is now located
        //End is the position where the king needs to locate to, the end position
        if(end.getPiece().isWhite() == this.isWhite())
            return false;

        //calculate the X and Y ordinates
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());

        //Moving in 4 sides up, down, left, right
        if(x+y == 1 && end.getPiece() != null)
            return true;
        //Moving diagonal and can capture black pieces also
        if (x+y == 2 && end.getPiece() != null && end.getPiece().isWhite() == false)
            return true;
        return false;
    }
}
