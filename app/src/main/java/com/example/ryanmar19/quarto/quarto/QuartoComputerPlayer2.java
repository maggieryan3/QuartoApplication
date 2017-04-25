package com.example.ryanmar19.quarto.quarto;

import com.example.ryanmar19.quarto.game.GameComputerPlayer;
import com.example.ryanmar19.quarto.game.infoMsg.GameInfo;

import java.io.Serializable;

/**
 * class QuartoComputerPlayer2
 * <p>
 * is the computer player that is our smart AI. Functions as an opponent to
 * the human player, or to another computer player.
 *
 * @author Maggie Ryan
 * @author Elizabeth Moran
 * @author Lucy Davidson
 * @version April 2017
 */

public class QuartoComputerPlayer2 extends GameComputerPlayer {

    // to support the Serializable interface
    private static final long serialVersionUID = 30672013L;

    /**
     * constructor for QuartoComputerPlayer2
     *
     * @param name the name of the player
     */
    public QuartoComputerPlayer2(String name) {
        // invoke superclass constructor
        super(name);
    }

    /**
     * Callback-method implemented in the subclass whenever updated
     * state is received.
     *
     * @param info the object representing the information from the game
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // if it's not a QuartoState message, ignore it; otherwise
        // cast it
        if (!(info instanceof QuartoState)) return;
        QuartoState myState = (QuartoState) info;

        // if it's not our move, ignore it
        if (myState.turn != this.playerNum) return;

        // If pieckedPiece is not null, find where to play the piece by
        // placing it on every open space on the board one by one and checking
        // if that makes a quarto. If it does, play it and call quarto.
        // If there is no winning path with the selected piece, place it randomly.
        if (myState.pickedPiece != null) {
            boolean playedPiece = false;
            sleep(1000);
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 4; y++) {
                    if (myState.boardPieces[x][y] == null) {
                        myState.boardPieces[x][y] = myState.pickedPiece;
                        if (myState.checkIfQuarto() == true) {
                            myState.boardPieces[x][y] = null;
                            QuartoPlayPieceAction action = new QuartoPlayPieceAction(this, x, y, myState.pickedPiece.pieceNum);
                            game.sendAction(action);
                            QuartoClaimVictoryAction win = new QuartoClaimVictoryAction(this);
                            game.sendAction(win);
                            return;
                        } else {
                            myState.boardPieces[x][y] = null;
                        }
                    }
                }
            }
            // if there is no winning quarto path, pick x and y positions at random (0-3)
            do {
                int xVal = (int) (4 * Math.random());
                int yVal = (int) (4 * Math.random());
                if (myState.boardPieces[xVal][yVal] == null) {
                    QuartoPlayPieceAction action = new QuartoPlayPieceAction(this, xVal, yVal, myState.pickedPiece.pieceNum);
                    game.sendAction(action);
                    return;
                }
            } while (playedPiece == false);
        }
        // If picked piece is null, loop through pieces in the bank and place it
        // on every open spot on the board to check if it makes a quarto. If not,
        // pick it. If it does, try another piece. If all pieces will result in a quarto,
        // pick a random piece.
        else if (myState.pickedPiece == null) {
            sleep(1000);
            for (int i = 0; i < 16; i++) {
                boolean goodPiece = true;
                if (myState.bankPieces[i] != null) {
                    for (int x = 0; x < 4; x++) {
                        for (int y = 0; y < 4; y++) {
                            if (myState.boardPieces[x][y] == null) {
                                myState.boardPieces[x][y] = myState.bankPieces[i];
                                if (myState.checkIfQuarto() == true) {
                                    myState.boardPieces[x][y] = null;
                                    goodPiece = false;
                                } else {
                                    myState.boardPieces[x][y] = null;
                                }
                            }
                        }
                    }
                    if (goodPiece == true) {
                        QuartoPickPieceAction action = new QuartoPickPieceAction(this, myState.bankPieces[i].pieceNum);
                        game.sendAction(action);
                        return;
                    }
                }
            }
            // if all pieces will result in a quarto, pick at random
            boolean pickedPiece = false;
            do {
                int ranVal = (int) (15 * Math.random());
                if (myState.bankPieces[ranVal] != null) {
                    QuartoPickPieceAction action = new QuartoPickPieceAction(this, ranVal);
                    game.sendAction(action);
                    return;
                }
            } while (pickedPiece == false);
        }
    }
}


