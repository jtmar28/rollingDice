package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{
        GraphicsContext gc = JIGraphicsUtility.setUpGraphics(stage, "Roll a Die", 700, 400);
        final int START_X = 300, START_Y = 150, ROLL_Y = 125;
        final int DIE_SIZE = 120, DOT_SIZE = 20;
        final int DOT_1 = DOT_SIZE /2,
                  DOT_2 = DIE_SIZE /2 - DOT_SIZE /2,
                  DOT_3 = DIE_SIZE - DOT_SIZE / 2 - DOT_SIZE;
        Font largeFont = new Font(20);
        gc.setFont(largeFont);

        //roll the die
        Random rand = new Random();
        int roll = rand.nextInt(6)+1;

        //draw a pink die
        gc.setFill(Color.PINK);
        gc.fillRect(START_X, START_Y, DIE_SIZE, DIE_SIZE);

        //set dot color
        gc.setFill(Color.BLACK);
        switch (roll){
            case 5: //draw upper right and lower left dots
                gc.fillOval(START_X + DOT_3, START_Y + DOT_1, DOT_SIZE, DOT_SIZE);
                gc.fillOval(START_X + DOT_2, START_Y + DOT_2, DOT_SIZE, DOT_SIZE);
                gc.fillOval(START_X + DOT_1, START_Y + DOT_3, DOT_SIZE, DOT_SIZE);
            case 3: //draw upper left and lower right
                gc.fillOval(START_X + DOT_1, START_Y + DOT_1, DOT_SIZE, DOT_SIZE);
                gc.fillOval(START_X + DOT_3, START_Y + DOT_3, DOT_SIZE, DOT_SIZE);
            case 1: //draw center dot
                gc.fillOval(START_X + DOT_2, START_Y + DOT_2, DOT_SIZE, DOT_SIZE);
                break;
            case 6: //draw middle left and right dots
                gc.fillOval(START_X + DOT_1, START_Y + DOT_2, DOT_SIZE, DOT_SIZE);
                gc.fillOval(START_X + DOT_3, START_Y + DOT_2, DOT_SIZE, DOT_SIZE);
            case 4: //draw upper right and lower left dots
                gc.fillOval(START_X + DOT_3, START_Y + DOT_1, DOT_SIZE, DOT_SIZE);
                gc.fillOval(START_X + DOT_1, START_Y + DOT_3, DOT_SIZE, DOT_SIZE);
            case 2: //draw upper left and lower right dots
                gc.fillOval(START_X + DOT_1, START_Y + DOT_1, DOT_SIZE, DOT_SIZE);
                gc.fillOval(START_X + DOT_3, START_Y + DOT_3, DOT_SIZE, DOT_SIZE);
                break;
        }

        //Display the roll number
        gc.fillText("The roll is " + roll, START_X, ROLL_Y);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
