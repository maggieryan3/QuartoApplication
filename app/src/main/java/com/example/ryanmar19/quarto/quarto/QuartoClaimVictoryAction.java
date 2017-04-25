package com.example.ryanmar19.quarto.quarto;

import com.example.ryanmar19.quarto.game.GamePlayer;
import com.example.ryanmar19.quarto.game.actionMsg.GameAction;

/**
 * class QuartoClaimVictoryAction
 * <p>
 * is an action class which is used to create an object which defines the action
 * where the player can win the game.
 *
 * @author Maggie Ryan
 * @author Elizabeth Moran
 * @author Lucy Davidson
 * @version April 2017
 */

public class QuartoClaimVictoryAction extends GameAction {

    // to support the Serializable interface
    private static final long serialVersionUID = 30672013L;

    /**
     * constructor for QuartoClaimVictoryAction
     *
     * @param player the player who created the action
     */
    public QuartoClaimVictoryAction(GamePlayer player) {
        super(player);
    }
}
