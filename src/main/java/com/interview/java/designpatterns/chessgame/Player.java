package com.interview.java.designpatterns.chessgame;

import lombok.Data;

@Data
public class Player {

    boolean whiteSide = false;
    public Player(boolean whiteSide){
        this.whiteSide = whiteSide;
    }
}
