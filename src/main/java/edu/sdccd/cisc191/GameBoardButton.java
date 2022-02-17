package edu.sdccd.cisc191;

import javafx.geometry.Insets;
import javafx.scene.control.Button;

/**
 * Extends the basic JavaFX Button with game functionality
 */
public class GameBoardButton extends Button {
    private int row;
    private int col;
    private boolean hasFish;
    private boolean isGuessed;
    public static Insets BUTTON_PADDING = new Insets(10);

    public GameBoardButton(int row, int col, boolean hasFish)
    {
        this.row = row;
        this.col = col;
        this.hasFish = hasFish;

        // TODO: set min/pref width, default text
        setText("?");
        setMaxSize(100, 100);
        setPrefSize(20, 10);
        // setPadding(BUTTON_PADDING);



    }

    public void handleClick() {
        // TODO: update text
        if(hasFish) {
            // TODO "<><"
            setText("<><");
        } else {
            // TODO "X"
            setText("X");
        }
        isGuessed = true;
        setDisabled(true);
    }
}