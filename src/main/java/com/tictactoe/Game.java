package com.tictactoe;

import java.util.Scanner;

public class Game {
    private static final Scanner scan = new Scanner(System.in);
    private static final String ENDGAME_TEMPLATE = "\nCreated by Shreyas Saha. Thanks for playing!";

    protected void userInput(char[] gameField){
        byte input;
        while (true) {
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (gameField[input - 1] == 'X' || gameField[input - 1] == 'O')
                    System.out.println("That one is already in use. Enter another.");
                else {
                    gameField[input - 1] = 'X';
                    break;
                }
            }
            else
                System.out.println("Invalid input. Enter again.");
        }
    }

    protected void computerMove(char[] gameField){
        byte rand;
        while (true) {
            rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (gameField[rand - 1] != 'X' && gameField[rand - 1] != 'O') {
                gameField[rand - 1] = 'O';
                break;
            }
        }
    }

    protected GameStatus userWin(char[] gameField){
        if(Game.isWin(gameField)){
            return GameStatus.WON;
        }
        else return GameStatus.DRAW;
    }

    protected GameStatus isDraw(char[] gameField){
        boolean boxAvailable = false;
        for(byte i=0; i<9; i++){
            if(gameField[i] != 'X' && gameField[i] != 'O'){
                boxAvailable = true;
                break;
            }
        }
        if(!boxAvailable){
            return GameStatus.DRAW;
        }
        else return GameStatus.WON;
    }

    protected GameStatus userLose(char[] gameField){
        if(isWin(gameField)){
            return GameStatus.LOST;
        }else return GameStatus.DRAW;
    }

    protected static boolean isWin(char[] gameField){
        return (gameField[0]=='O' && gameField[1]=='O' && gameField[2]=='O') ||  //first string
                (gameField[3]=='O' && gameField[4]=='O' && gameField[5]=='O') || //second string
                (gameField[6]=='O' && gameField[7]=='O' && gameField[8]=='O') || //third string
                (gameField[0]=='O' && gameField[3]=='O' && gameField[6]=='O') || //first row
                (gameField[1]=='O' && gameField[4]=='O' && gameField[7]=='O') || //second row
                (gameField[2]=='O' && gameField[5]=='O' && gameField[8]=='O') || //third row
                (gameField[0]=='O' && gameField[4]=='O' && gameField[8]=='O') || //left diagonal
                (gameField[2]=='O' && gameField[4]=='O' && gameField[6]=='O');   //right diagonal
    }

    protected void winningStatus(GameStatus gameStatus){
        switch(gameStatus){
            case WON -> System.out.println("You won the game!"+ ENDGAME_TEMPLATE);
            case LOST -> System.out.println("You lost the game!"+ ENDGAME_TEMPLATE);
            case DRAW -> System.out.println("It's a draw!"+ ENDGAME_TEMPLATE);
        }
    }

    enum GameStatus {
        WON,
        LOST,
        DRAW
    }

    protected void game(char[] gameField){
        boolean boxEmpty = false;
        while (true) {
            Box.boxDrawing();
            if(!boxEmpty){
                for(byte i = 0; i < 9; i++)
                    gameField[i] = ' ';
                boxEmpty = true;
            }

            userInput(gameField);
        }
    }
}
