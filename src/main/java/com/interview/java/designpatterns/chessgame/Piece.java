package com.interview.java.designpatterns.chessgame;

public abstract class Piece {

    private boolean isWhite;
    private boolean isKilled;

    public Piece(boolean white){
        this.setWhite(white);
    }

    public boolean isKilled(){
        return isKilled;
    }

    public boolean isWhite(){
        return isWhite;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public abstract boolean canMove(Board board, Box start, Box end);

    public boolean isValid(Board board, Box start, Box end){
        if(start.getX() == end.getX() && start.getY() == end.getY())
            return false;
        if((start.getX() < 0 || start.getX() > 7) || (end.getX() < 0 || end.getX() > 7) || (start.getY() < 0 || start.getY() > 7) || (end.getY() < 0 || end.getY() > 7))
            return false;
        return true;
    }
}
