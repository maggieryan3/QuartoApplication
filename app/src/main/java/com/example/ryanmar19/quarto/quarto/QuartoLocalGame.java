package com.example.ryanmar19.quarto.quarto;

import com.example.ryanmar19.quarto.game.GamePlayer;
import com.example.ryanmar19.quarto.game.LocalGame;
import com.example.ryanmar19.quarto.game.actionMsg.GameAction;

import java.io.Serializable;

import static android.os.SystemClock.sleep;

/**
 * class QuartoLocalGame
 * <p>
 * is the class that plays the game by passing information contained
 * in the Quarto state from player to player.
 *
 * @author Maggie Ryan
 * @author Elizabeth Moran
 * @author Lucy Davidson
 * @version April 2017
 */

public class QuartoLocalGame extends LocalGame {

    // the game's state
    protected QuartoState state;

    /**
     * Constructor for the QuartoLocalGame.
     */
    public QuartoLocalGame() {

        // perform superclass initialization
        super();

        // create a new, unfilled-in QuartoState object
        state = new QuartoState();
    }

    /**
     * Notify the given player that its state has changed.
     *
     * @param p the player to notify
     */
    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        // make a copy of the state, and send it to the player
        p.sendInfo(new QuartoState(state));
    }

    /**
     * Tell whether the given player is allowed to make a move at the
     * present point in the game.
     *
     * @param playerIdx the player's player-number (ID)
     * @return true if the player is allowed to move and false otherwise
     */
    @Override
    protected boolean canMove(int playerIdx) {
        if (playerIdx == state.turn) {
            return true;
        }
        return false;
    }

    /**
     * Check if the game is over. It is over, return a string that tells
     * who the winner(s), if any, are. If the game is not over, return null.
     *
     * @return a message that tells who has won the game, or null if the game is not over
     */
    @Override
    protected String checkIfGameOver() {
        if (state.boardFull == true) {
            QuartoClaimVictoryAction winAction = new QuartoClaimVictoryAction(this.players[state.turn]);
            state.ClaimVictoryAction(winAction);
            this.sendUpdatedStateTo(players[0]);
            this.sendUpdatedStateTo(players[1]);
            if (state.gameOver == true) {
                return this.playerNames[state.turn] + " has won!";
            } else {
                this.sendUpdatedStateTo(players[0]);
                this.sendUpdatedStateTo(players[1]);
                return "Tie!";
            }
        } else if (state.gameOver == true) {
            this.sendUpdatedStateTo(players[0]);
            this.sendUpdatedStateTo(players[1]);
            return this.playerNames[state.turn] + " has won!";
        }
        return null;
    }

    /**
     * Makes a move on behalf of a player.
     *
     * @param action The move that the player has sent to the game
     * @return Tells whether the move was a legal one.
     */
    @Override
    protected boolean makeMove(GameAction action) {
        if (action instanceof QuartoPickPieceAction) {
            state.PickPieceAction((QuartoPickPieceAction) action);
            this.sendUpdatedStateTo(players[0]);
            this.sendUpdatedStateTo(players[1]);
            return true;
        }
        if (action instanceof QuartoPlayPieceAction) {
            state.PlayPieceAction((QuartoPlayPieceAction) action);
            this.sendUpdatedStateTo(players[0]);
            this.sendUpdatedStateTo(players[1]);
            return true;
        }
        if (action instanceof QuartoClaimVictoryAction) {
            state.ClaimVictoryAction((QuartoClaimVictoryAction) action);
            if (state.ClaimVictoryAction((QuartoClaimVictoryAction) action) == true) {
                this.checkIfGameOver();
            }
            this.sendUpdatedStateTo(players[0]);
            this.sendUpdatedStateTo(players[1]);
            return true;
        }
        return false;
    }
}
