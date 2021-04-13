package com.interview.java.designpatterns.chessgame;

import lombok.Data;

@Data
public class Box {

    private Piece piece;
    private int x;
    private int y;

    public Box(int x, int y, Piece piece){
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public Piece getPiece(){
        return this.piece;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
