package Java;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.List;

public class polymorphism_java extends Application {
    private StackPane root;
    private GridPane quizContainer;

    private int currentQuestionIndex = 0;

    private String[] questions = {
        "1.What is polymorphism in Java?",
        "2.What is method overriding in Java?",
        "3.Which principle in Java allows objects of different classes to be treated as objects of a common superclass?",
        "4.In Java, what is a superclass method that is overridden in a subclass?",
        "5.Which keyword is used to indicate that a method in a subclass is intended to override a method in its superclass?",
        "6.What is dynamic method dispatch in Java?",
        "7.Preventing method overriding",
        "8.In Java, what is an example of compile-time polymorphism?",
        "9.What is the term for creating objects of a superclass and accessing them through the reference of the superclass?",
        "10.What is the role of the 'instanceof' operator in Java?"
    };

    private String[][] options = {
        {"A built-in Java library","The ability of objects to take on multiple forms","A loop structure","A data type"},
        {"A way to combine methods","A way to redefine a superclass method in a subclass","A way to create new methods","A way to hide methods"},
        {"Abstraction","Polymorphism","Encapsulation","Inheritance"},
        {"Overridden method","Overloaded method","Derived method","Base method"},
        {" super","inherit","redefine","override"},
        {"A way to combine multiple methods","A mechanism that determines which method to call at runtime based on the object type","A way to create new objects"," A way to define static methods"},
        {"Preventing method overriding"," Increasing memory usage","Enforcing strict data types","Reducing code complexity"},
        {"Abstract classes","Dynamic method dispatch","Method overloading","Method overriding"},
        {"Inheritance","Typecasting","Downcasting","Upcasting"},
        {"To override superclass methods","To define class hierarchies","To create new instances of classes","To check if an object is an instance of a specific class"}
    };

    private String[] correctAnswers = {
        "The ability of objects to take on multiple forms",
        "A way to redefine a superclass method in a subclass",
        "Polymorphism",
        "Overridden method",
        "override",
        "A mechanism that determines which method to call at runtime based on the object type",
        "Reducing code complexity",
        "Method overloading",
        "Upcasting",
        "To check if an object is an instance of a specific class"
    };

    private RadioButton[] optionButtons; // RadioButtons array to store answer choices

    private List<String> selectedOptions = new ArrayList<>();

    private boolean quizCompleted = false; // Track if the quiz is completed
    private int userScore = 0;

    // Define styles for correct and incorrect options
    private static final String CORRECT_OPTION_STYLE = "-fx-text-fill: green; -fx-font-size: 18px;";
    private static final String INCORRECT_OPTION_STYLE = "-fx-text-fill: red; -fx-font-size: 18px;";

    @Override
    public void start(Stage primaryStage) {
        // Create a StackPane as the main container
        root = new StackPane();

        // Set the background color of the StackPane to light blue
        root.setStyle("-fx-background-color: lightblue;");

        // Create a Rectangle with light yellow background as the card
        Rectangle cardBackground = new Rectangle(800, 500);
        cardBackground.setFill(Color.LIGHTYELLOW);

        // Add the card background to the StackPane
        root.getChildren().add(cardBackground);

        // Create a GridPane to hold the content
        quizContainer = new GridPane();
        quizContainer.setAlignment(Pos.CENTER);
        quizContainer.setPadding(new Insets(20));
        quizContainer.setHgap(10);
        quizContainer.setVgap(10);

        // Add the card content to the StackPane
        root.getChildren().add(quizContainer);

        // Create a Scene with the StackPane as the root node
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Welcome to the Quiz World");
        primaryStage.setScene(scene);

        // Call the method to set up the quiz elements
        setUpQuiz(quizContainer);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void setUpQuiz(GridPane quizContainer) {
        // Create a label for the title
        Label titleLabel = new Label("Welcome to the Quiz World");
        titleLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titleLabel.setTextAlignment(TextAlignment.CENTER);
        GridPane.setHalignment(titleLabel, HPos.CENTER);
        quizContainer.add(titleLabel, 0, 0, 2, 1);
        GridPane.setMargin(titleLabel, new Insets(-100, 0, 10, 0));
        Label scoreLabel = new Label("Score: " + userScore);
        scoreLabel.setFont(Font.font("Arial", FontWeight.BOLD, 18));
        quizContainer.add(scoreLabel, 1, 7);
        GridPane.setHalignment(scoreLabel, HPos.RIGHT);

        // Create a Text for the question with a larger font size
        Text questionText = new Text(questions[currentQuestionIndex]);
        questionText.setStyle("-fx-font-size: 24px;");
        questionText.setWrappingWidth(600);

        // Create RadioButtons for answer choices with a larger font size
        ToggleGroup toggleGroup = new ToggleGroup();

        optionButtons = new RadioButton[4]; // Initialize the RadioButtons array

        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new RadioButton(options[currentQuestionIndex][i]);
            optionButtons[i].setToggleGroup(toggleGroup);
            optionButtons[i].setWrapText(true);
            optionButtons[i].setStyle("-fx-font-size: 18px;");
        }

        // Create an HBox for the "Submit," "Back," and "Next" buttons
        HBox buttonBox = new HBox(20);

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-font-size: 18px;");
        backButton.setMinWidth(100);
        backButton.setMinHeight(40);

        backButton.setOnMouseEntered(event -> {
            backButton.setStyle("-fx-background-color: lightcoral; -fx-border-color: black; -fx-border-radius: 3; -fx-font-size: 18px;");
            backButton.setMinWidth(100);
            backButton.setMinHeight(40);
        });

        backButton.setOnMouseExited(event -> {
            backButton.setStyle("-fx-font-size: 18px;");
            backButton.setMinWidth(100);
            backButton.setMinHeight(40);
        });

        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-font-size: 18px;");
        submitButton.setMinWidth(100);
        submitButton.setMinHeight(40);

        submitButton.setOnMouseEntered(event -> {
            submitButton.setStyle("-fx-background-color: lightgreen; -fx-border-color: black; -fx-border-radius: 3; -fx-font-size: 18px;");
            submitButton.setMinWidth(100);
            submitButton.setMinHeight(40);
        });

        submitButton.setOnMouseExited(event -> {
            submitButton.setStyle("-fx-font-size: 18px;");
            submitButton.setMinWidth(100);
            submitButton.setMinHeight(40);
        });

        Button nextButton = new Button("Next");
        nextButton.setStyle("-fx-font-size: 18px;");
        nextButton.setMinWidth(100);
        nextButton.setMinHeight(40);

        nextButton.setOnMouseEntered(event -> {
            nextButton.setStyle("-fx-background-color: lightcoral; -fx-border-color: black; -fx-border-radius: 3; -fx-font-size: 18px;");
            nextButton.setMinWidth(100);
            nextButton.setMinHeight(40);
        });

        nextButton.setOnMouseExited(event -> {
            nextButton.setStyle("-fx-font-size: 18px;");
            nextButton.setMinWidth(100);
            nextButton.setMinHeight(40);
        });

        HBox.setMargin(backButton, new Insets(20, 10, 0, 0));
        HBox.setMargin(submitButton, new Insets(20, 0, 0, 0));
        HBox.setMargin(nextButton, new Insets(20, 0, 0, 0));

        buttonBox.getChildren().addAll(backButton, submitButton, nextButton);
        buttonBox.setAlignment(Pos.CENTER);

        // Add elements to the GridPane
        quizContainer.add(questionText, 0, 1, 2, 1);
        for (int i = 0; i < 4; i++) {
            quizContainer.add(optionButtons[i], 0, i + 2, 2, 1);
        }
        quizContainer.add(buttonBox, 1, 6);

        // Initialize selectedOptions ArrayList
        for (int i = 0; i < questions.length; i++) {
            selectedOptions.add("");
        }

        // Create an event handler for the "Back" button
        backButton.setOnAction(event -> {
            if (currentQuestionIndex > 0) {
                RadioButton selectedOption = (RadioButton) toggleGroup.getSelectedToggle();
                if (selectedOption != null) {
                    selectedOptions.set(currentQuestionIndex, selectedOption.getText());
                }
                currentQuestionIndex--;
                questionText.setText(questions[currentQuestionIndex]);

                // Update answer options based on the current question
                for (int i = 0; i < 4; i++) {
                    optionButtons[i].setText(options[currentQuestionIndex][i]);
                    optionButtons[i].setStyle("-fx-font-size: 18px;"); // Reset text color
                }

                toggleGroup.selectToggle(getSelectedOptionForCurrentQuestion());

                if (currentQuestionIndex < questions.length - 1) {
                    // Allow navigation to the next question if we're not on the last question
                    quizCompleted = false;
                }

                // Highlight the selected answer for the current question
                RadioButton currentSelectedOption = getSelectedOptionForCurrentQuestion();
                if (currentSelectedOption != null) {
                    if (selectedOptions.get(currentQuestionIndex).equals(correctAnswers[currentQuestionIndex])) {
                        currentSelectedOption.setStyle(CORRECT_OPTION_STYLE);
                    } else {
                        currentSelectedOption.setStyle(INCORRECT_OPTION_STYLE);
                    }
                }
            }
        });

        // Create an event handler for the "Next" button
        nextButton.setOnAction(event -> {
            if (currentQuestionIndex < questions.length - 1 && !quizCompleted) {
                RadioButton selectedOption = (RadioButton) toggleGroup.getSelectedToggle();
                if (selectedOption != null) {
                    selectedOptions.set(currentQuestionIndex, selectedOption.getText());
                }
                currentQuestionIndex++;
                questionText.setText(questions[currentQuestionIndex]);

                // Update answer options based on the current question
                for (int i = 0; i < 4; i++) {
                    optionButtons[i].setText(options[currentQuestionIndex][i]);
                    optionButtons[i].setStyle("-fx-font-size: 18px;"); // Reset text color
                }

                toggleGroup.selectToggle(getSelectedOptionForCurrentQuestion());

                // Highlight the selected answer for the current question
                RadioButton currentSelectedOption = getSelectedOptionForCurrentQuestion();
                if (currentSelectedOption != null) {
                    if (selectedOptions.get(currentQuestionIndex).equals(correctAnswers[currentQuestionIndex])) {
                        currentSelectedOption.setStyle(CORRECT_OPTION_STYLE);
                    } else {
                        currentSelectedOption.setStyle(INCORRECT_OPTION_STYLE);
                    }
                }
            }
        });

        // Create an event handler for the submit button
        submitButton.setOnAction(event -> {
            if (!quizCompleted) {
                RadioButton selectedOption = (RadioButton) toggleGroup.getSelectedToggle();
                if (selectedOption != null) {
                    selectedOptions.set(currentQuestionIndex, selectedOption.getText());
        
                    // Highlight the selected answer as correct (green) or incorrect (red)
                    if (selectedOption.getText().equals(correctAnswers[currentQuestionIndex])) {
                        for (int i = 0; i < 4; i++) {
                            optionButtons[i].setText(options[currentQuestionIndex][i]);
                            optionButtons[i].setStyle("-fx-font-size: 18px;"); // Reset text color
                        }
                        selectedOption.setStyle(CORRECT_OPTION_STYLE);
                    } else {
                        for (int i = 0; i < 4; i++) {
                            optionButtons[i].setText(options[currentQuestionIndex][i]);
                            optionButtons[i].setStyle("-fx-font-size: 18px;"); // Reset text color
                        }
                        selectedOption.setStyle(INCORRECT_OPTION_STYLE);
                    }
        
                    if (selectedOption.getText().equals(correctAnswers[currentQuestionIndex])) {
                        userScore++; // Increase the user's score for a correct answer
                    }
                }
        
                if (currentQuestionIndex == questions.length - 1) {
                    quizCompleted = true;
                    scoreLabel.setText("Total Score: " + userScore); // Update the score label with the total score
                } else {
                    nextButton.fire(); // Automatically move to the next question
                }
            }
        });
    }

    private RadioButton getSelectedOptionForCurrentQuestion() {
        String selectedOptionText = selectedOptions.get(currentQuestionIndex);
        for (RadioButton option : optionButtons) {
            if (option.getText().equals(selectedOptionText)) {
                return option;
            }
        }
        return null;
    }
}
