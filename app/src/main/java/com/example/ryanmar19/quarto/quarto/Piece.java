package com.example.ryanmar19.quarto.quarto;

import java.io.Serializable;

/**
 * class Piece
 * <p>
 * defines the characteristics of each playing piece in the game.
 *
 * @author Maggie Ryan
 * @author Elizabeth Moran
 * @author Lucy Davidson
 * @version April 2017
 */

public class Piece implements Serializable {

    // to support the Serializable interface
    private static final long serialVersionUID = 30672013L;

    //Instance Variables
    int pieceNum; //corresponds to it's spot in the bankPieces / pieceLib array in QuartoState
    String myImageId; //contains the Image name corresponding to it's MipMap name
    char color; //'b' for blue, 'y' for yellow
    char size; //'s' for small, 'l' for large
    char solidity; //'f' for filled, 'h' for hollow
    char shape; //'c' for circle, 's' for square

}
