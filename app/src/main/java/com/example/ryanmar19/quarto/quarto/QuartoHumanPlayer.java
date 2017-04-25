package com.example.ryanmar19.quarto.quarto;


import android.graphics.Color;
import android.graphics.Point;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ryanmar19.quarto.R;
import com.example.ryanmar19.quarto.game.GameHumanPlayer;
import com.example.ryanmar19.quarto.game.GameMainActivity;
import com.example.ryanmar19.quarto.game.infoMsg.GameInfo;
import com.example.ryanmar19.quarto.game.infoMsg.NotYourTurnInfo;

/**
 * class QuartoHumanPlayer
 * <p>
 * is the human player which interacts with the user interface to play the game.
 *
 * @author Maggie Ryan
 * @author Elizabeth Moran
 * @author Lucy Davidson
 * @version April 2017
 */

public class QuartoHumanPlayer extends GameHumanPlayer implements View.OnClickListener {
    /* instance variables */
    // the most recent game state, as given to us by the QuartoLocalGame
    private QuartoState state;

    // the android activity that we are running
    private GameMainActivity myActivity;

    //board surface view
    SurfaceView boardSurfaceView;

    //bankSurfaceView
    SurfaceView bankSurfaceView;

    //array of bank piece images
    ImageView pieces[] = new ImageView[16];

    //array of board piece images
    ImageView boardImages[][] = new ImageView[4][4];

    //button declarations
    Button myQuartoButton;
    TextView userMessage;

    //bank image declarations
    ImageView bluelargehollowsquare;
    ImageView bluelargefilledsquare;
    ImageView bluesmallhollowsquare;
    ImageView bluesmallfilledsquare;
    ImageView yellowlargehollowsquare;
    ImageView yellowlargefilledsquare;
    ImageView yellowsmallhollowsquare;
    ImageView yellowsmallfilledsquare;
    ImageView bluelargehollowcircle;
    ImageView bluelargefilledcircle;
    ImageView bluesmallhollowcircle;
    ImageView bluesmallfilledcircle;
    ImageView yellowlargehollowcircle;
    ImageView yellowlargefilledcircle;
    ImageView yellowsmallhollowcircle;
    ImageView yellowsmallfilledcircle;

    //board image declarations - # corresponds to xy position
    ImageView board00;
    ImageView board01;
    ImageView board02;
    ImageView board03;
    ImageView board10;
    ImageView board11;
    ImageView board12;
    ImageView board13;
    ImageView board20;
    ImageView board21;
    ImageView board22;
    ImageView board23;
    ImageView board30;
    ImageView board31;
    ImageView board32;
    ImageView board33;

    /**
     * constructor
     *
     * @param name the player's name
     */
    public QuartoHumanPlayer(String name) {
        super(name);
    }

    /**
     * Returns the GUI's top view object
     *
     * @return the top object in the GUI's view heirarchy
     */
    public View getTopView() {
        return null;
    }

    /**
     * callback method when we get a message (e.g., from the game)
     *
     * @param info the message
     */
    @Override
    public void receiveInfo(GameInfo info) {
        // if it was a "not your turn" message, just ignore it
        if (info instanceof NotYourTurnInfo) return;

        // ignore the message if it's not a CounterState message
        if (!(info instanceof QuartoState)) return;

        // update our state; then update the display
        this.state = (QuartoState) info;

        //if game over update textView
        if (state.gameOver == true || state.boardFull == true) {
            userMessage.setText("GAME OVER!");
            bankSurfaceView.invalidate();
        }

        /**
         External Citation
         Date: 20 March 2017
         Problem: Did not know how to dynamically change ImageView image resource
         Resource:
         http://stackoverflow.com/questions/8642823/using-setimagedrawable-
         dynamically-to-set-image-in-an-imageview
         Solution: I used the example code from this post.
         */
        //update board when AI plays a piece
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (state.boardPieces[i][j] != null) {
                    int ID = myActivity.getResources().getIdentifier(state.boardPieces[i][j].myImageId, "mipmap", myActivity.getPackageName());
                    boardImages[i][j].setImageResource(ID);
                }
            }
        }
        //update bank when AI places a piece
        for (int i = 0; i < 16; i++) {
            if (state.bankPieces[i] == null) {
                pieces[i].setImageBitmap(null);
                boardSurfaceView.invalidate();
                bankSurfaceView.invalidate();
            }
        }

        //highlight piece when AI picks a piece for human
        if (state.pickedPiece != null && state.turn == this.playerNum) {
            pieces[state.pickedPiece.pieceNum].setColorFilter(Color.argb(100, 0, 0, 0)); //Tint
            userMessage.setText("PLAY THE SELECTED PIECE");
            boardSurfaceView.invalidate();
            bankSurfaceView.invalidate();
        }
    }

    /**
     * Implements GUI
     *
     * @param activity instance of a GameMainActivity
     */
    @Override
    public void setAsGui(GameMainActivity activity) {

        if (state != null) {
            receiveInfo(state);
        }

        // remember the activity
        myActivity = activity;

        // Load the layout resource for our GUI
        activity.setContentView(R.layout.activity_main);

        //board and bank SV
        boardSurfaceView = (SurfaceView) myActivity.findViewById(R.id.board);
        bankSurfaceView = (SurfaceView) myActivity.findViewById(R.id.sideboard);

        //button setup
        myQuartoButton = (Button) myActivity.findViewById(R.id.theQuartoButton);
        userMessage = (TextView) myActivity.findViewById(R.id.userMessage);

        //pieces setup
        bluelargehollowsquare = (ImageView) myActivity.findViewById(R.id.bluelargehollowsquare);
        bluelargefilledsquare = (ImageView) myActivity.findViewById(R.id.bluelargefilledsquare);
        bluesmallhollowsquare = (ImageView) myActivity.findViewById(R.id.bluesmallhollowsquare);
        bluesmallfilledsquare = (ImageView) myActivity.findViewById(R.id.bluesmallfilledsquare);
        yellowlargehollowsquare = (ImageView) myActivity.findViewById(R.id.yellowlargehollowsquare);
        yellowlargefilledsquare = (ImageView) myActivity.findViewById(R.id.yellowlargefilledsquare);
        yellowsmallhollowsquare = (ImageView) myActivity.findViewById(R.id.yellowsmallhollowsquare);
        yellowsmallfilledsquare = (ImageView) myActivity.findViewById(R.id.yellowsmallfilledsquare);
        bluelargehollowcircle = (ImageView) myActivity.findViewById(R.id.bluelargehollowcircle);
        bluelargefilledcircle = (ImageView) myActivity.findViewById(R.id.bluelargefilledcircle);
        bluesmallhollowcircle = (ImageView) myActivity.findViewById(R.id.bluesmallhollowcircle);
        bluesmallfilledcircle = (ImageView) myActivity.findViewById(R.id.bluesmallfilledcircle);
        yellowlargehollowcircle = (ImageView) myActivity.findViewById(R.id.yellowlargehollowcircle);
        yellowlargefilledcircle = (ImageView) myActivity.findViewById(R.id.yellowlargefilledcircle);
        yellowsmallhollowcircle = (ImageView) myActivity.findViewById(R.id.yellowsmallhollowcircle);
        yellowsmallfilledcircle = (ImageView) myActivity.findViewById(R.id.yellowsmallfilledcircle);

        //put bank ImageViews into array
        pieces[0] = bluelargehollowsquare;
        pieces[1] = bluelargefilledsquare;
        pieces[2] = bluesmallhollowsquare;
        pieces[3] = bluesmallfilledsquare;
        pieces[4] = yellowlargehollowsquare;
        pieces[5] = yellowlargefilledsquare;
        pieces[6] = yellowsmallhollowsquare;
        pieces[7] = yellowsmallfilledsquare;
        pieces[8] = bluelargehollowcircle;
        pieces[9] = bluelargefilledcircle;
        pieces[10] = bluesmallhollowcircle;
        pieces[11] = bluesmallfilledcircle;
        pieces[12] = yellowlargehollowcircle;
        pieces[13] = yellowlargefilledcircle;
        pieces[14] = yellowsmallhollowcircle;
        pieces[15] = yellowsmallfilledcircle;

        //board ImageViews
        board00 = (ImageView) myActivity.findViewById(R.id.b00);
        board01 = (ImageView) myActivity.findViewById(R.id.b01);
        board02 = (ImageView) myActivity.findViewById(R.id.b02);
        board03 = (ImageView) myActivity.findViewById(R.id.b03);
        board10 = (ImageView) myActivity.findViewById(R.id.b10);
        board11 = (ImageView) myActivity.findViewById(R.id.b11);
        board12 = (ImageView) myActivity.findViewById(R.id.b12);
        board13 = (ImageView) myActivity.findViewById(R.id.b13);
        board20 = (ImageView) myActivity.findViewById(R.id.b20);
        board21 = (ImageView) myActivity.findViewById(R.id.b21);
        board22 = (ImageView) myActivity.findViewById(R.id.b22);
        board23 = (ImageView) myActivity.findViewById(R.id.b23);
        board30 = (ImageView) myActivity.findViewById(R.id.b30);
        board31 = (ImageView) myActivity.findViewById(R.id.b31);
        board32 = (ImageView) myActivity.findViewById(R.id.b32);
        board33 = (ImageView) myActivity.findViewById(R.id.b33);

        //board[][]
        boardImages[0][0] = board00;
        boardImages[0][1] = board01;
        boardImages[0][2] = board02;
        boardImages[0][3] = board03;
        boardImages[1][0] = board10;
        boardImages[1][1] = board11;
        boardImages[1][2] = board12;
        boardImages[1][3] = board13;
        boardImages[2][0] = board20;
        boardImages[2][1] = board21;
        boardImages[2][2] = board22;
        boardImages[2][3] = board23;
        boardImages[3][0] = board30;
        boardImages[3][1] = board31;
        boardImages[3][2] = board32;
        boardImages[3][3] = board33;

        //button listeners
        myQuartoButton.setOnClickListener(this);

        userMessage.setText("Waiting for Opponent...");

        //bank/board listeners
        for (int i = 0; i < 16; i++) {
            pieces[i].setOnClickListener(this);
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                boardImages[i][j].setOnClickListener(this);
                boardImages[i][j].setImageBitmap(null);
            }
        }
    }

    /**
     * Invoked whenever the player presses a button
     */
    @Override
    public void onClick(View v) {
        if (state.turn != this.playerNum) {
            return;
        }

        int buttonSelection = v.getId();
        //QUARTO button
        if (buttonSelection == R.id.theQuartoButton) {
            QuartoClaimVictoryAction action = new QuartoClaimVictoryAction(this);
            game.sendAction(action);
        }


        //board placement
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int bPiece = boardImages[i][j].getId();
                if (buttonSelection == bPiece && state.pickedPiece != null && state.boardPieces[i][j] == null) {
                    int ID = myActivity.getResources().getIdentifier(state.pickedPiece.myImageId, "mipmap", myActivity.getPackageName());
                    boardImages[i][j].setImageResource(ID);
                    pieces[state.pickedPiece.pieceNum].setImageBitmap(null);
                    pieces[state.pickedPiece.pieceNum].setBackgroundColor(0x00000000);
                    userMessage.setText("PICK A PIECE FOR YOUR OPPONENT");
                    boardSurfaceView.invalidate();
                    bankSurfaceView.invalidate();
                    QuartoPlayPieceAction action = new QuartoPlayPieceAction(this, i, j, state.pickedPiece.pieceNum);
                    game.sendAction(action);
                }
            }
        }

        //image selections
        for (int i = 0; i < 16; i++) {
            int piece = pieces[i].getId();
            if (buttonSelection == piece) {
                if (state.pickedPiece == null && state.bankPieces[i] != null) {
                    ImageView myImage = (ImageView) v;
                    myImage.setColorFilter(Color.argb(100, 0, 0, 0)); //Tint
                    userMessage.setText("Waiting for Opponent...");
                    boardSurfaceView.invalidate();
                    bankSurfaceView.invalidate();
                    QuartoPickPieceAction action = new QuartoPickPieceAction(this, i);
                    game.sendAction(action);
                }
            }
        }
    }
}
