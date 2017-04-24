package com.example.ryanmar19.quarto.quarto;

import com.example.ryanmar19.quarto.game.infoMsg.GameState;

import java.io.Serializable;

/**
 * class QuartoState
 * <p>
 * is the class which contains all the information about the current state
 * of the game, (i.e. where the pieces are, whose turn it is, is the game over.)
 *
 * @author Maggie Ryan
 * @author Elizabeth Moran
 * @author Lucy Davidson
 * @version April 2017
 */

public class QuartoState extends GameState implements Serializable {

    // to support the Serializable interface
    private static final long serialVersionUID = 30672013L;

    //Variables
    Piece pieceLib[] = new Piece[16]; //Array of all pieces
    Piece bankPieces[] = new Piece[16]; //Array of pieces in bank
    Piece boardPieces[][] = new Piece[4][4]; //Array of pieces on board
    int turn; //playerId of whose turn it is
    boolean gameOver; //Whether or not the game is over
    boolean boardFull; //Whether or not the game board is full
    Piece pickedPiece;
    int numQuarto; //number of Quartos on board
    int previousNumQuarto; //tracks the number of Quartos from last turn

    //Basic Constructor
    public QuartoState() {
        //piece initialize
        //Blue Large Hollow Square
        pieceLib[0] = new Piece();
        pieceLib[0].color = 'b';
        pieceLib[0].size = 'l';
        pieceLib[0].solidity = 'h';
        pieceLib[0].shape = 's';
        pieceLib[0].pieceNum = 0;

        //Blue Large filled Square
        pieceLib[1] = new Piece();
        pieceLib[1].color = 'b';
        pieceLib[1].size = 'l';
        pieceLib[1].solidity = 'f';
        pieceLib[1].shape = 's';
        pieceLib[1].pieceNum = 1;

        //Blue Small Hollow Square
        pieceLib[2] = new Piece();
        pieceLib[2].color = 'b';
        pieceLib[2].size = 's';
        pieceLib[2].solidity = 'h';
        pieceLib[2].shape = 's';
        pieceLib[2].pieceNum = 2;

        //Blue Small filled Square
        pieceLib[3] = new Piece();
        pieceLib[3].color = 'b';
        pieceLib[3].size = 's';
        pieceLib[3].solidity = 'f';
        pieceLib[3].shape = 's';
        pieceLib[3].pieceNum = 3;

        //Yellow Large Hollow Square
        pieceLib[4] = new Piece();
        pieceLib[4].color = 'y';
        pieceLib[4].size = 'l';
        pieceLib[4].solidity = 'h';
        pieceLib[4].shape = 's';
        pieceLib[4].pieceNum = 4;

        //Yellow Large filled Square
        pieceLib[5] = new Piece();
        pieceLib[5].color = 'y';
        pieceLib[5].size = 'l';
        pieceLib[5].solidity = 'f';
        pieceLib[5].shape = 's';
        pieceLib[5].pieceNum = 5;

        //Yellow small hollow square
        pieceLib[6] = new Piece();
        pieceLib[6].color = 'y';
        pieceLib[6].size = 's';
        pieceLib[6].solidity = 'h';
        pieceLib[6].shape = 's';
        pieceLib[6].pieceNum = 6;

        //Yellow small filled square
        pieceLib[7] = new Piece();
        pieceLib[7].color = 'y';
        pieceLib[7].size = 's';
        pieceLib[7].solidity = 'f';
        pieceLib[7].shape = 's';
        pieceLib[7].pieceNum = 7;

        //Blue Large hollow circle
        pieceLib[8] = new Piece();
        pieceLib[8].color = 'b';
        pieceLib[8].size = 'l';
        pieceLib[8].solidity = 'h';
        pieceLib[8].shape = 'c';
        pieceLib[8].pieceNum = 8;

        //Blue Large filled Circle
        pieceLib[9] = new Piece();
        pieceLib[9].color = 'b';
        pieceLib[9].size = 'l';
        pieceLib[9].solidity = 'f';
        pieceLib[9].shape = 'c';
        pieceLib[9].pieceNum = 9;

        //Blue small hollow circle
        pieceLib[10] = new Piece();
        pieceLib[10].color = 'b';
        pieceLib[10].size = 's';
        pieceLib[10].solidity = 'h';
        pieceLib[10].shape = 'c';
        pieceLib[10].pieceNum = 10;

        //Blue small filled circle
        pieceLib[11] = new Piece();
        pieceLib[11].color = 'b';
        pieceLib[11].size = 's';
        pieceLib[11].solidity = 'f';
        pieceLib[11].shape = 'c';
        pieceLib[11].pieceNum = 11;

        //Yellow large hollow circle
        pieceLib[12] = new Piece();
        pieceLib[12].color = 'y';
        pieceLib[12].size = 'l';
        pieceLib[12].solidity = 'h';
        pieceLib[12].shape = 'c';
        pieceLib[12].pieceNum = 12;

        //Yellow large filled circle
        pieceLib[13] = new Piece();
        pieceLib[13].color = 'y';
        pieceLib[13].size = 'l';
        pieceLib[13].solidity = 'f';
        pieceLib[13].shape = 'c';
        pieceLib[13].pieceNum = 13;

        //Yellow small hollow circle
        pieceLib[14] = new Piece();
        pieceLib[14].color = 'y';
        pieceLib[14].size = 's';
        pieceLib[14].solidity = 'h';
        pieceLib[14].shape = 'c';
        pieceLib[14].pieceNum = 14;

        //Yellow small filled circle
        pieceLib[15] = new Piece();
        pieceLib[15].color = 'y';
        pieceLib[15].size = 's';
        pieceLib[15].solidity = 'f';
        pieceLib[15].shape = 'c';
        pieceLib[15].pieceNum = 15;

        //sets up ImageIds
        pieceLib[0].myImageId = "blue_large_hollow_square";
        pieceLib[1].myImageId = "blue_large_solid_square";
        pieceLib[2].myImageId = "blue_small_hollow_square";
        pieceLib[3].myImageId = "blue_small_solid_square";
        pieceLib[4].myImageId = "yellow_large_hollow_square";
        pieceLib[5].myImageId = "yellow_large_solid_square";
        pieceLib[6].myImageId = "yellow_small_hollow_square";
        pieceLib[7].myImageId = "yellow_small_solid_square";
        pieceLib[8].myImageId = "blue_large_hollow_circle";
        pieceLib[9].myImageId = "blue_large_solid_circle";
        pieceLib[10].myImageId = "blue_small_hollow_circle";
        pieceLib[11].myImageId = "blue_small_solid_circle";
        pieceLib[12].myImageId = "yellow_large_hollow_circle";
        pieceLib[13].myImageId = "yellow_large_solid_circle";
        pieceLib[14].myImageId = "yellow_small_hollow_circle";
        pieceLib[15].myImageId = "yellow_small_solid_circle";

        //board initializer
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                boardPieces[i][j] = new Piece();
                boardPieces[i][j] = null;
            }
        }

        //bank initializer
        for (int i = 0; i < 16; i++) {
            bankPieces[i] = new Piece();
            bankPieces[i] = pieceLib[i];
        }

        //turn: player 1 goes first
        turn = 1;

        //other variables
        gameOver = false;
        pickedPiece = null;
        boardFull = false;
        numQuarto = 0;
        previousNumQuarto = 0;

    }

    //Deep copies a QuartoState
    public QuartoState(QuartoState original) {

        //Board
        boardPieces = new Piece[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                boardPieces[i][j] = original.boardPieces[i][j];
            }
        }

        //Bank
        bankPieces = new Piece[16];
        for (int i = 0; i < 16; i++) {
            bankPieces[i] = original.bankPieces[i];
        }

        //Variable deep copies
        turn = original.turn;
        pickedPiece = original.pickedPiece;
        gameOver = original.gameOver;
        boardFull = original.boardFull;
        numQuarto = original.numQuarto;
        previousNumQuarto = original.previousNumQuarto;

    }

    //ACTION METHODS
    //method for PickPieceAction: makes the chosen piece the game state's "pickedPiece" variable
    public boolean PickPieceAction(QuartoPickPieceAction action) {
        if (action instanceof QuartoPickPieceAction) {
            if (this.pickedPiece == null) {
                this.turn = this.changeTurn();
                this.pickedPiece = pieceLib[action.pieceNum];
                previousNumQuarto = numQuarto;
                numQuarto = this.getNumQuarto();
                return true;
            }
        }
        return false;
    }

    //method for PlayPieceAction: adds played piece to boardPieces array and removes it from boardPieces array
    public boolean PlayPieceAction(QuartoPlayPieceAction action) {
        if (action instanceof QuartoPlayPieceAction) {
            if (pickedPiece != null) {
                boardPieces[action.x][action.y] = this.pickedPiece;
                bankPieces[pickedPiece.pieceNum] = null;
                this.pickedPiece = null;

                int boardNum = 0;
                //check if board is full
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        if (boardPieces[i][j] != null) {
                            boardNum = boardNum + 1;
                        }
                    }
                }
                if (boardNum == 16) {
                    boardFull = true;
                }

                return true;
            }
        }
        return false;
    }

    //method for ClaimVictoryAction
    public boolean ClaimVictoryAction(QuartoClaimVictoryAction action) {
        if (action instanceof QuartoClaimVictoryAction) {

            if (this.getNumQuarto() > 0) {
                //if the user just played a piece and got a quarto - they win
                if (pickedPiece == null) {
                    if (this.getNumQuarto() > numQuarto) {
                        gameOver = true;
                        return true;
                    }
                }
                //if user sees opponents missed quarto - they win
                if (pickedPiece != null) {
                    if (numQuarto > previousNumQuarto) {
                        gameOver = true;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //OTHER METHODS

    /**
     * Method to change game state's turn
     */
    public int changeTurn() {
        if (turn == 0) {
            turn = 1;
            return turn;
        }
        if (turn == 1) {
            turn = 0;
            return turn;
        }
        return -1;
    }

    /**
     * Method to check if there is a quarto
     */
    public Boolean checkIfQuarto() {
        //If any of pieces don't match then this value will be set to false.
        boolean colorEqual = true;
        boolean sizeEqual = true;
        boolean solidityEqual = true;
        boolean shapeEqual = true;

        //Loop through vertical column
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 3; y++) {

                //If both board Pieces aren't null, compare them
                if (boardPieces[x][y] != null && boardPieces[x][y + 1] != null) {
                    //If the color of is not equal then set colorEqual to false.
                    if (boardPieces[x][y].color != boardPieces[x][y + 1].color)
                        colorEqual = false;
                    //If the size is not equal then set sizeEqual to false.
                    if (boardPieces[x][y].size != boardPieces[x][y + 1].size)
                        sizeEqual = false;
                    //If the solidity is not equal then set solidityEqual to false.
                    if (boardPieces[x][y].solidity != boardPieces[x][y + 1].solidity)
                        solidityEqual = false;
                    //If the shape is not the same then set shapeEqual to false.
                    if (boardPieces[x][y].shape != boardPieces[x][y + 1].shape)
                        shapeEqual = false;
                } else {
                    colorEqual = false;
                    shapeEqual = false;
                    solidityEqual = false;
                    sizeEqual = false;
                }
            }
            //If the column we just checked has a Quarto then return. Otherwise check the next column.
            if (colorEqual == true || sizeEqual == true || solidityEqual == true || shapeEqual == true) {
                return true;
            } else {
                colorEqual = true;
                sizeEqual = true;
                solidityEqual = true;
                shapeEqual = true;
            }
        }

        //Loop through the horizontal rows.
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 3; x++) {

                if (boardPieces[x][y] != null && boardPieces[x + 1][y] != null) {
                    //compares color
                    if (boardPieces[x][y].color != boardPieces[x + 1][y].color)
                        colorEqual = false;
                    //compares size
                    if (boardPieces[x][y].size != boardPieces[x + 1][y].size)
                        sizeEqual = false;
                    //compares solidity
                    if (boardPieces[x][y].solidity != boardPieces[x + 1][y].solidity)
                        solidityEqual = false;
                    //compares shape
                    if (boardPieces[x][y].shape != boardPieces[x + 1][y].shape)
                        shapeEqual = false;
                } else {
                    colorEqual = false;
                    sizeEqual = false;
                    solidityEqual = false;
                    shapeEqual = false;
                }
            }
            //If the row we just checked has a Quarto then return. Otherwise check the next row.
            if (colorEqual == true || sizeEqual == true || solidityEqual == true || shapeEqual == true) {
                return true;
            } else {
                colorEqual = true;
                sizeEqual = true;
                solidityEqual = true;
                shapeEqual = true;
            }
        }

        //Cross - bottom left to top right
        //(0,0) (1,1) (2,2) (3,3)
        for (int i = 0; i < 3; i++) {
            if (boardPieces[i][i] != null && boardPieces[i + 1][i + 1] != null) {
                //compares color
                if (boardPieces[i][i].color != boardPieces[i + 1][i + 1].color)
                    colorEqual = false;
                //compares size
                if (boardPieces[i][i].size != boardPieces[i + 1][i + 1].size)
                    sizeEqual = false;
                //compares solidity
                if (boardPieces[i][i].solidity != boardPieces[i + 1][i + 1].solidity)
                    solidityEqual = false;
                //compares shape
                if (boardPieces[i][i].shape != boardPieces[i + 1][i + 1].shape)
                    shapeEqual = false;
            } else {
                colorEqual = false;
                shapeEqual = false;
                solidityEqual = false;
                sizeEqual = false;
            }
        }
        //If the diagonal we just checked has a Quarto then return.
        if (colorEqual == true || sizeEqual == true || solidityEqual == true || shapeEqual == true) {
            return true;
        }

        //Cross - top left to bottom right.
        //(3,0) (2,1) (1,2) (0,3)
        colorEqual = true;
        sizeEqual = true;
        solidityEqual = true;
        shapeEqual = true;

        int y = 0;
        for (int x = 3; x > 0; x--) {
            //Check if the pieces exist.
            if (boardPieces[x][y] != null && boardPieces[x - 1][y + 1] != null) {
                //Check color.
                if (boardPieces[x][y].color != boardPieces[x - 1][y + 1].color)
                    colorEqual = false;

                //compares size
                if (boardPieces[x][y].size != boardPieces[x - 1][y + 1].size)
                    sizeEqual = false;

                //compares solidity
                if (boardPieces[x][y].solidity != boardPieces[x - 1][y + 1].solidity)
                    solidityEqual = false;

                //compares shape
                if (boardPieces[x][y].shape != boardPieces[x - 1][y + 1].shape)
                    shapeEqual = false;

                y++;
            } else {
                colorEqual = false;
                shapeEqual = false;
                solidityEqual = false;
                sizeEqual = false;
            }
        }
        //If the diagonal we just checked has a Quarto then return.
        if (colorEqual == true || sizeEqual == true || solidityEqual == true || shapeEqual == true) {
            return true;
        }
        return false;
    }

    public int getNumQuarto() {
        //If any of pieces don't match then this value will be set to false.
        boolean colorEqual = true;
        boolean sizeEqual = true;
        boolean solidityEqual = true;
        boolean shapeEqual = true;

        //Number of quartos we find
        int curNum = 0;

        //Loop through vertical column
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 3; y++) {

                //If both board Pieces aren't null, compare them
                if (boardPieces[x][y] != null && boardPieces[x][y + 1] != null) {
                    //If the color of is not equal then set colorEqual to false.
                    if (boardPieces[x][y].color != boardPieces[x][y + 1].color)
                        colorEqual = false;
                    //If the size is not equal then set sizeEqual to false.
                    if (boardPieces[x][y].size != boardPieces[x][y + 1].size)
                        sizeEqual = false;
                    //If the solidity is not equal then set solidityEqual to false.
                    if (boardPieces[x][y].solidity != boardPieces[x][y + 1].solidity)
                        solidityEqual = false;
                    //If the shape is not the same then set shapeEqual to false.
                    if (boardPieces[x][y].shape != boardPieces[x][y + 1].shape)
                        shapeEqual = false;
                } else {
                    colorEqual = false;
                    shapeEqual = false;
                    solidityEqual = false;
                    sizeEqual = false;
                }
            }
            //If the column we just checked has a Quarto then return. Otherwise check the next column.
            if (colorEqual == true || sizeEqual == true || solidityEqual == true || shapeEqual == true) {
                curNum = curNum + 1;
            } else {
                colorEqual = true;
                sizeEqual = true;
                solidityEqual = true;
                shapeEqual = true;
            }
        }

        //Loop through the horizontal rows.
        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 3; x++) {

                if (boardPieces[x][y] != null && boardPieces[x + 1][y] != null) {
                    //compares color
                    if (boardPieces[x][y].color != boardPieces[x + 1][y].color)
                        colorEqual = false;
                    //compares size
                    if (boardPieces[x][y].size != boardPieces[x + 1][y].size)
                        sizeEqual = false;
                    //compares solidity
                    if (boardPieces[x][y].solidity != boardPieces[x + 1][y].solidity)
                        solidityEqual = false;
                    //compares shape
                    if (boardPieces[x][y].shape != boardPieces[x + 1][y].shape)
                        shapeEqual = false;
                } else {
                    colorEqual = false;
                    sizeEqual = false;
                    solidityEqual = false;
                    shapeEqual = false;
                }
            }
            //If the row we just checked has a Quarto then return. Otherwise check the next row.
            if (colorEqual == true || sizeEqual == true || solidityEqual == true || shapeEqual == true) {
                curNum = curNum + 1;
            } else {
                colorEqual = true;
                sizeEqual = true;
                solidityEqual = true;
                shapeEqual = true;
            }
        }

        //Cross - bottom left to top right
        //(0,0) (1,1) (2,2) (3,3)
        for (int i = 0; i < 3; i++) {
            if (boardPieces[i][i] != null && boardPieces[i + 1][i + 1] != null) {
                //compares color
                if (boardPieces[i][i].color != boardPieces[i + 1][i + 1].color)
                    colorEqual = false;
                //compares size
                if (boardPieces[i][i].size != boardPieces[i + 1][i + 1].size)
                    sizeEqual = false;
                //compares solidity
                if (boardPieces[i][i].solidity != boardPieces[i + 1][i + 1].solidity)
                    solidityEqual = false;
                //compares shape
                if (boardPieces[i][i].shape != boardPieces[i + 1][i + 1].shape)
                    shapeEqual = false;
            } else {
                colorEqual = false;
                shapeEqual = false;
                solidityEqual = false;
                sizeEqual = false;
            }
        }
        //If the diagonal we just checked has a Quarto then return.
        if (colorEqual == true || sizeEqual == true || solidityEqual == true || shapeEqual == true) {
            curNum = curNum + 1;
        }

        //Cross - top left to bottom right.
        //(3,0) (2,1) (1,2) (0,3)
        colorEqual = true;
        sizeEqual = true;
        solidityEqual = true;
        shapeEqual = true;

        int y = 0;
        for (int x = 3; x > 0; x--) {
            //Check if the pieces exist.
            if (boardPieces[x][y] != null && boardPieces[x - 1][y + 1] != null) {
                //Check color.
                if (boardPieces[x][y].color != boardPieces[x - 1][y + 1].color)
                    colorEqual = false;

                //compares size
                if (boardPieces[x][y].size != boardPieces[x - 1][y + 1].size)
                    sizeEqual = false;

                //compares solidity
                if (boardPieces[x][y].solidity != boardPieces[x - 1][y + 1].solidity)
                    solidityEqual = false;

                //compares shape
                if (boardPieces[x][y].shape != boardPieces[x - 1][y + 1].shape)
                    shapeEqual = false;

                y++;
            } else {
                colorEqual = false;
                shapeEqual = false;
                solidityEqual = false;
                sizeEqual = false;
            }
        }
        //If the diagonal we just checked has a Quarto then return.
        if (colorEqual == true || sizeEqual == true || solidityEqual == true || shapeEqual == true) {
            curNum = curNum + 1;
        }
        return curNum;
    }

}

