package com.interview.java.designpatterns.chessgame;

public class Board {

    Box boxes[][];

    public Box getBox(int x, int y) throws Exception{
        if(x < 0 || x > 7 || y < 0 || y > 7)
            throw new Exception("Index out of bound exception");
        return boxes[x][y];
    }

    public Board(){
        this.initializeBoard();
    }

    public void initializeBoard(){
        // You need to look from the side direction and think like you are controlling the game
        //In that case X will be Y and Y will be X
        boxes[0][0] = new Box(0,0,new Rook(true));
        boxes[0][1] = new Box(0,1, new Knight(true));
        //Similarly fill other boxes
        //for empty boxes where there should not be any piece pass the value of piece as null
    }

}
