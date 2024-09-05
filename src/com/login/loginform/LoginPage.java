package com.login.loginform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

public class LoginPage extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        root.setPrefSize(1400, 700);
        

        ImageView logoImageView = new ImageView(new Image("file:src/draw2__1_-removebg-preview.png"));
        logoImageView.setFitHeight(395);
        logoImageView.setFitWidth(502);
        logoImageView.setLayoutX(128);
        logoImageView.setLayoutY(91);

        Label signInLabel = new Label("Login");
        signInLabel.setFont(Font.font("Arial", 31));
        signInLabel.setLayoutX(860);
        signInLabel.setLayoutY(120);

        Hyperlink facebookLink = createSocialHyperlink("https://www.facebook.com/", "file:src/facebook.png", 1065, 120);
        Hyperlink twitterLink = createSocialHyperlink("https://twitter.com/", "file:src/twitter.png", 1107, 120);
        Hyperlink linkedinLink = createSocialHyperlink("https://www.linkedin.com/", "file:src/linkedin.png", 1157, 120);

        TextField emailTextField = createTextField("email", 862, 192, 358, 41, 18);
        TextField passwordTextField = createTextField("Password", 861, 253, 358, 41, 19);

        CheckBox rememberMeCheckBox = new CheckBox("Remember me");
        rememberMeCheckBox.setFont(Font.font(20));
        rememberMeCheckBox.setLayoutX(863);
        rememberMeCheckBox.setLayoutY(309);

        Button loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color: #0E86D4;");
        loginButton.setTextFill(Color.WHITE);
        loginButton.setFont(Font.font("Bookman Old Style Bold", 20));
        loginButton.setLayoutX(860);
        loginButton.setLayoutY(372);
        // Add an action event for the login button
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String email = emailTextField.getText();
                String password = passwordTextField.getText();

                // Establish a database connection
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_info", "root", "root")) {
                    // Prepare a SQL query to check user credentials
                    String sql = "SELECT * FROM signupdata WHERE email = ? AND password = ?";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                        preparedStatement.setString(1, email);
                        preparedStatement.setString(2, password);

                        // Execute the query
                        if (preparedStatement.executeQuery().next()) {
                            // Successful login, you can navigate to another window or perform other actions.
                            System.out.println("Login successful");
                            App1 coursePage = new App1();
                            //  Stage courseStage = new Stage();
                            coursePage.start(primaryStage);
                        } else {
                            // Handle incorrect login credentials
                            System.out.println("Login failed");
                        }
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                    // Handle database connection or query errors
                }
            }
        });

          // Add style changes on mouse hover
           loginButton.setOnMouseEntered(e -> {
            loginButton.setStyle("-fx-background-color: lightblue;");
        });

        loginButton.setOnMouseExited(e -> {
            loginButton.setStyle("-fx-background-color:#0E86D4;");
        });


        Label copyrightLabel = new Label("@Super_x_'Code_Wars'");
        Font font = Font.font("Arial", FontWeight.BOLD, 20);
        copyrightLabel.setFont(font);
        copyrightLabel.setTextFill(Color.WHITE);
        copyrightLabel.setAlignment(Pos.CENTER);

        copyrightLabel.setStyle("-fx-background-color: #0E86D4;");
        copyrightLabel.setLayoutY(603);
        copyrightLabel.setPrefSize(1280, 56);

        Button backButton = new Button("Back");
        backButton.setFont(Font.font("Bookman Old Style Bold", 20));
        backButton.setLayoutX(862);
        backButton.setLayoutY(422);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                MainApp backToMain = new MainApp();
                try {
                    backToMain.start(primaryStage);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        root.getChildren().addAll(
                logoImageView, signInLabel, facebookLink, twitterLink, linkedinLink,
                emailTextField, passwordTextField, rememberMeCheckBox,
                loginButton, copyrightLabel, backButton
        );

        Scene scene = new Scene(root, 1400, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login Form");
        primaryStage.show();
    }

    private Hyperlink createSocialHyperlink(String url, String imageUrl, double x, double y) {
        Hyperlink hyperlink = new Hyperlink();
        ImageView imageView = new ImageView(new Image(imageUrl));
        imageView.setFitWidth(34);
        imageView.setFitHeight(35);
        hyperlink.setGraphic(imageView);
        hyperlink.setLayoutX(x);
        hyperlink.setLayoutY(y);
        hyperlink.setOnAction(e -> {
            getHostServices().showDocument(url);
        });
        return hyperlink;
    }

    private TextField createTextField(String promptText, double x, double y, double width, double height, int fontSize) {
        TextField textField = new TextField();
        textField.setPromptText(promptText);
        textField.setFont(Font.font("System Bold", fontSize));
        textField.setLayoutX(x);
        textField.setLayoutY(y);
        textField.setPrefWidth(width);
        textField.setPrefHeight(height);
        return textField;
    }
public static void launchApp(Stage primaryStage) {
    Application.launch(App1.class); // Start the courses class
}
}