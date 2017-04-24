package com.example.ryanmar19.quarto;

import com.example.ryanmar19.quarto.game.Game;
import com.example.ryanmar19.quarto.game.GameComputerPlayer;
import com.example.ryanmar19.quarto.game.GamePlayer;
import com.example.ryanmar19.quarto.game.infoMsg.GameInfo;
import com.example.ryanmar19.quarto.game.infoMsg.GameState;
import com.example.ryanmar19.quarto.quarto.Piece;
import com.example.ryanmar19.quarto.quarto.QuartoClaimVictoryAction;
import com.example.ryanmar19.quarto.quarto.QuartoPickPieceAction;
import com.example.ryanmar19.quarto.quarto.QuartoState;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class QuartoStateTest {
/*
    @Test
    public void testPickPieceAction() throws Exception {
        *//*QuartoState state = new QuartoState();
        QuartoPickPieceAction action = new QuartoPickPieceAction();
        action.pickedPiece = state.pieces[0];
        state.PickPieceAction(action);
        boolean blah = state.pickedPiece.equals(state.pieces[0]);
        *//*
    }

    @Test
    public void testPlacePieceAction() throws Exception {

    }

    @Test
    public void testClaimVictoryAction() throws Exception {
        QuartoState state = new QuartoState();
        QuartoClaimVictoryAction action = new QuartoClaimVictoryAction();

        state.setBoardPiece(state.pieces[0],0,0);
        state.setBoardPiece(state.pieces[1],0,1);
        state.setBoardPiece(state.pieces[2],0,2);
        state.setBoardPiece(state.pieces[3],0,3);
        boolean blah = state.ClaimVictoryAction(action);
        assertTrue(blah);
    }

    @Test
    public void testGetPlayerId() throws Exception {
        QuartoState state = new QuartoState();

    }

    @Test
    public void setPlayerId() throws Exception {

    }

    @Test
    public void getTurn() throws Exception {

    }

    @Test
    public void changeTurn() throws Exception {

    }

    @Test
    public void testGetBankPiece() throws Exception {
        QuartoState state = new QuartoState();
        Piece piece1 = state.getBankPiece(0);
        Piece piece2 = state.pieces[0];

        assertEquals(piece1, piece2);
    }

    @Test
    public void testGetBoardPiece() throws Exception {
        QuartoState state = new QuartoState();
        state.boardPieces[0][0] = state.pieces[0];
        Piece piece = state.getBoardPiece(0,0);
        assertEquals(piece, state.pieces[0]);
    }

    @Test
    public void setBoardPiece() throws Exception {
        QuartoState state = new QuartoState();
        state.setBoardPiece(state.pieces[0],0,0);
        assertEquals(state.boardPieces[0][0], state.pieces[0]);
    }

    @Test
    public void testGetPieceId() throws Exception {
        QuartoState state = new QuartoState();
        int num = state.getPieceId(state.pieces[0]);
        assertEquals(num,0);
    }

    @Test
    public void getPieceColor() throws Exception {
        QuartoState state = new QuartoState();
        char c = state.getPieceColor(state.pieces[0]);
        assertEquals('b',c);
    }

    @Test
    public void getPieceSize() throws Exception {

    }

    @Test
    public void getPieceShape() throws Exception {

    }

    @Test
    public void getPieceSolidity() throws Exception {

    }*/

}