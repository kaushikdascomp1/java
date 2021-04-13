package com.interview.java.designpatterns.chessgame;

import java.util.List;

public class Game {

    public Player[] players;
    public Board board;
    public Player currentTurn;
    public GameStatus gameStatus;
    public List<Move> movesPlayed;

    public Game(){
        Player p1 = new Player(true);
        Player p2 = new Player(false);
        initialize(p1,p2);
    }

    public void initialize(Player p1, Player p2){
        players[0] = p1;
        players[1] = p2;
        board.initializeBoard();

        if(p1.isWhiteSide()){
            this.currentTurn = p1;
        }else {
            this.currentTurn = p2;
        }
        movesPlayed.clear();
    }

    public boolean playerMove(Player player, int startX, int startY, int endX, int endY) throws Exception{
       Box startPos = board.getBox(startX,startY);
       Box endPos = board.getBox(endX, endY);
       Move move = new Move(player,startPos,endPos);
       return this.makeMove(move,player);
    }

    public boolean makeMove(Move move, Player player) throws Exception{
        Piece sourcePiece = move.getStart().getPiece();

        if(sourcePiece == null)
            return false;
        if(player != currentTurn)
            return false;
        //Validations to check if current piece to move and player should be same
        if(sourcePiece.isWhite() != player.isWhiteSide())
            return false;

        if(!sourcePiece.canMove(board,move.getStart(),move.getEnd())){
            return false;
        }

        //kill?
        Piece destPiece = move.getEnd().getPiece();
        if(destPiece != null){
            destPiece.setKilled(true);
            move.setPieceKilled(destPiece);
        }

        //castling?
        if(sourcePiece != null && sourcePiece instanceof King && !move.isCaslingMove()){
            move.setCaslingMove(true);
        }
        //store the move
        movesPlayed.add(move);
        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);

        if(destPiece != null && destPiece instanceof King){
            if (player.isWhiteSide()){
                this.gameStatus = GameStatus.WHITE_WIN;
            }else {
                this.gameStatus = GameStatus.BLACK_WIN;
            }
        }

        //change player turn
        if(this.currentTurn == players[0]){
            currentTurn = players[1];
        }else
            currentTurn = players[0];

        return true;
    }
}
