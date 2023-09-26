package com.tictactoe;

public class App {

    private static void gameInitiation(){
        System.out.println("Enter box number to select. Enjoy!\n");
        Box.boxDrawing();
    }

    public static void main(String[] args) {
        gameInitiation();

    }
}