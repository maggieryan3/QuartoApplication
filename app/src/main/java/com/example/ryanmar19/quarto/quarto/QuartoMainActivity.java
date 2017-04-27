package com.example.ryanmar19.quarto.quarto;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ToggleButton;

import com.example.ryanmar19.quarto.R;
import com.example.ryanmar19.quarto.game.GameMainActivity;
import com.example.ryanmar19.quarto.game.GamePlayer;
import com.example.ryanmar19.quarto.game.LocalGame;
import com.example.ryanmar19.quarto.game.config.GameConfig;
import com.example.ryanmar19.quarto.game.config.GamePlayerType;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * class QuartoMainActivity
 * <p>
 * is the main class which functions as the creator of the game.
 *
 * @author Andrew M. Nuxoll
 * @author Steven R. Vegdahl
 * @author Maggie Ryan
 * @author Elizabeth Moran
 * @author Lucy Davidson
 * @version April 2017
 */
public class QuartoMainActivity extends GameMainActivity {

    // the port number that this game will use when playing over the network
    private static final int PORT_NUMBER = 2234;

    /**
     * Create the default configuration for this game:
     * - one human player vs. one computer player
     * - minimum of 1 player, maximum of 2
     * - one kind of computer player and one kind of human player available
     *
     * @return the new configuration object, representing the default configuration
     */
    @Override
    public GameConfig createDefaultConfig() {

        // Define the allowed player types
        ArrayList<GamePlayerType> playerTypes = new ArrayList<GamePlayerType>();

        // a human player player type (player type 0)
        playerTypes.add(new GamePlayerType("Local Human Player") {
            public GamePlayer createPlayer(String name) {
                return new QuartoHumanPlayer(name);
            }
        });

        // a computer player type (player type 1)
        playerTypes.add(new GamePlayerType("Dumb Computer Player") {
            public GamePlayer createPlayer(String name) {
                return new QuartoComputerPlayer1(name);
            }
        });

        // a computer player type (player type 2)
        playerTypes.add(new GamePlayerType("Smart Computer Player") {
            public GamePlayer createPlayer(String name) {
                return new QuartoComputerPlayer2(name);
            }
        });

        // Create a game configuration class for Counter:
        // - player types as given above
        // - from 1 to 2 players
        // - name of game is "Counter Game"
        // - port number as defined above
        GameConfig defaultConfig = new GameConfig(playerTypes, 2, 2, "Quarto Game",
                PORT_NUMBER);

        // Add the default players to the configuration
        defaultConfig.addPlayer("Human", 0); // player 0: a human player
        defaultConfig.addPlayer("Computer", 1); // player 1: a computer player

        // Set the default remote-player setup:
        // - player name: "Remote Player"
        // - IP code: (empty string)
        // - default player type: human player
        defaultConfig.setRemoteData("Remote Player", "", 0);

        // return the configuration
        return defaultConfig;
    }//createDefaultConfig

    /**
     * create a local game
     *
     * @return the local game, a counter game
     */
    @Override
    public LocalGame createLocalGame() {
        return new QuartoLocalGame();
    }

}