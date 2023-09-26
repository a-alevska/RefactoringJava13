package com.tictactoe;

public class Box {
    private static final char[] gameField = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    protected static void boxDrawing(){
        System.out.println();
        for(byte i = 0; i < 2; i++){
            System.out.printf("%n %s | %s | %s %n", gameField[i*3], gameField[i*3+1], gameField[i*3+2]);
            System.out.print("-----------");
        }
        System.out.printf("%n %s | %s | %s %n", gameField[6], gameField[7], gameField[8]);
    }

    protected static boolean isBoxEmpty(){
        return false;
    }

}
