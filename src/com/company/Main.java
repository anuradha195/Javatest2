package com.company;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application {
    private Stage window;
    Scanner sc = new Scanner(System.in);
    int  count=0;
    double rand= Math.random();
    int random = (int) (rand*100);
    //int numberguessed = 0;

    public static void main(String[] args) {
        launch(args);
	// write your code here
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window=primaryStage;
        primaryStage.setTitle("Lets Play a Game");
        MenuBar menuBar = new MenuBar();
        // --- Menu Game
        Menu menuGame = new Menu("Games");
        MenuItem Numbergame=new MenuItem("Number Guessing game");

        Menu menuOtherOptions = new Menu("Other Options");
        menuBar.getMenus().addAll(menuGame,menuOtherOptions);

        menuGame.getItems().addAll(Numbergame);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(menuBar);
        Scene firstscene = new Scene(vbox, 640, 420);



        Button guessbutton=new Button("Check if you guessed right?");

        VBox vbox1 = new VBox();
        TextField numberdisplay = new TextField();
        numberdisplay.setPromptText("Guess a number ");
        vbox1.getChildren().addAll(numberdisplay,guessbutton);
        Scene gameScene = new Scene(vbox1, 640, 420);

        Numbergame.setOnAction(event -> {
            window.setScene(gameScene);

        });

            guessbutton.setOnAction(event -> {

                int numberguessed;
                //System.out.println("Number guess is "+ numberguessed);
                //System.out.println("random number is :" +random);
                //System.out.println("Count is : " + count);

                numberdisplay.setPromptText("Guess a number ");
                numberguessed = Integer.parseInt(numberdisplay.getText());
                count++;
                if (numberguessed > random) {
                    System.out.println("You guess too high, try again ");
                    if ( count==1)
                    {
                        System.out.println("you have 2 more Lives left");
                    }
                    if ( count ==2)
                    {
                        System.out.println("You have 1 more Life left");
                    }
                    if (count == 3) {
                        System.out.println("Oops...No More Lives left!!!");
                        window.close();
                    }
                } else if (numberguessed < random) {
                    System.out.println("You guess too low, try again ");
                    System.out.println("Count is :" + count);
                    if (count == 3) {
                        System.out.println("Oops...No More Lives left!!!");
                        window.close();
                    }
                }
                if (numberguessed == random) {
                    System.out.println("Congratulations!!!! You guessed the correct number ");
                    window.close();
                }
            });



            /*do {
                numberguessed=0;
                //TextField numberdisplay = new TextField();
                numberdisplay.setPromptText("Guess a number ");
                numberguessed = Integer.parseInt(numberdisplay.getText());
                //count++;
                if (numberguessed > random) {
                    System.out.println("You guess too high, try again ");
                    System.out.println("Count is :"+count);
                    if ( count == 3){
                        System.out.println("Oops...No More Lives left!!!");
                        window.close();
                    }
                } else if (numberguessed < random) {
                    System.out.println("You guess too low, try again ");
                    System.out.println("Count is :"+count);
                    if ( count == 3) {
                        System.out.println("Oops...No More Lives left!!!");
                        window.close();
                    }

                }

            } while (  !(numberguessed == random)  );
            if ( numberguessed == random);
                System.out.println("Congratulations!!!! You guessed the correct number ");
                window.close();*/

        window.setScene(firstscene);
        primaryStage.show();
    }

}
