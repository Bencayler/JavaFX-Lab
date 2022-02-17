package edu.sdccd.cisc191;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

/**
 * Extends the basic JavaFX Label with game functionality
 */
public class GameBoardLabel extends Label {
    public static Insets LABEL_PADDING = new Insets(20);

    public GameBoardLabel() {
        // TODO: set Label properties like padding == Complete, if not, you get the idea
        setPadding(LABEL_PADDING);
        setFont(Font.font(20));


    }
}