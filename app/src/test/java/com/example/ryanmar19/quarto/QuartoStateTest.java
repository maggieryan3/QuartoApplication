package com.example.ryanmar19.quarto;

import com.example.ryanmar19.quarto.game.Game;
import com.example.ryanmar19.quarto.game.GameComputerPlayer;
import com.example.ryanmar19.quarto.game.GamePlayer;
import com.example.ryanmar19.quarto.game.infoMsg.GameInfo;
import com.example.ryanmar19.quarto.game.infoMsg.GameState;
import com.example.ryanmar19.quarto.quarto.Piece;
import com.example.ryanmar19.quarto.quarto.QuartoClaimVictoryAction;
import com.example.ryanmar19.quarto.quarto.QuartoHumanPlayer;
import com.example.ryanmar19.quarto.quarto.QuartoPickPieceAction;
import com.example.ryanmar19.quarto.quarto.QuartoPlayPieceAction;
import com.example.ryanmar19.quarto.quarto.QuartoState;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class QuartoStateTest {

    @Test
    public void testQuartoPickPieceAction() throws Exception {
        QuartoState state = new QuartoState();
        GamePlayer Maggie = new QuartoHumanPlayer("Maggie");
        QuartoPickPieceAction action = new QuartoPickPieceAction(Maggie, 3);
        state.PickPieceAction(action);
        boolean blah = state.pickedPiece.equals(state.bankPieces[3]);
        assertTrue(blah);
    }

    @Test
    public void testQuartoPlayPieceAction() throws Exception {
        QuartoState state = new QuartoState();
        GamePlayer Lucy = new QuartoHumanPlayer("Lucy");

        QuartoPickPieceAction action = new QuartoPickPieceAction(Lucy, 1);
        state.PickPieceAction(action);

        QuartoPlayPieceAction action2 = new QuartoPlayPieceAction(Lucy, 2, 2, 1);
        state.PlayPieceAction(action2);

        boolean blah = state.boardPieces[2][2].equals(state.pieceLib[1]);
        assertTrue(blah);
    }


    @Test
    public void testQuartoClaimVictoryAction() throws Exception {
        QuartoState state = new QuartoState();
        GamePlayer Liz = new QuartoHumanPlayer("Liz");

        state.boardPieces[0][0] = state.pieceLib[1];
        state.boardPieces[1][1] = state.pieceLib[2];
        state.boardPieces[2][2] = state.pieceLib[3];
        state.boardPieces[3][3] = state.pieceLib[4];

        QuartoClaimVictoryAction action = new QuartoClaimVictoryAction(Liz);
        state.ClaimVictoryAction(action);

        boolean blah = state.checkIfQuarto();
        assertTrue(blah);
    }
}