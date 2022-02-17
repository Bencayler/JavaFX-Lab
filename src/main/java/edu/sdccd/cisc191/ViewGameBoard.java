package edu.sdccd.cisc191;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;

/**
 * Presents the user with the game graphical user interface
 */
public class ViewGameBoard extends Application
{
    private Canvas gameCanvas;
    private ControllerGameBoard controller;
    private GameBoardLabel fishRemaining;
    private GameBoardLabel guessesRemaining;
    private GameBoardLabel message;

    public static void main(String[] args)
    {
        // TODO: launch the app == Complete
        launch(args);
    }

    public void updateHeader() {
        //TODO update labels == Complete
        //"Fish: " + controller.modelGameBoard.getFishRemaining()
        fishRemaining.setText("Fish: " + controller.modelGameBoard.getFishRemaining());
        //"Bait: " + controller.modelGameBoard.getGuessesRemaining()
        guessesRemaining.setText("Bait: " + controller.modelGameBoard.getGuessesRemaining());
        if(controller.fishWin()) {
            //"Fishes win!"
            message.setText("Fishes win!");
        } else if(controller.playerWins()) {
            //"You win!"
            message.setText("You win!");
        } else {
            //"Find the fish!"
            message.setText("Find the fish!");
        }
    }
    @Override
    public void start(Stage stage) throws Exception {
        controller = new ControllerGameBoard();
        // TODO initialize gameCanvas == Maybe Complete? Who knows
        gameCanvas = new Canvas();

        fishRemaining = new GameBoardLabel();
        guessesRemaining = new GameBoardLabel();
        message = new GameBoardLabel();


        // TODO display game there are infinite ways to do this, I used BorderPane with HBox and VBox. == Maybe complete? not sure
        VBox rootBox = new VBox();
        HBox labelBox = new HBox(fishRemaining, guessesRemaining, message);
        labelBox.setAlignment(Pos.TOP_CENTER);
        rootBox.getChildren().add(labelBox);

        updateHeader();

        for (int row=0; row < ModelGameBoard.DIMENSION; row++) {
            // TODO: create row container
            HBox rowBox = new HBox();
            rowBox.setSpacing(10);

            for (int col=0; col < ModelGameBoard.DIMENSION; col++) {
                GameBoardButton button = new GameBoardButton(row, col, controller.modelGameBoard.fishAt(row,col));

                button.setMaxWidth(100);
                button.setMaxHeight(50);
                button.setPrefSize(15, 10);

                rowBox.getChildren().add(button);


                int finalRow = row;
                int finalCol = col;

                button.setOnAction(e -> {
                    controller.makeGuess(finalRow, finalCol);
                    if(!controller.isGameOver()) {
                        button.handleClick();
                        updateHeader();
                    }
                });

            }

            // TODO: add row to column
            rowBox.setAlignment(Pos.CENTER);
            rootBox.setSpacing(10);
            rootBox.getChildren().add(rowBox);


        }

        // TODO: create scene, stage, set title, and show == Complete
        Scene root = new Scene(rootBox, 500, 450);
        stage.setScene(root);
        stage.setTitle("Gone Fishing");
        stage.show();

    }
}