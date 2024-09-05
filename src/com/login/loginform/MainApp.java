package com.login.loginform;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Pure JavaFX Example");
        primaryStage.getIcons().add(new Image("file:src\\Screenshot (2).png"));

        Pane root = new Pane();
        Scene scene = new Scene(root, 1100, 600);

        ImageView backgroundImage = new ImageView(new Image("file:src/bg13.jpg"));
        backgroundImage.setFitWidth(1400);
        backgroundImage.setFitHeight(700);
        backgroundImage.setPickOnBounds(true);

        Button loginButton = new Button("Login");
        loginButton.setLayoutX(118);
        loginButton.setLayoutY(477);
        loginButton.setMnemonicParsing(false);
        loginButton.setPrefHeight(52);
        loginButton.setPrefWidth(101);
        loginButton.setStyle("-fx-background-color:#FFF0DF");
        loginButton.setTextFill(javafx.scene.paint.Color.valueOf("black"));
        loginButton.setFont(new Font("Bookman Old Style Bold", 23));

        // Add style changes on mouse hover
        loginButton.setOnMouseEntered(e -> {
            loginButton.setStyle("-fx-background-color: lightyellow;");
        });

        loginButton.setOnMouseExited(e -> {
            loginButton.setStyle("-fx-background-color:white;");
        });


        Hyperlink createAccountLink = new Hyperlink("Signup");
        createAccountLink.setLayoutX(117);
        createAccountLink.setLayoutY(557);
        createAccountLink.setFont(new Font("Bookman Old Style", 24));
        createAccountLink.setTextFill(javafx.scene.paint.Color.valueOf("white"));

                // Add style changes on mouse hover
        createAccountLink.setOnMouseEntered(e -> {
            createAccountLink.setStyle("-fx-text-fill: lightyellow;");
        });

        createAccountLink.setOnMouseExited(e -> {
            createAccountLink.setStyle("");
        });

        ImageView logoImage = new ImageView(new Image("file:src/Screenshot__58_-removebg-preview (1).png"));
        logoImage.setFitWidth(400);
        logoImage.setFitHeight(300);
        logoImage.setLayoutX(-20);
        logoImage.setLayoutY(-50);
        logoImage.setPickOnBounds(true);

        // Add event handlers for button and hyperlink
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event){
                try{
                    LoginPage loginPage = new LoginPage();
                    loginPage.start(primaryStage);
                }catch(Exception e){

                }
            }
        });
        createAccountLink.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event){
                try{
                    signupPage signupPagePage = new signupPage();
                    signupPagePage.start(primaryStage);
                }catch(Exception e){
                    
                }
            }
        });

        root.getChildren().addAll(backgroundImage, loginButton, createAccountLink, logoImage);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
