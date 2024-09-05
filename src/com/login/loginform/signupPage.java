package com.login.loginform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class signupPage extends Application {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/students_info";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        root.setPrefSize(1100, 600);

        ImageView logoImageView = new ImageView(new Image("file:src/draw2__1_-removebg-preview.png"));
        logoImageView.setFitWidth(489);
        logoImageView.setFitHeight(377);
        logoImageView.setLayoutX(726);
        logoImageView.setLayoutY(123);

        ImageView userImageView = createSmallLogo("file:src/user.png", 48, 198);
        ImageView emailImageView = createSmallLogo("file:src/emil.png", 49, 272);
        ImageView padlockImageView = createSmallLogo("file:src/padlock.png", 48, 359);
        ImageView keyImageView = createSmallLogo("file:src/key.png", 49, 445);

        Label signupLabel = new Label("Signup");
        signupLabel.setFont(Font.font("Bookman Old Style Bold", 41));
        signupLabel.setLayoutX(104);
        signupLabel.setLayoutY(101);

        TextField nameTextField = createTextField("Your name", 105, 193, 330, 44, 18);
        TextField emailTextField = createTextField("Email", 104, 270, 330, 44, 20);
        PasswordField passwordField = createPasswordField("Password", 106, 355, 330, 44, 20);
        PasswordField repeatPasswordField = createPasswordField("Repeat your password", 107, 442, 330, 44, 20);

        Text termsText = new Text("I agree all statements in ");
        termsText.setFont(Font.font("Bookman Old Style", 18));
        termsText.setLayoutX(58);
        termsText.setLayoutY(516);

        Hyperlink termsLink = new Hyperlink("Terms of Service");
        termsLink.setFont(Font.font("Bookman Old Style", 18));
        termsLink.setLayoutX(250);
        termsLink.setLayoutY(516);
        termsLink.setStyle("-fx-text-fill: #0E86D4;");
        termsLink.setCursor(Cursor.HAND);

        CheckBox agreeCheckBox = new CheckBox();
        agreeCheckBox.setGraphic(new HBox(termsText, termsLink));
        agreeCheckBox.setFont(Font.font("Bookman Old Style", 18));
        agreeCheckBox.setLayoutX(58);
        agreeCheckBox.setLayoutY(546);

        Button registerButton = new Button("REGISTER");
        registerButton.setStyle("-fx-background-color: #0E86D4;");
        registerButton.setTextFill(javafx.scene.paint.Color.WHITE);
        registerButton.setFont(Font.font("Bookman Old Style Bold", 21));
        registerButton.setLayoutX(177);
        registerButton.setLayoutY(603);

        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = nameTextField.getText();
                String email = emailTextField.getText();
                String password = passwordField.getText();
                String repeatPassword = repeatPasswordField.getText();

                if (isValidEmail(email) && isValidPassword(password) && password.equals(repeatPassword)) {
                    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD)) {
                        String insertSQL = "INSERT INTO signupdata (your_name, email, password, repeat_password) VALUES (?, ?, ?, ?)";
                        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                            preparedStatement.setString(1, name);
                            preparedStatement.setString(2, email);
                            preparedStatement.setString(3, password);
                            preparedStatement.setString(4, repeatPassword);
                            preparedStatement.executeUpdate();
                        }
                        System.out.println("Registration successful");
                        LoginPage loginPage = new LoginPage();
                        loginPage.start(primaryStage);

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Invalid input. Please check your email and password.");
                }
            }
        });

    

        root.getChildren().addAll(
                logoImageView, userImageView, emailImageView, padlockImageView, keyImageView,
                signupLabel, nameTextField, emailTextField, passwordField, repeatPasswordField,
                agreeCheckBox, registerButton
        );

        Scene scene = new Scene(root, 1100, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Signup Form");
        primaryStage.show();
    }

    private ImageView createSmallLogo(String imageUrl, double x, double y) {
        ImageView imageView = new ImageView(new Image(imageUrl));
        imageView.setFitWidth(35);
        imageView.setFitHeight(33);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        return imageView;
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

    private PasswordField createPasswordField(String promptText, double x, double y, double width, double height, int fontSize) {
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText(promptText);
        passwordField.setFont(Font.font("System Bold", fontSize));
        passwordField.setLayoutX(x);
        passwordField.setLayoutY(y);
        passwordField.setPrefWidth(width);
        passwordField.setPrefHeight(height);
        return passwordField;
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailRegex);
    }

    private boolean isValidPassword(String password) {
        String passwordRegex = "^[A-Za-z0-9@!$%*?&]{6,}$";
        return password.matches(passwordRegex);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
